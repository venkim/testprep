package com.venkat.gfg.dynprog;

public class FillWeightMinCost {

	public FillWeightMinCost() {
		// TODO Auto-generated constructor stub
	}

	public static int minCost(int value, int[] cost) {
		
		int[] dpcost = new int[value+1];
		
		// initialize dynamic cost
		for(int i = 0 ; i < cost.length ;i++) {
			dpcost[i+1] = cost[i];
		}
		
		// now in a loop compare and initialize
		for(int i = 2 ; i < dpcost.length;i++) {
			int minForI = dpcost[i];
			
			for(int j = 1 ; j < i ; j++){
				int dpcostj = dpcost[j];
				int remain = i-j;
				int offCost = cost[i-j-1];
				if ( dpcostj + offCost < minForI) {
					minForI = dpcostj + offCost;
				} 
			}
			dpcost[i] = minForI;
		}
		
		return dpcost[value];
	}
	public static void main(String[] args) {
		int W = 5;
		int[] cost = {20,10,4,50,100};
		
		int rtn = minCost(W, cost);
		System.out.println("For 5 and cost min is " + rtn);
		
		
		

	}

}
