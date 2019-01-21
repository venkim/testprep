package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

/*
 * 366
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and 
 * remove all leaves, repeat until the tree is empty.
 *
 * Example:
 * Given binary tree 
 *           1
 *          / \
 *         2   3
 *        / \     
 *       4   5    
 * Returns [4, 5, 3], [2], [1].
 *
 * Explanation:
 * 1. Removing the leaves [4, 5, 3] would result in this tree:
 *
 *           1
 *          / 
 *         2          
 * 2. Now removing the leaf [2] would result in this tree:
 *
 *           1          
 * 3. Now removing the leaf [1] would result in the empty tree:
 *
 *           []         
 * Returns [4, 5, 3], [2], [1].
 */
public class FindLeavesLevel {
	static class Node {
		int val;
		Node left, right;
		public Node(int val) {
			this.val = val;
			left = right = null;
		}
	}
	public FindLeavesLevel() {
		// TODO Auto-generated constructor stub
	}
	public static List<List<Integer>> findLeavesByLevel(Node root){
		List<List<Integer>> rslt = new ArrayList<>();
		
		helper(root, rslt);
		return (rslt);
	}
	/*
	 * 
	 */
	private static int helper(Node t, List<List<Integer>> rslt) {
		if (t == null)
			return -1;
		
		int lftLvl = helper(t.left, rslt);
		int rgtLvl = helper(t.right, rslt);
		
		int curr = Math.max(lftLvl,rgtLvl) + 1;
		
		if (curr >= rslt.size()) {
			rslt.add(new ArrayList<Integer>());
		}
		rslt.get(curr).add(t.val);
		return (curr);
	}
	public static void main(String[] args) {
		Node rt = new Node(1);
		rt.left = new Node(2);
		rt.right = new Node(3);
		rt.left.left = new Node(4);
		rt.left.right = new Node(5);
		rt.right.left = new Node(6);
		rt.right.right = new Node(7);
		rt.right.right.left = new Node(8);
		rt.right.right.right = new Node(9);

		List<List<Integer>> res = findLeavesByLevel(rt);
		
		for(List<Integer> lst: res) {
			System.out.println("List is " + lst);
		}
	}

}
