package com.lec.module.device.web;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.lec.framework.base.BaseCtl;
import com.lec.framework.base.Page;
import com.lec.framework.log.anotation.LogAspect;
import com.lec.framework.util.Servlets;
import com.lec.framework.util.StringUtils;
import com.lec.framework.util.UuidGenerateUtil;
import com.lec.framework.validator.ResponseEntity;
import com.lec.module.device.service.DeviceInfoService;
import com.lec.module.device.service.DeviceSensorService;
import com.lec.module.device.vo.DeviceInfo;
import com.lec.module.device.vo.DeviceInfoSearch;

@Controller
@RequestMapping(value = "/device/info")
public class DeviceInfoCtl extends BaseCtl {
	@Resource
	DeviceInfoService deviceInfoService;
	@Resource
	DeviceSensorService deviceSensorService;

	@RequestMapping(value = "list/{menuid}/")
	public String list(@PathVariable String menuid, Model model,
			@RequestParam(value = "sortType", defaultValue = "CREATE_TIME DESC") String sortType,
			@RequestParam(value = "page", defaultValue = "0") int pageNumber, String status,
			HttpServletRequest request) {
		logger.info("【设备列表】数据列表查询......");
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		super.updateSession(request, menuid, searchParams);
		// 不同的状态
		if (StringUtils.isNotEmpty(status)) {
			searchParams.put("status", status);
			model.addAttribute("status", status);
		}
		// 只查询自己创建的设备
		searchParams.put("createId", super.getCurrentUserId());
		Page page = deviceInfoService.getListByCondition(searchParams, pageNumber, Page.DEFAULT_PAGE_SIZE, sortType,
				menuid);
		model.addAllAttributes(searchParams);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefixByPost(searchParams, "search_"));
		model.addAttribute("menuid", menuid);
		model.addAttribute("sortType", sortType);
		model.addAttribute("pageList", page);
		model.addAttribute("page", pageNumber);
		return "device/info/list";
	}

	@RequestMapping(value = "add/{menuid}/")
	public String add(@PathVariable String menuid, String page, Model model, HttpServletRequest request) {
		model.addAttribute("menuid", menuid);
		model.addAttribute("page", page);
		return "device/info/add";
	}

	@RequestMapping(value = "doAdd/{menuid}/", method = RequestMethod.POST)
	@LogAspect(desc = "保存【设备列表】")
	public String doAdd(@PathVariable String menuid, DeviceInfo info, String page,
			RedirectAttributes redirectAttributes, String[] sName, String[] sType, String[] sNum, String[] sUnit,
			String[] sState, Double[] sRange, Double[] sMin, Double[] sMax, HttpServletRequest request) {
		String id = UuidGenerateUtil.getUUIDLong();
		info.setId(id);
		info.setCreateId(super.getCurrentUserId());
		info.setCreateTime(new Date());
		deviceInfoService.save(info);
		deviceSensorService.saveInfos(id, sName, sType, sNum, sUnit, sState, sRange, sMin, sMax);
		redirectAttributes.addFlashAttribute("message", "添加成功");
		return "redirect:/device/info/list/" + menuid + "/";

	}

	@RequestMapping(value = "update/{menuid}/{id}/")
	public String update(@PathVariable("id") String id, @PathVariable("menuid") String menuid, String page,
			Model model) {
		DeviceInfo info = deviceInfoService.getById(id);
		model.addAttribute("menuid", menuid);
		model.addAttribute("page", page);
		model.addAttribute("info", info);
		return "device/info/update";
	}

	@RequestMapping(value = "doUpdate/{menuid}/", method = RequestMethod.POST)
	@LogAspect(desc = "修改【设备列表】")
	public String doUpdate(@PathVariable String menuid, @ModelAttribute("info") DeviceInfo info, String page,
			String[] sId, String[] sName, String[] sType, String[] sNum, String[] sUnit, String[] sState,
			Double[] sRange, Double[] sMin, Double[] sMax, HttpServletRequest request,
			RedirectAttributes redirectAttributes) {
		info.setUpdateId(super.getCurrentUserId());
		info.setUpdateTime(new Date());
		deviceInfoService.updateByIdSelective(info);
		deviceSensorService.updateInfos(info.getId(), sId, sName, sType, sNum, sUnit, sState, sRange, sMin, sMax);
		redirectAttributes.addFlashAttribute("message", "修改成功");
		return "redirect:/device/info/list/" + menuid + "/?isgetsession=1&page=" + page;
	}

	@ResponseBody
	@LogAspect(desc = "变更【设备列表】状态")
	@RequestMapping(value = "doChange/{status}/", method = RequestMethod.POST)
	public ResponseEntity doChange(@PathVariable String status,
			@RequestParam(value = "ids", required = true) String ids) {
		ResponseEntity entity = new ResponseEntity();
		try {
			String[] id = ids.split(",");
			DeviceInfo info;
			for (String string : id) {
				info = new DeviceInfo();
				info.setId(string);
				info.setStatus(status);
				deviceInfoService.updateByIdSelective(info);
			}
			entity.setResult("ok");
			return entity;
		} catch (Exception e) {
			logger.error("变更设备状态出错。" + e.getMessage());
			entity.setResult("error");
			return entity;
		}
	}

	@ResponseBody
	@LogAspect(desc = "销毁【设备列表】")
	@RequestMapping(value = "doDestroy/", method = RequestMethod.POST)
	public ResponseEntity destroy(@RequestParam(value = "ids", required = true) String ids) {
		ResponseEntity entity = new ResponseEntity();
		try {
			logger.info("正在进行【设备列表】数据销毁......");
			String[] id = ids.split(",");
			for (String string : id) {
				deviceInfoService.destroyById(string);
			}
			entity.setResult("ok");
			return entity;
		} catch (Exception e) {
			logger.error("销毁设备信息出错。" + e.getMessage());
			entity.setResult("error");
			return entity;
		}
	}

	@RequestMapping(value = "showView/{menuid}/{id}/", method = RequestMethod.GET)
	public String showView(@PathVariable("id") String id, @PathVariable("menuid") String menuid, String page,
			String returnType, Model model, HttpServletRequest request) {
		DeviceInfo info = deviceInfoService.getById(id);
		model.addAttribute("menuid", menuid);
		model.addAttribute("page", page);
		model.addAttribute("info", info);
		model.addAttribute("returnType", returnType);
		return "device/info/view";
	}

	@ResponseBody
	@RequestMapping(value = "checkCode/{code}/", method = RequestMethod.POST)
	public ResponseEntity checkCode(@PathVariable String code) {
		ResponseEntity re = new ResponseEntity();

		Map<String, Object> args = new HashMap<String, Object>();
		args.put("code", code);
		int count = deviceInfoService.countList(args);
		if (count == 0) {
			re.setResult("ok");
		} else {
			re.setResult("repeat");
		}
		return re;
	}

	@ResponseBody
	@RequestMapping(value = "getDeviceByIndexMap/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<DeviceInfo> getDeviceByIndexMap() {
		DeviceInfoSearch search = new DeviceInfoSearch();
		search.createCriteria().andCreateIdEqualTo(getCurrentUserId());
		List<DeviceInfo> list = deviceInfoService.selectByExample(search);
		return list;
	}

	@ModelAttribute("info")
	public DeviceInfo getDeviceInfo(@RequestParam(value = "id", required = false) String id) {
		if (id != null) {
			return deviceInfoService.getById(id);
		}
		return null;
	}
}