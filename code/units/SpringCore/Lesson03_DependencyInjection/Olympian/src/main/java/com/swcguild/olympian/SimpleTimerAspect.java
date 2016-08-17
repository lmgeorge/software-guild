/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.olympian;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class SimpleTimerAspect {
	public Object timeMethod(ProceedingJoinPoint jp){
		Object obj = null;
		try{
			long start = System.currentTimeMillis();
			obj = jp.proceed();
			long end = System.currentTimeMillis();
			System.out.println("\n" 
				+ jp.getSignature().getName() 
				+ " ran for " + (end - start) + "ms");
		}catch (Throwable ex){
			System.out.println("Exception in SimpleTinerAspect.timeMethod");
		}
		
		
		return obj;
	}
}
