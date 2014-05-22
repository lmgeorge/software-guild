/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.datastructuresandalgorithms.queue;


/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface Queue extends Iterable{
	
	public void add(Object obj);
	
	public Object remove();
	
	public boolean isEmpty();
	
	public int size();
	
}
