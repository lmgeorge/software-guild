/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructuresandalgorithms.queue;

import java.util.Iterator;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class ArrayQueue implements Queue {

	private int head = 0;
	private int tail = 0;
	private static final int DEFAULT_INITIAL_SIZE = 3;
	private int numItems = 0;
	private Object[] objects;

	public ArrayQueue(int size) {
		objects = new Object[size];
	}

	public ArrayQueue() {
		this(DEFAULT_INITIAL_SIZE);
	}

	@Override
	public void add(Object obj) {
		if (numItems == objects.length) {
			resize(objects.length * 2);
		}

		objects[tail] = obj;
		tail++;
		numItems++;

	}

	@Override
	public Object remove() {
		Object obj = null;

		if (!isEmpty()) {

			if (numItems <= objects.length / 4) {
				resize(objects.length / 4);
			}

			obj = objects[head];
			objects[head] = null;
			head++;
			numItems--;
		}

		return obj;
	}

	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public Iterator iterator() {
		return new ReverseArrayIterator();
	}

	public void resize(int length) {
		Object[] temp = new Object[length];

		int i = 0;
		int index = 0;
		while (i < tail) {
			temp[index] = objects[i % objects.length];
			
			if (objects[index] == null && objects[tail - 1] != null) {
				index = 0;
			} else {
				index++;
			}				
			
			i++;
		}
		objects = temp;
		head = 0;
		tail = index % objects.length;
		//tail = index;
	}

	public int size() {
		return numItems;
	}

	private class ReverseArrayIterator implements Iterator {

		private int i = numItems;

		@Override
		public boolean hasNext() {
			return i > 0;
		}

		@Override
		public Object next() {
			return objects[--i];
		}


	}


}
