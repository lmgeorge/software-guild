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
public class LinkedListQueue implements Queue {

	private Node first, last;
	private int numItems = 0;

	@Override
	public void add(Object obj) {
		if (isEmpty()) {
			first = new Node(obj, null); 
		
		} else {
			last = new Node(first, null);
			first = new Node(obj, first);
		}
		numItems++;
	}

	@Override
	public Object remove() {
		Object ret;

		if (!iterator().hasNext()) {
			ret = null;
		} else {
			ret = first.obj;
			first = first.next;
		}
		numItems--;

		return ret;
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
	public Iterator iterator() {
		return new LinkedListIterator();
	}

	private class Node {

		private Object obj;
		private Node next;

		public Node(Object obj, Node next) {
			this.obj = obj;
			this.next = next;
		}


	}

	private class LinkedListIterator implements Iterator {

		Node node = first;

		@Override
		public boolean hasNext() {
			return node != null;
		}

		@Override
		public Object next() {

			if (!hasNext()) {
				return null;
			}

			Object ret = node.obj;
			node = node.next;

			return ret;
		}


	}


}
