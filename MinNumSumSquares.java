package com.venkat.gfg.dynprog;

public class MinNumSumSquares {

	public MinNumSumSquares() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * 1 + 1 + 1 + ... = n ( that is not minimum)
	 */
	public static int minNumSumSquares(int n) {
		
		if ( n <= 3)
			return n;
		
		int start = (int)Math.sqrt(n);
		for(int i = start ; i >= 0 ; i--) {
			if (i*i == n)
				return 1;
			else 
				return(1 + minNumSumSquares(n - i*i));
		}
		return (-1);
	}
	public static int minNumSumSquaresDP(int n) {
		
		int[] dp = new int[n+1];
		if ( n < 4)
			return n;
		
		dp[0]=0;
		dp[1]=1;
		dp[2]=2;
		dp[3]=3;

		
		for (int i = 4; i <= n ; i++) {
			int sq = (int)Math.sqrt(i);
			int rem = i - sq*sq;
			if ( sq*sq == i) {
				dp[i] = 1;
//				System.out.println("$" + i + " DP sq value is " + dp[i]);
			} else if ( i % (sq*sq) == 0) {
				System.out.println("Evenly divisible..." + sq*sq + "$" + i);
				dp[i] = i / (sq*sq);
			}
			else {
				dp[i] = 1 + dp[rem];
			}
//			System.out.println("sq sq is " + sq*sq + " rem is " + rem);
//			System.out.println("DP " + i +  " value is " + dp[i]);
		}
		return ( dp[n]);
	}
	public static int minNumSumSquaresDP2(int n) {	
		if (n == 0) return 0;
		if ( n < 4 ) return n;
	    int[] dps = new int[n+1];
	    dps[0] = 1;
	    dps[1] = 1;
	  dps[2] = 2;
	  dps[3] = 3;
	    // dps - at a certain position indicates the number of ways
	  // that number can be expressed as sum of squares
	    for(int i = 4; i <= n ; i++){
	      int min = Integer.MAX_VALUE;
	      System.out.println(" i = " + i);
	      for(int j = 1 ; j *j <= i ; j++){
	        int sq = (int) j*j;
	        if ( sq == i)
	          min = Math.min(1, min);
	        else if ( i % (int)(sq) == 0) 
				      min = Math.min( min, i/(int)(sq));
	        else {
	        	System.out.println(" in the else... path" + (i-sq) );
	          if ( i - sq > 0) {
	        	System.out.println("in the i - sq " + sq + "$" + (i-sq) + "$" + dps[i-sq]);  
	            min = Math.min(min, 1 + dps[i-sq]);
	          }
	        }   
	      }
	      dps[i] = min;
	      System.out.println(" i = " + i + " dp i " + dps[i]);
	    }
	    return ( dps[n]); 
	}
	public static void main(String[] args) {
//		for(int i = 2 ; i < 51 ; i++) {
			int i = 12;
			System.out.println(" RC min Num - Sum - Squares of " + i + " " + minNumSumSquares(i));
			System.out.println(" DP min Num - Sum - Squares of " + i + " " + minNumSumSquaresDP2(i));
//		}
	}

}
