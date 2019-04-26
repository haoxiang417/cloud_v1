/**
 * 
 */
package com.lec.common.system.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.google.gson.JsonObject;
import com.lec.common.system.service.ResourceService;
import com.lec.common.system.service.UserDeskService;
import com.lec.common.system.vo.SystemResource;
import com.lec.common.system.vo.UserDesk;
import com.lec.common.system.vo.UserDeskMenuBarTemp;
import com.lec.common.user.service.UserService;
import com.lec.common.user.type.MenuType;
import com.lec.framework.base.BaseCtl;
import com.lec.framework.cache.Cache;
import com.lec.framework.log.anotation.LogAspect;
import com.lec.core.security.OperatorDetails;
import com.lec.framework.security.SpringSecurityUtils;
import com.lec.framework.util.UuidGenerateUtil;
import com.lec.framework.util.ZhongWenToPinYin;
import com.lec.framework.validator.ResponseEntity;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 桌面分屏处理
 * @author kouyunhao
 * @version 1.0
 * 2013-6-26
 */
@Controller
@RequestMapping(value = "desk/deskinfo")
public class UserDeskCtl extends BaseCtl{
	
	@Resource
	UserDeskService userDeskService;
	
	@Resource
	ResourceService resourceService;
	
	@Resource 
	FreeMarkerConfigurer freeMarkerConfigurer;
	
	@Resource
	UserService userService;
	
	@Resource
	FreeMarkerConfigurer config;
	
	@Resource
	Cache cache;
	
	List<UserDeskMenuBarTemp> userMenuBarList = new ArrayList<UserDeskMenuBarTemp>();
	
	public static final String INIT_RESOURCE_ID = "0";
	
	@RequestMapping(value="desk_list/",method = RequestMethod.GET)
	public void list(ServletResponse response, @RequestParam(value = "sortType", defaultValue = "SCREENNUM") String sortType){
		StringBuffer scrBuffer = new StringBuffer(); 
		if(curruserAlldeskList() != null && curruserAlldeskList().size() != 0){
			for(UserDesk userDesk : curruserAlldeskList()){
				if(StringUtils.isNotEmpty(userDesk.getScreennum())){
					scrBuffer.append(userDesk.getScreennum());
					scrBuffer.append(",");
				}
			}
		}
		logger.debug("response json:{0}", scrBuffer.length() == 0 ? "null" : StringUtils.removeEnd(scrBuffer.toString(), ","));
		try {
			response.getWriter().write(scrBuffer.length() == 0 ? "null" : StringUtils.removeEnd(scrBuffer.toString(), ","));
		} catch (IOException e) {
			logger.error(e);
		}
	} 
	
	/**
	 * 获取当前用户当前桌面快捷方式
	 * @author kouyunhao
	 * @version 1.0
	 * @param screennum
	 * @return
	 * Dec 31, 2013
	 */
	public List<UserDesk> curruserCurrdeskList(String screennum){
		return userDeskService.findListByUserIdAndScreennum(getCurrentUserId(), screennum);
	}
	
	/**
	 * 获取当前用户所有桌面快捷方式
	 * @author kouyunhao
	 * @version 1.0
	 * @param screennum
	 * @return
	 * Dec 31, 2013
	 */
	public List<UserDesk> curruserAlldeskList(){
		return userDeskService.findListByUserId(getCurrentUserId());
	}
	
