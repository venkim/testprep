package com.venkat.leetfree;

public class PaintHouses2 {
	int[][] cost;
	int n;
	int k;
	int minOverall;
	public PaintHouses2(int[][] cost) {
		this.cost = cost;
		this.n= cost.length;
		this.k = cost[0].length;
		findMinCost();
	}
	private void findMinCost() {
		int[][] dpc;
		
		dpc = new int[n][k];
		for(int i = 0 ; i < k; i++) {
			dpc[0][i] = cost[0][i];
		}
		
		for(int nHouse = 1 ; nHouse < n; nHouse++) {
			int minCost = Integer.MAX_VALUE;
			for(int pos = 0 ; pos < k; pos++) {
				int preHouse = nHouse - 1;
				for(int prepos = 0 ; prepos < k; prepos++) {
					if (pos == prepos)
						continue;
					minCost = Math.min(minCost,dpc[preHouse][prepos]);
				}
				dpc[nHouse][pos] = minCost + cost[nHouse][pos];
			}
		}
		minOverall = Integer.MAX_VALUE;
		int lhouse = n-1;
		for(int pos = 0 ; pos < k; pos++) {
			minOverall = Math.min(minOverall, dpc[lhouse][pos]);
		}
	}
	public int getMinCost() {
		return (this.minOverall);
	}
	public static void main(String[] args) {
		int[][] cost = {
				{2,4,5},{3,2,6},{4,2,3},{5,2,3},{3,5,7} 
		} ;
		PaintHouses2 ph2 = new PaintHouses2(cost);
		
		System.out.println("min cost is " + ph2.getMinCost());
		
	}
}
