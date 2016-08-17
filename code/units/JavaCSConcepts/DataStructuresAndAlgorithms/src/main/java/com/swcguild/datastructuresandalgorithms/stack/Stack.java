/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.datastructuresandalgorithms.stack;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public interface Stack extends Iterable {

	public boolean isEmpty();

	public int size();

	public void push(Object obj);

	public Object pop();


}
