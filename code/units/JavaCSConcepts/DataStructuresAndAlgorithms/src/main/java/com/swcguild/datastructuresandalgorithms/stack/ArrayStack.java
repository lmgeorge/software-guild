/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructuresandalgorithms.stack;

import java.util.Iterator;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ArrayStack implements Stack {

	private static final int DEFAULT_INITIAL_SIZE = 4;
	private Object[] items;
	private int numItems = 0;

	public ArrayStack(int size) {
		items = new Object[size];
	}

	public ArrayStack() {
		this(DEFAULT_INITIAL_SIZE);
	}

	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public int size() {
		return numItems;
	}

	@Override
	public void push(Object obj) {
		if (numItems == items.length) {
			resize(items.length * 2);
		}
		
		items[numItems] = obj;
		numItems++;
	}

	@Override
	public Object pop() {
		if (numItems == 0){
			return null;
		}
		Object temp = items[numItems--];
		items[numItems] = null;
		
		if(numItems > 0 && numItems == items.length/4){
			resize(items.length/2);
		}
		
		return temp;
	}

	@Override
	public Iterator iterator() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	private void resize(int length) {
		Object[] temp = new Object[length];
		
		//System.arraycopy(items, 0, temp, 0, numItems);
		
		for(int i = 0; i < numItems; i++){
			temp[i] = items[i];
		}
		
		items = temp;
	}


}
