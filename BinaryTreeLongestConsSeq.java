package com.venkat.leetfree;

public class BinaryTreeLongestConsSeq {
	static class Node {
		int val;
		Node left, right;
		public Node(int v) {
			this.val = v;
			left = null;
			right = null;
		}
	}
	static int maxlen = 0;
	public BinaryTreeLongestConsSeq() {
		// TODO Auto-generated constructor stub
	}
	public static int longestConsSeq(Node root) {
		dfs(root, null, 1);
		return (maxlen);
	}
	public static void dfs(Node curr, Node parent, int len) {

		if (curr == null) {
			maxlen = Math.max(maxlen, len);
			return ;
		}
		System.out.println("current val is " + curr.val);
		if (parent != null && curr.val == parent.val + 1) {
			len = Math.max(1, len+1);
			System.out.println("satisfy rel " + curr.val + "$" + parent.val + "$ len =" + len);
		}
		maxlen = Math.max(maxlen, len);
		dfs(curr.left, curr,len);
		dfs(curr.right,curr,len);

	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(4);
		root.right.right.right = new Node(5);
		
		System.out.println("max conseq... " + longestConsSeq(root));

	}
}
