package com.venkat.gfg.dynprog;

public class FindLongestPathAdj {

	public FindLongestPathAdj() {
		// TODO Auto-generated constructor stub
	}
	public static int findLongestFromACell(int i, int j, int mat[][], int dp[][]) {
		// assume a square matrix
		int n = mat.length;
		
		
		if ( i < 0 || i > n || j < 0 || j> n)
			return 0;
		
		if ( dp[i][j] != -1)
			return ( dp[i][j]);
		
		// Since all numbers are unique and in range from 1 to n*n
		// there is atmost one possible direction from any cell
		if ( j < n-1 &&  mat[i][j] + 1 == mat[i][j+1]  ) {
			dp[i][j] = 1 + findLongestFromACell(i , j+1, mat, dp);
			return ( dp[i][j]);
		}
/**************8		
		if ( j > 0 && mat[i][j-1] + 1 ==  mat[i][j] ) {
			dp[i][j] = 1 +  findLongestFromACell(i, j-1, mat, dp);
			return ( dp[i][j]);
		}
		
		if ( i > 0 && mat[i-1][j] + 1 == mat[i][j] ) {
			dp[i][j] = 1 + findLongestFromACell(i-1, j, mat, dp);
			return ( dp[i][j]) ;
		}
****/		
		if ( i < n-1 && mat[i][j] + 1 == mat[i+1][j]) {
			dp[i][j] = 1 + findLongestFromACell(i+1, j, mat, dp);
			return ( dp[i][j]);
		}
		dp[i][j] = 1;
		return ( dp[i][j] );
	}
	public static int findLongestOverAll(int[][] mat) {
		int n = mat.length;
		int[][] dp = new int[n][n];
		
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				dp[i][j] = -1;
			}
		}

		int maxPath = Integer.MIN_VALUE;
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j < n ; j++) {
				if ( dp[i][j] == -1)
					dp[i][j] = findLongestFromACell( i,  j, mat,  dp);
				maxPath = Math.max(maxPath, dp[i][j] );
			}	
		}
		return (maxPath);
	}
	public static void main(String[] args) {
		int  mat[][] = { 
				{1, 2, 9},
                {5, 3, 8},
                {4, 6, 7} 
                };
		System.out.println("Length of the longest path is " + findLongestOverAll(mat));

	}

}
