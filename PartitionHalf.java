package com.venkat.gfg.dynprog;

public class PartitionHalf {

	public PartitionHalf() {
		// TODO Auto-generated constructor stub
	}

	public static boolean findPartition(int[] arr, int n) {
		int sum = 0;
		for(int i = 0 ; i < n ; i++) {
			sum += arr[i];
		}
		// definitely odd - so impossible
		if ( sum % 2 != 0)
			return (false);
		
		boolean[][] sdp = new boolean[sum/2+1][n+1];
		
		// the first row is definitely true - i.e., sum 0
		for(int i = 0 ; i <= n ; i++)
			sdp[0][i] = true;
		
		// the first column except the 0,0 - set to false
		for(int i = 1 ; i <= sum/2 ; i++)
			sdp[i][0] = false;
		
		// now onwards - either include or exclude and take the best
		// fill the matrix - in bottom up manner.
		for(int i = 1;i <= sum/2 ; i++) {
			for(int j = 1 ; j <= n ; j++) {
				sdp[i][j] = sdp[i][j-1];
				if ( i >= arr[j-1]) { // only if that sum is greater than element
					sdp[i][j] = sdp[i][j] || sdp[i-arr[j-1]][j-1];
				}
			}
		}
		
		return ( sdp[sum/2][n]);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int arr[] = {3, 1, 1, 2, 2,1};
	     int n = arr.length;
	     if (findPartition(arr, n) == true)
	         System.out.println("Can be divided into two " +
	                               "subsets of equal sum");
	     else
	         System.out.println("Can not be divided into" +
	                            " two subsets of equal sum");
	}

}
