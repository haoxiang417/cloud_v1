package com.lec.common.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;

import org.springframework.util.ResourceUtils;

import com.lec.framework.base.BaseCtl;

/**
 * 用于导出的基础类
 * @author HX
 *
 */
public class ExportBaseCtl extends BaseCtl {

	/**
	 * 获取导出模板文件
	 * @param templatePath
	 * @return
	 * @throws Exception
	 */
	public InputStream getTemplateFile(String templatePath) throws Exception {
		URL url = this.getClass().getClassLoader().getResource(templatePath);
		if(url == null){
			url = ResourceUtils.getURL("classpath:" + templatePath);
		}
		if(url == null){
			url = ResourceUtils.getURL("file:" + templatePath);
		}
		InputStream ins = new FileInputStream(url.getFile());
		return ins;
	}
	
}
