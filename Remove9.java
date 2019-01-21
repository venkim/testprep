package com.venkat.leetfree;
/*
 * Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...
 *
 *  So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...
 *
 *  Given a positive integer n, you need to return the n-th integer after removing. Note that 1 will be the first integer.
 *
 *  Example 1:
 *  Input: 9
 *  Output: 10
 *  Hint: n will not exceed 9 x 10^8.
 *  
 *  Soln Idea: Essentially if you look at the sequence the numbers look like they are base 9
 *  instead of base 10. So, given a number you are trying to get the base 9 number of that input.
 *  So use the Integer wrapper class toString method to convert the number to base 9
 *  and then convert that to a decimal number or just string it...
 *  Not sure if this is a short-cut or a different approach expected...
 */
public class Remove9 {

	public Remove9() {
		
	}
	public static String getRem9(int n){
		System.out.println(" " + Integer.toString(n,9) );
		return Integer.toString(n,9);
	}

	public static void main(String[] args) {
		int inp = 9;
		System.out.println(" For index " + inp + " val = " + Integer.parseInt(getRem9(inp)));

	}

}
