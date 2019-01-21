package com.venkat.leetfree;
/*
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees 
 * (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. 
 * The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 */
public class Strobogrammatic1 {

	public Strobogrammatic1() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * 6 and 9 are fine on opposite ends, 
	 * 8 on opposite ends or as the single digit
	 * 1 on opposite ends or as the single digit
	 */
	public static boolean isStrobog(int n) {
		
		int[] digs = getDigs(n);
		int len = digs.length;
		System.out.println("Number is " + n);
//		for(int i = 0 ; i < digs.length; i++) {
//			System.out.print("," + digs[i]);
//		}
		System.out.println();
		for(int i = 0; i < len/2; i++) {
			if (digs[i] == 8 && digs[len-1-i] == 8)
				continue;
			if (digs[i] == 1 && digs[len-1-i] == 1)
				continue;
			if (digs[i] == 6 && digs[len-1-i] == 9)
				continue;
			if (digs[i] == 9 && digs[len-1-i] == 6)
				continue;			
			return (false);
		}
		return (true);
	}
	public static int[] getDigs(int n) {
		int len = 0;
		int curr = n;
		while (curr > 0) {
			int rem = curr % 10;
			curr /= 10;
			len++;
		}
		int[] digs = new int[len];
		curr = n;
		int ind = 0;
		while(curr > 0) {
			digs[ind++] = curr % 10;
			curr /= 10;
		}
		return (digs);
	}
	public static void main(String[] args) {
		int[] test = {69,88,81,818,181,16891,19681,888,232};
		for(int i = 0 ; i < test.length;i++) {
			System.out.println("Number " + test[i] + " is strobo " + isStrobog(test[i]));
		}

	}

}
