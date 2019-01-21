package com.venkat.leetfree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;



public class MinDepthOfTree {
	static class Node {
		int data;
		Node left, right;
		public Node(int val) {
			this.data = val;
			left = right = null;
		}
	}
	public MinDepthOfTree() {
		// TODO Auto-generated constructor stub
	}
	public static int minDepth(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		
		q.offer(root);
		int lvl = 0;
		while (!q.isEmpty()) {
			lvl++;
			int sz = q.size();
			for(int i = 0 ; i < sz; i++) {
				Node curr = q.poll();
				if (curr.left == null && curr.right == null)
					return lvl;
				if (curr.left != null)
					q.offer(curr.left);
				if (curr.right != null)
					q.offer(curr.right);
			}
		}
		return 0;
	}
	public static Node insert(Node root, int val) {
//		System.out.println("Inserting val = " + val);
		if (root == null)
			return (new Node(val));
		
		if (val < root.data) {
			root.left = insert(root.left, val);
		} else {
			root.right = insert(root.right,val);
		}
		return (root);
	}
	public static void inOrder(Node curr) {
		if (curr == null)
			return ;
		inOrder(curr.left);
		System.out.print(curr.data + ",");
		inOrder(curr.right);
			
	}
	public static void main(String[] args) {
		Set<Integer> lset = new HashSet<Integer>();
		int[] elem = new int[75];
		for(int i = 0 ; i < 75; i++) {
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
		
		System.out.println("Min depth of root is " + minDepth(root));

	}

}
