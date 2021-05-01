package com.easyliao.qyweixin.service.common.aspect;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Slf4j
@Aspect
@Component
public class LogAspect {

    @Pointcut("execution(public * com.yanqin.bookdeal.controller..*.*(..))")
    public void systemLog() {}

    @Around(value = "systemLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        long startTime = System.currentTimeMillis();
        Object proceed = null;
        String formParam = "",bodyParam = "";
        Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        try {
            formParam = gson.toJson(request.getParameterMap());
            //请求的参数
            Object[] args = joinPoint.getArgs();
            bodyParam = Arrays.toString(args);

            proceed = joinPoint.proceed();
            return proceed;
        }catch (Exception e){
            throw e;
        }finally {
            try {
                long endTime = System.currentTimeMillis();

                MethodSignature signature = (MethodSignature) joinPoint.getSignature();

                //请求的方法名
                String className = joinPoint.getTarget().getClass().getName();
                String methodName = signature.getName();

                log.info("请求接口: [{}] \n" +
                                "请求方法: [{}] \n" +
                                "访问ip: [{}] \n" +
                                "类名: [{}] \n" +
                                "方法名: [{}] \n" +
                                "表单参数: [{}] \n" +
                                "请求体参数: [{}] \n" +
                                "耗时: [{}ms] \n" +
                                "响应: [{}] \n",
                        request.getRequestURL().toString(),
                        request.getMethod(),
                        request.getRemoteAddr(),
                        className,
                        methodName,
                        formParam,
                        bodyParam,
                        endTime - startTime,
                        gson.toJson(proceed)
                );
                if (endTime - startTime > 5000) {
                    log.warn("接口响应时间超过5s了！！！");
                }
            }catch (Exception e){
                log.error("LogAspect error",e);
            }
        }



    }

//    private String convert(String data) {
//        ScriptEngineManager sem = new ScriptEngineManager();
//        ScriptEngine engine = sem.getEngineByExtension("js");
//        String convert = null;
//        try {
//            convert = (String)engine.eval("unescape('"+data+"')");
//            System.out.println(convert);
//        } catch (ScriptException e) {
//            e.printStackTrace();
//        }
//        return convert;
//    }
}
