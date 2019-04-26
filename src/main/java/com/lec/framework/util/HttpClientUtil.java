package com.lec.framework.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 * Apache HttpClient工具类
 * @author haoxiang
 * @version 1.0
 * 2015-9-29
 */
public class HttpClientUtil {

	/**
	 * 字符集
	 */
	public final static String CHAR_SET = "UTF-8";
	/**
	 * 1Mb大小，单位：byte
	 */
	public final static long SIZE_1M = 1024*1024;
	/**
	 * 请求配置
	 */
	private static RequestConfig CONFIG;
	static {
		//默认超时时间为5秒
		updateTimeout(5);
	}

	/**
	 * 更新超时时间
	 * @param second  超时时间[5~120]，单位：秒
	 */
	public static void updateTimeout(int second) {
		int time = 0;
		if (second < 5) {
			time = 5000;
		} else if (second > 120) {
			time = 120000;
		}else {
			time = second * 1000;
		}
		CONFIG = RequestConfig.custom()
				.setConnectTimeout(time)// 设置连接超时
				.setConnectionRequestTimeout(time)// 设置连接请求超时
				.setSocketTimeout(time)// 设置socket超时
				.build();
	}
	
	/**
	 * 发送post请求
	 * @param url
	 * @param args
	 * @return
	 * @throws Exception
	 */
	public static String httpPost(String url, Map<String, Object> args) throws Exception {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		try {
			httpclient = HttpClients.custom().setDefaultRequestConfig(CONFIG).build();

			HttpPost post = new HttpPost(url);

			// 给请求中设置参数
			if (args != null && args.size() > 0) {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				Object obj;
				for (String key : args.keySet()) {
					obj = args.get(key);
					if (obj == null) {
						continue;
					}
					params.add(new BasicNameValuePair(key, obj.toString()));
				}
				UrlEncodedFormEntity parms = new UrlEncodedFormEntity(params, CHAR_SET);
				post.setEntity(parms);
			}
			// 发送请求并接收返回
			response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();

			return readContentByInputStream(entity.getContent(), CHAR_SET);

		} catch (Exception e) {
			throw e;
		} finally {
			// 释放资源
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				response = null;
			}
			try {
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				httpclient = null;
			}
		}
	}
	
	/**
	 * 发送post请求，多个附件
	 * @param url
	 * @param args
	 * @param fileMap MultipartHttpServletRequest.getMultiFileMap()
	 * @param tempFilePath 上传文件时临时文件的路径
	 * @param signFileMaxSize 单个文件允许的最大容量；单位：byte
	 * @return
	 * @throws Exception
	 */
	public static String httpPostFiles(String url, Map<String, Object> args
			, MultiValueMap<String, MultipartFile> fileMap
			, String tempFilePath
			, long signFileMaxSize) throws Exception {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		
		try {
			httpclient = HttpClients.custom().setDefaultRequestConfig(CONFIG).build();

			HttpPost post = new HttpPost(url);

			// 给请求中设置参数
			if (args != null && args.size() > 0) {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				Object obj;
				for (String key : args.keySet()) {
					obj = args.get(key);
					if (obj == null) {
						continue;
					}
					params.add(new BasicNameValuePair(key, obj.toString()));
				}
				UrlEncodedFormEntity parms = new UrlEncodedFormEntity(params, CHAR_SET);
				post.setEntity(parms);
			}
			
			//添加附件
			MultipartEntityBuilder meb = MultipartEntityBuilder.create();
			meb.setCharset(Charset.forName(CHAR_SET));
			meb.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			//本地临时文件集合
			List<File> tempList = new ArrayList<File>();
			//本地临时文件
			File tempFile = null;
			for (String key : fileMap.keySet()) {
				List<MultipartFile> list = fileMap.get(key);
				for (MultipartFile file : list) {
					if (file == null || file.getSize() == 0) {
						continue;
					}
					//验证文件不能大于signFileMaxSize
					if (file.getSize() > signFileMaxSize) {
						continue;
					}
					tempFile = createTempFileByMultipartFile(file, tempFilePath);
					tempList.add(tempFile);
					meb.addPart(file.getName(), new FileBody(tempFile
							, ContentType.create("text/plain", "UTF-8"), file.getOriginalFilename()));
				}
			}
			post.setEntity(meb.build());
			
			// 发送请求并接收返回
			response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			
			//删除临时文件
			removeTempFiles(tempList);
			
			return readContentByInputStream(entity.getContent(), CHAR_SET);

		} catch (Exception e) {
			throw e;
		} finally {
			// 释放资源
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				response = null;
			}
			try {
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				httpclient = null;
			}
		}
	}
	
	/**
	 * 创建临时文件
	 * @param mf
	 * @param tempFilePath
	 * @return
	 */
	private static File createTempFileByMultipartFile(MultipartFile mf, String tempFilePath) {
		String oldFileName = mf.getOriginalFilename();
		File newFile = new File(tempFilePath + "/" + System.currentTimeMillis() + oldFileName.substring(oldFileName.lastIndexOf(".")));
		if (!newFile.exists()) {
			try {
				newFile.createNewFile();
			} catch (IOException e) { }
		}
		try {
			mf.transferTo(newFile);
			return newFile;
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 删除临时文件
	 * @param tempList
	 */
	private static void removeTempFiles(List<File> tempList) {
		for (File file : tempList) {
			if (file.exists()) {
				file.delete();
			}
		}
	}
	
	/**
	 * 发送post请求，单个附件
	 * @param url
	 * @param args
	 * @param file
	 * @param maxFileSize 最大文件大小
	 * @return
	 * @throws Exception
	 */
	public static String httpPostFile(String url, Map<String, Object> args
			, CommonsMultipartFile file, String tempFilePath, long maxFileSize) throws Exception {
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		
		try {
			httpclient = HttpClients.custom().setDefaultRequestConfig(CONFIG).build();

			HttpPost post = new HttpPost(url);

			// 给请求中设置参数
			if (args != null && args.size() > 0) {
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				Object obj;
				for (String key : args.keySet()) {
					obj = args.get(key);
					if (obj == null) {
						continue;
					}
					params.add(new BasicNameValuePair(key, obj.toString()));
				}
				UrlEncodedFormEntity parms = new UrlEncodedFormEntity(params, CHAR_SET);
				post.setEntity(parms);
			}
			//本地临时文件集合
			List<File> tempList = new ArrayList<File>();
			//添加附件
			if (file != null && file.getSize() <= maxFileSize) {
				MultipartEntityBuilder meb = MultipartEntityBuilder.create();
				meb.setCharset(Charset.forName(CHAR_SET));
				meb.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
				
				File tempFile = createTempFileByMultipartFile(file, tempFilePath);
				tempList.add(tempFile);
				
				meb.addPart(file.getName(), new FileBody(tempFile
						, ContentType.create("text/plain", "UTF-8"), file.getOriginalFilename()));
			}
			
			// 发送请求并接收返回
			response = httpclient.execute(post);
			HttpEntity entity = response.getEntity();
			
			//删除临时文件
			removeTempFiles(tempList);
			
			return readContentByInputStream(entity.getContent(), CHAR_SET);

		} catch (Exception e) {
			throw e;
		} finally {
			// 释放资源
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				response = null;
			}
			try {
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				httpclient = null;
			}
		}
	}

	/**
	 * 发送get请求
	 * @param url 请求地址
	 * @param args 参数，可为null
	 * @return
	 * @throws Exception
	 */
	public static String httpGet(String url, Map<String, Object> args) throws Exception {
		URIBuilder ub = new URIBuilder();
		//设置url编码
		ub.setCharset(Consts.UTF_8);
		//判断是否url里已经带有参数
		boolean isUrlParm = url.indexOf("?") > -1;
		//获取协议
		String sc = url.substring(0, url.indexOf(":"));
		//设置协议
		ub.setScheme(sc);
		url = url.substring(sc.length()+3);
		//设置host
		ub.setHost(url.substring(0, url.indexOf("/")));
		//设置访问的目标地址（path）
		if (isUrlParm) {
			ub.setPath(url.substring(url.indexOf("/"), url.indexOf("?")));
			//参数字符串,key1=value1&key2=value2.....
			String parmStr = url.substring(url.indexOf("?")+1);
			String[] strs = parmStr.split("&");
			String[] temp;
			for (String str : strs) {
				if (str == null || str.length() == 0) {
					continue;
				}
				temp = str.split("=");
				ub.setParameter(temp[0], temp[1]);
			}
		}else{
			ub.setPath(url.substring(url.indexOf("/")));
		}
		
		if (args != null) {
			Object obj;
			for (String key : args.keySet()) {
				obj = args.get(key);
				if (obj == null) {
					continue;
				}
				ub.setParameter(key, args.get(key).toString());
			}
		}
		CloseableHttpClient httpclient = null;
		CloseableHttpResponse response = null;
		try {
			httpclient = HttpClients.custom().setDefaultRequestConfig(CONFIG).build();

			HttpGet get = new HttpGet(ub.build());

			// 发送请求并接收返回
			response = httpclient.execute(get);

			// 获取返回体
			HttpEntity entity = response.getEntity();

			return readContentByInputStream(entity.getContent(), CHAR_SET);

		} catch (Exception e) {
			throw e;
		} finally {
			// 释放资源
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				response = null;
			}
			try {
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				httpclient = null;
			}
		}
	}
	
	/**
	 * 从输入流中读取返回数据
	 * @param in 输入流
	 * @param charset 字符集
	 * @return
	 */
	public static String readContentByInputStream(InputStream in, String charset) {
		StringBuilder str = new StringBuilder();
		// 获取返回数据
		BufferedReader reader = null;
		String tempLine = null;
		try {
			reader = new BufferedReader(new InputStreamReader(in, charset));
			while ((tempLine = reader.readLine()) != null) {
				str.append(tempLine);
			}
		} catch (Exception e) {
			return "";
		} finally {
			// 释放资源
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					reader = null;
				}
			}
		}
		return str.toString();
	}
	
}
