package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * Given a binary tree, collect a tree's nodes as if you were 
 * doing this: Collect and remove all leaves, 
 * repeat until the tree is empty.
 * 
 * Example:
 * Given binary tree 
 *         1
 *        / \
 *       2   3
 *      / \     
 *     4   5    
 * Returns [4, 5, 3], [2], [1].
 * 
 * Explanation:
 * 1. Removing the leaves [4, 5, 3] would result in this tree:
 * 
 *          1
 *         / 
 *       2          
 * 2. Now removing the leaf [2] would result in this tree:
 * 
 *         1          
 * 3. Now removing the leaf [1] would result in the empty tree:
 * 
 *         []         
 * Returns [4, 5, 3], [2], [1].
 */
public class CollectLeaves {
	static class Node {
		int val;
		Node left, right;
		public Node(int val) {
			this.val = val;
			left = right = null;
		}
	}
	public CollectLeaves() {
		// TODO Auto-generated constructor stub
	}
	public static List<List<Integer>> collectLeaves(Node root){
		List<List<Integer>> rslt = new ArrayList<>();
		helper(root,rslt);
		return (rslt);
	}
	public static int helper(Node root,List<List<Integer>> rslt) {
		if (root == null)
			return -1;
		
		int left = helper(root.left,rslt);
		int right = helper(root.right,rslt);
		int currLevel = Math.max(left, right)+1;
		if (rslt.size() <= currLevel)
			rslt.add(new ArrayList<Integer>());
		
		rslt.get(currLevel).add(root.val);
		return (currLevel);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		
		List<List<Integer>> rslt = collectLeaves(root);
		
		for(List<Integer> lst: rslt) {
			System.out.println(lst);
		}

	}

}
