package com.venkat.leetfree;
/*
 * 
 *Given a string, find the length of the longest substring T 
 *that contains at most k distinct characters.
 * 
 * For example, Given s = “eceba”,
 *
 * T is "ece" which its length is 3.
 */
public class LongestwithKuniq2 {
	public static final int ALPHASIZE = 26;
	public LongestwithKuniq2() {
		// TODO Auto-generated constructor stub
	}
	public static String longOne(String inp, int k) {
		if (inp == null || inp.length() <= k)
			return inp;
		
		int[] cnt = new int[26];
		int uqcnt = 0;
		for(int i = 0 ; i < inp.length(); i++) {
			if (cnt[inp.charAt(i) - 'a'] == 0)
				uqcnt++;
			cnt[inp.charAt(i) - 'a']++;
		}
		if (uqcnt < k)
			return inp;
		
		cnt = new int[26];
		int curr_sta = 0, curr_end = 0;
		int max_sta = 0, max_end = 0;
		for(int i = 0 ; i < inp.length();i++) {
			cnt[inp.charAt(i)-'a']++;
			curr_end++;
			if ( !isValid(cnt,k)) {
				cnt[inp.charAt(curr_sta)-'a']--;
				curr_sta++;
			}
			if ( (max_end - max_sta) < (curr_end-curr_sta)) {
				max_end = curr_end;
				max_sta = curr_sta;
				//System.out.println(" max_end);
			}
		}
		
		return inp.substring(max_sta, max_end);
	}
	public static boolean isValid(int[] cnt, int k) {
		int uqcnt = 0;
		for(int i = 0 ; i < cnt.length;i++) {
			if (cnt[i] > 0)
				uqcnt++;
		}
		if (uqcnt <= k)
			return true;
		return (false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inp = "somestringaabbaaaaabbcddd";
		System.out.println(" Long with 2 uniq " + longOne(inp, 2));
		
	}

}
