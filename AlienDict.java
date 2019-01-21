package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class AlienDict {

	public AlienDict() {
	}
	public static String alienOrder(String[] words) {
		if (words == null || words.length == 0)
			return "";
			
		// Build a graph, and indegree map
		Map<Character,List<Character>> adjList = new HashMap<>();
		Map<Character, Integer> inDegree = new HashMap<>();
			
		buildGraph(adjList,inDegree,words);
			
		return topoSort(adjList,inDegree);
	}
	private static void buildGraph(Map<Character,List<Character>> adjList, Map<Character,Integer> inDegree,String[] words) {
		for(String word:words) {
			for(char c: word.toCharArray()) {
				adjList.putIfAbsent(c, new ArrayList<>());
				inDegree.putIfAbsent(c,0);
			}
		}
			
		for(int i = 0; i < words.length-1; i++) {
			int index = 0;
			while(index < words[i].length() && index < words[i+1].length() ) {
				char c1 = words[i].charAt(index);
				char c2 = words[i+1].charAt(index);
				if (c1 != c2) {
					adjList.get(c1).add(c2);
					inDegree.put(c2, inDegree.get(c2)+1);
					break;
				}
				index++;
			}
		}
			
	}
	private static String topoSort(Map<Character,List<Character>> adjList, Map<Character,Integer> inDegree) {
		Queue<Character> q = new LinkedList<Character>();
		for(char c : inDegree.keySet()) {
			if (inDegree.get(c) == 0)
				q.offer(c);
		}
		
		StringBuffer sb = new StringBuffer();
		while (!q.isEmpty()) {
			char c = q.poll();
			sb.append(c);
			for(char edgeNode: adjList.get(c) ) {
				inDegree.put( edgeNode, inDegree.get(edgeNode)-1);
				if (inDegree.get(edgeNode) == 0) 
					q.offer(edgeNode);
			}
			
		}
		
		if (sb.length() != adjList.size())
			return "";
		
		return (sb.toString());
	}
	public static void main(String[] args) {
		String[] words = { "wrt","wrf","er","ett","rftt"};
		System.out.println("Alien order -- " + alienOrder(words));
	}
}
