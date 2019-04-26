package com.lec.common.user.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.lec.core.security.OperatorDetails;
import com.lec.framework.security.SpringSecurityUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
import com.lec.common.system.vo.SystemResource;
import com.lec.common.user.cache.AuthorityButtonCache;
import com.lec.common.user.service.RoleService;
import com.lec.common.user.type.MenuType;
import com.lec.common.user.vo.Role;
import com.lec.core.security.InvocationSecurityMetadataSourceBean;

import com.lec.framework.base.BaseCtl;
import com.lec.framework.base.Page;
import com.lec.framework.log.anotation.LogAspect;
import com.lec.framework.resource.MessageResources;
import com.lec.framework.util.Servlets;
import com.lec.framework.util.UuidGenerateUtil;
import com.lec.framework.util.ZhongWenToPinYin;
import com.lec.framework.validator.ResponseEntity;

/***
 * 角色管理
 * 
 * @author zhouhaij
 * @Apr 16, 2013 5:39:59 PM
 */
@Controller
@RequestMapping(value = "system/role")
public class RoleCtl extends BaseCtl {

	@Resource
	RoleService roleService;

	@Resource
	ResourceService resourceService;

	@Resource
	InvocationSecurityMetadataSourceBean filterInvocationDefinitionSource;
	
	@Resource
	AuthorityButtonCache authorityButtonCache;
	
	/***
	 * 跳转到主界面
	 * 
	 * @param menuid
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "list/{menuid}/")
	public String list(@PathVariable String menuid, ModelMap model, @RequestParam(value = "sortType", defaultValue = "id") String sortType, @RequestParam(value = "page", defaultValue = "0") int pageNumber, HttpServletRequest request) {
		logger.info("正在进行部门列表查询。。。。。。");
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		Page page = roleService.getRolesByCondition(searchParams, pageNumber, Page.DEFAULT_PAGE_SIZE, sortType);
        // 获取资源管理器
        MessageResources resource = MessageResources.getMessageInstance(null, null,Locale.CHINA);
        // 获取超级管理员的编码
        String superRole = resource.getMessage("super.user.code");
		boolean isRealse = isRealse(request.getSession().getServletContext());
		if (isRealse) {
			@SuppressWarnings("unchecked")
			List<Role> list = page.getResult();
			for (Iterator<Role> iterator = list.iterator(); iterator.hasNext();) {
				Role role = iterator.next();
				// 隐藏超级管理员的角色
				if (superRole.toUpperCase().equals(role.getCode().toUpperCase())) {
					iterator.remove();
				}
			}
            page.setTotalSize(page.getTotalSize()-1);
		}

		model.addAttribute("menuid", menuid);
		model.addAttribute("sortType", sortType);
		model.addAttribute("pageList", page);
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));

		Role role = new Role();
		try {
			// 将查询的map转换成user对象
			BeanUtils.populate(role, searchParams);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
        OperatorDetails oper = SpringSecurityUtils.getCurrentUser();
        //存入当前登录用户
        model.addAttribute("oper", oper);

        Collection<GrantedAuthority> authorities = oper.getAuthorities();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(superRole);
        Boolean isAdmin = false;
        if(authorities.contains(grantedAuthority)){
            logger.info("当前用户为超级管理员");
            isAdmin = true;
        }
        //存入当前登录用户
        model.addAttribute("isAdmin", isAdmin);

		model.addAttribute("role", role);
		return "system/role/list";
	}

	/***
	 * 删除角色
	 * 
	 * @param ids
	 */
	@RequestMapping(value = "delete/{ids}/", method = RequestMethod.DELETE)
	@ResponseBody
	@LogAspect(desc = "删除角色")
	public ResponseEntity delete(@PathVariable String ids) {
		ResponseEntity entity = new ResponseEntity();
		try {
			logger.info("正在进行角色数据删除。。。。。。");
			String[] id = ids.split(",");
			for (String string : id) {
				roleService.deleteById(string);
			}
			entity.setResult("ok");
			return entity;
		} catch (Exception e) {
			entity.setResult("error");
			return entity;
		}
	}

	
	/***
	 * 判断角色名称是否重复
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "nameExist")
	@ResponseBody
	public String nameExist(HttpServletRequest req, @RequestParam(value = "name") String name) {
		boolean dic = roleService.containsName(name);
		String returnStr = Boolean.FALSE.toString();
		if (!dic) {
			returnStr = Boolean.TRUE.toString();
		}
		String oper = req.getParameter("oper");
		//不为空说明是修改
		if(StringUtils.isNotBlank(oper)){
			if(name.equals(oper)){
				return Boolean.TRUE.toString();
			}
		}
		return returnStr;
	}
	
	/***
	 * 添加角色
	 * 
	 * @param role
	 * @param menuid
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "doAdd", method = RequestMethod.POST)
	@LogAspect(desc = "添加角色")
	public String doAdd(Role role, String menuid, RedirectAttributes redirectAttributes) {
		logger.info("menuid:" + menuid);
		role.setId(UuidGenerateUtil.getUUIDLong());
		role.setCode(ZhongWenToPinYin.getPinYin(role.getName()).toUpperCase());
		role.setStatus("0");
        role.setCreateBy(getCurrentUserId());
		roleService.save(role);

		redirectAttributes.addAttribute("message", "部门添加成功");
		return "redirect:/system/role/list/" + menuid + "/";
	}

	/***
	 * 获取待修改角色信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "update/{id}/{menuid}/", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") String id, @PathVariable("menuid") String menuid, String page, Model model) {
		model.addAttribute("role", roleService.getById(id));
		model.addAttribute("menuid", menuid);
		model.addAttribute("page", page);
		return "system/role/update";
	}

	@RequestMapping(value = "showview/{id}/{menuid}/", method = RequestMethod.GET)
	public String showview(@PathVariable("id") String id, @PathVariable("menuid") String menuid, String page, Model model) {
		model.addAttribute("role", roleService.getById(id));
		model.addAttribute("menuid", menuid);
		model.addAttribute("page", page);
		return "system/role/showview";
	}
	
	/***
	 * 修改角色
	 * 
	 * @param role
	 * @param menuid
	 * @param redirectAttributes
	 * @return
	 */
	@RequestMapping(value = "doUpdate", method = RequestMethod.POST)
	@LogAspect(desc = "修改角色")
	public String doUpdate(@ModelAttribute("preloadRole") Role role, String page, String menuid, RedirectAttributes redirectAttributes) {
		roleService.updateByIdSelective(role);
		redirectAttributes.addFlashAttribute("message", "修改成功");
		return "redirect:/system/role/list/" + menuid + "/?page=" + page;
	}

