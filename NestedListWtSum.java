package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
/*
 *  list [1,[4,[6]]], return 27. 
 *  	(one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 * list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 */
public class NestedListWtSum {
	static class NestedInteger {
		boolean isInt;
		int myint;
		List<NestedInteger> mylist;
		public boolean isInteger() {
			return (isInt);
		}
  
		public NestedInteger(int x) {
			isInt = true;
			myint = x;
		}
		public NestedInteger(List<NestedInteger> mlist) {
			isInt = false;
			mylist = mlist;
		}
		public int getInteger() {
			return myint;
		}
		public List<NestedInteger> getList(){
			return (mylist);
		}
		public boolean add(NestedInteger ni) {
			if (!isInteger()) {
				mylist.add(ni);
				return(true);
			}
			return (false);
		}
	}
	public NestedListWtSum() {
		// TODO Auto-generated constructor stub
	}
	public static int depthSum(NestedInteger ni) {
		if (ni.isInteger()) {
			return ni.getInteger();
		} else {
			return (depthSum(ni.getList(),1));
		}
		
	}
	public static int depthSum(List<NestedInteger> nestedList) {
		return (depthSum(nestedList,1));
	}
	public static int depthSum(List<NestedInteger> nestedList,int depth) {
		int sum = 0;
		for(NestedInteger x: nestedList) {
			if (x.isInteger()) {
				sum += depth*x.getInteger();
			} else {
				sum += depthSum(x.getList(),depth+1);
			}
		}
		return (sum);
	}

	public static void main(String[] args) {
		NestedInteger n1 = new NestedInteger(10);
		List<NestedInteger> lst = new ArrayList<NestedInteger>();
		for(int i = 2 ; i < 10; i++) {
			lst.add(new NestedInteger(2*10));
			List<NestedInteger> tt = new ArrayList<NestedInteger>();
			for(int j = 5 ; j < 10; j++) {
				 tt.add( new NestedInteger(j*20));
			}
			lst.add( new NestedInteger(tt) );
		}
		NestedInteger n2 = new NestedInteger(lst);
		
		n2.add( new NestedInteger(250));
		n2.add( n1);
		
		System.out.println("Depth sum of n1 is " + depthSum(n2));
	}

}
