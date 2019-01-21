package com.venkat.leetfree;
/*
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.

 ** Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.

 ** The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.

 ** The right-most node is also defined by the same way with left and right exchanged.

 ** Example 1
 ** Input:
 **   1
 **    \
 **     2
 **    / \
 **   3   4

 ** Ouput:
 ** [1, 3, 4, 2]

 ** Explanation:
 ** The root doesn't have left subtree, so the root itself is left boundary.
 ** The leaves are node 3 and 4.
 ** The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 ** So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 ** Example 2
 ** Input:
 **     ____1_____
 **    /          \
 **   2            3
 **  / \          / 
 ** 4   5        6   
 **    / \      / \
 **   7   8    9  10  
 **        
 ** Ouput:
 ** [1,2,4,7,8,9,10,6,3]

 ** Explanation:
 ** The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 ** The leaves are node 4,7,8,9,10.
 ** The right boundary are node 1,3,6,10. (10 is the right-most node).
 ** So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3]
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTree {
	static class Node {
		int val;
		Node left,right;
		public Node(int val) {
			this.val = val;
			left = right = null;
		}
	}
	List<Integer> rslt;
	Stack<Integer> rstk;
	public List<Integer> getList(){
		return (rslt);
	}
	private void leftTree(Node root){
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			return ;
		
		rslt.add(root.val);
		if (root.left != null) {
			leftTree(root.left);
		} else {
			leftTree(root.right);
		}
	}
	
	private void addLeafs(Node root) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			rslt.add(root.val);
			return;
		}
		addLeafs(root.left);
		addLeafs(root.right);
	}
	
	private void addRight(Node root) {
		if (root == null)
			return ;
		if (root.left == null && root.right == null)
			return ;
		rstk.add(root.val);
		if (root.right != null) {
			addRight(root.right);
		} else {
			addRight(root.left);
		}
	}
	public BoundaryTree(Node root) {
		rslt = new ArrayList<Integer>();
		rstk = new Stack<Integer>();
		leftTree(root);
		addLeafs(root);
		addRight(root.right);
		while(!rstk.isEmpty()) {
			rslt.add(rstk.pop());
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.right.left = new Node(7);
		root.left.right.right = new Node(8);
		root.right.left = new Node(6);
		root.right.left.left = new Node(9);
		root.right.left.right = new Node(10);
		
		BoundaryTree bt2 = new BoundaryTree(root);
		System.out.println("List is " + bt2.getList());
	}

}
