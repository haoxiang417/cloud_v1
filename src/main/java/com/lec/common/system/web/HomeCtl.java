package com.lec.common.system.web;

import com.google.gson.JsonObject;
import com.lec.common.log.service.OperateLogService;
import com.lec.common.log.service.SystemLogService;
import com.lec.common.log.vo.OperationLog;
import com.lec.common.log.vo.SystemLog;
import com.lec.common.system.service.ResourceService;
import com.lec.common.system.vo.SystemResource;
import com.lec.common.user.service.UserService;
import com.lec.common.user.type.MenuType;
import com.lec.core.security.OperatorDetails;
import com.lec.framework.base.BaseCtl;
import com.lec.framework.base.Page;
import com.lec.framework.resource.MessageResources;
import com.lec.framework.security.SpringSecurityUtils;
import com.lec.framework.util.Servlets;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/***
 * 框架主页处理
 *
 * @author zhouhaij
 * @Apr 9, 2013 2:45:38 PM
 */
@Controller
public class HomeCtl extends BaseCtl {

	@Resource
	ResourceService resourceService;
	@Resource
	FreeMarkerConfigurer freeMarkerConfigurer;
	@Resource
	SystemLogService systemLogService;
	@Resource
	UserService userService;
	@Resource
	OperateLogService operateLogService;

