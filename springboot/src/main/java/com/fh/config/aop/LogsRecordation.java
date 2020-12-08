package com.fh.config.aop;

import com.fh.logs.entity.TLogs1203;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class LogsRecordation {

    @Resource
    private HttpServletRequest request;

    @Pointcut("execution(* com.fh.user.controller..*.*(..))")
    public void loginPointCut() {
    }


    @Around("loginPointCut() && @annotation(logsAnnontation) ")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint,LogsAnnontation logsAnnontation){
        Object object = null;
        TLogs1203 tLogs1203= new TLogs1203();
        //获取类路径
        tLogs1203.setClassname(joinPoint.getSignature().getDeclaringTypeName());
        //获取方法名
        tLogs1203.setMethodname(joinPoint.getSignature().getName());
        try {
            object = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }finally {

        }
        return object;
    }
}
