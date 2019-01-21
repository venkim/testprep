package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Map.Entry;

public class GetInTopoSort {
	Map<Integer,List<Integer>> adjList;
	Map<Integer,Integer> inDegree;
	public GetInTopoSort(Map<Integer,List<Integer>> in) {
		this.adjList = in;
		inDegree = new HashMap<Integer,Integer>();
		for(Integer key : adjList.keySet()) {
			inDegree.putIfAbsent(key, 0);
			List<Integer> vertList = adjList.get(key);
			for(int vert : vertList) {
				inDegree.put(vert, 1+inDegree.getOrDefault(vert,0));
			}
		}
		System.out.println("adjList size " + adjList.size());
		System.out.println("inDegree size " + inDegree.size());
		for(Map.Entry<Integer, Integer> ent: inDegree.entrySet()) {
			System.out.println("entry is " + ent);
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int vert : inDegree.keySet()) {
			if (inDegree.get(vert) == 0) {
				q.offer(vert);
			}
		}
		
		StringBuffer sb = new StringBuffer();
		while (!q.isEmpty()) {
			int curVert = q.poll();
			System.out.println("current ver is " + curVert);
			sb.append(curVert);
			if (!adjList.containsKey(curVert))
				continue;
			for(int v : adjList.get(curVert)) {
				inDegree.put(v, inDegree.get(v)-1);
				if (inDegree.get(v) == 0) {
					q.offer(v);
				}
			}
		}
		
		System.out.println("sb is " + sb);
		
	}


	public static void main(String[] args) {
		Map<Integer,List<Integer>> adjList;
		adjList = new HashMap<>();
		adjList.put(0, Arrays.asList(1,2));
		adjList.put(1, Arrays.asList(3));
		adjList.put(2, Arrays.asList(4));
		adjList.put(3, Arrays.asList(5,6,8));
		adjList.put(4, Arrays.asList(5,6));
		adjList.put(5, Arrays.asList(7));
		adjList.put(6, Arrays.asList(7));

		GetInTopoSort gts = new GetInTopoSort(adjList);
	}

}