	/***
	 * 处理主页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "home/admin/", method = RequestMethod.GET)
	public String showMenu(ModelMap model,HttpServletRequest request) {
		OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
		// 检测是否为发布模式
		boolean isRealse = isRealse(request.getSession().getServletContext());
		String resCode = null;
		if (isRealse) {
			MessageResources resource = MessageResources.getMessageInstance(null, null,Locale.CHINA);
			// 获取资源管理菜单编码
			resCode = resource.getMessage("res.code");
		}
		if (userInfo == null) {
			throw new UsernameNotFoundException("用户不存在");
		}

		model.addAttribute("userName", userInfo.getRealName());
		request.getSession().setAttribute("userName", userInfo.getRealName());
		if(null==request.getSession().getAttribute("skin")){
			request.getSession().setAttribute("skin", userInfo.getSkin());
		}

        //默认显示的模块
        SystemResource resource =  null;
        if(request.getSession().getAttribute("one_menus")==null) {
            List<SystemResource> menus = resourceService.getChildMenusByUserId(userInfo.getId(),"0", MenuType.MODULE);//.getMenusByUserId(, MenuType.MODULE);
            List<SystemResource> oneLevel = new ArrayList<SystemResource>();
            for (SystemResource menu : menus) {
                // 寻找一级菜单
                if ("0".equals(menu.getParentid())) {
                    oneLevel.add(menu);
                }
            }
            request.getSession().setAttribute("one_menus", oneLevel);
        }
        @SuppressWarnings("unchecked")
		List<SystemResource> one = ( List<SystemResource> )request.getSession().getAttribute("one_menus");
        String moudelId = request.getParameter("moudelId");
        if(StringUtils.isNotBlank(moudelId)) {
            try {
                //没有时表示单击的是首页
                if (moudelId.equals("0")) {
                    resource = one.get(0);
                } else {
                    resource = resourceService.getById(moudelId);
                }
            } catch (Exception e) {
            }
        }else{
            try {
                resource = one.get(0);
                moudelId = "0";
            }catch(Exception e){

            }
        }
        if(resource == null){
            return "error/no_role";
        }
        if(resource != null) {
            //获取二级菜单
            List<SystemResource> children = resourceService.getChildMenusByUserId(userInfo.getId(), resource.getId(), MenuType.MODULE);
            for (SystemResource menu : children) {
                String menuid = menu.getId();
                //获得第三级菜单
                List<SystemResource> resList = resourceService.getChildMenusByUserId(userInfo.getId(), menuid, MenuType.MODULE);
                //处理菜单的UrL
                this.processMenus(resList);
                //去除资源管理菜单
                for (int i = 0; i < resList.size(); i++) {
                    if(resCode!=null) {
                        if (resCode.toUpperCase().equals(resList.get(i).getCode().toUpperCase())) {
                            resList.remove(i);
                            continue;
                        }
                    }
                }
                menu.setSonResourceList(resList);
            }
            //获取一级菜单的url地址
            String url = resource.getContent();
            String context = request.getSession().getServletContext().getContextPath();
            if (StringUtils.isNotBlank(url)) {
                if (!url.startsWith("http")) {
                    url = context + "/" + url + "?menuid=" + resource.getId();
                }
                model.addAttribute("welcomeurl", url);
            }
            request.getSession().setAttribute("secmenus", children);
            //存储模块Id
            request.getSession().setAttribute("moudelid", moudelId);
        }
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
        searchParams.put("status","3");
        //获取配置权限
        List<SystemResource> btnList = resourceService.getChildMenusByUserId(userInfo.getId(), "0", MenuType.BUTTON);
        boolean hasIndex = false;
        boolean hasWarring = false;
        if (btnList != null && btnList.size() > 0) {
        	for (SystemResource sr : btnList) {
            	if ("btn_SHOUYE".equals(sr.getCode())) {
            		hasIndex = true;
            	}
            	if ("btn_BAOJING".equals(sr.getCode())) {
            		hasWarring = true;
            	}
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("hasIndex", hasIndex?"1":"0");
        session.setAttribute("hasWarring", hasWarring?"1":"0");
        String index = request.getParameter("index");
        if (index != null && index.length() > 0) {
        	session.setAttribute("index", index);
        }
		return "home/index";
	}

	/***
	 * 处理首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "home/welcome/", method = RequestMethod.GET)
	@SuppressWarnings("unchecked")
	public String desktop(ModelMap model) {
		OperatorDetails oper = getCurrentUser();
		SystemLog systemLog = systemLogService.getLastLogInfo(oper);
		List<String> roles = userService.getRoleNameListByUser(getCurrentUserId());
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("operator", oper.getUsername());
		if(systemLog!=null){
			map.put("ip", systemLog.getIpAddress()==null?"":systemLog.getIpAddress());
		}
		Page page = operateLogService.getLogsByCondition(map, 0, 10, "id");
		List<OperationLog> resultList = page.getResult();
		model.addAttribute("operator",oper);
		model.addAttribute("operatorLogin", systemLog);
		model.addAttribute("operator_roles", roles);
		model.addAttribute("operation_list", resultList);
		return "home/welcome";
	}

	/***
	 * 处理右边主页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "home/getsubmenu/{menuid}", method = RequestMethod.GET)
	@ResponseBody
	public void getsubmenu(@PathVariable String menuid, ModelMap model, HttpServletResponse resp, HttpServletRequest request) {
		OperatorDetails userInfo = SpringSecurityUtils.getCurrentUser();
		if (userInfo == null) {
			throw new UsernameNotFoundException("用户不存在");
		}

		// 检测是否为发布模式
		boolean isRealse = isRealse(request.getSession().getServletContext());
		String resCode = null;
		if (isRealse) {
			MessageResources resource = MessageResources.getMessageInstance(null, null,Locale.CHINA);
			// 获取资源管理菜单编码
			resCode = resource.getMessage("res.code");
		}

		// 获得子系统名称
		SystemResource sys = resourceService.getById(menuid);
		// 获得左边第一级模块
		List<SystemResource> resList = resourceService.getChildMenusByUserId(userInfo.getId(), menuid, MenuType.MODULE);
		this.processMenus(resList);
		// 获得左边第二级功能
		for (SystemResource menu : resList) {
			List<SystemResource> sonResourceList = resourceService.getChildMenusByUserId(userInfo.getId(), menu.getId(), MenuType.MODULE);
			this.processMenus(sonResourceList);
			if (sonResourceList != null && sonResourceList.size() > 0) {
				if (resCode != null) {
					for (int i = 0; i < sonResourceList.size(); i++) {
						if (resCode.toUpperCase().equals(sonResourceList.get(i).getCode().toUpperCase())) {
							sonResourceList.remove(i);
							continue;
						}
					}
				}
				menu.setSonResourceList(sonResourceList);
			} else {
				List<SystemResource> templist = new ArrayList<SystemResource>();
				menu.setSonResourceList(templist);
			}
		}
		String menuStr = null;
		Configuration config = freeMarkerConfigurer.getConfiguration();
		Template template;
		Map<String, List<SystemResource>> menuModel = new HashMap<String, List<SystemResource>>();
		try {
			// 利用freemarker进行字符处理得到菜单
			menuModel.put("menus", resList);
			template = config.getTemplate("/ftl/menu.ftl");
			menuStr = FreeMarkerTemplateUtils.processTemplateIntoString(template, menuModel);
			// 根据子系统名，生成子系统首页链接
			String aStr = "<a href='#' onclick=\"showSysIndex('" + sys.getContent() + "')\" >" + sys.getName() + "首页</a>";
			menuStr = menuStr.replaceAll("系统功能菜单", aStr);
			JsonObject object = new JsonObject();
			logger.debugLine();
			logger.debug(menuStr);
			logger.debugLine();
			object.addProperty("content", menuStr);
			if (!StringUtils.isBlank(sys.getContent())) {
				object.addProperty("url", sys.getContent());
			}
			resp.getWriter().write(object.toString());
		} catch (Exception e) {
			logger.error(e);
		}
	}

	private void processMenus(List<SystemResource> resList) {
		for (SystemResource menu : resList) {
			if (!StringUtils.isEmpty(menu.getContent())) {
				String url = StringUtils.removeEnd(menu.getContent(), "*");
				logger.debug("菜单url:{0}", url);
				if (url.indexOf("forward") == -1) {
					// 如果url配置有?说明带有参数
					if (url.indexOf("?") > -1) {
						String[] ss = url.split("\\?");
						if (ss[0].endsWith("/")) {
							url = ss[0] + menu.getId() + "/?" + ss[1];
						} else {
							url = ss[0] + "/" + menu.getId() + "/?" + ss[1];
						}
					}
					// 如果以/结束，说明其中有其他参数，在url末尾加上menuid
					else if (url.endsWith("/")) {
						url += menu.getId() + "/";
					}
                    else if (url.startsWith("http")) {
                        url += "?menuid=" + menu.getId();
                    }
					// 否则直接加上menuid
					else {
						url += "/" + menu.getId() + "/";
					}
				}
                else{
                    url +="?menuid="+menu.getId();
                }
				menu.setContent(url);
			} else {
				menu.setContent("");
			}
			menu.setIcon(menu.getIcon() == null ? "" : menu.getIcon());
		}
	}

}