	/**
	 * 得到当前节点的祖父节点
	 * @author kouyunhao
	 * @version 1.0
	 * @param parentid
	 * @param response
	 * Jul 23, 2013
	 */
	@RequestMapping(value="get_grandfather_node/{parentid}/{name}",method = RequestMethod.GET)
	public void get_grandfather(@PathVariable String parentid, @PathVariable String name, ServletResponse response){
		List<SystemResource> menus =  resourceService.getMenusByUserId(getCurrentUserId(),MenuType.MODULE);
		StringBuffer scrBuffer = new StringBuffer(); 
		for (SystemResource menu : menus) {
			//寻找一级菜单
			if("0".equals(menu.getParentid())){
				List<SystemResource> childrenList = resourceService.getChildren(menu.getId(), MenuType.MODULE);
				if(childrenList != null && childrenList.size() != 0){
					for(SystemResource child : childrenList){
						if(parentid.equals(child.getId())){
							String picName = ZhongWenToPinYin.getPinYin(com.lec.framework.util.StringUtils.getCN(name.trim())).toLowerCase();
							scrBuffer.append("home/getsubmenu/"+menu.getId() + "," + menu.getName() + "," + picName);
						}
					}
				}
			}
		}
		//logger.debug("response json:{0}", scrBuffer.length() == 0 ? "null" : scrBuffer.toString());
		try {
			response.getWriter().write(scrBuffer.length() == 0 ? "null" : scrBuffer.toString());
		} catch (IOException e) {
			logger.error(e);
		}
	} 
	
	@RequestMapping(value="add_desk/{screennum}",method = RequestMethod.GET)
	@ResponseBody
	@LogAspect(desc="添加自定义桌面")
	public ResponseEntity addDesk(@PathVariable String screennum){
		ResponseEntity  entity = new ResponseEntity();
//		Map<String, UserDesk> userDeskMap = userDeskService.getUserDeskMapByScreennum();
//		boolean isExist = true;
//		if(userDeskMap != null && userDeskMap.size() != 0){
//			if(userDeskMap.keySet().contains(screennum)){
//				isExist = false;
//			}
//		}
		if(curruserCurrdeskList(screennum) != null && curruserCurrdeskList(screennum).size() != 0){
			entity.setResult("error");
			return entity;
		}else{
			UserDesk desk = new UserDesk();
			desk.setId(UuidGenerateUtil.getUUID());
			desk.setScreennum(screennum);
			desk.setResourceId(INIT_RESOURCE_ID);
			desk.setUserId(getCurrentUserId());
			userDeskService.save(desk);
			try {
				entity.setResult("ok");
				return entity;
			} catch (Exception e) {
				entity.setResult("error");
				return entity;
			}
		}
		//return "home/index2";
	}
	
	@RequestMapping(value="del_desk/{screennum}",method = RequestMethod.DELETE)
	@ResponseBody
	@LogAspect(desc="删除自定义桌面")
	public ResponseEntity delDesk(@PathVariable String screennum){
		ResponseEntity  entity = new ResponseEntity();
		for(UserDesk desk : curruserCurrdeskList(screennum)){
			userDeskService.deleteById(desk.getId());
		}
		if(curruserAlldeskList() != null && curruserAlldeskList().size() != 0){
			for(UserDesk userDesk : curruserAlldeskList()){
				String userScrNum = userDesk.getScreennum();
				if(StringUtils.isNotEmpty(userScrNum)){
					if(Integer.parseInt(userScrNum) > Integer.parseInt(screennum)){
						userScrNum = (Integer.parseInt(userDesk.getScreennum())-1) + "";
						userDesk.setScreennum(userScrNum);
						userDeskService.updateById(userDesk);
					}
				}
			}
		}
		try {
			entity.setResult("ok");
			return entity;
		} catch (Exception e) {
			logger.error(e);
			entity.setResult("error");
			return entity;
		}
		//return "home/index2";
	} 
	private void processMenus(List<SystemResource> resList){
		for (SystemResource menu : resList) {
			if(!StringUtils.isEmpty(menu.getContent())){
				String url = StringUtils.removeEnd(menu.getContent(),"*");
				logger.debug("菜单url:{0}",url);
				if(url.indexOf("forward")==-1){
					//如果以/结束，说明其中有其他参数，在url末尾加上menuid
					if(url.endsWith("/")){
						url+=menu.getId()+"/";
					}
					//否则直接加上menuid
					else{
						url+="/"+menu.getId()+"/";
					}
				}
				menu.setContent(url);
			}else{
				menu.setContent("");
			}
			menu.setIcon(menu.getIcon()==null?"":menu.getIcon());
		}
	}
	
