package com.venkat.leetfree;

public class PaintHouses {
	int[][] cost;
	int[][] minHouseCost;
	int minCost;
	public PaintHouses(int[][] cost) {	
		this.cost = cost;
		
		int numHouses = cost.length;
		minHouseCost = new int[numHouses][cost[0].length];
		
		minHouseCost[0] = cost[0]; 
		for(int i = 1 ; i < numHouses ; i++) {
			minHouseCost[i][0] = Math.min(minHouseCost[i-1][1], minHouseCost[i-1][2]) + cost[i][0];
			minHouseCost[i][1] = Math.min(minHouseCost[i-1][0], minHouseCost[i-1][2]) + cost[i][1];
			minHouseCost[i][2] = Math.min(minHouseCost[i-1][0], minHouseCost[i-1][1]) + cost[i][2];			
		}
		this.minCost = Math.min( Math.min(minHouseCost[numHouses-1][0], minHouseCost[numHouses-1][1]),
							minHouseCost[numHouses-1][2] );

	}

	public static void main(String[] args) {
		int[][] cost = {
				{2,4,5},{3,2,6},{4,2,3},{5,2,3},{3,5,7} 
		} ;
		PaintHouses ph = new PaintHouses(cost);
		System.out.println("Min cost is = " + ph.minCost);
	}

}
