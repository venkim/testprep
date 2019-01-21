package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * Given a string s, return all the palindromic permutations (without duplicates) of it. 
 * Return an empty list if no palindromic permutation could be form.
 * For example:
 * Given s = "aabb", return ["abba", "baab"].
 * Given s = "abc", return [].
 */
public class PrintAllPallins {
	public static final int ALPHA = 26;	// assume only lowercase 26 chars 
	public PrintAllPallins() {
		// TODO Auto-generated constructor stub
	}
	public static boolean isPalin(String str, int[] freq) {

		int numOdds = 0, numEvens = 0;
		for(int j = 0; j  < freq.length; j++) {
			if (freq[j] % 2 == 1)
				numOdds++;
			else
				numEvens++;
		}
		if (numOdds > 1)
			return (false);
		return (true);
	}
	public static List<String> allPalins(String str){
		int[] freq = new int[ALPHA];
		for(int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			freq[ch-'a']++;
		}		
		
		List<String> rslt = new ArrayList<String>();
		if (!isPalin(str,freq))
			return rslt;
		
		int len = str.length();
		StringBuilder half = new StringBuilder();
		char oddc = 0;
		for(int i = 0; i < ALPHA;i++) {
			// handle the one lone odd character - 
			// just save it for later
			if (freq[i] % 2 == 1)
				oddc = (char)('a'+i);
			
			StringBuilder t = new StringBuilder();
			for(int j = 0 ; j < freq[i]/2;j++)
				t.append((char)(i+'a'));
			half.append(t);
		}
		List<String> halfPerms = permuts(half.toString());
//		System.out.println("halfPerms list is : " + halfPerms);
		Set<String> temp = new HashSet<String>();
		for(String x : halfPerms) {
			StringBuilder sb = new StringBuilder();
			sb.append(x);
			if (len % 2 == 1) {
				sb.append(oddc);
			} 
//			System.out.println("orig = " + half + " half reverse..." + revStr(half.toString()));
			sb.append( revStr(x) );
			temp.add(sb.toString());
		}
		rslt = new ArrayList<>(temp);
		return (rslt);
	}
	public static String revStr(String x) {
		if (x == null || x.length() == 0 || x.length() == 1)
			return x;
		int len = x.length();
		StringBuilder sb = new StringBuilder();
		for(int i = len-1;i >= 0;i--) {
			sb.append(x.charAt(i));
		}
		return (sb.toString());
	}
	public static List<String> permuts(String s){
		List<String> perms = new ArrayList<String>();
		permutHelp(s, "", perms);
		return (perms);
	}
	public static void permutHelp(String s, String prefix, List<String> perms) {
		if (s.length() == 0) {
			perms.add(prefix);
		} else {
			for(int i = 0 ; i < s.length(); i++) {
				String rem = s.substring(0, i) + s.substring(i+1);
				String newPfx = prefix + s.charAt(i);
				permutHelp(rem, newPfx, perms);
			}
		}
	}
	public static void main(String[] args) {
		List<String> lst = allPalins("aabb");
		System.out.println("Lst is " + lst);
		
		lst = allPalins("abc");
		System.out.println("Lst is " + lst);
		
		lst = allPalins("malayalam");
		System.out.println("Lst is " + lst);

	}

	public static List<String> permutA(String s){
		List<String> rslt = new ArrayList<String>();
		permutHelpA(s, "", rslt);
		return (rslt);
	}
	public static void permutHelpA(String s, String prefix,List<String> rslt) {
		if (s.length() == 0) {
			rslt.add(prefix);
		} else {
			for(int i = 0 ; i < s.length(); i++) {
				String newPfx = prefix + s.charAt(i);
				String rem = s.substring(0, i) + s.substring(i+1);
				permutHelpA(rem, newPfx, rslt);
			}
		}
	}
}
