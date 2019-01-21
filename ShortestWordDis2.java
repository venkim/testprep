package com.venkat.leetfree;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ShortestWordDis2 {
	Map<String,Queue<Integer>> wordPos;
	String[] words;
	public ShortestWordDis2(String[] words) {
		this.words = words;
		wordPos = new HashMap<>();
		for(int i = 0 ; i < words.length;i++) {
			wordPos.putIfAbsent(words[i],new PriorityQueue<Integer>());
			wordPos.get(words[i]).offer(i);
		}
	}
	public int shortestDis(String word1, String word2) {
		Queue<Integer> pq1 = wordPos.get(word1);
		Queue<Integer> pq2 = wordPos.get(word2);
		
		Iterator<Integer> itr1 = pq1.iterator();
		Iterator<Integer> itr2 = pq2.iterator();
		
		int mindis = Integer.MAX_VALUE;
		int pos1 = 0, pos2 = 0;
		while (itr1.hasNext() || itr2.hasNext()){ 
			if (itr1.hasNext())
				pos1 = itr1.next();
			if (itr2.hasNext())
				pos2 = itr2.next();
			mindis = Math.min(mindis, Math.abs(pos1-pos2));
		}
		return (mindis);
	}
	public static void main(String[] args) {
		String[] words = {"practice", "makes", "perfect", "coding", "makes"};
		ShortestWordDis2 sd2 = new ShortestWordDis2(words);
		System.out.println("Print distance " + sd2.shortestDis("coding", "practice"));
		System.out.println("Print distance " + sd2.shortestDis("coding", "makes"));

	}

}
