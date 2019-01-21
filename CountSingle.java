package com.venkat.leetfree;

public class CountSingle {
	static class Node {
		int val;
		Node left, right;
		public Node(int val) {
			this.val = val;
			left = null;
			right = null;
		}
	}
	class Count {
		int count = 0;
		Count(){
			this.count = 0;
		}
	}
	Node root;
	Count ct;
	public CountSingle(Node root){
		this.root = root;
		ct = new Count();
		countSingle(root,ct);
	}
	public boolean countSingle(Node node, Count c) {
		if (node == null)
			return (true);
		boolean leftStat = false, rightStat = false;
		
		leftStat = countSingle(node.left,c);
		rightStat = countSingle(node.right,c);

		if (leftStat == false || rightStat == false)
			return (false);
		
		if (node.left != null && node.left.val != node.val)
			return (false);
		if (node.right != null && node.right.val != node.val)
			return (false);
		// if it gets here - the values are the same on this node
		c.count++;
		return (true);
			
	}
	public int getCount() {
		return ct.count;
	}
	public static void main(String[] args) {
		Node root = new Node(5); 
        root.left = new Node(4); 
        root.right = new Node(5); 
        root.left.left = new Node(4); 
        root.left.right = new Node(4); 
        root.right.right = new Node(5); 		
        
   
        CountSingle cts = new CountSingle(root);
        System.out.println("Count is = " + cts.getCount());
	}

}
