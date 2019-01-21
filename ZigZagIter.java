package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Given two 1d vectors, implement an iterator to 
 * return their elements alternately.
 *
 * For example, given two 1d vectors:
 ** 
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 */
public class ZigZagIter {
	List<Integer> ll1;
	List<Integer> ll2;
	Iterator<Integer> myIter1;
	Iterator<Integer> myIter2;
	
	boolean fturn;
	public ZigZagIter(List l1, List l2) {
		this.ll1 = l1;
		this.ll2 = l2;
		myIter1 = ll1.iterator();
		myIter2 = ll2.iterator();
		fturn = true;
	}
	public boolean hasNext() {
		boolean rslt;
		if (fturn) {
			if (myIter1.hasNext())
				return (true);
			else if (myIter2.hasNext())
				return (true);
			else
				return (false);
		} else {
			if (myIter2.hasNext())
				return (true);
			else if (myIter1.hasNext())
				return (true);
			else
				return (false);
		}
			
	}
	public int next() {
		if (fturn) {
			if (myIter1.hasNext()) {
				fturn = !fturn;	
				return (myIter1.next());
			} else if (myIter2.hasNext()) {
				fturn = !fturn;	
				return (myIter2.next());
			} else 
				return -1;
		} else {
			if (myIter2.hasNext()) {
				fturn = !fturn;	
				return (myIter2.next());
			} else if (myIter1.hasNext()) {
				fturn = !fturn;	
				return (myIter1.next());
			} else
				return -1;
		}
			
	}

	public static void main(String[] args) {
		List<Integer> lone = new ArrayList<>();
		for(int i = 1 ; i < 20 ;i++)
			lone.add(10*i);

		List<Integer> ltwo = new ArrayList<>();
		for(int i = 1 ; i < 10 ;i++)
			ltwo.add(10*i+5);
		
		ZigZagIter zizi = new ZigZagIter(lone,ltwo);
		while (zizi.hasNext()) {
			System.out.println("Next item is " + zizi.next());
		}
	}

}
