package com.venkat.gfg.dynprog;

public class LongIncrSequence {

	public LongIncrSequence() {
		// TODO Auto-generated constructor stub
	}
	public static int lis(int[] arr) {
		int alen = arr.length;
		int[] lcs = new int[alen];

		for ( int k = 0 ; k < alen ; k++)
			lcs[k] = 1;
		
		for(int i = 0 ; i < alen ; i++) {
			for(int j = 0 ; j < i ; j++ ) {
				if (arr[j] < arr[i]) {
					if ( lcs[j] + 1 > lcs[i]) {
						lcs[i] = lcs[j] + 1;
					}
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 1; i < alen; i++) {
			if ( lcs[i] > max)
				max = lcs[i];
		}
		return (max);
	}
	public static void main(String[] args) {

		int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		System.out.println("LIS for arr is " + lis(arr));

	}
}
