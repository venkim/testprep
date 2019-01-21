package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class AlienDictOld {
	static class Graph {
		int num;
		ArrayList<Integer>[] adjList;
		boolean[] visited;
		Stack<Integer> stk;
		int[] rslt;
		boolean topolSortable;
		Graph(int num){
			this.num = num;
			visited = new boolean[this.num];
			stk = new Stack<Integer>();
			System.out.println("alpha size is " + this.num);
			adjList = (ArrayList<Integer>[])new ArrayList[num];
			for(int i = 0 ; i < num;i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			this.rslt = new int[num];
		}
		public void addEdge(int u, int v) {
			System.out.println("u is " + u);
			System.out.println("v is " + v);
			adjList[u].add(v);
		}
		public void topolSort() {
			for(int i = 0 ; i < num; i++) {
				if (!visited[i]) {
					topolUtil(i);
				}
			}
			if (stk.isEmpty() || stk.size() != this.num) {
				topolSortable = false;
			} else {
				topolSortable = true;
			}
			int idx = 0;
			while (!stk.isEmpty()) {
				rslt[idx] = stk.pop();
			}
		}
		public void topolUtil(int i) {
			visited[i] = true;
			for(Integer adjNode : adjList[i]) {
				if (!visited[adjNode]) {
					topolUtil(adjNode);
				}
			}
			stk.push(i); 
		}
		public void printTopol() {
			for(int i = 0 ; i < rslt.length; i++) {
				System.out.print("" + rslt[i] + ",");
			}
			System.out.println();
		}
		
	}
	String[] words;
	char[] alienAlpha;
	Map<Character,Integer> cmap;
	int num;
	public AlienDictOld(String[] words) {
		this.words = words;
		Set<Character> alpha = new TreeSet<Character>();
		for(String word: words) {
			for(int i = 0 ; i < word.length(); i++) {
				alpha.add(word.charAt(i));
			}
		}
		this.num = alpha.size();
		alienAlpha = new char[this.num];
		cmap = new HashMap<Character,Integer>();
		Iterator<Character> itr = alpha.iterator();
		int idx1 = 0;
		while (itr.hasNext()) {
			char cchr = itr.next();
			alienAlpha[idx1] = cchr;
			cmap.put(cchr, idx1);
			idx1++;
		}
		
		doOrder();
	}
	private void doOrder() {
		Graph graph = new Graph(this.num);
		for(int i = 0 ; i < words.length-1;i++) {
			String word1 = words[i];
			String word2 = words[i+1];
			System.out.println("i is " + i );
			System.out.println("Word 1 = " + word1 + "word 2 = " + word2);
			int indx = 0;
			int minlen = Math.min(word1.length(), word2.length());
			System.out.println("minlen = " + minlen);
			while (indx < minlen &&
				   word1.charAt(indx) == word2.charAt(indx)) 
				indx++;
			if (indx < minlen){
				graph.addEdge(cmap.get(word1.charAt(indx)), cmap.get(word2.charAt(indx)));
			}
			System.out.println("indx = " + indx);
		}
		graph.topolSort();
		graph.printTopol();
	}


	public static void main(String[] args) {
		String[] words = {"wrt", "wrf","er","ett","rftt"};
		AlienDictOld adict = new AlienDictOld(words);
		
	}

}
