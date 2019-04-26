package com.lec.common.system.web;

import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lec.common.system.service.ResourceService;
import com.lec.common.system.service.SystemResourceHelpService;
import com.lec.common.system.service.SystemUserResourceService;
import com.lec.common.system.vo.SystemResource;
import com.lec.common.system.vo.SystemResourceHelp;
import com.lec.common.user.type.MenuType;
import com.lec.framework.base.BaseCtl;
import com.lec.framework.log.anotation.LogAspect;
import com.lec.framework.resource.MessageResources;
import com.lec.framework.util.StringUtils;
import com.lec.framework.util.ZhongWenToPinYin;
import com.lec.framework.validator.ResponseEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/***
 * 资源管理
 * @author zhouhaij
 * @Apr 16, 2013 5:39:59 PM
 */
@Controller
@RequestMapping("system/res")
public class ResourceCtl extends BaseCtl{

	@Resource
	ResourceService resourceService;
	@Resource
	SystemResourceHelpService systemResourceHelpService;
	@Resource
	SystemUserResourceService systemUserResourceService;
	
	@RequestMapping(value="list/{menuid}/",method = RequestMethod.GET)
	public String list(@PathVariable String menuid,ModelMap modal){
		logger.info("正在进行资源查询。。。。。。");
		List<SystemResource> res =  resourceService.findAll(false); 
		
		JsonArray jsonArray = new JsonArray();
		//{ id:1, pId:0, name:"根 Root", open:true},
		JsonObject root = new JsonObject();
		root.addProperty("id","0");
		root.addProperty("pId","-1");
		
		root.addProperty("name","资源菜单");
		jsonArray.add(root);
		for (SystemResource resource : res) {
			JsonObject json = new JsonObject();
			json.addProperty("id",resource.getId());
			json.addProperty("pId",resource.getParentid());
			
			json.addProperty("name",resource.getName());
			json.addProperty("enName",resource.getModuleCode());
			json.addProperty("isBtn",resource.getType());
			
			String content = StringUtils.EMPTY_STRING;
			if(!StringUtils.isEmpty(resource.getContent())){
				content = resource.getContent().replace('*',' ');
			}
			json.addProperty("actionUrl", content);
			jsonArray.add(json);
		}
		logger.debug("response json:{0}", jsonArray.toString());
		modal.addAttribute("data", jsonArray.toString());
		
		return "system/res/list";
	}
	
	/***************************************************************************
	 * 跳转到iframe上一级页面 add by kouyunhao 2013-07-18
	 * @param menuid
	 * @param model
	 * @return
	 */
	@RequestMapping(value="sublist/{menuid}/",method = RequestMethod.GET)
	public String iframe_list(@PathVariable String menuid,ModelMap modal){
		logger.info("正在进行资源查询。。。。。。");
		List<SystemResource> res =  resourceService.findAll(false); 
		
		JsonArray jsonArray = new JsonArray();
		for (SystemResource resource : res) {
			JsonObject json = new JsonObject();
			json.addProperty("id",resource.getId());
			json.addProperty("pId",resource.getParentid());
			
			json.addProperty("name",resource.getName());
			json.addProperty("enName",resource.getModuleCode());
			json.addProperty("isBtn",resource.getType());
			
			String content = StringUtils.EMPTY_STRING;
			if(!StringUtils.isEmpty(resource.getContent())){
				content = resource.getContent().replace('*',' ');
			}
			json.addProperty("actionUrl", content);
			jsonArray.add(json);
		}
		logger.debug("response json:{0}", jsonArray.toString());
		modal.addAttribute("data", jsonArray.toString());
		
		return "system/res/list";
	}
	
	@RequestMapping(value="doAddModule/{menuid}/",method = RequestMethod.POST)
	@LogAspect(desc="添加模块")
	public String doAddModule(@PathVariable String menuid,SystemResource res,RedirectAttributes redirectAttributes){
		res.setModuleCode(ZhongWenToPinYin.getPinYin(res.getName()).trim().toUpperCase());
		res.setCode(res.getModuleCode());
		res.setLeaf(false);
		res.setParentid("0");
		res.setType(MenuType.MODULE.toString());
		//名字同一大写
		res.setName(res.getName().toUpperCase());
		resourceService.save(res);
		redirectAttributes.addFlashAttribute("message", "添加成功");
		return "redirect:/system/res/list/"+menuid+"/";
	}
	
