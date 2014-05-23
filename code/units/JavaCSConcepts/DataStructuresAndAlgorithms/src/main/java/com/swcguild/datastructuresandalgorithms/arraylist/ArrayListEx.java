/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.datastructuresandalgorithms.arraylist;

import java.util.Iterator;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface ArrayListEx {
	
	public void prepend (Object obj);
	public void append(Object obj);
	public Object remove(int index);
	public void insert(Object obj, int index);
	public int size();
	public boolean isEmpty();
	public Object get(int index);
	public Iterator iterator();
}
