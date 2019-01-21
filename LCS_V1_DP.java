package com.venkat.gfg.dynprog;

public class LCS_V1_DP {

	/*
	 * find the longest commmon substring between two strings s1 and s2
	 */
	public static String lcs(String s1, String s2) {
		char X[] = s1.toCharArray();
		int m = X.length;
		
		char Y[] = s2.toCharArray();
		int n = Y.length;
		
		String ss = lcs(X, Y, m, n);
		return (ss);
	}
	public static String lcs(char[] X, char[] Y, int m, int n) {
		int ldp[][] = new int[m+1][n+1];
		
		// bottom up fill in the ldp array
		for(int i = 0 ; i <= m ; i++) {
			for(int j = 0 ; j <= n;j++) {
				if ( i == 0 || j == 0)
					ldp[i][j] = 0;
				else if (X[i-1] == Y[j-1])
					ldp[i][j] = ldp[i-1][j-1] + 1;
				else
					ldp[i][j] = Math.max( ldp[i-1][j],ldp[i][j-1]);
			}
		}
		
		int lcsIndex = ldp[m][n];
		char[] rslt = new char[lcsIndex];
		
		int index = lcsIndex;
		int i = m, j = n;
		while ( i > 0 && j > 0) {
			if ( X[i-1] == Y[j-1]) {
				rslt[index-1] = X[i-1];
				i--; j-- ; index--;
			} else if ( ldp[i-1][j] > ldp[i][j-1]) {
				i--;
			} else {
				j--;
			}
		}
		String rStr = new String (rslt);		

		return rStr;
	}
	public LCS_V1_DP() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		
		System.out.println("String s1 = " + s1 + " String s2 = " + s2 + " LCS = " + lcs(s1,s2));

	}

}
