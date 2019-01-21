package com.venkat.leetfree;

public class FlipTree {
	static class Node {
		int val;
		Node left, right;
		public Node(int v) {
			this.val = v;
			this.left = null;
			this.right = null;
		}
	}
	public FlipTree() {

	}
	public static Node flip(Node curr,Node parent) {
		if (curr == null )
			return parent;

		Node newNode = flip(curr.left,curr);
		
		curr.left = (parent == null) ? null : parent.right;
		curr.right = parent;
		
		return (newNode);
		
	}
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		inOrder(root);
		System.out.println("");
		Node nroot = flip(root, null);
		inOrder(nroot);
		System.out.println("");
	}
	public static void inOrder(Node curr) {
		if (curr == null) {
			System.out.print("#:");
			return ;
		}
		inOrder(curr.left);
		System.out.print(curr.val + ":");
		inOrder(curr.right);
	}

}
