package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.venkat.leetfree.AutoCompleteSystem.Node;

/*
 * Given a binary tree, return the vertical order traversal of its nodes' values. 
 * (ie, from top to bottom, column by column).
 * 
 * If two nodes are in the same row and column, the order should be from left to right.
   *
   *Examples:
   *
   *Given binary tree [3,9,20,null,null,15,7],
   *   3
   *  /\
   * /  \
   * 9  20
   *    /\
   *   /  \
   *  15   7
   *return its vertical order traversal as:
   *[
   *  [9],
   *  [3,15],
   *  [20],
   *  [7]
   *]
   *Given binary tree [3,9,8,4,0,1,7],
   *     3
   *    /\
   *   /  \
   *   9   8
   *  /\  /\
   * /  \/  \
   * 4  01   7
   *return its vertical order traversal as:
   *[
   *  [4],
   *  [9],
   *  [3,0,1],
   *  [8],
   *  [7]
   *]
   *Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
   *     3
   *    /\
   *   /  \
   *   9   8
   *  /\  /\
   * /  \/  \
   * 4  01   7
   *    /\
   *   /  \
   *   5   2
   *return its vertical order traversal as:
   *[
   *  [4],
   *  [9,5],
   *  [3,0,1],
   *  [8,2],
   *  [7]
   *]
 * 
 * 
 */
public class VerticalOrder {
	static class TreeNode {
		int val;
		TreeNode left, right;
		TreeNode(int v){
			this.val = v;
			left = right = null;
		}
	}
	public VerticalOrder() {
		// TODO Auto-generated constructor stub
	}
	public List<List<Integer>> verticalOrder(TreeNode root){
		List<List<Integer>> rslt = new ArrayList<>();
		if (root == null)
			return (rslt);
		
		// Level and last
		Map<Integer, List<Integer>> lvlMap = new HashMap<>();
		
		LinkedList<TreeNode> q = new LinkedList<TreeNode>();
		LinkedList<Integer> lvlList = new LinkedList<Integer>();
		
		q.offer(root);
		lvlList.offer(0);
		
		int minlevel = 0;
		int maxlevel = 0;
		
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			int l = lvlList.poll();
			
			// track min and max levels
			minlevel = Math.min(l, minlevel);
			maxlevel = Math.max(l, maxlevel);
			
			lvlMap.putIfAbsent(l,new ArrayList<Integer>());
			lvlMap.get(l).add(curr.val);
			
			if (curr.left != null) {
				q.offer(curr.left);
				lvlList.offer(l-1);
			}
			if (curr.right != null) {
				q.offer(curr.right);
				lvlList.offer(l+1);
			}
		}
		
		for(int i = minlevel; i <= maxlevel; i++ ) {
			if (lvlMap.containsKey(i)) {
				rslt.add(lvlMap.get(i));
			}
		}
		return (rslt);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(7);
		root.left.right.left = new TreeNode(5);
		root.left.right.right = new TreeNode(2);
		
		VerticalOrder vo = new VerticalOrder();
		List<List<Integer>> rslt = vo.verticalOrder(root);
		
		for(List<Integer> lst: rslt) {
			System.out.println("next elem " + lst);
		}

	}
	
	public static List<List<Integer>> vertOrder(TreeNode root){
		List<List<Integer>> rslt = new ArrayList<>();
		if (root == null)
			return rslt;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		Queue<Integer> lvlq = new LinkedList<>();
		Map<Integer,List<Integer>> lvlMap = new HashMap<>();
		
		q.offer(root);
		lvlq.offer(0);
		
		int minLevel = 0, maxLevel = 0;
		int currLevel = 0;
		while (!q.isEmpty()) {
			TreeNode curr = q.poll();
			currLevel = lvlq.poll();
			
			minLevel = Math.min(minLevel, currLevel);
			maxLevel = Math.max(maxLevel, currLevel);
			
			lvlMap.putIfAbsent(currLevel, new ArrayList<Integer>());
			lvlMap.get(currLevel).add(curr.val);
			
			if (curr.left != null) {
				q.offer(curr.left);
				lvlq.offer(currLevel-1);
			}
			
			if (curr.right != null) {
				q.offer(curr.right);
				lvlq.offer(currLevel+1);
			}
			
		}
		
		for(int i = minLevel; i < maxLevel; i++) {
			if (lvlMap.containsKey(i)) {
				rslt.add( lvlMap.get(i) );
			}
		}
		return (rslt);
	
	}

}
