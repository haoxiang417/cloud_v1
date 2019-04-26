package com.lec.common.log.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.common.log.service.OperateLogService;
import com.lec.common.log.service.SystemLogService;
import com.lec.common.log.vo.SystemLog;
import com.lec.framework.base.BaseCtl;
import com.lec.framework.base.Page;
import com.lec.framework.util.Servlets;

/**
 * <p>日志控制器</p>
 * @author zhouhaij
 * @since 1.0
 * @version
 */
@Controller
@RequestMapping("system/log")
public class LogCtl extends BaseCtl{
	
	@Resource
	SystemLogService systemLogService;
	
	@Resource
	OperateLogService operateLogService;

	@RequestMapping(value="loginlist/{menuid}")
	public String loginlist(ModelMap model,@PathVariable String menuid
			, @RequestParam(value = "sortType", defaultValue = "id") String sortType
			, @RequestParam(value = "page", defaultValue = "0") int pageNumber, HttpServletRequest request){
		logger.info("正在进行登录日志查询");
		
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		super.updateSession(request, menuid, searchParams);
		Page page = systemLogService.getSystemLogsByCondition(searchParams, pageNumber, Page.DEFAULT_PAGE_SIZE, sortType);
		
		// 将搜索条件编码成字符串，用于排序，分页的URL
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		model.addAttribute("menuid", menuid);
		model.addAttribute("sortType", sortType);
		model.addAttribute("pageList", page);
		model.addAllAttributes(searchParams);
		return "system/log/login_list";
	}
	
	@RequestMapping(value="showloginview/{id}/{menuid}")
	public String showloginview(@PathVariable String id,@PathVariable String menuid,ModelMap model){
		SystemLog syslog = systemLogService.getById(id);
		model.addAttribute("menuid", menuid);
		model.addAttribute("syslog", syslog);
		return "system/log/login_view";
	}
	
	
	@RequestMapping(value="operlist/{menuid}")
	public String operlist(ModelMap model,@PathVariable String menuid, @RequestParam(value = "sortType", defaultValue = "id") String sortType
			, @RequestParam(value = "page", defaultValue = "0") int pageNumber, HttpServletRequest request){
		logger.info("正在进行操作日志查询");
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		processOperList(model, menuid, sortType, pageNumber, searchParams, request);
		return "system/log/oper_list";
	}
	
	
	@RequestMapping(value = "showOperview/{id}/{menuid}/", method = RequestMethod.GET)
	public String showOperview(@PathVariable("id") String id,@PathVariable("menuid") String menuid,String page,Model model){
		model.addAttribute("log",operateLogService.selectLogById(id));
		model.addAttribute("menuid",menuid);
		model.addAttribute("page",page);
		return "system/log/showview_oper";
	}

	@RequestMapping("errorlist/{menuid}")
	public String errorList(ModelMap model,@PathVariable String menuid, @RequestParam(value = "sortType", defaultValue = "id") String sortType
			, @RequestParam(value = "page", defaultValue = "0") int pageNumber, HttpServletRequest request){
		logger.info("正在进行异常操作日志查询");
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		//添加异常日志的标志
		searchParams.put("isSuccess", "0");
		processOperList(model, menuid, sortType, pageNumber, searchParams, request);
		return "system/log/error_list";
	}
	
	@RequestMapping(value = "showview/{id}/{menuid}/", method = RequestMethod.GET)
	public String showview(@PathVariable("id") String id,@PathVariable("menuid") String menuid,String page,Model model){
		model.addAttribute("log",operateLogService.selectLogById(id));
		model.addAttribute("menuid",menuid);
		model.addAttribute("page",page);
		return "system/log/showerror";
	}
	
	
	/**
	 * @param model
	 * @param menuid
	 * @param sortType
	 * @param pageNumber
	 * @param searchParams
	 */
	private void processOperList(ModelMap model, String menuid, String sortType, int pageNumber
			, Map<String, Object> searchParams, HttpServletRequest request) {
		super.updateSession(request, menuid, searchParams);
		Page page = operateLogService.getLogsByCondition(searchParams, pageNumber, Page.DEFAULT_PAGE_SIZE, sortType);
		
		model.addAllAttributes(searchParams);
		model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
		model.addAttribute("menuid", menuid);
		model.addAttribute("sortType", sortType);
		model.addAttribute("pageList", page);
	}
}
