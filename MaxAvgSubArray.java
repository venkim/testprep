package com.venkat.leetfree;
/*
 * Given an array consisting of n integers, find the contiguous subarray 
 * whose length is greater than or equal to k that has the maximum 
 * average value. And you need to output the maximum average value.

 * Example 1:
 *Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation:
 * when length is 5, maximum average value is 10.8,
 * when length is 6, maximum average value is 9.16667.
 * Thus return 12.75.
 * Note:
 *  1 <= k <= n <= 10,000.
 *  Elements of the given array will be in range [-10,000, 10,000].
 *  The answer with the calculation error less than 10-5 will be accepted.
 */
public class MaxAvgSubArray {

	public MaxAvgSubArray() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * use forwarding window...
	 */
	public static double maxAvgSubarray(double[] a, int k) {
		int start = 0;
		int endxx = k;
		int len = a.length;
		double runsum = 0;
		double currAvg = 0,maxAvg = 0;
		
		for(int i = 0 ; i < k; i++) {
			runsum += a[i];
		}
		currAvg = runsum / k;
		maxAvg = currAvg;
		
		while (start < len-k && endxx < len-1) {
			endxx += 1;
			runsum += a[endxx];
			currAvg = runsum / (endxx-start);
			if (currAvg > maxAvg) {
				maxAvg = currAvg;
			} else {
				start++;
			}
			System.out.println(" elem is " + a[endxx]);
			System.out.println(" Num elements is " + (endxx-start));
			System.out.println("curr Avg is " + currAvg + " Max Avg is " + maxAvg);
		}
		return (maxAvg);
	}
	public static void main(String[] args) {
		int n = 15;
		double[] a = new double[15];
		for(int i = 0 ; i < 15; i++) {
			double sgndet = Math.random();
			if (sgndet > 0.5)
				a[i] = 100*Math.random();
			else
				a[i] = -1*100*Math.random();
			
			System.out.print("," + a[i]);
		}
		System.out.println();
		System.out.println("Max avg subarry sum " + maxAvgSubarray(a, 4) );
	}

}
