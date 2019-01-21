package com.venkat.leetfree;
/*
 * An edit between two strings is one of the following changes.
 *
 * Add a character
 * Delete a character
 * Change a character
 * Given two string s1 and s2, 
 * find if s1 can be converted to s2 with 
 * exactly one edit. Expected time complexity is O(m+n) 
 * where m and n are lengths of two strings.
 *
 * Examples:
 * Input:  s1 = "geeks", s2 = "geek"
 * Output: yes
 * Number of edits is 1
 * Input:  s1 = "geeks", s2 = "geeks"
 * Output: no
 * Number of edits is 0
 */
public class IsEditDistanceOne {
	boolean editDisOne = false;
	public boolean isEditOne() {
		return (editDisOne);
	}
	public IsEditDistanceOne(String s, String t) {
		editDisOne = true;
		if (s == null && t == null) {
			editDisOne = true;
			return;
		}
		int slen = 0, tlen= 0;
		if (s != null)
			slen = s.length();
		if (t != null)
			tlen = t.length();
		if (Math.abs(slen - tlen) > 1) {
			editDisOne = false;
			return;
		}
		
		int cntDiff = 0;
		for(int i = 0, j = 0 ; i < slen && j < tlen; i++,j++) {
			if (s.charAt(i) != t.charAt(j)) {
				if (cntDiff >= 1) {
					editDisOne = false;
					break;
				}
				
				cntDiff++;
				if (slen > tlen) {
					i++;
				} else if (slen < tlen) {
					j++;
				}
			}
		}
			
	}

	public static void main(String[] args) {
		String s = "camp", t = "camp";
		IsEditDistanceOne edt1 = new IsEditDistanceOne(s,t);
		System.out.println("status is " + edt1.isEditOne());
		
		s = "camp11";
		edt1 = new IsEditDistanceOne(s,t);
		System.out.println("status is " + edt1.isEditOne());
		
		t = "damp22";
		edt1 = new IsEditDistanceOne(s,t);
		System.out.println("status is " + edt1.isEditOne());
		
		

	}

}
