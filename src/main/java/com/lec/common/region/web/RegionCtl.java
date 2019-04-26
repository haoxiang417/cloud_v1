package com.lec.common.region.web;

import java.util.HashMap;
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

import com.google.common.collect.Table;
import com.lec.common.region.cache.RegionCache;
import com.lec.common.region.service.RegionService;
import com.lec.common.region.vo.Region;
import com.lec.framework.base.BaseCtl;
import com.lec.framework.cache.Cache;
import com.lec.framework.log.anotation.LogAspect;
import com.lec.framework.util.StringUtils;
import com.lec.framework.util.UuidGenerateUtil;
import com.lec.framework.validator.ResponseEntity;

@Controller
@RequestMapping(value = "system/region")
public class RegionCtl extends BaseCtl {
	
    @Resource
    RegionService regionService;
    @Resource
    Cache cache;

	@RequestMapping(value = "list/{menuid}/")
	public String list(@PathVariable String menuid, Model model) {
		model.addAttribute("treeData", this.showTreeNode());
		return "system/region/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "showTreeNode/", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public String showTreeNode() {
		return regionService.makeTreeData();
	}
	
	@RequestMapping(value = "add/{menuid}/{pid}/")
	public String add(@PathVariable("menuid") String menuid
			, @PathVariable("pid") String pid, Model model, HttpServletRequest request, RedirectAttributes attr) {
		
		if (StringUtils.isEmpty(pid)) {
			attr.addFlashAttribute("message", "未选择上级节点。");
			return "redirect:/system/region/list/"+menuid+"/";
		}
		Region r = regionService.getById(pid);
		if (r == null) {
			attr.addFlashAttribute("message", "上级节点信息获取错误。");
			return "redirect:/system/region/list/"+menuid+"/";
		}
		
		model.addAttribute("pid", pid);
		model.addAttribute("pname", r.getName());
		model.addAttribute("menuid", menuid);
		return "system/region/add";
	}
	
	@RequestMapping(value = "doAdd/{menuid}/",method = RequestMethod.POST)
	@LogAspect(desc="保存【行政区域】")
	public String doAdd(@PathVariable String menuid, Region region, String isContinue, RedirectAttributes attr) {
		region.setId(UuidGenerateUtil.getUUIDLong());
		regionService.save(region);
		attr.addFlashAttribute("message", "新增成功");
		if ("1".equals(isContinue)) {
			return "redirect:/system/region/add/"+menuid+"/"+region.getPid()+"/";
		}
		return "redirect:/system/region/list/"+menuid+"/";
	}

	@RequestMapping(value = "update/{menuid}/{id}/")
	public String update(@PathVariable("menuid") String menuid, @PathVariable("id") String id, Model model) {
		Region r = regionService.getById(id);
		Region pr = regionService.getById(r.getPid());
		model.addAttribute("pname", pr.getName());
		model.addAttribute("info", r);
		model.addAttribute("menuid", menuid);
		return "system/region/update";
	}
	
	@RequestMapping(value = "doUpdate/{menuid}/",method = RequestMethod.POST)
	@LogAspect(desc="修改【行政区域】")
	public String doUpdate(@PathVariable String menuid, @ModelAttribute("info")Region info, RedirectAttributes attr) {
		regionService.updateByIdSelective(info);
		attr.addFlashAttribute("message", "修改成功");
		return "redirect:/system/region/list/"+menuid+"/";
	}

    @RequestMapping(value="doDelete/",method = RequestMethod.POST)
    @ResponseBody
    @LogAspect(desc="删除【行政区域】")
    public ResponseEntity delete(@RequestParam(value = "ids", required = true) String ids) {
        ResponseEntity  entity = new ResponseEntity();
        try {
            logger.info("正在进行【行政区域】数据删除。。。。。。");
            String[] id = ids.split(",");
            for (String string : id) {
            	if ("0".equals(string)) {
            		continue;
            	}
                regionService.deleteById(string);
            }
            entity.setResult("ok");
            return entity;
        } catch (Exception e) {
            entity.setResult("error");
            return entity;
        }
    }
    
    @RequestMapping(value = "showRegion/",method = RequestMethod.GET)
    public String showRegion(String idElement, String nameElement, String isCallback, Model model) {
    	model.addAttribute("treeData", regionService.makeTreeData());
    	model.addAttribute("idElement", idElement);
    	model.addAttribute("nameElement", nameElement);
    	model.addAttribute("isCallback", isCallback==null?"0":isCallback);
		return "system/region/show_region";
    }

    @ResponseBody
    @RequestMapping(value = "getLocation/{regionId}/")
    public Map<String, Object> getLocation(@PathVariable String regionId) {
    	@SuppressWarnings("unchecked")
		Table<String, String, String> table = (Table<String, String, String>)cache.get(RegionCache.ID_LOCATION);
    	if (table != null) {
    		Map<String, String> map = table.column(RegionCache.ID_LOCATION);
    		if (map != null) {
    			String location = map.get(regionId);
    			if (StringUtils.isNotEmpty(location)) {
    				String[] ss = location.split(",");
    				Map<String, Object> m = new HashMap<String, Object>();
        			m.put("longitude", ss[0]);
        			m.put("latitude", ss[1]);
        			return m;
    			}
    		}
    	}
    	return null;
    }
    
}