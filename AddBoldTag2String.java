package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 ** Example 1:
 ** Input: 
 ** s = "abcxyz123"
 ** dict = ["abc","123"]
 ** Output:
 ** "<b>abc</b>xyz<b>123</b>"
 ** Example 2:
 ** Input: 
 ** s = "aaabbcc"
 ** dict = ["aaa","aab","bc"]
 ** Output:
 ** "<b>aaabbc</b>c"
 ** Note:
 ** The given dict won't contain duplicates, and its length won't exceed 100.
 ** All the strings in input have length in range [1, 1000].
 */
public class AddBoldTag2String {

	String s;
	String[] dict;
	String rslt;
	public AddBoldTag2String(String s, String[] dict){
		this.s = s;
		this.dict = dict;
		
		List<int[]> ilist = new ArrayList<>();
		int slen = s.length();
		
		for(String wd: dict) {
			int wlen = wd.length();
			for(int i = 0; i <= slen - wlen;i++) {
				if (s.substring(i, i+wlen).equals(wd)) {
					ilist.add(new int[] {i,i+wlen-1});
				}
			}
		}
		if (ilist.size() == 0) {
			this.rslt = s; 
			return ;
		}
		// sort the intervals
		Collections.sort(ilist,(a,b)->(a[0] == b[0] ? (a[1]-b[1]) : (a[0]-b[0]) ));
		for(int[] mem: ilist) {
			System.out.println("positions " + mem[0] + "$" + mem[1]);
		}
		// merge the intervals and suitably bold
		int start = 0, prev = 0, endpos = 0;
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < ilist.size()) {
			sb.append(s.substring(prev,ilist.get(i)[0]));
			System.out.println(" sb is " + sb);
			start = i;
			endpos = ilist.get(i)[1];
			int cur = i+1;
			while (cur < ilist.size() && ilist.get(cur)[1] <= endpos) {
				endpos = Math.max(endpos, ilist.get(cur)[1]);
				cur++;
			}
			sb.append("<b>" + s.substring(ilist.get(start)[0],endpos+1) + "</b>");
			prev = endpos+1;
			i = cur;
		}
		System.out.println(" sb is " + sb);
		sb.append( s.substring(endpos+1,s.length()));
		System.out.println(" sb is " + sb);
		this.rslt = sb.toString();
	}
	String getBoldedString() {
		return (this.rslt);
	}

	public static void main(String[] args) {
		String s = "abcxyz123";
		String dict[] = {"abc","123"};
		AddBoldTag2String abts = new AddBoldTag2String(s,dict);
		
		System.out.println("Result string is " + abts.getBoldedString());

	}

}
