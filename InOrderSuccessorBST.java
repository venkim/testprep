package com.venkat.leetfree;
/*
 * Given a binary search tree and a node in it, find 
 * the in-order successor of that node in the BST.
 *
 *Note: If the given node has no in-order successor 
 *in the tree, return null.
 *
 *
 */
public class InOrderSuccessorBST {
	static class Node {
		int val;
		Node left, right;
		Node(int v){
			this.val = v;
			left = null;
			right = null;
		}
	}
	public InOrderSuccessorBST() {
		// TODO Auto-generated constructor stub
	}
	public static Node inOrdSuccBST(Node root, Node n) {
		if (n == null || root == null)
			return null;
		
		if (n.right != null)
			return (n.right);
					
		Node curr = root;
		Node succ = null;
		while (curr != null) {
			if (n.val < curr.val) {
				succ = curr;
				curr = curr.left;
			} else if (n.val > curr.val){
				curr = curr.right;
			} else {
				break;
			}
		}
		return (succ);
	}

	public static void main(String[] args) {
		Node tn  = new Node(50);
		tn.left = new Node(25);
		tn.right = new Node(75);
		tn.left.left = new Node(12);
		Node cand = tn.left.left;
		tn.left.right = new Node(37);
		tn.right.left = new Node(68);
		tn.right.right = new Node(87);
		//Node cand = tn.right.right;
		
		Node suck = InOrderSuccessorBST.inOrdSuccBST(tn,cand);
		if (suck != null)
			System.out.println("Success or BST to 12 is " + suck.val);
		else
			System.out.println("No sucessor found for this node with val = " + cand.val);

	}
}
