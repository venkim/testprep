package com.venkat.leetfree;

import java.util.Arrays;

/*
 * Given an unsorted array nums, reorder it in-place 
 * such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 *
 * For example, given nums = [3, 5, 2, 1, 6, 4], one 
 * possible answer is [1, 6, 2, 5, 3, 4].
 */
public class WiggleSort {
	int[] arr;
	public WiggleSort(int[] iarr) {
		this.arr = iarr;
		method2();
	}
	private void method1() {
		Arrays.sort(arr);
		for(int i = 1 ; i < arr.length -1; i+=2) {
			swap(i, i+1);
		}
	}
	/*
	 * O(n) - method - one pass
	 */
	private void method2() {
		boolean less = true;
		for(int i = 0 ; i < arr.length -1 ;i++) {
			if (less) {
				if (arr[i] > arr[i+1]) {
					swap(i,i+1);
				}
			} else {
				if (arr[i] < arr[i+1]) {
					swap(i,i+1);
				}
			}
			less = !less;
		}
	}
	private void swap(int j,int k) {
		int temp = arr[j];
		arr[j] = arr[k];
		arr[k] = temp;
	}
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < arr.length; i++) {
			sb.append( arr[i] + ",");
		}
		return (sb.toString());
	}

	public static void main(String[] args){
		int[] a = { 10, 7, 2, 5, 3, 1, 4, 6, 9, 8 };
		WiggleSort ws1 = new WiggleSort(a);
		System.out.println(ws1);

	}

}
