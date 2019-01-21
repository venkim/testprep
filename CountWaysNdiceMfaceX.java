package com.venkat.gfg.dynprog;

import static org.hamcrest.CoreMatchers.instanceOf;

public class CountWaysNdiceMfaceX {

	public CountWaysNdiceMfaceX() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * m faced dice
	 * n dice
	 * sum to X
	 */
	public static int countWays(int m, int n, int X) {
		int[][] dpc = new int[n+1][X+1];
		
		// with 1 dice what can be counted- and only one way
		for(int j = 1; j <= m && j <= X ; j++)
			dpc[1][j] = 1;
			
		// populate dyn array - bottom up
		for(int i = 2 ; i <= n ; i++) {
			for(int j = 1 ; j <=X ; j++) {
				
				// use previous entries and use the recurrence relation
				for(int k = 1 ; k < j && k <= m; k++ ) {
					dpc[i][j] += dpc[i-1][j-k];  
				}
			}
		}
		
		// display
		 for (int i = 0; i <= n; i++){
			 for (int j = 0; j <= X; j++)
		        System.out.print( dpc[i][j] + "|");
		     System.out.println("");
		}
		 
		 return dpc[n][X];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numFaces = 6;
		for(int numDice= 1; numDice < 10 ; numDice++) {
			for(int sum = 4; sum< 16 ; sum++) {
				System.out.println("NumFace = 6 " + 
						" numDice = " + numDice + " sum= " + sum +
						" Ways = " + countWays(numFaces, numDice, sum));
			}
		}
	}

}