	@RequestMapping(value="doAddMenu/{menuid}/",method = RequestMethod.POST)
	@LogAspect(desc="添加菜单")
	public String doAddMenu(@PathVariable String menuid, SystemResource res
			, String parentid, String helpContent
			, HttpServletRequest request, RedirectAttributes redirectAttributes){
		res.setModuleCode(ZhongWenToPinYin.getPinYin(res.getName()).trim().toUpperCase());
		res.setCode(res.getModuleCode());
		res.setLeaf(true);
		res.setType(MenuType.MODULE.toString());
		//名字同一大写
		res.setName(res.getName().toUpperCase());
		resourceService.save(res);
		if (StringUtils.isNotEmpty(helpContent)) {
			systemResourceHelpService.save(new SystemResourceHelp(res.getId(), helpContent));
		}
		redirectAttributes.addFlashAttribute("message", "添加成功");
		return "redirect:/system/res/list/"+menuid+"/";
	}
	
	
	
	@RequestMapping(value="doAddBtn/{menuid}/",method = RequestMethod.POST)
	@LogAspect(desc="添加操作")
	public String doAddBtn(@PathVariable String menuid,SystemResource res,String parentid,RedirectAttributes redirectAttributes){
		res.setModuleCode(ZhongWenToPinYin.getPinYin(res.getName()).trim().toUpperCase());
		res.setCode("btn_"+res.getModuleCode());
		res.setType(MenuType.BUTTON.toString());
		resourceService.save(res);
		redirectAttributes.addFlashAttribute("message", "添加成功");
		return "redirect:/system/res/list/"+menuid+"/";
	}
	
	/***
	 * 快速添加常用的查看、添加、修改、删除操作
	 * @param menuid
	 * @param res
	 * @param parentid
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value="doAddCommonButtons/{menuid}/{parentid}/",method = RequestMethod.GET)
	@ResponseBody
	@LogAspect(desc="快速添加常用按钮")
	public ResponseEntity doAddCommonButtons(@PathVariable String menuid,@PathVariable String parentid){
		ResponseEntity entity = new ResponseEntity();
		try{
			MessageResources resource = MessageResources.getMessageInstance(null,null, Locale.CHINA);
			String btns = resource.getMessage("common.btns");
			String[] icons = new String[]{"icon-eye-open","icon-plus","icon-edit","icon-remove"};
			String[] btn = btns.split(",");
			int i = 0;
			for (String str:btn) {
				SystemResource res = new SystemResource();
				res.setModuleCode(ZhongWenToPinYin.getPinYin(str).trim().toUpperCase());
				res.setCode("btn_"+res.getModuleCode());
				res.setType(MenuType.BUTTON.toString());
				res.setName(str);
				res.setParentid(parentid);
				res.setIcon(icons[i]);
				resourceService.save(res);
				i++;
			}
			entity.setResult("ok");
			return entity;
		}catch (Exception e) {
			e.printStackTrace();
			entity.setResult("error");
			return entity;
		}
	}
	
	
	/***
	 * 获取待修改信息
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}/{menuid}/", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") String id,@PathVariable("menuid") String menuid,Model model) {
		model.addAttribute("res",resourceService.getById(id));
		model.addAttribute("helpInfo", systemResourceHelpService.getByMenuId(id));
		model.addAttribute("menuid",menuid);
		return "system/res/update";
	}
	
	@RequestMapping(value = "updateBtn/{id}/{menuid}/", method = RequestMethod.GET)
	public String updateBtn(@PathVariable("id") String id,@PathVariable("menuid") String menuid,Model model) {
		model.addAttribute("res",resourceService.getById(id));
		model.addAttribute("menuid",menuid);
		return "system/res/update_btn";
	}

	/***
	 * 修改资源
	 * @param user
	 * @param menuid
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "doUpdate", method = RequestMethod.POST)
	@LogAspect(desc="修改资源")
	public String doUpdate(@ModelAttribute("preloadRes") SystemResource res, String menuid
			, String helpContent
			, HttpServletRequest request, RedirectAttributes redirectAttributes) {
		res.setModuleCode(ZhongWenToPinYin.getPinYin(res.getName()).trim().toUpperCase());
		if(res.getType().equals(MenuType.BUTTON.toString())){
			res.setCode("btn_"+res.getModuleCode());
		}else{
			res.setCode(res.getModuleCode());
		}
		resourceService.updateByIdSelective(res);
		if (StringUtils.isNotEmpty(helpContent)) {
			systemResourceHelpService.update(new SystemResourceHelp(res.getId(), helpContent));
		}
		redirectAttributes.addFlashAttribute("message", "修改成功");
		return "redirect:/system/res/list/"+menuid+"/";
	}
	
	/****
	 * 拖拽移动节点
	 * @param id
	 * @param tid
	 * @param moveType
	 * @return
	 */
	@RequestMapping(value = "moveNode/{id}/{tid}/", method = RequestMethod.GET)
	@LogAspect(desc="移动节点")
	@ResponseBody
	public ResponseEntity moveNode(@PathVariable("id") String id,@PathVariable("tid") String tid,@RequestParam("moveType") String moveType){
		ResponseEntity  entity = new ResponseEntity();
		//moveType  指定移动到目标节点的相对位置 "inner"：成为子节点，"prev"：成为同级前一个节点，"next"：成为同级后一个节点
		SystemResource vnode = resourceService.getById(id);
		SystemResource targetNode = resourceService.getById(tid);
		
		//成为目标节点的子节点
		if("inner".equals(moveType)){
			//如果找不到，则设置为根节点
			if(targetNode==null){
				vnode.setParentid("0");
			}else
			vnode.setParentid(targetNode.getId());
		}
		
		//同级前一个节点
		if("prev".equals(moveType)){
			vnode.setSortOrder((targetNode.getSortOrder()-1)<0?0:(targetNode.getSortOrder()-1));
		}
		
		//同级后一个节点
		if("next".equals(moveType)){
			vnode.setSortOrder(targetNode.getSortOrder()+1);
		}
		
		//修改节点
		resourceService.updateByIdSelective(vnode);
		entity.setResult("ok");
		return entity;
	}
	
	
	/***
	 * 删除资源
	 * @param ids
	 * @param resp
	 */
	@RequestMapping(value="delete/{ids}/",method = RequestMethod.DELETE)
	@ResponseBody
	@LogAspect(desc="删除资源")
	public ResponseEntity delete(@PathVariable String ids){
		ResponseEntity  entity = new ResponseEntity();
		try {
			logger.info("正在进行系统资源数据删除。。。。。。");
			String[] id = ids.split(",");
			for (String string : id) {
				resourceService.deleteById(string);
			}
			entity.setResult("ok");
			return entity;
		} catch (Exception e) {
			entity.setMessage("该资源已被某角色引用，无法删除。");
			entity.setResult("error");
			return entity;
		}
	}
	
