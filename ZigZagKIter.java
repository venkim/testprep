package com.venkat.leetfree;

import java.util.List;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ZigZagKIter implements Iterator<Integer> {
	Queue<Iterator<Integer>> itq;
	int pos;
	public ZigZagKIter(Iterator it1, Iterator it2, 
			Iterator it3,Iterator it4){
		itq = new LinkedList<>();
		if (it1 != null && it1.hasNext())
			itq.add(it1);
		if (it2 != null && it2.hasNext())
			itq.add(it2);
		if (it3 != null && it3.hasNext())
			itq.add(it3);
		if (it4 != null && it4.hasNext())
			itq.add(it4);
	}

	@Override
	public boolean hasNext() {
		if (itq.size() > 0) {
			return (true);
		} 
		return false;
	}

	@Override
	public Integer next() {
		if (itq.size() <= 0) {
			throw new NullPointerException("") ;
		}
		int rslt = 0;
		Iterator<Integer> myIter = itq.poll();
		if (myIter.hasNext()) {
			rslt = myIter.next();
			if (myIter.hasNext()) {
				itq.offer(myIter);
			}
		}
		return rslt;
	}
	public static void main(String[] args) {
		List<Integer> l1 = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		List<Integer> l3 = new ArrayList<>();
		List<Integer> l4 = new ArrayList<>();
		
		for(int i = 1 ; i < 11; i++) {
			l1.add(10*i+3);
			l2.add(10*i+4);
			l3.add(10*i+5);
			l4.add(10*i+6);
		}
		for(int i = 1 ; i < 11; i++) {
			l2.add(100*i+4);
			l3.add(100*i+5);
		}
		ZigZagKIter zki = new ZigZagKIter(l1.iterator(), 
				l2.iterator(), l3.iterator(), l4.iterator());
		
		while (zki.hasNext()) {
			System.out.println(" next elem is " + zki.next());
		}
	}
}
