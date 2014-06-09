package com.yuexin.service;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * ����
 * @author Administrator
 *
 */
@Aspect
public class MyInterceptor {
	@SuppressWarnings("unused")
	@Pointcut("execution(* com.yuexin.service.impl.PersonServiceImpl.*(..))")
	private void anyMethod(){}
	
	@Before("anyMethod()")
	public void doAccessCheck(){
		System.out.println("ǰ��֪ͨ");
	}
	
	@AfterReturning("anyMethod()")
	public void after(){
		System.out.println("����֪ͨ��");
	}
}
