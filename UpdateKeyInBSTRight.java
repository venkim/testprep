package com.venkat.leetfree;

import com.venkat.leetfree.BuildBSTFromPreOrder.Node;

/*
 * Update key in a BST - to contains sum of all keys greater than that node..
 * 
 * Given a binary search tree (BST) modify it so that every key is updated so that
 * it contains sum of all greater keys present in BST.
 * 
 * Use reverse in-order traversal.
 */
public class UpdateKeyInBSTRight {
	static class Node {
		int data;
		Node left, right;
		public Node(int d) {
			this.data = d;
			left = right = null;
		}
	}
	public static Node buildBSTFromPreOrder(int[] pre,int l,int r){
		if (l > r)
			return null;
		
		int curr = pre[l];
		Node nd = new Node(curr);
		
		int i = 0;
		for(i = l+1;i <= r; i++) {
			if (pre[i] < curr)
				i++;
		}
		nd.left = buildBSTFromPreOrder(pre, l+1, i-1);
		nd.right = buildBSTFromPreOrder(pre,i,r);
		return (nd);
	}
	public UpdateKeyInBSTRight() {
		// TODO Auto-generated constructor stub
	}

	public static int updateRight(Node curr, int sumSoFar) {
		if (curr == null)
			return (sumSoFar);
		
		int rtval = updateRight(curr.right, sumSoFar);
		
		curr.data += rtval;
		sumSoFar = curr.data;
		
		return updateRight(curr.left, sumSoFar);
	}
	public static void printPOrder(Node root) {
		if (root == null)
			return ;

		System.out.print( root.data + ",");
		printPOrder(root.left);
		printPOrder(root.right);
	}
	public static void main(String[] args) {
		int[] pre = {15,10,8,12,20,16,25};
		
		Node rt = buildBSTFromPreOrder(pre,0,pre.length-1);
		printPOrder(rt);
		System.out.println();
		
		updateRight(rt,0);
	
		printPOrder(rt);
		System.out.println();
		
		rt = buildBSTFromPreOrder(pre,0,pre.length-1);
		updateLeft(rt,0);
		printPOrder(rt);
		System.out.println();
		
	}
	
	
	
	
	
	
	
	
	
	
	// call will come in a updateLeft(root, 0)
	
	public static int updateLeft(Node curr, int sumSoFar) {
		if (curr == null)
			return sumSoFar;
		
		int lftVal = updateLeft(curr.left, sumSoFar);
		curr.data += lftVal;
		sumSoFar += curr.data;
		
		return ( updateLeft(curr.right,sumSoFar));
	}
	
	


}
