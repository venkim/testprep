package com.venkat.gfg.dynprog;

public class ChooseRoutOfNmodP {

	public ChooseRoutOfNmodP() {
		// TODO Auto-generated constructor stub
	}
/*
 * C(n, r)%p = [ C(n-1, r-1)%p + C(n-1, r)%p ] % p
 *  C(n, 0) = C(n, n) = 1
 * aim is to calculate nCr modulo p for large values of n and r
 * where nCr might overflow - so use abbove formula using DP  
 */
	public static int chooseNcRmodP(int n, int r, int p) {
		int [][] ncrdp = new int[n+1][r+1];
		
		// bottom up fill the array 
		for(int i = 1; i <= n ; i++) {
			for(int j = 0 ; j <= Math.min(i,r); j++) {
				if ( j == 0 || j == i)	// base case choosing 0 out of n or n out of n is 1
					ncrdp[i][j] = 1;
				else
					// using property of modulo
					ncrdp[i][j] = (ncrdp[i-1][j-1] % p  + ncrdp[i-1][j] %p ) % p;
			}
			printA( ncrdp[i]);
		}
		return ( ncrdp[n][r]);
	}
	
	public static void printA(int[] a) {
		for(int i = 0 ; i < a.length ; i++)
			System.out.print("," + a[i]);
		System.out.println("");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10, r = 2 , p = 13;
		System.out.print(" choosing " + r + " out of " + n + "mod p =" + p + " = "  );
		System.out.println( "" + chooseNcRmodP(n,r,p));

	}

}
