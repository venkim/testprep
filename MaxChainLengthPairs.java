package com.venkat.gfg.dynprog;

import java.util.Arrays;
import java.util.Collections;

class Pair implements Comparable<Pair> {
	int x;
	int y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair other) {
		Pair pother = (Pair)other;
		if (this.x < pother.x)
			return -1;
		else if (this.x > pother.x)
				return +1;
		else
			return 0;
	}
	public String toString() {
		return("Pair [" + x + "," + y + "]");
	}
}
public class MaxChainLengthPairs {

	public MaxChainLengthPairs() {
		// TODO Auto-generated constructor stub
	}
	public static int maxChainLength(Pair[] a, int len) {
		int[] mcl = new int[a.length];
		
		Arrays.sort(a);
		for(int i = 0 ; i < a.length ; i++) {
			System.out.print( " ," + a[i]);
		}
		System.out.println();
		for(int i = 0 ; i < len ; i++)
			mcl[i] = 1;
		
		/* compute optimized chain length in bottom-up style */
		for(int i = 1 ; i < len ; i++) {
			int maxLen = mcl[i];
			for(int j = 0 ; j <= i;j++) {
				if ( a[j].y < a[i].x) {
					int jlen = mcl[j];
					if (1 + jlen > maxLen) {
						maxLen = 1 + jlen;
					}
				}
			}
			mcl[i] = maxLen;
		}
		int maxPLen = 0;
		// now cycle through mcl array
		for(int i = 0 ; i < mcl.length ;i++) {
			if (mcl[i] > maxPLen) {
				maxPLen = mcl[i];
			}
		}
		return (maxPLen);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pair arr[] = new Pair[] {new Pair(5,24), new Pair(15, 25),
                new Pair (27, 40), new Pair(50, 60)};
		
		for(int i = 0 ; i < arr.length ; i++) {
			System.out.print( " ," + arr[i]);
		}
		System.out.println();
		System.out.println("Max chain length is " + maxChainLength( arr , arr.length ));
	}

}