	@RequestMapping(value="add_menu/{screennum}/{resourceId}",method = RequestMethod.GET)
	@ResponseBody
	@LogAspect(desc="添加桌面快捷方式")
	public ResponseEntity addMenu(@PathVariable String screennum, @PathVariable String resourceId){
		ResponseEntity result = new ResponseEntity();
		try {
			if(curruserCurrdeskList(screennum) != null && curruserCurrdeskList(screennum).size() != 0){
				UserDesk deskInfo = curruserCurrdeskList(screennum).get(0);
				if(deskInfo.getResourceId().equals("0")){
					deskInfo.setResourceId(resourceId);
				}else{
					if(deskInfo.getResourceId().indexOf(resourceId) < 0){
						deskInfo.setResourceId(deskInfo.getResourceId() + "," + resourceId);
					}
				}
				userDeskService.updateByIdSelective(deskInfo);
			}else{
				ResponseEntity entity = addDesk("2");
				if(entity.getResult().equals("ok")){
					List<UserDesk> userDeskList = curruserCurrdeskList("2");
					UserDesk userDesk = userDeskList.get(0);
					userDesk.setResourceId(resourceId);
					userDeskService.updateByIdSelective(userDesk);
				}
			}
			result.setResult("ok");
			return result;
		} catch (RuntimeException e) {
			logger.error(e);
			result.setResult("error");
			return result;
		}
	} 
	
	@RequestMapping(value="del_menu/{screennum}/{resourceId}",method = RequestMethod.GET)
	@LogAspect(desc="删除桌面快捷方式")
	public String delMenu(@PathVariable String screennum, @PathVariable String resourceId, RedirectAttributes redirectAttributes){
		if(curruserCurrdeskList(screennum) != null && curruserCurrdeskList(screennum).size() != 0){
			UserDesk desk = curruserCurrdeskList(screennum).get(0);
			String[] resids = desk.getResourceId().split(",");
			StringBuffer resBuffer = new StringBuffer();
			for(int i = 0; i < resids.length; i++){
				if(!resids[i].equals(resourceId)){
					resBuffer.append(resids[i]);
					resBuffer.append(",");
				}
			}
			desk.setResourceId(StringUtils.removeEnd(resBuffer.toString(), ","));
			desk.setResourceId(StringUtils.removeEnd(resBuffer.toString(), ","));
			userDeskService.updateByIdSelective(desk);
			redirectAttributes.addFlashAttribute("message", "删除成功");
		}
		return "redirect:desk/deskinfo/desk_list";
	} 
	
	/**
	 * 查询当前用户所有桌面的resourceId
	 * @author kouyunhao
	 * @version 1.0
	 * @param response
	 * 2013-7-8
	 */
	@RequestMapping(value="res_list/",method = RequestMethod.GET)
	public void res_list(ServletResponse response){
		StringBuffer resBuffer = new StringBuffer();
		if(curruserAlldeskList() != null && curruserAlldeskList().size() != 0){
			for(UserDesk userDesk : curruserAlldeskList()){
				if(StringUtils.isNotEmpty(userDesk.getScreennum())){
					if(!userDesk.getResourceId().equals("0")){
						resBuffer.append(userDesk.getResourceId());
						resBuffer.append(",");
					}
				}
			}
		}
		//json.addProperty("resid", StringUtils.removeEnd(resBuffer.toString(), ","));
		logger.debug("response json:{0}", resBuffer.length() == 0 ? "null" : StringUtils.removeEnd(resBuffer.toString(), ","));
		try {
			//response.getWriter().write(json.toString());
			response.getWriter().write(resBuffer.length() == 0 ? "null" : StringUtils.removeEnd(resBuffer.toString(), ","));
		} catch (IOException e) {
			logger.error(e);
		}
		
	} 
	
