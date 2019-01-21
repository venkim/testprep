package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;


/*
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges 
 * (each edge is a pair of nodes), write a function to check 
 * whether these edges make up a valid tree.
 * For example:
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * Note: you can assume that no duplicate edges will appear in edges. 
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class GraphValidTree {
	int n;
	Map<Integer,List<Integer>> adjMat;
	public GraphValidTree(int n, int [][] edges) {
		this.n = n;
		this.adjMat = new HashMap<>();
		for(int[] edge:edges) {
			adjMat.putIfAbsent(edge[0],new ArrayList<Integer>());
			adjMat.get(edge[0]).add(edge[1]);
			
			adjMat.putIfAbsent(edge[1], new ArrayList<Integer>());
			adjMat.get(edge[1]).add(edge[0]);
		}
	}
	public boolean validTreeDFS() {
		boolean[] visited = new boolean[n];
		if (!dfsHelper(0,-1,visited)) 
			return (false);
		
		for(boolean boo : visited)
			if (!boo)
				return (false);
		return (true);
	}
	private boolean dfsHelper(int curr, int parent,boolean[] visited) {
		if (visited[curr])
			return (false);
		if (!visited[curr])
			visited[curr] = true;
		
		for(Integer x: adjMat.get(curr)) {
			if ( x != parent && !dfsHelper(x,curr,visited))
				return (false);
		}
		return (true);
	}
	private boolean bfsHelper() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(0);
		boolean[] visited = new boolean[n];
		
		while (!q.isEmpty()) {
			Integer curr = q.poll();
			if (visited[curr])
				return false;
			visited[curr] = true;
			for(Integer adjv : adjMat.get(curr)) {
				if (!visited[adjv])
					q.offer(adjv);
			}
		}
		
		for(boolean bvis:visited)
			if (!bvis)
				return (false);
		
		return(true);
	}
	public static void main(String[] args) {
		int n = 5;
		int[][] edges1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
		GraphValidTree gvt1 = new GraphValidTree(n,edges1);
		System.out.println("Graph of validi tree 1 .." + gvt1.validTreeDFS());
		System.out.println("Graph of validi tree bfs .." + gvt1.bfsHelper());
		
		int[][] edges2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		GraphValidTree gvt2 = new GraphValidTree(n,edges2);
		System.out.println("Graph of validi tree 2 .." + gvt2.validTreeDFS());
		System.out.println("Graph of validi tree 2 bfs.." + gvt2.bfsHelper());
	}

}
