package com.venkat.leetfree;

public class ContestMatch {
	int n;
	public ContestMatch(int n) {
		this.n= n;
	}
	public String findContestMatch() {
		String[] team = new String[n];
		for(int i = 0 ; i < n; i++) {
			team[i] = "" + i;
		}
		
		for( ; n > 1; n /= 2) {
			for(int i = 0; i < n/2; i++) {
				team[i] = "(" + team[i] + "," + team[n-1-i] + ")";
			}
		}
		return (team[0]);
	}
	public static void main(String[] args) {
		ContestMatch cm1 = new ContestMatch(8);
		System.out.println("contest..." + cm1.findContestMatch());
	
		ContestMatch cm2 = new ContestMatch(32);
		System.out.println("contest..." + cm2.findContestMatch());
		
	}


}
