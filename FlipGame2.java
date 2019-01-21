package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class FlipGame2 {

	public FlipGame2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String s = "++++";
		List<String> res = genPossibleNextMoves(s);
		System.out.println("Result is " + res);
		System.out.println("Result of can first player win is " + canFirstPlayerWin(s));
	}
	public static boolean canFirstPlayerWin(String str) {
		List<String> rslt = genPossibleNextMoves(str);
		for(String x : rslt) {
			boolean canWin = true;
			int len = x.length();
			for(int i = 1; i < len; i++) {
				if ( x.charAt(i) == x.charAt(i-1))
					canWin = false;
			}
			if (canWin)
				return (false);
		}
		return (true);
	}
	public static List<String> genPossibleNextMoves(String str){
		List<String> rslt = new ArrayList<>();
		if (str == null || str.length() == 0 || str.length() == 1)
			return rslt;
		
		int len = str.length();
		for(int i = 0 ; i < len-1;i++) {
			if (str.charAt(i) == str.charAt(i+1)) {
				if (str.charAt(i) == '-') {
					String newStr = str.substring(0, i) + "++" + str.substring(i+2);
					rslt.add(newStr);
				} else {
					String newStr = str.substring(0, i) + "--" + str.substring(i+2);
					rslt.add(newStr);					
				}
			}
		}
		return (rslt);
	}
}
