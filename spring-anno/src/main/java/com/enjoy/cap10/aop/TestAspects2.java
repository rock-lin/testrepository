package com.enjoy.cap10.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

//日志切面类
@Aspect
@Order(1)
public class TestAspects2 {
    @Pointcut("execution(public int com.enjoy.cap10.aop.Calculator.*(..))")
	public void apointCut(){};
	
	//@before代表在目标方法执行前切入, 并指定在哪个方法前切入
	@Before("apointCut()")
	public void aalogStart(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName()+"除法2运行....参数列表是:{"+Arrays.asList(joinPoint.getArgs())+"}");
	}
	@After("apointCut()")
	public void aalogEnd(JoinPoint joinPoint){
		System.out.println(joinPoint.getSignature().getName()+"除法2结束......");
		
	}
	@AfterReturning(value="apointCut()",returning="result")
	public void aalogReturn(Object result){
		System.out.println("除法2正常返回......运行结果是:{"+result+"}");
	}
	@AfterThrowing(value="apointCut()",throwing="exception")
	public void aalogException(Exception exception){
		System.out.println("运行异常......异常信息是:{"+exception+"}");
	}
//	
//	/*@Around("pointCut()")
//	public Object Around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
//		System.out.println("@Arount:执行目标方法之前...");
//		Object obj = proceedingJoinPoint.proceed();//相当于开始调div地
//		System.out.println("@Arount:执行目标方法之后...");
//		return obj;
//	}*/
}
