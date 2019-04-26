package com.lec.framework.security;

import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;

import com.lec.framework.util.DeEncryptUtil;

/**
 * 数据库配置文件 SPRING注入类
 * <p>Description: 这个类是数据库配置文件SPRING注入类</p>
 * @author: 岩涛
 * @date: 2012-09-05
 */
@SuppressWarnings("unchecked")
public class PropertiesDeEncrypt implements FactoryBean {

    private Properties properties;

    public Object getObject() throws Exception {
        return getProperties();
    }

    public Class getObjectType() {
        return Properties.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties inProperties) {
        this.properties = inProperties;
        String originalUsername = properties.getProperty("user");
        String originalPassword = properties.getProperty("password");
        properties.put("user", originalUsername);
        properties.put("password", originalPassword);
        if (originalUsername != null) {
            String newUsername = deEncryptString(originalUsername);
        }
        if (originalPassword != null) {
            String newPassword = deEncryptString(originalPassword);
        }
    }

    @SuppressWarnings("unused")
    private String deEncryptString(String originalString) {
        try {
            DeEncryptUtil des = new DeEncryptUtil();
            String input = des.decrypt(originalString);
            return input;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
