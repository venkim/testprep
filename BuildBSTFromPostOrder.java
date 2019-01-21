package com.venkat.leetfree;

public class BuildBSTFromPostOrder {
	static class Node {
		int data;
		Node left, right;
		public Node(int d) {
			this.data = d;
			left = right = null;
		}
	}
	public static Node buildBSTFromPostOrder(int[] porder,int l,int r){
		System.out.println("l and r " + l + "$" + r);
		if (l > r)
			return null;

		Node node = new Node(porder[r]);
		int i;
		for(i = r; i >= l; i--) {
			if (porder[i] < node.data)
				break;
		}

		node.right = buildBSTFromPostOrder(porder,i+1,r-1);
		node.left = buildBSTFromPostOrder(porder,l,i);
		return (node);
	}
	public static void printPOrder(Node root) {
		if (root == null)
			return ;
		
		printPOrder(root.left);
		printPOrder(root.right);
		System.out.print( root.data + ",");
	}
	
	public static void main(String[] args) {
		int[] porder = {8,12,10,16,25,20,15};
		Node rt = buildBSTFromPostOrder(porder, 0, porder.length-1);
		printPOrder(rt);
	}

}
