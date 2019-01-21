package com.venkat.gfg.dynprog;

import java.util.Arrays;

public class CountSol {

	public CountSol() {
		// TODO Auto-generated constructor stub
	}
    // Returns counr of solutions for given 
    // rhs and coefficients coeff[0..n-1]
    public static int countSol(int coeff[], int n, int rhs)
    {
        // Create and initialize a table to 
        // store results of subproblems
        int dp[]=new int[rhs + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
     
        // Fill table in bottom up manner
        for (int i = 0; i < n; i++)
        	for (int j = coeff[i]; j <= rhs; j++)
        		dp[j] += dp[j - coeff[i]];
     
        return dp[rhs];
    }
     
    // Driver code
    public static void main (String[] args)
    {
        int coeff[] = {2, 2, 5};
        int rhs = 4;
        int n = coeff.length;
        System.out.print(countSol(coeff, n, rhs));
    }
}



