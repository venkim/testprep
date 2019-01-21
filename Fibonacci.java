package com.venkat.gfg.dynprog;

public class Fibonacci {

	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	public static int fib(int n) {
		if (n == 0 || n == 1 )
			return 1;
		
		return ( fib(n-1) + fib(n-2));
	}
	public static int fibDP(int n) {
		int[] fb = new int[n+2];
		fb[0] = 1;
		fb[1] = 1;
		for(int i = 2;i <= n ;i++) {
			fb[i] = fb[i-1] + fb[i-2];
		}
		return (fb[n]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		System.out.println("Fib straight for " + n + " is = " + fib(n));
		System.out.println("Fib dynprog for " + n + " is = " + fibDP(n));
		
		n = 7;
		System.out.println("Fib straight for " + n + " is = " + fib(n));
		System.out.println("Fib dynprog for " + n + " is = " + fibDP(n));
	}

}
