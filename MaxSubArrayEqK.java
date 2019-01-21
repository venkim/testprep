package com.venkat.leetfree;

import java.util.HashMap;
import java.util.Map;

/*
 * Given an array nums and a target value k, find the maximum length of a subarray that sums to k. If there isn't one, return 0 instead.

 * * Note:
 * * The sum of the entire nums array is guaranteed to fit within the 32-bit signed integer range.

 * * Example 1:
 * * Given nums = [1, -1, 5, -2, 3], k = 3,
 * * return 4. (because the subarray [1, -1, 5, -2] sums to 3 and is the longest)
 * * Example 2:
 * * Given nums = [-2, -1, 2, 1], k = 1,
 * * return 2. (because the subarray [-1, 2] sums to 1 and is the longest)
 * * Follow Up:
 * * Can you do it in O(n) time?
 */
public class MaxSubArrayEqK {

	public MaxSubArrayEqK() {
		// TODO Auto-generated constructor stub
	}
	public static int maxlenSubArrayEqK(int[] a,int k) {
		Map<Integer,Integer> sumindx = new HashMap<>();
		
		if (a == null || a.length == 0)
			return 0;
		int max = 0, sum = 0;
		int len = a.length;
		for(int i = 0; i < len; i++) {
			sum = sum + a[i];
			
			if (sum == k)
				max = Math.max(max, i+1);
			
			int diff = sum - k;
			if (sumindx.containsKey(diff)) {
				max = Math.max(max, i-sumindx.get(diff));
			}
			if (!sumindx.containsKey(sum))
				sumindx.put(sum, i);
		}
		return (max);
	}
	public static void main(String[] args) {
		int[] nums = {1, -1, 5, -2, 3};
		int k = 3;
		int rslt = maxlenSubArrayEqK(nums,k);
		System.out.println("For a and k - ans = " + rslt);
		
		int[] nums1 = {-2, -1, 2, 1};
		k = 1;
		rslt = maxlenSubArrayEqK(nums1,k);
		System.out.println("For a and k - ans = " + rslt);

	}

}
