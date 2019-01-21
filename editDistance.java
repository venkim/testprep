package com.venkat.gfg.dynprog;

public class editDistance {

	public editDistance() {
		// TODO Auto-generated constructor stub
	}
	public static int editDistance(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		return ( editDistance(s1, s2, m, n ));
	}
	public static int editDistanceDP(String s1, String s2) {
		int m = s1.length();
		int n = s2.length();
		return ( editDistanceDP(s1, s2, m, n ));
	}
	public static int editDistance(String s1, String s2, int m, int n) {		
		// insert the entire length of n if m is ZERO length
		if (m <= 0) return (n);
		
		// insert the entire length of m if n is ZERO length
		if (n <= 0) return (m);
		
		if ( s1.charAt(m-1) == s2.charAt(n-1)) {
			return ( editDistance(s1, s2, m-1, n-1));
		} else {
			return ( 1 + min(editDistance(s1,s2,m,n-1), 
							 editDistance(s1,s2,m-1,n),
							 editDistance(s1,s2,m-1,n-1) 
							 ) );
		}
	}
	public static int editDistanceDP(String s1, String s2, int m, int n) {
		int[][] edp = new int[m+1][n+1];
		
		// fill in edp array in bottom up manner
		for(int i = 0 ; i <= m ; i++) {
			for(int j = 0 ; j <= n ;j++) {
				if ( i == 0) 
					edp[i][j] = j;
				else if (j == 0) 
					edp[i][j] = i;
				else if ( s1.charAt(i-1) == s2.charAt(j-1) ) {
					edp[i][j] = edp[i-1][j-1];
				} else {
					edp[i][j] = 1 + min( edp[i-1][j], edp[i][j-1], edp[i-1][j-1] );
				}
 			}
		}
		return ( edp[m][n]);
	}
	public static int min(int a,int b,int c) {
		int min = Math.min(a, b);
		return ( Math.min( min, c));
	}
	
	public static void main(String[] args) {
		String s1 = "saturday";
		String s2 = "satarday";
		System.out.println("String " + s1 + ":" + s2 + ":" + editDistance(s1,s2));
		System.out.println("DP:-String " + s1 + ":" + s2 + ":" + editDistanceDP(s1,s2));
		
		s2 = "sunday";
		System.out.println("String " + s1 + ":" + s2 + ":" + editDistance(s1,s2));
		System.out.println("DP:-String " + s1 + ":" + s2 + ":" + editDistanceDP(s1,s2));
	}
}
