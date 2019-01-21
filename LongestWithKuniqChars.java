package com.venkat.leetfree;
/*
 * Given a string you need to print longest possible substring that has 
 * exactly M unique characters. If there are more than one 
 * substring of longest possible length, then print any one of them.
 */
public class LongestWithKuniqChars {
	public final int MAX_CHARS = 26;
	String instr;
	int k;
	String output ;
	public LongestWithKuniqChars(String str, int k) {
		this.instr = str;
		this.k = k;
		this.output = "";
		kUniques();
	}
	private boolean isValid(int[] cnt,int k) {
		int lcnt = 0;
		for(int i = 0; i < cnt.length ;i++) {
			if (cnt[i] > 0)
				lcnt++;
		}
		System.out.println("lcnt is " + lcnt + "k is " + k);
		if (lcnt <= k)
			return (true);
		return (false);
	}
	private void kUniques() {
		int u = 0;
		int n = instr.length();
		
		int[] cnt = new int[MAX_CHARS];
		for(int i = 0; i < n ;i++) {
			if (cnt[instr.charAt(i)-'a'] == 0)
				u++;
			cnt[instr.charAt(i)-'a']++;
		}
		if (u < k) {
			output = "";
			return ;
		}
		// reset cnt ...
		cnt = new int[MAX_CHARS];
		int curr_start = 0;
		int curr_end = 0;
		int max_window_start = 0, max_window_size = 1;
		cnt[instr.charAt(0)-'a']++;
		for(int i = 1 ; i < n; i++) {
			System.out.println("curr_start curr_end " + curr_start + "$" + curr_end);
			cnt[instr.charAt(i)-'a']++;
			curr_end++;
			
			while (!isValid(cnt,k)) {
				System.out.println("inside while...");
				cnt[instr.charAt(curr_start) -'a']--;
				curr_start++;
			}
			System.out.println("curr_start curr_end " + curr_start + "$" + curr_end);
			if (curr_end - curr_start +1 > max_window_size) {
				max_window_size = curr_end-curr_start+1;
				max_window_start = curr_start;
						
			}
		}
		this.output = instr.substring(max_window_start,max_window_size); 
	}
	public String getOut() {
		return this.output;
	}
	public static void main(String[] args) {
		LongestWithKuniqChars lc = new LongestWithKuniqChars("aabbcc",2);
		System.out.println("out " + lc.getOut());
		
		lc = new LongestWithKuniqChars("aabbaaaacc",2);
		System.out.println("out " + lc.getOut());

	}
}
