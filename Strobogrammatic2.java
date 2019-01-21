package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

/*
 * A strobogrammatic number is a number that looks the same when 
 * rotated 180 degrees (looked at upside down).
 * Find all strobogrammatic numbers that are of length = n.
 */
public class Strobogrammatic2 {

	public Strobogrammatic2() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * List of the strobogrammatic numbers of length n
	 *
	 **/
	
	public static List<String> cntStrobos(int n, int len) {
		List<String> rslt = new ArrayList<String>();
		
		if (n == 0) {
			rslt.add("");
			return (rslt);
		}
		
		if (n == 1) {
			rslt.add("0");
			rslt.add("1");
			rslt.add("8");
			return (rslt);
		}
		
		List<String> temp = cntStrobos(n-2,len);
		for(String s: temp) {
			if (n != len) {
				rslt.add("0" + s + "0");
			}
			rslt.add("6" + s + "9");
			rslt.add("9" + s + "6");
			rslt.add("1" + s + "1");
			rslt.add("8" + s + "8");
		}
		return rslt;
	}
	public static void main(String[] args) {
		List<String> rslt = cntStrobos(2,2);
		for(String s : rslt) {
			System.out.println("," + s);
		}
		
		rslt = cntStrobos(3,3);
		for(String s : rslt) {
			System.out.println("," + s);
		}
		
		rslt = cntStrobos(4,4);
		for(String s : rslt) {
			System.out.println("," + s);
		}
		
		rslt = cntStrobos(7,7);
		for(String s : rslt) {
			System.out.println("," + s);
		}
	}

}
