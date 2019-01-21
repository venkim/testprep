package com.venkat.leetfree;
/*
 * 
 * The Numbers table keeps the value of number and its frequency.

 * +----------+-------------+
 * |  Number  |  Frequency  |
 * +----------+-------------|
 * |  0       |  7          |
 * |  1       |  1          |
 * |  2       |  3          |
 * |  3       |  1          |
 * +----------+-------------+
 * In this table, the numbers are 0, 0, 0, 0, 0, 0, 0, 1, 2, 2, 2, 3, so the median is (0 + 0) / 2 = 0.

 * +--------+
 * | median |
 * +--------|
 * | 0.0000 |
 * +--------+
 * Write a query to find the median of all numbers and name the result as median.
 */
public class FreqMedian {
	int[][] numbers;
	public FreqMedian(int[][] num) {
		this.numbers = num;
	}
	public double getMedian() {
		int num = 0;
		for(int[] frq : numbers) {
			num += frq[1];
		}
		int numMed = num/2;
		System.out.println("Num at median..." + numMed);
		int numPassed = 0;
		for(int[] frq: numbers) {
			if (numPassed + frq[1] < numMed)
				numPassed += frq[1];
			else
				return (1.0*frq[0]);
		}
		return 1.0;
	}
	public static void main(String[] args) {
		int[][] numbers = {
				 {0,7},
				 {1,4},
				 {2,3},
				 {3,11},
				 {4,2},
				 {5,5}
			};
		FreqMedian frm = new FreqMedian(numbers);
		System.out.println("Med freq is " + frm.getMedian());

	}

}
