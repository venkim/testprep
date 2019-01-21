package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class ClosestKValuesBST {
	static class Node {
		double val;
		Node left, right;
		Node(double key){
			this.val = key;
			left = right = null;
		}
	}
	public static Queue<Double> dpq;
	public static int count;
	public static Node createBST(double[] dblarr, int lo, int hi) {
		if (lo > hi)
			return null;
		if (lo == hi)
			return (new Node(dblarr[lo]));
		int mid = lo + (hi-lo)/2;
		Node root = createBST(dblarr,mid,mid);
		root.left = createBST(dblarr,lo,mid-1);
		root.right = createBST(dblarr,mid+1,hi);
		return (root);
	}
	public ClosestKValuesBST() {
	}

	public static List<Double> closeKValues(Node root, double target, int k){
		List<Double> rslt = new ArrayList<Double>();
		int count = 0;
		dpq = new PriorityQueue<Double>();
		
		inOrderTraverse(root,target,k);
		
		for(Double dx : dpq)
			rslt.add(dx);
		
		return (rslt);
	}
	private static void inOrderTraverse(Node root,double target,int k) {
		if (root == null)
			return;
		inOrderTraverse(root.left, target, k);
		if (count < k) {
			dpq.offer(root.val);
		} else {
			if (Math.abs(root.val - target) < Math.abs(root.val - dpq.peek()) ) {
				dpq.poll();
				dpq.offer(root.val);
			}
		}
		count++;
		inOrderTraverse(root.right,target,k);
		
	}
	public static List<Double> closeKValues2(Node root, double target, int k){
		List<Double> rslt = new ArrayList<Double>();	
		if (root == null)
			return (rslt);
		
		Stack<Double> predecessor = new Stack<Double>();
		Stack<Double> successor = new Stack<Double>();
		
		getPred(root,target,predecessor);
		getSucc(root,target,successor);
		
		for(int i = 0 ; i < k ; i++) {
			if (predecessor.isEmpty()) {
				rslt.add(successor.pop());
			} else if (successor.isEmpty()) {
				rslt.add(predecessor.pop());
			} else if ( Math.abs(target-predecessor.peek()) < Math.abs(target-successor.peek())) {
				rslt.add(predecessor.pop());
			} else {
				rslt.add(successor.pop());
			}
		}
		
		return (rslt);
	}
	public static void getPred(Node root,double target, Stack<Double> p) {
		if (root == null)
			return ;
		getPred(root.left,target,p);
		if (root.val > target)
			return ;
		p.push(root.val);
		getPred(root.right,target,p);
	}
	public static void getSucc(Node root, double target, Stack<Double> s) {
		if (root == null)
			return ;
		getSucc(root.right,target,s);
		if (root.val < target)
			return;
		s.push(root.val);
		getSucc(root.left,target,s);
	}
	public static void main(String[] args) {
		double[] dblarr = new double[100];
		for(int i = 0; i < 100;i++) {
			double cand =  Math.round( 10000.00*Math.random() )/100.00D;
			dblarr[i] = cand;
		}
		
		Arrays.sort(dblarr);
		Node dblrt = createBST(dblarr,0,dblarr.length-1);
		
		double target = 75.0;
		List<Double> rslt = closeKValues(dblrt, target, 10);
		
		System.out.println("Results....");
		for(Double ddx : rslt) {
			System.out.print("," + ddx);
		}
		
		System.out.println();
		List<Double> rslt2 = closeKValues2(dblrt,target, 10);
		System.out.println("Results. 2 ...");
		for(Double ddx : rslt) {
			System.out.print("," + ddx);
		}		
		
	}

}
