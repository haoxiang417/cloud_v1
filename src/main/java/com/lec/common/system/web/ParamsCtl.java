package com.lec.common.system.web;

import com.lec.common.system.service.ParamsService;
import com.lec.common.system.vo.SystemParams;
import com.lec.framework.log.anotation.LogAspect;
import com.lec.framework.util.Servlets;
import com.lec.framework.util.StringUtils;
import com.lec.framework.util.UuidGenerateUtil;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/***
 * 系统设置处理
 * @author zhouhaij
 * @May 6, 2013 3:33:09 PM
 */
@Controller
@RequestMapping("system/params")
public class ParamsCtl {

  @Resource
  ParamsService paramsService;

  /***
   * 系统参数
   * @param model
   * @return
   */
  @RequestMapping("syslist/{menuid}/")
  public String syslist(@PathVariable String menuid, ModelMap model) {
    model.addAttribute("menuid", menuid);
    Map<String, String> maps = paramsService.getAllParams("1");
    model.addAllAttributes(maps);
    return "system/settings/sys_list";
  }


  @RequestMapping(value = "doUpdateSysParams", method = RequestMethod.POST)
  @LogAspect(desc = "修改系统参数")
  public String doUpdateSysParams(String menuid, HttpServletRequest req,
      RedirectAttributes redirectAttributes) {

    /***
     * 1 表示卡口    2 表示违法   3 表示监控    4 表示流量  5 表示Gps 6表示isBlack
     */
    String[] values = req.getParameterValues("sysMondule");
    //是否开启了部门权限
    String[] startDepart = req.getParameterValues("isStartDepartControl");

    String isStartDepartControl = startDepart[0];

    String[] params = new String[]{"isCross", "isVio", "isVideo", "isCount", "isGps", "isBlack"};
    Integer[] vals = new Integer[]{0, 0, 0, 0, 0, 0};

    if (values != null) {
      if (isStartDepartControl.equals("1") && values != null) {
        for (int i = 0; i < values.length; i++) {
          Integer val = Integer.parseInt(values[i]);
          vals[val - 1] = 1;
        }
      }
      for (int j = 0; j < vals.length; j++) {
        processSystemParams(params[j], vals[j] + "", "1");
      }

    } else {

      //当所有模块都没勾选时，设定为0
      for (int j = 0; j < params.length; j++) {
        processSystemParams(params[j], "0", "1");
      }
    }

    //设备对话框显示模式
    String dialogmodel = req.getParameter("dialogmodel");
    processSystemParams("dialogmodel", dialogmodel, "1");

    //区域编码
    String areacode = req.getParameter("areacode");
    processSystemParams("areacode", areacode, "1");

    //启用用户的部门权限
    processSystemParams("isStartDepartControl", isStartDepartControl, "1");

    //无设备部门是否显示所有的
    String[] showAlls = req.getParameterValues("isBlankDeviceShowAll");
    String isBlankDeviceShowAll = "0";
    if (showAlls != null) {
      isBlankDeviceShowAll = showAlls[0];
    }
    processSystemParams("isBlankDeviceShowAll", isBlankDeviceShowAll, "1");

    //刷新系统参数全局变量
    Map<String, String> maps = paramsService.getAllParams("1");
    ParamsService.SYSTEM_PARAMS.putAll(maps);

    //存入用户参数
    Map<String, String> userMaps = paramsService.getAllParams("0");
    ParamsService.SYSTEM_PARAMS.putAll(userMaps);

    maps.putAll(userMaps);

    req.getSession().getServletContext().setAttribute("atms", maps);

    redirectAttributes.addFlashAttribute("message", "设置成功");

    return "redirect:/system/params/syslist/" + menuid + "/";

  }


  /***
   * 用户参数
   * @param model
   * @return
   */
  @RequestMapping("userlist/{menuid}/")
  public String userlist(@PathVariable String menuid, ModelMap model) {
    Map<String, String> maps = paramsService.getAllParams("0");
    model.addAllAttributes(maps);
    model.addAttribute("menuid", menuid);
    return "system/settings/user_list";
  }


  @RequestMapping(value = "doUpdateUserParams", method = RequestMethod.POST)
  @LogAspect(desc = "修改用户参数")
  public String doUpdateUserParams(String menuid, HttpServletRequest req,
      RedirectAttributes redirectAttributes) {
    Map<String, Object> reqMap = Servlets.getParametersStartingWith(req, "set_");
    for (String key : reqMap.keySet()) {
      processSystemParams(key, reqMap.get(key).toString(), "0");
    }
    //刷新系统参数全局变量
    Map<String, String> maps = paramsService.getAllParams("0");
    ParamsService.SYSTEM_PARAMS.putAll(maps);

    //刷新系统参数全局变量
    Map<String, String> sysmaps = paramsService.getAllParams("1");
    ParamsService.SYSTEM_PARAMS.putAll(sysmaps);

    maps.putAll(sysmaps);

    //存入application变量，便于页面使用
    redirectAttributes.addFlashAttribute("message", "设置成功");
    req.getSession().getServletContext().setAttribute("atms", maps);

    return "redirect:/system/params/userlist/" + menuid + "/";
  }

  /**
   * @param key
   * @param value
   * @param type
   */
  private void processSystemParams(String key, String value, String type) {
    SystemParams systemParams = null;
    systemParams = paramsService.getParamsByKeyAndType(key, type);
    if (!StringUtils.isEmpty(value)) {
      if (systemParams == null) {
        systemParams = new SystemParams();
      }
      systemParams.setName(key);
      //1表示系统参数
      systemParams.setTypes(type);
      systemParams.setValue(value);
      if (StringUtils.isEmpty(systemParams.getId())) {
        systemParams.setId(UuidGenerateUtil.getUUIDLong());
        paramsService.save(systemParams);
      } else {
        paramsService.updateByIdSelective(systemParams);
      }
    }
  }


}
