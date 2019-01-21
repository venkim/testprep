package com.venkat.leetfree;

import com.venkat.leetfree.BuildBSTFromPostOrder.Node;

public class BuildBSTFromPreOrder {
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
	public BuildBSTFromPreOrder() {
		// TODO Auto-generated constructor stub
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
	}

}
