package com.venkat.gfg.dynprog;

import java.util.HashSet;


public class LongestUniqueSubstring {

	public LongestUniqueSubstring() {
		// TODO Auto-generated constructor stub
	}
/*
 * long..("abcdefab") = "abcdef"
 * long...("ababc") = "abc"
 * long...("ababefgh") = "abefgh"
 * long...("abcdfgab") = "cdfgab")
 */
	public static String longestUniqSub(String s) {
		HashSet<Character> hset = new HashSet<Character>();
		int maxlen = 0;
		int currlen = 0;
		int start = 0, end = 0;
		int maxst = 0, maxnd = 0;
		
		for(int i = 0 ; i < s.length(); i++ ) {
			char cChar = s.charAt(i);
			if ( hset.contains(cChar)) {
				// reset and have to return back somewhere
				// instead remove repeated characters and reposition start
				while ( s.charAt(start) != cChar) {
					// remove those characters that are already found
					hset.remove( s.charAt(start) );
					start++;
				}
				// position the start for new character
				start++;
				end++;
			} else {
				hset.add(cChar);
				end++;
				currlen = end - start;
				if ( currlen > maxlen) {
					maxlen = currlen;
					maxst = start;
					maxnd = end;
				}
			}
		}
		System.out.print("MAx start is " + maxst);
		System.out.println(":MAx   end is " + maxnd);
		String rtn = s.substring(maxst, maxnd);
		return (rtn);
	}
	public static void main(String[] args) {
		/*
		 * long..("abcdefab") = "abcdef"
		 * long...("ababc") = "abc"
		 * long...("ababefgh") = "abefgh"
		 * long...("abcdfgab") = "cdfgab"
		 * long...("abcdefacyxz") = "defacyxz"
		 * long...("abcdefcyxz") = "defcyxz"
		 */
		String str ;
		str = "abcdefab";
		System.out.println(str + " Longest Sub uniq String " + longestUniqSub(str));
		str = "ababc";
		System.out.println(str + " Longest Sub uniq String " + longestUniqSub(str));
		str = "ababefgh";
		System.out.println(str + " Longest Sub uniq String " + longestUniqSub(str));
		str = "abcdfgab";
		System.out.println(str + " Longest Sub uniq String " + longestUniqSub(str));
		str = "abcdefabyxz";
		System.out.println(str + " Longest Sub uniq String " + longestUniqSub(str));
		str = "abcdefacyxz";
		System.out.println(str + " Longest Sub uniq String " + longestUniqSub(str));	
		str = "abcdefcyxz";
		System.out.println(str + " Longest Sub uniq String " + longestUniqSub(str));
	}

}
