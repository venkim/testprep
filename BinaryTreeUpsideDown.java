package com.venkat.leetfree;
/*
 * Given a binary tree where all the right nodes are either 
 * leaf nodes with a sibling (a left node that shares the 
 * same parent node) or empty, flip it upside down and turn 
 * it into a tree where the original right nodes turned into 
 * left leaf nodes. Return the new root.
 *
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1  
 */
public class BinaryTreeUpsideDown {
	static class Node {
		int val;
		Node left, right;
		Node(int val){
			this.val = val;
			left = right = null;
		}
		public void printNode(Node curr) {
			if (curr == null)
				return;
			System.out.println("curr.val " + curr.val);
			printNode(curr.left);
			printNode(curr.right);
			
		}
	}
	Node root;
	Node newRoot;
	public BinaryTreeUpsideDown(Node root) {
		this.root = root;
		this.newRoot = upsideDown(root);
	}
	private Node upsideDown(Node curr) {
		if (curr == null || curr.left == null)
			return curr;
		
		Node oldleft = curr.left;
		// do the thing on the left node
		Node left = upsideDown(curr.left);
		
		// This node -- left node's left = right
		oldleft.left = curr.right;
		// this node's left's right is itself.
		oldleft.right = curr;
		
		// set the left and right -- to null
		curr.left = null;
		curr.right = null;
		
		return (left);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		root.printNode(root);
		BinaryTreeUpsideDown btud = new BinaryTreeUpsideDown(root);
		root.printNode(btud.newRoot);
	}

}
