package com.lec.framework.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailUtil {

	/**
	 * 超时时间，5秒
	 */
	private static final int TIME_OUT = 5000;
	
	private static final String CHARTSET = "UTF-8";
	
	/**
	 * 发送简单文本邮件
	 * @param smtpAddr	发送邮箱的smtp地址
	 * @param loginUser	发送邮箱的登录名
	 * @param loginPwd	发送邮箱的登录密码
	 * @param toAddr	接收人地址
	 * @param toName	接收人称呼
	 * @param fromAddr	发件人地址
	 * @param fromName	发件人称呼
	 * @param title		邮件标题
	 * @param content	邮件内容
	 * @throws EmailException
	 */
	public static void sendSimpleMail(String smtpAddr, String loginUser, String loginPwd
			, String toAddr, String toName, String fromAddr, String fromName
			, String title, String content) throws EmailException {
		SimpleEmail email = new SimpleEmail();
		//smtp host 
		email.setHostName(smtpAddr);
		//设置使用SSL登录
		email.setSSLOnConnect(true);
		//设置登录超时时间
		email.setSocketConnectionTimeout(TIME_OUT);
		//设置发送邮件超时时间
		email.setSocketTimeout(2*TIME_OUT);
		//登陆邮件服务器的用户名和密码
		email.setAuthentication(loginUser, loginPwd);
		//接收人
		email.addTo(toAddr, toName, CHARTSET);
		if (fromAddr == null || fromAddr.length() == 0) {
			fromAddr = loginUser;
		}
		//发送人
		email.setFrom(fromAddr, fromName);
		//标题
		email.setSubject(title);
		//邮件内容
		email.setMsg(content);
		//发送
		email.send();
	}
	
}
