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
public class LinkedListDoublyLinked implements ArrayListEx {

	private int numItems = 0;
	private int maxIndex = 0;
	private Object[] objects = {};
	private Node first, prev, last, next, node;

	@Override
	public void prepend(Object obj) {
		if (isEmpty()) {
			first = new Node(obj, null, null, maxIndex);

			maxIndex++;
			numItems++;
		} else {
			next = new Node(first.obj, first, null, maxIndex);

			first = new Node(obj, null, next, 0);
			
			next.prev = first;
			
			maxIndex++;
			numItems++;
		}
	}

	@Override
	public void append(Object obj) {

	}

	@Override
	public Object remove(int index) {
		Object ret = null;

		return ret;
	}

	@Override
	public int size() {
		return maxIndex + 1;
	}

	@Override
	public boolean isEmpty() {
		return numItems == 0;
	}

	@Override
	public Object get(int index) {
		Object ret = null;
		Iterator iter = iterator();

		Node temp = new Node();
		while (iter.hasNext()) {
			if (temp.prev.index == index) {
				ret = temp.prev.obj;
			} else if (temp.next.index == index) {
				ret = temp.next.obj;
			} else {

			}
		}

		return ret;
	}

	@Override
	public void insert(Object obj, int index) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public Iterator iterator() {
		return new LinkedListArrayListIterator();
	}

	private class LinkedListArrayListIterator implements Iterator {

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

	private class Node {

		Object obj;
		Node next, prev;
		int index;

		public Node() {

		}

		public Node(Object obj, Node next, int index) {
			this.obj = obj;
			this.next = next;
			this.index = index;
		}

		public Node(Object obj, Node prev, Node next, int index) {
			this.obj = obj;
			this.prev = prev;
			this.next = next;
			this.index = index;
		}


	}


}
