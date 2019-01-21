package com.venkat.gfg.dynprog;

public class Knapsack {

	public Knapsack() {
		// TODO Auto-generated constructor stub
	}
	/* knapsack - Recursive solution
	 * W - max weight that bag can hold
	 * wt - series of weights available
	 * val - series of values available
	 * n - length of the weights array - number of weights available
	 */
	public static int knapsackRec(int W, int wt[], int val[],int n) {
		// base case
		if ( n == 0 || W == 0)
			return 0;
		
		// if the one we are considering is greater than W - cannot include
		if ( wt[n-1] > W) {
			return knapsackRec(W, wt, val,n-1);
		}
		
		// Now consider the max of two situations - one with including n-1 
		// and one without including that n-1
		return ( Math.max( val[n-1] + knapsackRec( W - wt[n-1], wt, val,n-1)  , 
				           knapsackRec(W, wt, val, n-1)));
	}
	/* knapsack - dynprog solution
	 * W - max weight that bag can hold
	 * wt - series of weights available
	 * val - series of values available
	 * n - length of the weights array - number of weights available
	 */
	public static int knapsackDP(int W, int wt[], int val[],int n) {
		int[][] kndp = new int[n+1][W+1];
		
		// build bottom up dyn knap sack
		for(int i = 0 ; i <= n ; i++) {
			for(int j = 0 ; j <= W; j++) {
				// edge rows to 0
				if (i == 0 || j == 0)
					kndp[i][j] = 0;
				else if ( wt[i-1] > j )	// wt i is individually > j(curr weight) - dont include
					kndp[i][j] = kndp[i-1][j];
				else 
					kndp[i][j] = Math.max( val[i-1] + kndp[i-1][j-wt[i-1]] , kndp[i-1][j]);
			}
		}
		return (kndp[n][W]);
	}
	public static void main(String args[])
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println("Recursive kn " + knapsackRec(W, wt, val, n));
        
        System.out.println("DP Kn" + knapsackDP(W, wt, val, n));
    }

}
