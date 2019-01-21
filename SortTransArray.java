package com.venkat.leetfree;
/*
 * Given a sorted array of integers nums and integer values a, b and c. 
 * Apply a quadratic function of the form f(x) = ax2 + bx + c 
 * to each element x in the array.
 * The returned array must be in sorted order.
 * Expected time complexity: O(n)
 * Example:
 * nums = [-4, -2, 2, 4], a = 1, b = 3, c = 5,
 * Result: [3, 9, 15, 33]
 *
 * nums = [-4, -2, 2, 4], a = -1, b = 3, c = 5
 * Result: [-23, -5, 1, 7]
 * 
 */
public class SortTransArray {
	
	public SortTransArray() {
		// TODO Auto-generated constructor stub
	}
	public static int[] sortTransformedArray2(int[] nums,int a,int b,int c) {
		int max = Integer.MIN_VALUE;
		int index = -1;
		
		int[] rslt = {};
		if (nums == null || nums.length == 0)
			return rslt;
		
		rslt = new int[nums.length];
		// O(n) -- to scan and find max
		for(int i = 0; i < nums.length; i++) {
			int curVal = getVal(nums[i],a,b,c);
			if (curVal > max) {
				max = curVal;
				index = i;
			}
		}
		// linear scan - finding min element up to max
		int i = 0, j = nums.length -1;
		int iVal, jVal;
		int resInd = 0;
		while ( i < index && j > index) {
			iVal = getVal(nums[i],a,b,c);
			jVal = getVal(nums[j],a,b,c);
			if (iVal < jVal) {
				rslt[resInd++] = iVal;
				i++; 
			} else {
				rslt[resInd++] = jVal;
				j--;
			}
		}
		while (i < index) {
			iVal = getVal(nums[i],a,b,c);
			rslt[resInd++] = iVal;
			i++;
		}
		while (j > index) {
			jVal = getVal(nums[j],a,b,c);
			rslt[resInd++] = jVal;
			j--;
		}
		rslt[index] = max;
		return (rslt);
	}
	private static int getVal(int x, int a, int b, int c) {
		return (a*x*x + b*x + c); 
	}
	public static int[] sortTransformedArray(int[] nums,int a,int b,int c) {
		int len = nums.length;
		int[] rslt = new int[len];
		int start = 0, end = nums.length -1;
		int nextInd = 0;
		
		if (a > 0 || (a == 0 && b > 0)) {
			nextInd = len-1;
		}
		if (a < 0 || (a == 0 && b < 0)) {
			nextInd = 0;
		}
		double mid = -1.0 * b/(2 *1.0 * a);
		while(start <= end) {
			if (a > 0 || (a == 0 && b > 0)) {
				if (Math.abs(mid - nums[start]) > Math.abs(nums[end] - mid)) {
					int x = nums[start++];
					rslt[nextInd--] = a*x*x+b*x+c;
				} else {
					int x = nums[end--];
					rslt[nextInd--] = a*x*x+b*x+c;
				}
			} else if ( a < 0 || (a == 0 && b < 0)) {
				if (Math.abs(mid - nums[start]) > Math.abs(nums[end] - mid)) {
					int x = nums[start++];
					rslt[nextInd++] = a*x*x+b*x+c;
				} else {
					int x = nums[end--];
					rslt[nextInd++] = a*x*x+b*x+c;
				}
			}
		}
		return (rslt);
	}
	public static void main(String[] args) {
		int[] nums = {-4, -2, 2, 4};
		int a = 1, b = 3, c = 5;
		
		int[] rslt = sortTransformedArray(nums,a,b,c);
		for(int i = 0 ; i < rslt.length;i++) {
			System.out.print("," + rslt[i]);
		}
		
		System.out.println("second array...");
		rslt = sortTransformedArray2(nums,a,b,c);
		for(int i = 0; i < rslt.length;i++) {
			System.out.print("," + rslt[i]);
		}


	}

}
