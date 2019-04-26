package com.lec.module.device.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec.framework.base.BaseCtl;
import com.lec.framework.base.Page;
import com.lec.framework.util.Servlets;
import com.lec.module.device.service.DeviceSensorDataService;

@Controller
@RequestMapping({ "/device/sensor/data" })
public class DeviceSensorDataCtl extends BaseCtl {

	@Resource
	DeviceSensorDataService deviceSensorDataService;

	@RequestMapping({ "list/{deviceCode}/{sensorCode}/" })
	public String list(@PathVariable("deviceCode") String deviceCode, @PathVariable("sensorCode") String sensorCode,
			@RequestParam(value = "sortType", defaultValue = "DATA_TIME DESC") String sortType,
			@RequestParam(value = "page", defaultValue = "0") int pageNumber, Model model, HttpServletRequest request) {
		
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(request, "search_");
		searchParams.put("deviceCode", deviceCode);
		searchParams.put("sensorCode", sensorCode);

		Page page = deviceSensorDataService.getListByCondition(searchParams, pageNumber, 15, sortType);

		model.addAllAttributes(searchParams);
		model.addAttribute("sortType", sortType);
		model.addAttribute("pageList", page);
		model.addAttribute("page", Integer.valueOf(pageNumber));

		return "device/data/list";
	}
}
