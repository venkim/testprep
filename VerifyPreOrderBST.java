package com.venkat.leetfree;

import java.util.Stack;

/*
 * Given an array of numbers, verify whether it is the correct preorder traversal 
 * sequence of a binary search tree.
 *
 * You may assume each number in the sequence is unique.
 *
 * Follow up:
 * Could you do it using only constant space complexity?
 */
public class VerifyPreOrderBST {
	
 
	public VerifyPreOrderBST() {
	}
	public static boolean isBST(int[] a, int left, int right) {
		int low = Integer.MIN_VALUE;
		Stack<Integer> stk = new Stack<>();
		for(int p: a) {
			if ( p < low)
				return (false);
			while (!stk.isEmpty() && p > stk.peek()) 
				low = stk.pop();
			
			stk.push(p);
		}
		return (true);
	}

	public static boolean isBST2(int[] a, int start, int end, int min, int max) {
		if (start >= end)
			return (true);
		
		int root = a[start];
		// find the index that is greater than a[start]
		int maxIndx = start;
		for(int i = start; i <= end; i++) {
			if ( a[i] < min || a[i] > max)
				return (false);
			
			if (a[i] > root)
				break;
			maxIndx++;
		}
		
		boolean left = isBST2(a, start+1,maxIndx-1, min, a[start]-1);
		
		boolean right = isBST2(a, maxIndx, end, a[start]+1, max);
		
		return (left && right);
		
	}
	public static void main(String[] args) {
		int[] a = {40, 30, 35, 80, 100};
		System.out.println("result of pre bst is " + isBST(a,0,a.length));

		int[] b = {40, 30, 35, 20, 80, 100};
		System.out.println("result of pre bst is " + isBST(b,0,b.length));
		System.out.println("result of pre bst 3 is " + isBST3(b,0,b.length-1,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}

	
	
	public static boolean isBST3(int[] a, int lo, int hi, int min, int max) {
		if (lo >= hi)
			return true;
		
		int root = a[lo];
		int maxIndex = lo;
		for(int i = lo; i <= hi; i++) {
			if (a[i] < min || a[i] > max)
				return (false);
			if (a[i] > root)
				break;
			maxIndex++;
		}
		boolean leftStat = isBST3(a,lo+1,maxIndex-1,min,root-1);
		boolean rightStat = isBST3(a,maxIndex,hi,root+1,max);
		return (leftStat && rightStat);
	}
	public static boolean isBSTStk(int[] a) {
		Stack<Integer> pstk = new Stack<Integer>();
		int minval = Integer.MIN_VALUE;
		
		for(int p : a) {
			
			if (p < minval)
				return (false);
			
			while(!pstk.isEmpty() && p > pstk.peek())
				minval = pstk.pop();
			
			
			pstk.push(p);
		}
		return (true);
	}
}