	/**
	 * 查询当前用户某个桌面的resourceId
	 * @author kouyunhao
	 * @version 1.0
	 * @param response
	 * 2013-7-8
	 */
	@RequestMapping(value="get_list/{screennum}",method = RequestMethod.GET)
	public void get_list(@PathVariable String screennum, ServletResponse response){
		StringBuffer nameBuffer = new StringBuffer();
		if(curruserCurrdeskList(screennum) != null && curruserCurrdeskList(screennum).size() != 0){
			UserDesk userDesk = curruserCurrdeskList(screennum).get(0);
			String resid = "";
			if(StringUtils.isNotEmpty(userDesk.getScreennum())){
				resid = userDesk.getResourceId();
				if(!resid.equals("0")){
					String[] residArr = resid.split(",");
					for(int i = 0; i < residArr.length; i++){
						String subid = residArr[i];
						SystemResource res = resourceService.getById(subid);
						if(res != null){
							String subName = res.getName();
							String picName = ZhongWenToPinYin.getPinYin(subName.trim().replace(" ", "")).toLowerCase();
							String url = res.getContent() + "/" + subid + "/"; 
							String eventId = "picc%" + subid;
							SystemResource sysRes = resourceService.getById(subid);
							String pid = "";
							String pname = "";
							if(sysRes != null){
								pid = sysRes.getParentid();
								SystemResource sysResp = resourceService.getById(pid);
								if(sysResp != null){
									pname = sysResp.getName();
								}
							}
							nameBuffer.append(subid +"_"+ subName +"_"+ pname +"_"+ url +"_"+ pid +"_"+picName+"_"+eventId);
							nameBuffer.append(",");
						}
					}
				}
			}
		}
		try {
			response.getWriter().write(nameBuffer.length() == 0 ? "null" : StringUtils.removeEnd(nameBuffer.toString(), ","));
		} catch (IOException e) {
			logger.error(e);
		}
	} 
	
