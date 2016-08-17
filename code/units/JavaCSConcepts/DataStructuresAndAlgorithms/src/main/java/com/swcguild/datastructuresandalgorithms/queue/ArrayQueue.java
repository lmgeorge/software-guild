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
		tail++; //resizing will reset the tail to the end of the array, but incrementing the tail will help keep track if things are added in sucession
		numItems++;

	}

	@Override
	public Object remove() {
		Object obj = null;

		if (!isEmpty()) {
			//if the numItems == 1, then the array will be shrunk 
			//if we don't use <= then if numItems < 2, the array won't be shrunk
			if (numItems <= objects.length / 4) {
				resize(objects.length / 4);
			}

			obj = objects[head];
			objects[head] = null; // null out the object
			head++; //resizing will reset the head to the beginning of the array, but incrementing the head will help keep track if things are removed and then added again
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

		int counter = 0;
		int index = 0;
		while (counter < tail) {
			temp[index] = objects[counter % objects.length];
			
			// check if the indexed spot in the old array is null
			// if the new array is smaller than the old, the head in the new array won't be set to null
			// otherwise keep increment the index and check the next position as long as the counter is less than the tail position.
			if (objects[index] == null ) { 
				index = 0;
			} else {
				index++;
			}				
			
			counter++;
		}
		objects = temp;
		head = 0;
		tail = index % objects.length;
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
