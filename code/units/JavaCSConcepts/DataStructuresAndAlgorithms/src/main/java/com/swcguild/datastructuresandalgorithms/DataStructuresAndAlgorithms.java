/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructuresandalgorithms;

import com.swcguild.datastructuresandalgorithms.queue.ArrayQueue;
import com.swcguild.datastructuresandalgorithms.queue.Queue;
import com.swcguild.datastructuresandalgorithms.stack.ArrayStack;
import com.swcguild.datastructuresandalgorithms.stack.Stack;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class DataStructuresAndAlgorithms {

	public static void main(String[] args) {

		Stack st = new ArrayStack();

		String a = "a";
		String b = "b";
		String c = "c";
		String d = "d";

		st.push(a);
		st.push(b);
		st.push(c);
		st.push(d);

		for (Object obj : st) {
			System.out.println((String) obj);
		}

		System.out.println("==============");

		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());
		System.out.println(st.pop());

		System.out.println("==============");
		System.out.println("==============");
		
	//test Queue
		Queue q = new ArrayQueue();

		String e = "e";
		String f = "f";
		String g = "g";
		String h = "h";
		
		q.add(e);
		q.add(f);
		q.add(g);
		q.add(h);
		
		for (Object obj: q){
			System.out.println((String) obj);
		}
		System.out.println("==============");
		
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		System.out.println(q.remove());
		
		
	}


}
