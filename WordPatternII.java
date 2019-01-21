package com.venkat.leetfree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.
 * Examples: 
 *  pattern = "abab", str = "redblueredblue" should return true. 
 *  pattern = "aaaa", str = "asdasdasdasd" should return true. 
 *  pattern = "aabb", str = "xyzabcxzyabc" should return false.
 * Notes:
 * You may assume both pattern and str contains only lowercase letters.
 * 
 * backtracking is a strategy...
 */
public class WordPatternII {

	Map<Character,String> pmap;
	Set<String> hset;
	public WordPatternII() {

		
		hset = new HashSet();
		pmap = new HashMap();
		
	}
	public boolean wordPatMatch(String pat, String str) {
		if (pat.isEmpty() && str.isEmpty())
			return(true);
		
		if (pmap.containsKey(pat.charAt(0))) {
			String val = pmap.get(pat.charAt(0));
			if (str.length() < val.length())
				return (false);
			int vallen = val.length();
			if (!str.substring(0,vallen).equals(val))
				return (false);
			if (wordPatMatch(pat.substring(1),str.substring(vallen)))
				return (true);
		} else {
			// use backtracking - trying different lengths
			for(int i = 1; i <= str.length() ; i++) {
				if (hset.contains(str.substring(0,i))) continue;
				pmap.put(pat.charAt(0),str.substring(0,i));
				hset.add(str.substring(0,i));
				if (wordPatMatch(pat.substring(1), str.substring(i)))
					return (true);
				hset.remove(str.substring(0,i));
				pmap.remove(pat.charAt(0));
			}
		}
		return (false);
	}

	public static void main(String[] args) {
		WordPatternII wp2 = new WordPatternII();
		System.out.println("Word pat match " + wp2.wordPatMatch("abab","redblueredblue"));
		
		wp2 = new WordPatternII();
		System.out.println("Word pat match " + wp2.wordPatMatch("aabb","redrxdblueblue"));
	}
}
