package com.venkat.leetfree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;

/*
 * Given two sentences words1, words2 (each represented as an array of strings), 
 * and a list of similar word pairs pairs, determine if two sentences are similar.

 * For example, words1 = ["great", "acting", "skills"] and words2 = ["fine", "drama", "talent"] 
 * are similar, if the similar word pairs are pairs = [["great", "good"], ["fine", "good"], 
 * ["acting","drama"], ["skills","talent"]].

 * Note that the similarity relation is transitive. For example, if "great" and "good" 
 * are similar, and "fine" and "good" are similar, 
 * then "great" and "fine" are similar.

 * Similarity is also symmetric. For example, "great" and "fine" being similar is the same 
 * as "fine" and "great" being similar.

 * Also, a word is always similar with itself. For example, the sentences 
 * words1 = ["great"], words2 = ["great"], pairs = [] are similar, even though there are no specified similar word pairs.

 * Finally, sentences can only be similar if they have the same number of 
 * words. So a sentence like words1 = ["great"] can never be similar to words2 = ["doubleplus","good"].

 *  Note:

   * The length of words1 and words2 will not exceed 1000.
   * The length of pairs will not exceed 2000.
   * The length of each pairs[i] will be 2.
   * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
 */
public class SentenceSimilarity {

	public SentenceSimilarity() {
		// TODO Auto-generated constructor stub
	}

	public static boolean areSentencesSimilar(String[] words1, String[] words2,String[][] pairs) {
		if (words1.length != words2.length)
			return (false);
		Map<String, List<String>> graph = new HashMap<String,List<String>>();
		for(String[] pair: pairs) {
			for(String p: pair) {
				if (graph.get(p) == null) {
					graph.put(p,new ArrayList<String>());
				}
			}
			
			graph.get(pair[0]).add(pair[1]);
			graph.get(pair[1]).add(pair[0]);
		}
		
		for(int i = 0 ; i < words1.length; i++) {
			String w1 = words1[i];
			String w2 = words2[i];
			
			Stack<String> stk = new Stack<>();
			Set<String> seen = new HashSet<>();
			
			stk.push(w1);
			seen.add(w1);
			
			search: {
				while( !stk.isEmpty()) {
					String word = stk.pop();
					if (word.equals(w2))
						break search;
					if (graph.containsKey(word)) {
						for(String nn: graph.get(word)) {
							if (!seen.contains(nn)) {
								stk.push(nn);
								seen.add(nn);
							}
						}
					}
				}
				return (false);
			}
		}
		return (true);
	}
	public static void main(String[] args) {
		String[] words1 = {"great", "acting", "skills"};
		String[] words2 = {"fine", "drama", "talent"};
		
		String[][] pairs = {
				{"great", "good"}, {"fine", "good"}, {"acting","drama"}, {"skills","talent"}		
		};

		boolean sim = areSentencesSimilar(words1, words2, pairs);
		System.out.println("Are sentences similar... ? " + sim);
	}

	public static boolean are SentencesSimilar1(String[] words1,String[] words2,String[][] pairs) {
		// trivial case
		if (words1 == null && words2 == null)
			return true;
		if (words1.length != words2.length)
			return false;
		
		// create a graph using the pairs
		Map<String, List<String>> graph = new HashMap<>();
		for(String[] pair: pairs) {
			String wd1 = pair[0];
			String wd2 = pair[1];
			graph.putIfAbsent(wd1, new ArrayList<String>());
			graph.putIfAbsent(wd2, new ArrayList<String>());
			
			graph.get(wd1).add(w2);
			graph.get(wd2).add(w1);
		}
		
		// Now use the graph to validate similarity
		int len = words1.length;
		for(int i = 0 ; i < len; i++) {
			String wd1 = words1[i];
			String wd2 = words2[i];
			
			// if simple equals -- done..
			if (wd1.equals(w2)) {
				continue;
			}
			// check if equivalent according to graph using DFS
			Stack<String> strStk = new Stack<String>();
			Set<String> visited = new HashSet<String>();
			
			strStk.push(wd1);
			visited.add(wd1);
			
			search : {
				while (!strStk.isEmpty()) {
					String curr = strStk.pop();
					if (curr.equals(w2))
						break search;
					for(String eqstr : graph.get(curr)) {
						if (eqstr.equals(wd2)){
							break search;
						}
						if (visited.add(eqstr)) {
							strStk.push(eqstr);
						}
					}
				}
				return (false);
			}
		}
		return (true);
	}
}
