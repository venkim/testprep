package com.venkat.gfg.dynprog;

public class MaxSumIncrSubSeq {

	public MaxSumIncrSubSeq() {
		// TODO Auto-generated constructor stub
	}

	public static int maxSum(int[] a) {
		int[] msum = new int[a.length];
		
		msum[0] = a[0];
		for(int i = 1 ; i < a.length ; i++) {
			int maxSum = msum[i];
			for(int j = 0; j < i ; j++) {
				if ( a[j] < a[i]) {
					int currSum = msum[j] + a[i];
					if ( currSum > maxSum)
						maxSum = currSum;
				}
			}
			msum[i] = maxSum;
		}
		// now loop through the maxSum array and return max
		int mmax = Integer.MIN_VALUE;
		for(int i = 0 ; i < msum.length ; i++) {
			if ( msum[i] > mmax)
				mmax = msum[i];
		}
		return (mmax);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] =  {1, 101, 2, 3, 100, 4, 5};
		System.out.println("CASE 1 - max sum is " + maxSum(a));
		
		int[] b = {3, 4, 5, 10};
		System.out.println("CASE 2 - max sum is " + maxSum(b));
		
		int [] c = {10, 5, 4, 3};
		System.out.println("CASE 3 - max sum is " + maxSum(c));
		

	}

}
