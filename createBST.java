package com.venkat.leetfree;

import java.util.HashSet;
import java.util.Set;

public class createBST {
	static class Node {
		int val;
		Node left, right;
		Node(int v){
			this.val = v;
			left = right = null;
		}
	}
	public createBST() {
		// TODO Auto-generated constructor stub
	}
	public static Node insert(Node root, int val) {
//		System.out.println("Inserting val = " + val);
		if (root == null)
			return (new Node(val));
		
		if (val < root.val) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right,val);
		}
		return (root);
	}
	// iterative version 
	public static Node insertIter(Node root, int val) {
		Node curr = root;
		Node parent = null;
//		System.out.println("Inserting val = " + val);
		if (root == null)
			return (new Node(val));
		
		while (curr != null) {
			parent = curr;
			
			if (val < curr.val)
				curr = curr.left;
			else
				curr = curr.right;
		}
		// curr is null here and parent is right at the point
		if (val < parent.val)
			parent.left = new Node(val);
		else
			parent.right = new Node(val);
		
		return (root);

	}
	public static void inOrder(Node curr) {
		if (curr == null)
			return ;
		inOrder(curr.left);
		System.out.print(curr.val + ",");
		inOrder(curr.right);
			
	}
	public static void main(String[] args) {
		Set<Integer> lset = new HashSet<Integer>();
		int[] elem = new int[25];
		for(int i = 0 ; i < 25; i++) {
			int x = (int)(Math.random()*500);
			if (!lset.contains(x)) {
				elem[i] = x;
				lset.add(x);
			}
		}
		Node root = null;
		for(int i = 0 ; i < elem.length; i++) {
			 root = insert(root, elem[i]);
		}
		inOrder(root);
		System.out.println();
		
		Node iroot = null;
		for(int i = 0 ; i < elem.length; i++) {
			 iroot = insertIter(iroot, elem[i]);
		}
		inOrder(iroot);
		System.out.println();
	}
}
