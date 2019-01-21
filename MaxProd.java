package com.venkat.gfg.dynprog;

public class MaxProd {

	public MaxProd() {
		// TODO Auto-generated constructor stub
	}
	public static int maxProd(int n) {
		if (n <= 1)
			return 0;
		if ( n == 2)
			return 1;
		int mxret = 0;
		for(int k = 2 ; k < n ; k++) {
			int ret = Math.max(k * ( n-k) , k * maxProd(n-k));
			mxret = Math.max( ret, mxret);
		}
		return ( mxret );
	}
	public static int maxProdDP(int n) {
		int[] dpp = new int[n+1];
		dpp[0] = 0;
		dpp[1] = 0;
		dpp[2] = 1;
		if ( n == 0 || n == 1) 	return 0;
		
		if ( n == 2) return 1;
		
		for(int k = 3 ; k <= n ; k++ ) {
			int maxpk = 0;
			for(int z = 2 ; z < k ; z++) {
				int tpk = Math.max(z * (k-z), dpp[z]*(k-z));
				maxpk = Math.max(tpk, maxpk);
			}
			dpp[k] = maxpk;
		}
		return (dpp[n]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int j = 2 ; j <= 10 ; j++) {
			System.out.println(" val " + j + "Max Prod = " + maxProd(j));
			System.out.println(" val " + j + "Max Prod DP = " + maxProdDP(j));
		}
	}

}
