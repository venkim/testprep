package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDict1 {
	String[] words;
	Map<Character,List<Character>> adjList;
	Map<Character,Integer> inDegree;
	public AlienDict1(String[] words) {
		this.words = words;
		adjList = new HashMap<>();
		inDegree = new HashMap<>();
		buildGraph();
	}
	private void buildGraph() {
		// initialize adjacency list
		for(int i = 0; i < words.length; i++) {
			char[] chary = words[i].toCharArray();
			for(int j = 0; j < chary.length;j++) {
				char ch = chary[j];
				adjList.putIfAbsent(ch, new ArrayList<Character>());
			}
		}
		
		// fill out adj list and inDegree...
		for(int i = 0 ; i < words.length -1; i++) {
			String word = words[i];
			int index = 0;
			for(index = 0; index < word.length(); index++) {
				if (index < word.length() && index < words[i+1].length()) {
					char ch1 = word.charAt(index);
					char ch2 = words[i+1].charAt(index);
					if (ch1 != ch2) {
						adjList.get(ch1).add(ch2);
						inDegree.putIfAbsent(ch2,1+inDegree.get(ch2));
					}
				}
			}
		}
	}
	public String alienOrder(String[] words) {
		// Use a Queue and do Topol sort 
		Queue<Character> q = new LinkedList<>();
		for(Character ch: inDegree.keySet()) {
			if (inDegree.get(ch) == 0) {
				q.offer(ch);
			}
		}
		
		// build a string buffer ..
		StringBuffer sb = new StringBuffer();
		while(!q.isEmpty()) {
			char ch = q.poll();
			sb.append(ch);
			for(char curch:adjList.get(ch)) {
				inDegree.put(curch, inDegree.get(curch)-1);
				if (inDegree.get(curch) == 0) {
					q.offer(curch);
				}
			}
		}
		
		if (sb.length() == 0)
			return "";
		return (sb.toString());
	}
	public static void main(String[] args) {
		String[] words = { "wrt","wrf","er","ett","rftt"};
		AlienDict1 ad1 = new AlienDict1(words);
		System.out.println("Alien order -- " + ad1.alienOrder(words));

	}

}
