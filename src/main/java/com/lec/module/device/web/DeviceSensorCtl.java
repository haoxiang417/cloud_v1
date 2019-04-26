package com.lec.module.device.web;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.lec.framework.base.BaseCtl;
import com.lec.framework.base.Page;
import com.lec.framework.util.Servlets;
import com.lec.module.device.service.DeviceInfoService;
import com.lec.module.device.service.DeviceSensorService;
import com.lec.module.device.vo.DeviceSensor;

@Controller
@RequestMapping(value = "/device/sensor")
@SessionAttributes(value = { "deviceInfo" })
public class DeviceSensorCtl extends BaseCtl {
	@Resource
	DeviceSensorService deviceSensorService;
	@Resource
	DeviceInfoService deviceInfoService;

//	@RequestMapping(value = "getListByUpdate/{infoId}/")
//	public String getListByUpdate(@PathVariable String infoId, HttpServletRequest request, Model model) {
//		DeviceSensorSearch search = new DeviceSensorSearch();
//		search.createCriteria().andDeviceIdEqualTo(infoId);
//		List<DeviceSensor> list = deviceSensorService.selectByExample(search);
//		model.addAttribute("dsList", list);
//		return "device/sensor/update";
//	}
//
//	@RequestMapping(value = "getListByView/{infoId}/")
//	public String getListByView(@PathVariable String infoId, HttpServletRequest request, Model model) {
//		DeviceSensorSearch search = new DeviceSensorSearch();
//		search.createCriteria().andDeviceIdEqualTo(infoId);
//		List<DeviceSensor> list = deviceSensorService.selectByExample(search);
//		model.addAttribute("dsList", list);
//		return "device/sensor/view";
//	}

	@RequestMapping({ "list/{menuid}/{deviceId}/" })
	public String list(@PathVariable("menuid") String menuid, @PathVariable("deviceId") String deviceId, Model model,
			@RequestParam(value = "sortType", defaultValue = "ID DESC") String sortType,
			@RequestParam(value = "page", defaultValue = "0") int pageNumber, String status,
			HttpServletRequest request) {
		this.logger.info("【设备传感器列表】数据列表查询......");
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		super.updateSession(request, menuid, searchParams);
		searchParams.put("deviceId", deviceId);
		Page page = this.deviceSensorService.getListByCondition(searchParams, pageNumber, 15, sortType, menuid);
		makePage(page);
		model.addAllAttributes(searchParams);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefixByPost(searchParams, "search_"));
		model.addAttribute("menuid", menuid);
		model.addAttribute("sortType", sortType);
		model.addAttribute("pageList", page);
		model.addAttribute("page", Integer.valueOf(pageNumber));

		model.addAttribute("deviceInfo", this.deviceInfoService.getById(deviceId));
		return "device/sensor/list";
	}

	private void makePage(Page page) {
		if (page != null) {
			@SuppressWarnings("rawtypes")
			List list = page.getResult();
			DeviceSensor ds = null;
			for (int i = 0; i < list.size(); i++) {
				ds = (DeviceSensor) list.get(i);
				if ((ds.getDataTime() == null) || (isTimeOut(ds.getDataTime(), 10)))
					ds.setConnect("0");
				else
					ds.setConnect("1");
			}
		}
	}

	private boolean isTimeOut(Date dataTime, int timeout) {
		if (dataTime == null) {
			return true;
		}
		Calendar c = Calendar.getInstance();
		c.setTime(dataTime);
		c.add(12, timeout);

		return c.getTime().after(new Date());
	}

	@RequestMapping({ "query/{menuid}/" })
	public String query(@PathVariable("menuid") String menuid, Model model,
			@RequestParam(value = "sortType", defaultValue = "DEVICE_ID, ID DESC") String sortType,
			@RequestParam(value = "page", defaultValue = "0") int pageNumber, String status,
			HttpServletRequest request) {
		this.logger.info("【设备传感器列表】数据列表查询......");
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		super.updateSession(request, menuid, searchParams);
		Page page = this.deviceSensorService.getListByCondition(searchParams, pageNumber, 15, sortType, menuid);
		makePage(page);
		model.addAllAttributes(searchParams);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefixByPost(searchParams, "search_"));
		model.addAttribute("menuid", menuid);
		model.addAttribute("sortType", sortType);
		model.addAttribute("pageList", page);
		model.addAttribute("page", Integer.valueOf(pageNumber));
		return "device/sensor/query";
	}

}