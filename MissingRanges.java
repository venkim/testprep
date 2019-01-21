package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public MissingRanges() {
		// TODO Auto-generated constructor stub
	}
	public static List<String> findMissingRanges(int[] vals, int start, int end) {
		List<String> rslt = new ArrayList<String>();
		int prev = start-1;
		int curr = vals[0];
		int len = vals.length;
		for(int i = 0 ; i <= len;i++) {
			if (i == len)
				curr = end;
			else
				curr = vals[i];

			if (curr - prev >= 2) {
				rslt.add(getRange(prev+1,curr-1));
			}
			prev = curr;
		}
		return (rslt);
	}
	private static String getRange(int from, int to) {
		if (from == to) 
			return "" + from;
		else 
			return "" + from + "->" + to ;
	}
	public static void main(String[] args) {
		int[] vals =  {0, 1, 3, 50, 75};
		System.out.println("missing ranges is " + MissingRanges.findMissingRanges(vals, 0, 99));

	}
}
