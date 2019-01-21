package com.venkat.leetfree;

import java.util.HashSet;
import java.util.Set;

public class NextTime {
	int MIN_TIM = 0;
	int MAX_TIM = 23*60 + 59;
	String curTime;
	Set<Character> valDigs;
	public NextTime(String curTime) {
		this.curTime = curTime;
		valDigs = new HashSet<Character>();
		for(int i = 0 ; i < curTime.length() ; i++) {
			if (curTime.charAt(i) != ':') {
				valDigs.add(curTime.charAt(i));
			}
		}
	}
	private boolean isValid(char c) {
		if (valDigs.contains(c))
			return (true);
		else
			return (false);
	}
	private boolean isValid(String st) {
		for(int i = 0 ; i < st.length(); i++) {
			if (st.charAt(i) != ':') {
				if (!isValid(st.charAt(i))) {
					return (false);
				}
			}
		}
		return (true);
	}
	public String nextTime() {
		int tim = getTimFromStr(this.curTime);
		for(int t = tim + 1; t < tim + 24*60; t++){
			int nt = t % (24*60);
			String st = getStrFromTime(nt);
			if (isValid(st)) {
				return st;
			}
		}
		return "";
	}
	private int getTimFromStr(String str) {
		String toks[] = str.split(":");
		int hr = Integer.parseInt(toks[0]);
		int mn = Integer.parseInt(toks[1]);
		int ret = 60*hr + mn;
		return (ret);
	}
	private String getStrFromTime(int tim) {
		int hr = tim / 60;
		int mn = tim % 60;
		String retStr = "" +  String.format("%02d", hr) + ":" + String.format("%02d", mn);
		return (retStr);
	}
	public static void main(String[] args) {
		NextTime nt1 = new NextTime("14:59");
		System.out.println("Next time is " + nt1.nextTime());

	}
}
