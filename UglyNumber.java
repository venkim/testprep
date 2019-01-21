package com.venkat.gfg.dynprog;

public class UglyNumber {

	public UglyNumber() {
		// TODO Auto-generated constructor stub
	}

	public static int maxDiv(int a, int b) {
		while ( a%b == 0) {
			a = a/b ;
		}
		return (a);
	}
	// a number if ugly if hte only prime factors of that 
	// number are 2 3 5
	public static boolean isUgly(int n) {
		boolean ugly = false;
		n = maxDiv(n,2);
		n = maxDiv(n,3);
		n = maxDiv(n,5);
		if ( n== 1 ) 
			ugly = true;
		return (ugly);
	}
	public static int getNthUgly(int n) {
		int i2 = 0, val2 = 2;
		int i3 = 0, val3 = 3;
		int i5 = 0, val5 = 5;
		int nextUgly = 1;
		
		int[] ugly = new int[n];
		ugly[0] = 1;
		
		for(int i = 1 ; i < n; i++) {
			nextUgly = Math.min(  Math.min(val2, val3), val5) ;
			ugly[i] = nextUgly;
			
			if ( nextUgly == val2) {
				i2 = i2 + 1;
				val2 = ugly[i2] * 2;
			}
			if ( nextUgly == val3) {
				i3 = i3 + 1;
				val3 = ugly[i3] * 3;
			}
			if ( nextUgly == val5) {
				i5 = i5 + 1;
				val5 = ugly[i5] * 5;
			}
		}
		
		return (nextUgly);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// return the nth ugly number
		
		for(int j = 1 ; j < 20 ; j++) {
			System.out.println(j + " th ugly number is " + getNthUgly(j) );
		}
	}

}
