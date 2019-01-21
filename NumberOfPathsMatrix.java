package com.venkat.gfg.dynprog;

import java.util.Scanner;

public class NumberOfPathsMatrix {

	public NumberOfPathsMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static int countPaths(int m, int n) {
		
		
		if ( m == 1 || n == 1)
			return 1;
			
		return ( countPaths(m-1,n) + countPaths(m,n-1) ) ;	

	}
	public static int countPathsDP(int m, int n) {
		int[][] cdp = new int[m+1][n+1];
		// row and column with 1 in either
		for(int i = 1; i <= m ;i++) {
			cdp[i][1] = 1;
		}
		for(int j = 1 ; j <= n;j++) {
			cdp[1][j] = 1;
		}
		
		for(int i = 2 ; i <= m ; i++) {
			for(int j = 2 ; j <= n ; j++) {
				cdp[i][j] = cdp[i-1][j] + cdp[i][j-1];
			}
		}
		return ( cdp[m][n]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i = 1; i <= 3 ; i++) {
			for(int j = 1 ; j <=3 ; j++ ) {
				System.out.println(" row = " + i + "| col = " + j + "|+Count ways = " + countPaths(i,j));
				System.out.println("DP row = " + i + "| col = " + j + "|+Count ways = " + countPathsDP(i,j));

			}
		}
		
		Scanner sc = new Scanner(System.in);
		
		int numTC = sc.nextInt();
		int nRow=0, nCol=0;
		while (numTC > 0) {
			numTC--;
			nRow= sc.nextInt();
			nCol = sc.nextInt();
			System.out.println(countPathsDP(nRow,nCol));
		}
	}

}
