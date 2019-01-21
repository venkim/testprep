package com.venkat.gfg.dynprog;

public class LongestPalindromeSubsequence {

	public LongestPalindromeSubsequence() {
		// TODO Auto-generated constructor stub
	}
	
	public static String lcs(char[] X,char[] Y, int m, int n) {
		int[][] dlp = new int[m+1][n+1];
		
		for(int i = 0 ; i <= m ; i++) {
			for(int j = 0 ; j <= n ; j++) {
				System.out.println("i = " + i + "| j = " + j);
				if ( i == 0 || j == 0) {
					dlp[i][j] = 0;
				} else if ( X[i-1] == Y[j-1]) {
					dlp[i][j] = dlp[i-1][j-1] + 1;
				} else {
					dlp[i][j] = Math.max( dlp[i-1][j], dlp[i][j-1]);
				}
			}
		}
		
		int lcsLength = dlp[m][n];
		System.out.println("lcsIndex is " + lcsLength);
		int ind = lcsLength;
		char[] rslt = new char[ind];
		
		int i = m, j = n;
		while ( i > 0 && j > 0) {
			if (X[i-1] == Y[j-1]) {
				rslt[--ind] = X[i-1];
				i-- ; j -- ;
			} else if ( dlp[i-1][j] > dlp[i][j-1]) {
				i--;
			} else { 
				j--;
			}
		}
		String ss = new String(rslt);
		return (ss);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "GEEKSFORGEEKS";
		char[] X = s1.toCharArray();
		
		char[] Y = new char[X.length];
		for(int i = 0 ; i < X.length ; i++)
			Y[i] = X[ X.length -1 -i];
		
		System.out.println("X length = " + X.length + "| Y length = " + Y.length);
		
		String lpalin = lcs(X,Y,X.length,Y.length);
		System.out.println(" palin string is " + lpalin);;
			
				
	}

}
