package com.venkat.gfg.dynprog;

public class CutRodMaxPrice {

	public CutRodMaxPrice() {
		// TODO Auto-generated constructor stub
	}
	public static int cutRodDP(int[] price, int n) {
		if ( n <= 0)
			return 0;
		int max_val = Integer.MIN_VALUE;
		
		// recursively cut in diff points and computer price
		for(int i = 1 ; i < n ; i++) {
			max_val = Math.max( max_val, price[i] +  cutRodDP(price, n-i-1) );
		}
		return (max_val);
	}
	public static int cutRod(int[] price) {
		int[] dprice = new int[1 + price.length];
		
		dprice[0] = 0;
		for(int k = 1 ; k < dprice.length ;k++)
			dprice[k] = 0;
		
		for(int i = 1 ; i < dprice.length ; i++) {
			dispArr(dprice);
			// get the current dyn price from dyn price
			int max = dprice[i];
			// for each smaller piece whose dyn price 
			// that has already been computed
			for(int j = 1 ; j <= i ; j++) {
				int diff = i - j;
				int pdiff = price[diff];
				
				if ( dprice[j] + pdiff > max ) {
					max = dprice[j] + pdiff;
				}
			}
			dprice[i] = max;
		}
		dispArr(dprice);
		return (dprice[ dprice.length -1]);
	}
	public static void dispArr(int[] d) {
		for(int i = 0 ; i < d.length ; i++) {
			System.out.print(  d[i] + " ,");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] price = {0,1,   5,   8,   9 , 10,  17,  17,  20};
		System.out.println(" Dyn price = " + cutRod(price));
		
		int[] npr = {1,   5,   8,   9 , 10,  17,  17,  20};
		System.out.println(" cutRod DP price = " + cutRodDP(npr,8));
	}

}
