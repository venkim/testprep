package com.venkat.gfg.dynprog;

public class MinTrainCost {
	public static final int INF = 100000;
	public MinTrainCost() {
		// TODO Auto-generated constructor stub
	}

	public static int minTrainCost(int[][] cost) {
		int N = cost.length ;
		int[] dpc = new int[N];
		
		for(int i = 0 ; i < N ;i++)
			dpc[i] = INF;
		
		for ( int i = 1 ; i < N; i++) {
			// set mincost to get to i as dpc - inf
			int minCost = dpc[i];	
			// recursively go through all previous stations 
			// from 0 to intermediate j and from j to i
			for(int j = 0 ; j < i ; j++) {
				int currCost = cost[0][j] + cost[j][i];
				minCost = Math.min(minCost, currCost);
			}
			dpc[i] = minCost;
		}
		
		return dpc[N-1];
	}
	public static void main(String[] args) {
		int N = 4;
		int [][] cost = { 
					{0, 15, 80, 90},
					{INF, 0, 40, 50},
					{INF, INF, 0, 70},
					{INF, INF, INF, 0}
	             	};
		
		System.out.println("Min cost from origin to dest = " + minTrainCost(cost));

	}

}
