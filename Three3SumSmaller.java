package com.venkat.leetfree;

import java.util.Arrays;

/*
 *  Given an array of n integers nums and a target, find the number
 *  of index triplets i, j, k with 0 <= i < j < k < n that satisfy the 
 *  condition nums[i] + nums[j] + nums[k] < target.
 *  For example, given nums = [-2, 0, 1, 3], and target = 2.
 * Return 2. Because there are two triplets which sums are less than 2:
 *	[-2, 0, 1]
 *	[-2, 0, 3]
 */
public class Three3SumSmaller {

	public Three3SumSmaller() {
		// TODO Auto-generated constructor stub
	}

	public static int getNum3Smaller(int[] nums, int target) {
		int cnt = 0;
		 
		Arrays.sort(nums);
		int len = nums.length;
		int i = 0, j = len-1;
		boolean direction = false;
		 
		while(i <= j) {
			int sum = nums[i] + nums[j];
			int runner = i+1;
			while (runner < j) {
				if (nums[runner] + sum < target) {
					cnt++;
				}
				runner++;
			}
			if (direction)
				i++; 
			else
				j--;
			direction = !direction;
		}
		return (cnt);			
	}
	public static void main(String[] args) {
		 int[] nums = {-2, 0, 1, 3};
		 int target = 2;
		 
		 int rslt = getNum3Smaller(nums,target);
		 
		 System.out.println("The count result is " + rslt);
	 
	}

}
