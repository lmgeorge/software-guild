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
public class LinkedListStack implements Stack {

	private Node first;
	private int numItems = 0;

	@Override
	public boolean isEmpty() {
		return first == null;
	}

	@Override
	public int size() {
		return numItems;
	}

	@Override
	public void push(Object obj) {
		first = new Node(obj, first);
		Node oldFirst = new Node(first, null);
		numItems++;
	}

	@Override
	public Object pop() {
		Object obj;
		if (!iterator().hasNext()) {
			obj = null;
		} else {
			obj = first.obj;

			first = first.next;
		}
		numItems--;

		return obj;
	}

	@Override
	public Iterator iterator() {
		return new LinkedListIterator();
	}

	private class LinkedListIterator implements Iterator {

		private Node node;

		public LinkedListIterator() {
			node = first;
		}

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

		private Object obj;
		private Node next;

		public Node(Object obj, Node next) {
			this.obj = obj;
			this.next = next;
		}


	}


}