	@RequestMapping(value="get_resnum/{screennum}",method = RequestMethod.GET)
	public void get_resnum(@PathVariable String screennum,ServletResponse response){
		try {
			String[] resnum = null;
			if(curruserCurrdeskList(screennum) != null && curruserCurrdeskList(screennum).size() != 0){
				UserDesk userDesk = curruserCurrdeskList(screennum).get(0);
				if(userDesk.getResourceId() != null){
					resnum = userDesk.getResourceId().split(",");
				}
			}
			response.getWriter().write(resnum == null ? "0" : String.valueOf(resnum.length));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/***
	 * 处理应用设置左边菜单
	 * @param model
	 * @return
	 */						
	@RequestMapping(value = "get_left_2menu/{menuid}/{name}",method = RequestMethod.GET)
	@ResponseBody
	public void get_left_2menu(@PathVariable String menuid,@PathVariable String name,ModelMap model,HttpServletResponse resp,HttpServletRequest request){
		OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
		if(userInfo==null){
			throw new UsernameNotFoundException("用户不存在");
		}
		//获得左边第一级模块
		List<SystemResource> resList = resourceService.getChildMenusByUserId(userInfo.getId(), menuid, MenuType.MODULE);
		this.processMenus(resList);
		String menuStr =null;		
		Configuration config = freeMarkerConfigurer.getConfiguration();		
		Template template;
		Map<String,List<SystemResource>>  menuModel = new HashMap<String,List<SystemResource>>();
		try {
			// 利用freemarker进行字符处理得到菜单
			menuModel.put("menus", resList);
			template = config.getTemplate("/ftl/left_2menu.ftl");
			menuStr = FreeMarkerTemplateUtils.processTemplateIntoString(template, menuModel);
			JsonObject object = new JsonObject();
			logger.debugLine();
			logger.debug(menuStr);
			logger.debugLine();
			object.addProperty("content",menuStr);
			resp.getWriter().write(object.toString());
		}catch(Exception e){
			logger.error(e);
		}
	}
	
	/***
	 * 处理应用设置左边菜单
	 * @param model
	 * @return
	 */						
	@RequestMapping(value = "get_right_shortcut/{menuid}",method = RequestMethod.GET)
	@ResponseBody
	public void get_right_shortcut(@PathVariable String menuid,ModelMap model,HttpServletResponse resp,HttpServletRequest request){
		OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
		if(userInfo==null){
			throw new UsernameNotFoundException("用户不存在");
		}
		//获得左边第一级模块
		List<SystemResource> resList = resourceService.getChildMenusByUserId(userInfo.getId(), menuid, MenuType.MODULE);
		//String[] three_level_munuArr = new String[resList.size()];
		StringBuffer bufferInfo = new StringBuffer();
		if(resList != null && resList.size() != 0){
			for(int i = 0; i < resList.size(); i++){
				bufferInfo.append(resList.get(i).getId());
				bufferInfo.append(",");
				bufferInfo.append(resList.get(i).getName());
				bufferInfo.append(",");
				bufferInfo.append(resList.get(i).getContent());
				bufferInfo.append(",");
				bufferInfo.append(ZhongWenToPinYin.getPinYin(resList.get(i).getName().trim().replace(" ", "")).toLowerCase());
				bufferInfo.append(",");
				//three_level_munuArr[i] = bufferInfo.toString();
			}
		}
		try {
			//JsonObject object = new JsonObject();
			//object.addProperty("content", bufferInfo.length() == 0 ? "null" : StringUtils.removeEnd(bufferInfo.toString(), ","));
			resp.getWriter().write(bufferInfo.length() == 0 ? "null" : StringUtils.removeEnd(bufferInfo.toString(), ","));
		}catch(Exception e){
			logger.error(e);
		}
	}
	
	/***
	 * 处理应用设置左边菜单
	 * @param model
	 * @return
	 */						
	@RequestMapping(value = "add_menubar/{content}/{name}/{picname}",method = RequestMethod.GET)
	@ResponseBody
	public void add_menubar(@PathVariable String content,@PathVariable String name,@PathVariable String picname){
		OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
		if(userInfo==null){
			throw new UsernameNotFoundException("用户不存在");
		}
		try {
			boolean isExsit = false;
			for(int i = 0; i < userMenuBarList.size(); i++){
				if(!picname.equals(userMenuBarList.get(i).getPicname())){
					isExsit = true;
				}
			}
			if(!isExsit){
				UserDeskMenuBarTemp menuBar = new UserDeskMenuBarTemp();
				menuBar.setContent(content);
				menuBar.setName(name == "" ? "" : com.lec.framework.util.StringUtils.getCN(name));
				menuBar.setPicname(picname);
				userMenuBarList.add(menuBar);
				cache.put("userDeskMenuBar", userMenuBarList);
				System.out.println("=========================================");
			}
		}catch(Exception e){
			logger.error(e);
		}
	}
	/***
	 * 处理应用设置左边菜单
	 * @param model
	 * @return
	 */						
	@RequestMapping(value = "get_menubar/",method = RequestMethod.GET)
	@ResponseBody
	public String get_menubar(ModelMap model){
		OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
		
		if(userInfo==null){
			throw new UsernameNotFoundException("用户不存在");
		}
		model.addAttribute("bars", userMenuBarList);
		return pageJumping();
		//return "home/index";
	}
	
	/**
	 * 添加页面跳转判断，解决用户自定义桌面无法显示快捷方式问题。
	 * @author kouyunhao
	 * @version 1.0
	 * @return
	 * Dec 23, 2013
	 */
	public String pageJumping(){
		List<SystemResource> menus = resourceService.getMenusByUserId(getCurrentUser().getRealName(), MenuType.MODULE);
		List<SystemResource> oneLevel = new ArrayList<SystemResource>();
		for (SystemResource menu : menus) {
			// 设置页面图片名称
			menu.setPicName(ZhongWenToPinYin.getPinYin(menu.getName()).trim().toLowerCase());
			// 寻找一级菜单
			if ("0".equals(menu.getParentid())) {
				menu.setContent("home/getsubmenu/" + menu.getId());
				oneLevel.add(menu);
			}
		}
		int topMenuSize = oneLevel.size();
		if (topMenuSize <= 12) {
			return "home/index";
		} else if (topMenuSize > 12 && topMenuSize <= 21) {
			return "home/index2";
		} else if (topMenuSize > 21 && topMenuSize <= 28) {
			return "home/index3";
		}
		return "home/index";
	}
	
}
