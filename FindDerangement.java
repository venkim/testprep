package com.venkat.leetfree;
/*
 ** In combinatorial mathematics, a derangement is a permutation of the elements 
 ** of a set, such that no element appears in its original position.

 ** There's originally an array consisting of n integers from 1 to n 
 ** in ascending order, you need to find the number of derangement it can generate.

 ** Also, since the answer may be very large, you should return the output mod 109 + 7.

 ** Example 1:
 ** Input: 3
 ** Output: 2
 ** Explanation: The original array is [1,2,3]. The two derangements are [2,3,1] and [3,1,2].
 ** Note:
 ** n is in the range of [1, 106].
 */
public class FindDerangement {
	public static final int NUMLIM = (int)Math.pow(10,9)+7;
	public FindDerangement() {
		// TODO Auto-generated constructor stub
	}
	public static int findNumDeran(int n) {
		if (n == 0)
			return 1;
		if (n == 1)
			return 0;
		int first = 1, second = 0;
		int curr = 2;
		
		while(curr <= n) {
			int temp = (int)((long)(curr-1L)*( (long) (second + first) % NUMLIM) % NUMLIM );
			first = second;
			second = temp;
			curr++;
		}
		return (second);
	}
	public static void main(String[] args) {
		for(int i = 0; i <= 20; i++) {
			System.out.println(" i = " + i + " num Derange = " + findNumDeran(i));
		}

	}

}