	/***
	 * 先根据form的id从数据库查出对象，再把Form提交的内容绑定到该对象上
	 * @param id
	 * @return
	 */
	@ModelAttribute("preloadRes")
	public SystemResource getResource(@RequestParam(value = "id", required = false) String id) {
		if (id != null) {
			return resourceService.getById(id);
		}
		return null;
	}
	
	/**
	 * ajax获取菜单帮助
	 * @param menuid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getHelp/{menuid}/", produces = "application/json;charset=UTF-8")
	public SystemResourceHelp getHelpContent(@PathVariable String menuid) {
		return systemResourceHelpService.getByMenuId(menuid);
	}
	
	/**
	 * ajax获取子菜单
	 * @param menuid
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getChild/{menuid}/", produces = "application/json;charset=UTF-8")
	public JSONArray getChild(@PathVariable String menuid) {
		List<SystemResource> list = systemResourceHelpService.getChileMenu(menuid, super.getCurrentUserId());
		JSONArray array = new JSONArray();
		JSONObject obj = null;
		if (list != null && list.size() > 0) {
			for (SystemResource sr : list) {
				obj = new JSONObject();
				obj.element("id", sr.getId());
				obj.element("name", sr.getName());
				array.add(obj);
			}
		}
		return array;
	}
	
	@ResponseBody
	@RequestMapping(value = "saveSetting/", method = RequestMethod.POST)
	public void saveSetting(@RequestParam(value = "ids", required = true) String ids, HttpServletRequest request) {
		try {
			systemUserResourceService.save(super.getCurrentUserId(), ids.split(","));
			resourceService.getUserModule(super.getCurrentUserId(), request);
		}catch(Exception e) {
			logger.error("保存用户配置菜单顺序失败：" + e.getMessage());
		}
	}
	
}
