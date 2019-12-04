package com.enjoy.cap10.aop;

import org.springframework.aop.framework.AopContext;

public class Calculator {
	//业务逻辑方法
	public int div(int i, int j)  {
		System.out.println("--------");
//		((Calculator)AopContext.currentProxy()).xf(i, j);
		return i/j;
	}
	
	
	//业务逻辑方法
    public int xf(int i, int j)  {
        System.out.println(">>>>>>>");
        return i*j;
    }
	
}
