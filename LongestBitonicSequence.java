package com.venkat.gfg.dynprog;

public class LongestBitonicSequence {

	public LongestBitonicSequence() {
		// TODO Auto-generated constructor stub
	}

	public static int lbs(int[] a, int n) {
		int[] lis = new int[a.length];
		int[] lds = new int[a.length];
		
		for(int i = 0 ; i < a.length;i++) {
			lis[i] = 1;
			lds[i] = 1;
		}
		// populate lis dynamically - bottom up
		for(int i = 1; i < a.length ; i++) {
			for(int k = 1; k < i; k++) {
				if ( a[k] < a[i] && lis[k] + 1 > lis[i] )
					lis[i] = 1 + lis[k];
			}
		}
		
		// populate lds dynamically - bottom up
		for(int i = 1; i < a.length ; i++) {
			for(int k = 1; k < i; k++) {
				if ( a[k] > a[i] && lds[k] + 1 > lds[i] )
					lds[i] = 1 + lds[k];
			}
		}
		
		int maxbss = Integer.MIN_VALUE;
		
		for(int m = 0 ; m < a.length ; m++) {
			if ( lis[m] + lds[m] > maxbss) {
				maxbss = lis[m] + lds[m];
			}
		}
		
		return maxbss;
	}
	public static void main(String[] args) {
		int arr[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5,
                13, 3, 11, 7, 15};
		int n = arr.length;
		System.out.println("Length of LBS is "+ lbs( arr, n ));

	}

}
