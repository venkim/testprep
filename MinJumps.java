package com.venkat.gfg.dynprog;

public class MinJumps {

	public MinJumps() {
		// TODO Auto-generated constructor stub
	}
	public static int minJumps(int[] arr, int n) {
		if ( n == 0 || arr[0] == 0)
			return Integer.MAX_VALUE;
		
		int[] jumps = new int[n];
		
		int  j;
		jumps[0] = 0;
		for(int i = 1;i < n;i++) {
			jumps[i] = Integer.MAX_VALUE;
			for(j = 0; j < i; j++) {
				if ( i < j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + i);
					break;
				}
			}
		}
		return ( jumps[n-1]);
		
	}
		// driver program to test above function
	public static void main(String[] args) {
			int arr[] = {1, 3, 6, 1, 1, 9};
		                
		    System.out.println("Minimum number of jumps to reach end is : " +
		                                  minJumps(arr,arr.length));

		}


}
