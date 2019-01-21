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
public class LongestwithKuniq3 {
	public static final int ALPHASIZE = 26;
	public LongestwithKuniq3() {
	}
	public static String longestWithUniq(String s, int k) {
		if (s == null || s.length() == 0)
			return s;
		
		if (s.length() < k)
			return s;
		int[] cnt = new int[ALPHASIZE];
		int uniqk = 0;
		for(int i = 0;i < s.length();i++) {
			if (cnt[s.charAt(i)-'a'] == 0) {
				uniqk++;
			}
			cnt[s.charAt(i)-'a']++;
		}
		if (uniqk < k)
			return s;
		System.out.println("passing mid way mark");
		cnt = new int[ALPHASIZE];
		int curr_sta = 0, curr_end = 0;
		int max_sta = 0, max_end = 0;
		int uniqcnt = 0;
		for(int i = 0;i < s.length(); i++) {
			char c = s.charAt(i);
			cnt[c-'a']++;
			curr_end = i;
//			System.out.println("curr sta end " + curr_sta + "$" + curr_end);
			if (isValid(cnt,k)) {
				curr_end = i;
				if (max_end - max_sta < curr_end - curr_sta) {
					max_end = curr_end;
					max_sta = curr_sta;
				}
			} else {
				cnt[s.charAt(curr_sta)-'a']--;
				curr_sta++;
			}
//			System.out.println("max sta end " + max_sta + "$" + max_end);
		}
		return (s.substring(max_sta, max_end));
	}
	private static boolean isValid(int[] cnt,int k) {
		int uniqk = 0;
		for(int i = 0; i < cnt.length;i++) {
			if (cnt[i] != 0)
				uniqk++;
		}
		if (uniqk <= k)
			return true;
		return (false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String inp = "somestringaabbaaaaabbcddd";
		System.out.println(" Long with 2 uniq " + longestWithUniq(inp, 2));
		
	}

}
