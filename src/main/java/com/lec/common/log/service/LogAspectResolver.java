package com.lec.common.log.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.lec.common.log.vo.OperationLog;
import com.lec.common.system.service.ResourceService;
import com.lec.common.system.vo.SystemResource;
import com.lec.framework.log.Logging;
import com.lec.framework.log.anotation.LogAspect;
import com.lec.framework.security.SpringSecurityUtils;
import com.lec.framework.util.JsonUtil;
import com.lec.framework.util.UuidGenerateUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;

/***
 * 日志注解处理器
 * @author zhouhaij
 * @Apr 25, 2013 8:52:03 AM
 */
@Aspect
public class LogAspectResolver {
	
	private static GsonBuilder builder = new GsonBuilder();   
	
	private Logging logger = new Logging(LogAspectResolver.class);
	
	Gson gson = null;
	
	public LogAspectResolver(){
		gson = builder.setDateFormat("yyyy-mm-dd").create();   
	}
	
	@Resource
    OperateLogService operateLogService;  
    
	@Resource
	ResourceService resourceService;
	
    /***
     * 标注该方法体为后置通知，当目标方法执行成功后执行该方法体  
     * @param jp
     */
    @AfterReturning("within(com.lec..*) && @annotation(la)")  
    public void addLogSuccess(JoinPoint jp, LogAspect la){  
    	//获取目标方法体参数  
        Object[] parames = jp.getArgs();
        //获取目标类名  
        String className = jp.getTarget().getClass().getSimpleName();
        //获取目标方法签名 
        String signature = jp.getSignature().toString(); 
        //获取具体的方法名
        String methodName = signature.substring(signature.lastIndexOf(".")+1, signature.indexOf("("));  
    	
        logger.info("正在调用的类名："+className);
        logger.info("方法签名:"+methodName);
        
        User user = SpringSecurityUtils.getCurrentUser();
        String ip = SpringSecurityUtils.getCurrentUserIp();
        
        OperationLog log = new OperationLog();
        log.setId(UuidGenerateUtil.getUUIDLong());
        log.setClassName(className);
        log.setDes(la.desc());
        log.setIsSuccess("1");
        log.setMethodName(methodName);
        
        log.setOperateTime(new Date());
        log.setOperateType(parseOperateType(methodName));
        log.setOperator(user.getUsername());
        log.setIp(ip);
        
        String sb = parseParams(parames, log);
        
        log.setContent("");
        log.setArgs(sb);
        operateLogService.save(log);
    }



   /***
    * 标注该方法体为异常通知，当目标方法出现异常时，执行该方法体  
    * @param jp
    * @param ex
    */
    @AfterThrowing(pointcut="within(com.lec..*) && @annotation(la)", throwing="ex")  
    public void addLog(JoinPoint jp, LogAspect la,Exception ex){ 
    	//获取目标方法体参数  
        Object[] parames = jp.getArgs();
        //获取目标类名  
        String className = jp.getTarget().getClass().getSimpleName();
        //获取目标方法签名 
        String signature = jp.getSignature().toString(); 
        //获取具体的方法名
        String methodName = signature.substring(signature.lastIndexOf(".")+1, signature.indexOf("("));  
    	
        logger.info("正在调用的类名："+className);
        logger.info("方法签名:"+methodName);
        logger.info("参数:"+parames);
        
        
        User user = SpringSecurityUtils.getCurrentUser();
        String ip = SpringSecurityUtils.getCurrentUserIp();
        
        OperationLog log = new OperationLog();
        log.setId(UuidGenerateUtil.getUUIDLong());
        log.setClassName(className);
        log.setDes(la.desc());
        log.setIsSuccess("0");
        log.setMethodName(methodName);
        
        log.setOperateTime(new Date());
        log.setOperateType(parseOperateType(methodName));
        log.setOperator(user.getUsername());
        log.setIp(ip);
        
        String sb = parseParams(parames, log);
        log.setArgs(sb);
        
        Writer wr = new StringWriter(0);
        PrintWriter writer = new PrintWriter(wr,true);
        ex.printStackTrace(writer);
        String content = wr.toString();
        if(content.length()>2000){
        	log.setContent(content.substring(0, 2000));
        }else{
        	log.setContent(content);
        }
        operateLogService.save(log);
    }
    
    

	private String parseParams(Object[] parames, OperationLog log) {
		JsonArray sb = new JsonArray();
        for (Object object : parames) {
        	if(object == null){
        		continue;
        	}
        	
        	if (object instanceof RedirectAttributes || object instanceof ServletRequest || object instanceof ServletResponse || object instanceof Model) {
        		continue;
			}
        	
        	if(object instanceof Collection){
                try {
                    return JsonUtil.toJson(object).toString();
                }catch (Exception e){
                    e.printStackTrace();
                }
        	}else{
        		//判断是不是系统生成的uuid,如果是则查找模块名称
        		if(object.toString().length()==30 || object.toString().length()==32){
        			SystemResource res = resourceService.getById(object.toString());
        			if(res!=null){
        				log.setModuleName(res.getName());
        			}else{
        				//不是menuid,说明是参数
        				JsonObject obj = new JsonObject();
        				obj.addProperty("str", object.toString());
        				sb.add(obj);
        			}
        		}
        		else{
        			if(object instanceof String){
                        JsonObject obj = new JsonObject();
        				obj.addProperty("str", object.toString());
        				sb.add(obj);
        			}else{
                        try {
                            return JsonUtil.toJson(object).toString();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
        			}
        		}
        	}
		}
        return sb.toString();
	}

    private String parseOperateType(String methodName){
    	if(methodName.toLowerCase().contains("add"))  return "a";
    	if(methodName.toLowerCase().contains("update"))  return "u";
    	if(methodName.toLowerCase().contains("del"))  return "d";
    	return "o";
    }
    

}
