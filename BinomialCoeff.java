package com.venkat.gfg.dynprog;

public class BinomialCoeff {

	public BinomialCoeff() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * recursive method
	 */
	public static int binomCoeff(int n, int k) {
		// base case is that if choosing 0 items or n items then 1
		if (k == 0 || k == n)
			return 1;
		
		// in terms of sub problems how to you structure 
		// choose k-1 items of n-1 and pick the one remaining item
		// OR choose k items of n-1 and dont choose the one remaining item
		return ( binomCoeff(n-1,k) + binomCoeff(n-1,k-1)) ;
	}
	/*
	 * dynamic programming - method
	 */
	public static int binomCoeffDP(int n, int k) {
		int[][] coeff = new int[n+1][k+1];

		
		// to calculate bottom-up 
		for(int i = 0 ; i <= n ; i++) {
			for(int j = 0 ; j <= min(i,k) ; j++) {
				// Base case - both 0
				if ( j == 0 || j == i)
					coeff[i][j] = 1;
				else
					coeff[i][j] = coeff[i-1][j-1] + coeff[i-1][j];
			}
		}
		return (coeff[n][k]);
	}
	public static int min(int ai, int bi) {
		return ( ai < bi ? ai : bi);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int k = 2;
		System.out.println(" n = " + n + "Choose k=" + k + ":" + binomCoeff(n,k));
		System.out.println(" n = " + n + "Choose k=" + k + ":" + binomCoeffDP(n,k));
	}

}
