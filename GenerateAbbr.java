package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class GenerateAbbr {

	public GenerateAbbr() {
		// TODO Auto-generated constructor stub
	}
	public static List<String> genAbbr(String str){
		List<String> rslt = new ArrayList<String>();
		
		rslt.add(str);
		genAbbrHelper(0,str,rslt);
		
		return(rslt);
	}
	private static void genAbbrHelper(int start, String str, List<String> rslt) {
		if (start >= str.length()) 
			return;
		
		for(int i = start; i < str.length(); i++) {
			for(int j = 1; i + j <= str.length(); j++) {
				String num = Integer.toString(j);
				String abbr = str.substring(0,i) + num + str.substring(i+j);
				rslt.add(abbr);
				genAbbrHelper(i+1+num.length(),abbr,rslt);
			}
		}
	}
	public static void main(String[] args) {
		String s = "goat";
		System.out.println(" abbr are ..." + genAbbr(s));

	}

}
