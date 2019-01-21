package com.venkat.gfg.dynprog;

public class optimalBST {

	public optimalBST() {
		// TODO Auto-generated constructor stub
	}
	public static int optimalSearchTree(int[] keys, int[] freq, int n) {
		return optCost(freq, 0, n-1);
	}
	public static int optCost(int[] freq, int i, int j) {
		if ( j < i)
			return 0;
		
		if ( i == j)
			return freq[i];
		
		int fsum = 0;
		for(int k = i ; k <= j ; k++)
			fsum += freq[k];
		
		int min = Integer.MAX_VALUE;
		for(int r = i; r  <= j ; r++) {
			int cost = optCost(freq,i,r-1) + optCost(freq,r+1,j);
			min = Math.min(min, cost);
		}
		
		return min + fsum;
	}
	public static void main(String[] args) {
        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        int n = keys.length;
        System.out.println("Cost of Optimal BST is " +
                         optimalSearchTree(keys, freq, n));

	}

}
