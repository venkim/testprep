package com.venkat.leetfree;

import java.util.HashMap;
import java.util.Map;

public class SentSimilarity2 {
	static class DSU {
		int[] parent;
		public DSU(int n) {
			parent = new int[n];
			for(int i = 0 ; i < n ; i++) {
				parent[i] = i;
			}
		}
		public int find(int u) {
			while (parent[u] != u)
				u = parent[u];
			return (u);
		}
		public void union(int u, int v) {
			if (find(u) == find(v))
				return;
			int paru = parent[u];
			int parv = parent[v];
			parent[parv] = paru;
		}
	}
	public static boolean areSentencesSimilar2(String[] words1, String[] words2,
					String[][] pairs){
		if (words1.length != words2.length)
			return (false);
		
		Map<String,Integer> stoiMap = new HashMap<>();
		int count = 0;
		
		DSU dsu = new DSU(2*pairs.length);
		for(String[] pair: pairs) {
			for(String wd: pair) {
				if (stoiMap.get(wd) == null) {
					stoiMap.put(wd, count++);
				}
			}
			dsu.union(stoiMap.get(pair[0]), stoiMap.get(pair[1]));
		}
		
		for(int i = 0 ; i < words1.length; i++) {
			String wd1 = words1[i];
			String wd2 = words2[i];
			
			if (wd1.equals(wd2))
				continue;
			
			if (!stoiMap.containsKey(wd1) || !stoiMap.containsKey(wd2))
				return (false);
			
			int pw1 = dsu.find( stoiMap.get(wd1) );
			int pw2 = dsu.find( stoiMap.get(wd2) );
			
			if (pw1 != pw2)
				return (false);
			
		}
		return (true);
	} 
	public SentSimilarity2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};
		
		String[][] pairs = {
				{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}		
		};

		boolean sim = areSentencesSimilar2(words1, words2, pairs);
		System.out.println("Are sentences similar... ? " + sim);

	}

}
