package com.venkat.gfg.dynprog;

public class LongestRepeatingSubseq {
/*
 * Given a string, find length of the longest repeating subseequence 
 * such that the two subsequence don’t have same string character at 
 * same position, i.e., any i’th character in the two subsequences 
 * shouldn’t have the same index in the original string.
 */
	public LongestRepeatingSubseq() {
		// TODO Auto-generated constructor stub
	}
/*
 *  This is exactly similar to LCS - but 
 *  looks for not same position
 */
	public static String lrs(String str) {
		int len = str.length();
		int[][] dp = new int[len+1][len+1];
		
		for(int i = 1 ; i <= len ; i++) {
			for(int j = 1 ; j <= len ; j++) {
				if ( str.charAt(i-1) == str.charAt(j-1) && i != j) {
					dp[i][j] = 1 + dp[i-1][j-1];
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		int ind = dp[len][len];
		char[] rslt = new char[ind];
		
		int i = len, j = len;
		while ( i > 0 && j > 0) {
			if ( str.charAt(i-1) == str.charAt(j-1)&& i != j ) {
				rslt[--ind] = str.charAt(i-1);
				i--;j--;
			} else if ( dp[i-1][j] > dp[i][j-1]) {
				i--;
			} else 
				j--;
		}
		String rs = new String(rslt);
		return (rs);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "AABEBCDD";
		
		System.out.println("lrs result is " + lrs(s));
	}

}
