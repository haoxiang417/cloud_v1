package com.lec.framework.form.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 防重复提交的注解
 * @author HX
 * 2017-10-16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SameUrlData {

	/**
	 * 添加方法的path，默认doAdd
	 * @return
	 */
	String addPath() default "doAdd";
	/**
	 * 列表查询方法的path，默认list
	 * @return
	 */
	String listPath() default "list";
	
}
