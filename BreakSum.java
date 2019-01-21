package com.venkat.gfg.dynprog;

public class BreakSum {

	public BreakSum() {
		// TODO Auto-generated constructor stub
	}
	public static int breakSumRec(int n) {
		if (n == 0 || n == 1)
			return n;
			
		// recursively break into parts and choose max
		return ( Math.max(n,  breakSumRec(n/2) +breakSumRec(n/3) + breakSumRec(n/4) ));
	}
	public static int breakSumDP(int n) {
		int[] bdp = new int[n+1];
		bdp[0] = 0;
		bdp[1] = 1;
		for ( int i = 2 ; i <= n ; i++) {
			bdp[i] = Math.max(i,  bdp[i/2] + bdp[i/3]+ bdp[i/4]);
		}
		return (bdp[n]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 12;
		System.out.println("Break for " + n + " breakSumRec(n) = " + breakSumRec(n));
		System.out.println("Break for " + n + " breakSumDP(n) = " + breakSumDP(n));
		
		n = 24;
		System.out.println("Break for " + n + " breakSumRec(n) = " + breakSumRec(n));
		System.out.println("Break for " + n + " breakSumDP(n) = " + breakSumDP(n));
	}

}
