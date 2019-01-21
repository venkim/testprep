package com.venkat.leetfree;

public class Celebrity {
	int[][] m;
	int n;
	public Celebrity(int[][] m) {
		this.m = m;
		this.n= m.length;
	}
	public boolean knows(int u, int v) {
		if (m[u][v] == 1)
			return true;
		return (false);
	}
	public int findCelebrity() {
		int[] indegree = new int[m.length];
		int[] outdegree = new int[m.length];
		
		for(int i = 0 ;i < n ; i++) {
			for(int j = 0 ; j < n; j++) {
				if (i != j &&knows(i,j)) {
					outdegree[i]++;
					indegree[j]++;
				}
			}
		}
		for(int i = 0 ; i < n ; i++) {
			if (indegree[i] == n-1 && outdegree[i] == 0) {
				return i;
			}
		}
		return (-1);
	}
	public int findCelebrity2() {
		int l = 0, r = n-1;
		while (l < r) {
			if (knows(l,r)) {
				l++;
			} else {
				r--;
			}
		}
		int cand = l;
		for(int i = 0 ; i < n ; i++) {
			if (cand != i) { 
				if ( knows(cand,i ) || !knows(i,cand) ) {
					return -1;
				}
			}
		}
		return (cand);
	}
	public static void main(String[] args) {
		int[][] m = { 
				{0,1,1},
				{0,0,0},
				{0,1,0}
			};
		Celebrity cl = new Celebrity(m);
		System.out.println("Is there a celebrity ? " + cl.findCelebrity());
		System.out.println("Is there a celebrity 2 ? " + cl.findCelebrity2());
	}

}
