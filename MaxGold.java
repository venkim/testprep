package com.venkat.gfg.dynprog;

public class MaxGold {

	public MaxGold() {
		// TODO Auto-generated constructor stub
	}
	public static int maxGold(int[][] g,int m, int n) {
		int[][] dg = new int[m][n];
		
		for(int i = 0 ; i < m ; i++) {
			dg[i][0] = g[i][0];
		}
		
		// From next column onwards, carefully populate up, same, down
		for(int j = 1 ; j < n ; j++) {
			for(int ir = 0;  ir < m ; ir++) {
				if (ir == 0) {
					// straight
					int straight = dg[ir][j-1] + g[ir][j-1];
					int up = dg[ir+1][j-1] + g[ir][j-1];
					dg[ir][j] = Math.max(straight, up);
				} else if ( ir == m-1) {
					// down cross
					int down = dg[ir-1][j-1] + g[ir][j];
					int straight = dg[ir][j-1] + g[ir][j];
					dg[ir][j] = Math.max(down, straight);
 				} else {
 					int down = dg[ir-1][j-1] + g[ir][j];
 					int straight = dg[ir][j-1] + g[ir][j];
 					int up = dg[ir+1][j-1] + g[ir][j];
 					dg[ir][j] =  Math.max( Math.max(down, straight)  , up );
 				}
			}
		}
		
		int finalMax = 0;
		for(int ir = 0 ; ir < n ; ir++) {
			if ( dg[ir][n-1] > finalMax ) {
				finalMax = dg[ir][n-1];
			}
		}
		return (finalMax);
	}
	public static void main(String[] args) {

		int gold[][]= { {1, 3, 1, 5},
                {2, 2, 4, 1},
                {5, 0, 2, 3},
                {0, 6, 1, 2} };
                 
		int m = 4, n = 4;
 
		System.out.print("Max Gold return is = " + maxGold(gold, m, n));
	}

}
