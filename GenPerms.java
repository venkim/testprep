package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class GenPerms {

	public GenPerms() {
		// TODO Auto-generated constructor stub
	}
	public static List<String> genPerms(int n) {
		List<String> rslt = new ArrayList<>();
		
		String raw = "";
		for(int i = 0 ; i < n ; i++) {
			raw += "" + i;
		}
		System.out.println("Raw string is " + raw);
		permHelper(0, n-1, raw, rslt);
		return (rslt);
	}
	public static void permHelper(int l,int r, String curr, List<String> rslt) {
		if (l == r) {
			rslt.add(curr);
		} else {
			for(int i = l; i <= r; i++) {
				curr = swap(curr,l,i);
				permHelper(l+1,r,curr,rslt);
				curr = swap(curr,l,i);
			}
		}
	}
	public static String swap(String str, int x, int y) {
		char xchar = str.charAt(x);
		char ychar = str.charAt(y);
		char[] strArr = str.toCharArray();
		strArr[y] = xchar;
		strArr[x] = ychar;
		return (String.valueOf(strArr));
	}
	public static void main(String[] args) {
		List<String> res = genPerms(3);
		System.out.println("For 3 size is " + res.size());
		System.out.println("Perms of 3 is " + res);
		
		int n = 5;
		res = genPerms(n);
		System.out.println("For " + n + " size is " + res.size());
		System.out.println("Perms of " + n + " is " + res);		
	}

}
