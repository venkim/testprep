package com.venkat.leetfree;

public class CountSUnivalue1 {
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
		void addCount() {
			count++;
		}
	}
	Node root;
	Count ct;
	public CountSUnivalue1(Node root){
		this.root = root;
		ct = new Count();
		countUnivalue(root,ct);
	}
	public boolean countUnivalue(Node node, Count c) {
		if (node == null)
			return true;
		boolean leftStat = false, rightStat = false;
		
		leftStat = countUnivalue(node.left,c);
		rightStat = countUnivalue(node.right,c);
		
		if (leftStat == false || rightStat == false)
			return (false);
		
		if (node.left != null && node.val != node.left.val)
			return (false);
		
		if (node.right != null && node.val != node.right.val)
			return (false);
		ct.addCount();
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
        
   
        CountSUnivalue1 cts = new CountSUnivalue1(root);
        System.out.println("Count is = " + cts.getCount());
	}

}
