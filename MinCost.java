package com.venkat.gfg.dynprog;

public class MinCost {

	public MinCost() {
		// TODO Auto-generated constructor stub
	}

	public static int minCost(int[][] costs) {
		int rlen = costs.length;
		int clen = costs[0].length;
		
		int[][] minc = new int[rlen][clen];
		
		// initialize the col 0, and row 0 paths
		minc[0][0] = costs[0][0];
		for(int i = 1 ; i < rlen ; i++) {
			minc[i][0] = costs[i][0] + minc[i-1][0];
		}
		
		for(int j = 1 ; j < clen; j++) {
			minc[0][j] = costs[0][j] + minc[0][j-1];
		}
		int mpath = 0;
		for (int i = 1 ; i < rlen ; i++) {
			for (int j = 1 ; j < clen; j++) {
				mpath = Math.min( Math.min( minc[i-1][j],minc[i][j-1]) , minc[i-1][j-1]);
				minc[i][j] = mpath + costs[i][j];
			}
		}
		printMat(minc);
		return ( minc[rlen-1][clen-1] );
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mc = {
				{1,2,3},
				{4,8,2},
				{1,5,3}
				};
		
		System.out.println("Mincost from top left to bot right is " + minCost(mc));
	}
	public static void printMat(int[][] mat) {
		int numR = mat.length;
		int numC = mat[0].length;
		for(int i = 0; i < numR ; i++) {
			System.out.print("|");
			for(int j = 0 ; j < numC ; j++) {
				System.out.print( mat[i][j]) ;
				System.out.print("|");
			}
			System.out.println();
		}
	}
}
