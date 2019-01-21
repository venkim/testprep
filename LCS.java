package com.venkat.gfg.dynprog;
/*******************8
 * 
 * @author vm9764
 *1) Optimal Substructure:
 *Let the input sequences be X[0..m-1] and Y[0..n-1] of lengths m and n respectively. 
 *And let L(X[0..m-1], Y[0..n-1]) be the length of LCS of the two sequences X and Y. 
 *Following is the recursive definition of L(X[0..m-1], Y[0..n-1]).
 *
 *If last characters of both sequences match (or X[m-1] == Y[n-1]) then
 *L(X[0..m-1], Y[0..n-1]) = 1 + L(X[0..m-2], Y[0..n-2])
 *
 *If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
 *L(X[0..m-1], Y[0..n-1]) = MAX ( L(X[0..m-2], Y[0..n-1]), L(X[0..m-1], Y[0..n-2])
 */
public class LCS {

	public LCS() {
		// TODO Auto-generated constructor stub
	}
	public static int lcs(char[] X, char[] Y, int m, int n) {
		if ( m == 0 || n == 0)
			return (0);
		
		if ( X[m-1] == Y[n-1]) {
			return ( 1 + lcs(X, Y, m-1, n-1));
		} else {
			return ( Math.max(lcs(X,Y,m-1,n), lcs(X,Y,m,n-1)) );
		}
	}
	public static String lcsDP(char[] X, char[] Y, int m, int n) {
		int[][] ldp = new int[m+1][n+1];
		
		// start building from a bottom-up fashion
		for(int i = 0 ; i <= m ; i++) {
			for( int j = 0 ; j <= n ; j++) {
				if ( i == 0 || j == 0)
					ldp[i][j] = 0;
				else if ( X[i-1] == Y[j-1]) {
					ldp[i][j] = 1 + ldp[i-1][j-1];
				} else {
					ldp[i][j] = Math.max( ldp[i-1][j], ldp[i][j-1]);
				}
			}
		}
		int lcsIndex = ldp[m][n];
		char[] lcs = new char[lcsIndex];
		
		int i = m, j = n;
		while (i > 0 && j > 0) {
			// if current character in X and Y are same, 
			// that character is part of LCS
			if (X[i-1] == Y[j-1]) {
				lcs[lcsIndex-1] = X[i-1];
				System.out.println("This character is " + lcs[lcsIndex-1]);
				i--;j--;lcsIndex--;
			}else if ( ldp[i-1][j] > ldp[i][j-1])
				i--;
			 else 
				j--;
		}
		for(int ii = 0 ; ii < lcs.length ; ii++) {
			System.out.println("," + lcs[ii]);
		}
		String rslt = new String(lcs);
		System.out.println("String before return is " + rslt);
		return ( rslt);
		
	}
	public static void main(String[] args) {
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		
		char[] X = s1.toCharArray();
		char[] Y = s2.toCharArray();
		
		int lcsLen = lcs(X,Y,s1.length(), s2.length());
		
		System.out.println("Longest common subsequence of " + s1 + " and " + s2 + " is " + lcsLen);

		String maxlcs = lcsDP(X,Y,s1.length(), s2.length());
		System.out.println("Longest common subsequence of " + s1 + " and " + s2 + " is " + maxlcs);

	}

}
