package com.lec.common.user.web;

import com.lec.common.deptment.service.DepartmentService;
import com.lec.common.user.service.UserService;
import com.lec.framework.base.BaseCtl;
import com.lec.framework.base.Page;
import com.lec.framework.util.ObjectUtils;
import com.lec.framework.util.Servlets;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by admin on 2014/7/13.
 */
@Controller
@RequestMapping("system/user/dialog")
public class UserDialogCtl  extends BaseCtl {

    @Resource
    UserService  UserService;

    @Resource
    DepartmentService departmentService;

    @RequestMapping(value = "show/{menuid}/")
    public String show(@PathVariable String menuid, ModelMap model, @RequestParam(value = "sortType", defaultValue = "id") String sortType, @RequestParam(value = "page", defaultValue = "0") int pageNumber, HttpServletRequest request) {
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");

        // 加入按部门查询,能查出当前部门及子部门
        Object orgid = searchParams.get("orgId");
        if (!ObjectUtils.isNull(orgid)) {
            searchParams.put("deptid",orgid.toString());
        }
        Page page = UserService.getUsersByCondition(searchParams, pageNumber, 10, sortType);
        //还原orgId，便于下次或翻页查询
        searchParams.put("orgId",orgid);
        model.addAttribute("sortType", sortType);
        model.addAttribute("orgId", orgid);
        model.addAttribute("menuid", menuid);
        model.addAttribute("pageList", page);
        // 将搜索条件编码成字符串，用于排序，分页的URL
        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
        model.addAttribute("search", searchParams);
        return "system/user/dialog";
    }
    
    @RequestMapping(value = "show1/{menuid}/")
    public String showFenpai(@PathVariable String menuid, ModelMap model, @RequestParam(value = "sortType", defaultValue = "id") String sortType, @RequestParam(value = "page", defaultValue = "0") int pageNumber, HttpServletRequest request) {
        Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");

        // 加入按部门查询,能查出当前部门及子部门
        Object orgid = searchParams.get("orgId");
        if (!ObjectUtils.isNull(orgid)) {
            searchParams.put("deptid",orgid.toString());
        }
        Page page = UserService.getUsersByCondition(searchParams, pageNumber, 10, sortType);
        //还原orgId，便于下次或翻页查询
        searchParams.put("orgId",orgid);
        model.addAttribute("sortType", sortType);
        model.addAttribute("orgId", orgid);
        model.addAttribute("menuid", menuid);
        model.addAttribute("pageList", page);
        // 将搜索条件编码成字符串，用于排序，分页的URL
        model.addAttribute("searchParams", Servlets.encodeParameterStringWithPrefix(searchParams, "search_"));
        model.addAttribute("search", searchParams);
        return "system/user/dialog1";
    }

    @RequestMapping(value = "showtransfer/{menuid}/")
    public String showtransfer(@PathVariable String menuid, ModelMap model, @RequestParam(value = "sortType", defaultValue = "id") String sortType, @RequestParam(value = "page", defaultValue = "0") int pageNumber, HttpServletRequest request) {
        show(menuid,model,sortType,pageNumber,request);
        return "system/user/transfer_dialog";
    }


}
