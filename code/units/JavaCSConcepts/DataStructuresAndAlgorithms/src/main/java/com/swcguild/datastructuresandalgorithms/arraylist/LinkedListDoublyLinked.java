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

	private int size;
	private Node head, tail;

	public LinkedListDoublyLinked() {
		head = new Node(null, null, null, 0);
		tail = new Node(null, null, null, 1);
		size = 0;

		head.setNext(tail);
		tail.setPrev(head);
	}

	@Override
	public void prepend(Object obj) {

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
		return size + 1;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Object get(int index) {
		Object obj = null;
		
		return obj; 
	}

	@Override
	public void insert(Object obj, int index) {

	}

	@Override
	public Iterator iterator() {
		return new LinkedListArrayListIterator();
	}

	private class LinkedListArrayListIterator implements Iterator {

		Node node;

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

		public void setPrev(Node prev) {
			this.prev = prev;
		}

		public void setNext(Node next) {
			this.next = next;
		}

		public Node getPrev(Node node) {
			if (node == head) {
				return null;
			}
			return node.prev;
		}

		public Node getNext(Node node) {
			if (node == tail) {
				return null;
			}
			return node.next;
		}


	}


}
