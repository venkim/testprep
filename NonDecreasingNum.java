package com.venkat.gfg.dynprog;

public class NonDecreasingNum {

	public NonDecreasingNum() {
		// TODO Auto-generated constructor stub
	}

	 public static int countNonDecreasing(int n){
	        // dp[i][j] contains total count of non decreasing
	        // numbers ending with digit i and of length j
	        int dp[][] = new int[10][n+1];
	      
	        // Fill table for non decreasing numbers of length 1
	        // Base cases 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
	        for (int i = 0; i < 10; i++)
	            dp[i][1] = 1;
	      
	        // Fill the table in bottom-up manner
	        for (int digit = 0; digit <= 9; digit++)
	        {
	            // Compute total numbers of non decreasing
	            // numbers of length 'len'
	            for (int len = 2; len <= n; len++)
	            {
	                // sum of all numbers of length of len-1
	                // in which last digit x is <= 'digit'
	                for (int x = 0; x <= digit; x++)
	                    dp[digit][len] += dp[x][len-1];
	            }
	        }
	      
	        int count = 0;
	      
	        // There total nondecreasing numbers of length n
	        // wiint be dp[0][n] +  dp[1][n] ..+ dp[9][n]
	        for (int i = 0; i < 10; i++)
	            count += dp[i][n];
	      
	        return count;
	    }
	    public static void main(String args[])
	    {
	       int n = 3;
	       System.out.println(countNonDecreasing(n));
	       
	       n = 1;
	       System.out.println(countNonDecreasing(n));
	       
	       n = 2;
	       System.out.println(countNonDecreasing(n));
	    }

}
