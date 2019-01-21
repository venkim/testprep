package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CoDec {

	public CoDec() {
		// TODO Auto-generated constructor stub
	}
	public static String encode(List<String> lst) {
		StringBuilder sb = new StringBuilder();
		for(String s: lst) {
			sb.append(s.length()).append("/").append(s);
		}
		return (sb.toString());
	}

	public static List<String> decode(String str){
		List<String> rslt = new ArrayList<String>();
		int i = 0;
		while (i < str.length()) {
			int slpos = str.indexOf("/",i);
			int size = Integer.parseInt(str.substring(i, slpos));
			String curr = str.substring(slpos+1,slpos+1+size);
			rslt.add(curr);
			i = slpos+size+1;
		}
		return (rslt);
	}
	public static void main(String[] args) {
		String[] sarry = {"goat","cheese","lady","bears","lion"};
		
		System.out.println("original string...");
		for(String x : sarry) {
			System.out.print("," + x);
		}
		List<String> lst = Arrays.asList(sarry);
		String encStr = encode(lst);
		
		System.out.println(" enc str " + encStr);
		
		List<String> rslt = decode(encStr);
		
		System.out.println();
		System.out.println(" decoded - to - encoded ");
		for(String x : rslt) {
			System.out.print("," + x);
		}

	}
	public static String enCode(List<String> lst) {
		StringBuffer sb = new StringBuffer();
		for(String x: lst) {
			sb.append(x.length()).append("/").append(x);
		}
		return (sb.toString());
	}
	public static List<String> deCode(String str){
		int i = 0;
		int slpos = 0;
		List<String> rslt = new ArrayList<String>();
		while (i < str.length()) {
			slpos = str.indexOf("/",i);
			int sz = Integer.parseInt(str.substring(i,slpos));
			String x = str.substring(slpos+1,slpos+1+sz);
			rslt.add(x);
			i = slpos+1+sz;
		}
		return (rslt);
	}
}
