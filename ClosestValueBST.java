package com.venkat.leetfree;

import java.util.Arrays;

/*
 * Given a non-empty binary search tree and a target value, 
 * find the value in the BST that is closest to the target.

 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestValueBST {
	static class Node {
		double data;
		Node left, right;
		public Node(double d) {
			this.data = d;
			left = right = null;
		}
	}
	public ClosestValueBST() {
		
	}
	static double closestVal;
	static double minDiff = Integer.MAX_VALUE;
	static double currDiff = Integer.MAX_VALUE;
	public static void clearClosest() {
		minDiff = Integer.MAX_VALUE;
	}
	public static double closestValueBST(double key, Node root) {
		if (root == null)
			return Integer.MAX_VALUE;
		currDiff = Math.abs(key - root.data);
		if (currDiff < minDiff) {
			minDiff = currDiff;
			closestVal = root.data;
		}
		if (key < root.data) {
			closestValueBST(key,root.left);
		} else {
			closestValueBST(key,root.right);
		} 
		return (closestVal);
	}
	public static Node createBalancedBST(double[] ldata) {
		return (createBalancedBST(ldata,0,ldata.length-1));
	}
	public static Node createBalancedBST(double[] ldata,int lo ,int hi) {
		if ( lo > hi)
			return null;
		if (lo == hi)
			return (new Node(ldata[lo]));
		int mid = lo + (hi-lo)/2;
		Node root = new Node(ldata[mid]);
		root.left = createBalancedBST(ldata,lo, mid-1);
		root.right = createBalancedBST(ldata,mid+1,hi);
		return (root);
		
	}
	public static void main(String[] args) {
		double[] ldata = {10.5,12.6,17.4,21.5,2.4,15.8,16.2,24.9,28.4,50.5,40.37,31.94,31.42,58.12,59.55};

		Arrays.sort(ldata);
		
		for(int i = 0 ; i < ldata.length -1; i++) {
			System.out.print("" + ldata[i] + ",");
		}
		
		Node rootNode = createBalancedBST(ldata);
		clearClosest();
		closestValueBST(16.25,rootNode);
		System.out.println("\n Looking for closest near 16.25");
		System.out.println("Minimum value ..." + closestVal);
		
		clearClosest();
		closestValueBST(41.25,rootNode);
		System.out.println("\n Looking for closest near 41.25 ");
		System.out.println("Minimum value ..." + closestVal);

	}
}
