/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.flooringapp;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class Timer {
	public Object timeMethod(ProceedingJoinPoint jp){
		Object obj = null;
		
		try{
			long begin = System.currentTimeMillis();
			obj = jp.proceed();
			long end = System.currentTimeMillis();
			
			System.out.printf("%n"
				+ jp.getSignature().getName() + 
				 " ran for " + (end - begin) + "ms.%n");
		}catch (Throwable ex){
			System.out.println("Error: Timer failed in " + Timer.class.getName());
		}
		
		return obj;
	}
}