	/***
	 * 资源授权
	 * 
	 * @param menuid
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "grantres/{menuid}/{roleid}", method = RequestMethod.GET)
	public String grantRes(@PathVariable("roleid") String roleid, @PathVariable("menuid") String menuid, String page, Model model, HttpServletRequest request) {
		String[] roleids = roleid.split(",");
		List<Role> roles = new ArrayList<Role>();
        OperatorDetails currentUser = getCurrentUser();
		String resCode = null;
        MessageResources messageInstance = MessageResources.getMessageInstance(null, null, Locale.CHINA);
        //获取超级管理员角色
        resCode = messageInstance.getMessage("super.user.code");
        List<SystemResource> res = null;
        Collection<GrantedAuthority> authorities = currentUser.getAuthorities();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(resCode);
        if(authorities.contains(grantedAuthority)){
            logger.info("当前用户为超级管理员");
            res = resourceService.findAll(false);
        }
        //如果不是超级管理员，则获取当前用户的资源权限
        else{
            res = resourceService.getAllResourceByUserId(currentUser.getId());
        }

		JsonArray jsonArray = new JsonArray();
		for (int i = 0; i < res.size(); i++) {
			SystemResource resource = res.get(i);
			if (resCode != null) {
				if (resCode.toUpperCase().equals(resource.getCode().toUpperCase())) {
					res.remove(i);
					i++;
					continue;
				}
			}
			JsonObject json = new JsonObject();
			json.addProperty("id", resource.getId());
			json.addProperty("pId", resource.getParentid());

			json.addProperty("name", resource.getName());

			for (String rid : roleids) {
				// 判断角色是否有权限
				boolean checked = resourceService.hasResourceByRoleId(rid, resource.getId());
				if (checked) {
					json.addProperty("checked", "true");
					//跳出循环，继续下个角色，避免多角色时，出现树节点重复问题
					continue;
				}
			}	
			jsonArray.add(json);
		}
		//存入到授权的角色信息
		for (String rid : roleids) {
			Role role = roleService.getById(rid);
			roles.add(role);
		}
		logger.debug("response json:{0}", jsonArray.toString());
		model.addAttribute("data", jsonArray.toString());

		model.addAttribute("menuid", menuid);
		model.addAttribute("page", page);
		model.addAttribute("roles", roles);
		model.addAttribute("roleids", roleid);
		return "system/role/grant_res";
	}

	@RequestMapping(value = "showTree/{roleid}", method = RequestMethod.POST)
	public void showTree(@PathVariable("roleid") String roleid, @RequestParam(value = "id", defaultValue = "0") String id, ServletResponse resp) {
		logger.info("正在进行系统资源信息查询。。。。。。");

		List<SystemResource> SystemResourceList = resourceService.getChildren(id,MenuType.MODULE);
		JsonArray jsonArray = new JsonArray();
		for (SystemResource res : SystemResourceList) {
			JsonObject json = new JsonObject();
			json.addProperty("id", res.getId());
			json.addProperty("isParent", resourceService.hasChild(res.getId(),MenuType.MODULE));
			json.addProperty("name", res.getName());
			// 判断角色是否有权限
			boolean checked = resourceService.hasResourceByRoleId(roleid, res.getId());
			if (checked) {
				json.addProperty("checked", "true");
			}
			jsonArray.add(json);
		}
		logger.debug("response json:{0}", jsonArray.toString());
		try {
			resp.getWriter().write(jsonArray.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "doGrantRes/{roleid}/", method = RequestMethod.POST)
	@LogAspect(desc = "角色资源授权")
	public String doGrantRes(@PathVariable("roleid") String roleid,String menuid, String page,ServletRequest req,RedirectAttributes redirectAttributes) {
		String res = req.getParameter("res");
		String[] roleids = roleid.split(",");
		for (String string : roleids) {
			resourceService.grantRoleResource(string, res.split(","));
		}
		try {
			//刷新角色权限关系
			filterInvocationDefinitionSource.refreshRoleResource();
		} catch (Exception e) {
			e.printStackTrace();
		}
		redirectAttributes.addFlashAttribute("message", "授权成功");
		return "redirect:/system/role/list/" + menuid + "/?page=" + page;
	}

	/***
	 * 先根据form的id从数据库查出User对象，再把Form提交的内容绑定到该对象上
	 * 
	 * @param id
	 * @return
	 */
	@ModelAttribute("preloadRole")
	public Role getRole(@RequestParam(value = "id", required = false) String id) {
		if (id != null) {
			return roleService.getById(id);
		}
		return null;
	}

}
