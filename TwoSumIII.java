package com.venkat.leetfree;

import java.util.HashSet;
import java.util.Set;

/*
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 *For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * 
 * If you want O(1) for add and O(n) for find - A set will do and possible another for dups
 * If you want O(n) for add and O(1) for find - A map/set and a set will do - one for sum
 * 			- map for keeping the elements and sum for possible sums
 * 			- if you keep set for keeping elements and set for possible sums - you lose
 * 			- some original info - how many elements there are 
 * 			- limitations on representing 
 */
public class TwoSumIII {
	Set<Integer> elems;
	Set<Integer> sums;
	public TwoSumIII() {
		elems = new HashSet<Integer>();
		sums = new HashSet<Integer>();
	}
	/*
	 * O(n) complexity - for adding
	 */
	public void add(int n) {
		for(Integer x: elems) {
			sums.add(x+n);
		}
		// add after updating the sum to avoid
		// adding a dup....
		elems.add(n);
	}
	/*
	 * find is O(1)
	 */
	public boolean find(int sum) {
		if (sums.contains(sum))
			return true;
		return (false);
	}
	public static void main(String[] args) {
		TwoSumIII ts3 = new TwoSumIII();
		ts3.add(1);
		ts3.add(3);
		ts3.add(5);
		System.out.println("Finding 4 in sum " + ts3.find(4) );
		System.out.println("Finding 4 in sum " + ts3.find(7) );

		

	}

}
