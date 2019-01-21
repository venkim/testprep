package com.venkat.leetfree;

import java.util.HashSet;
import java.util.Set;
/*
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

* Example:

* Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
* Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).

* 0 0 0
* 0 0 0
* 0 0 0
* Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.

* 1 0 0
* 0 0 0   Number of islands = 1
* 0 0 0
* Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.

* 1 1 0
* 0 0 0   Number of islands = 1
* 0 0 0
* Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.

* 1 1 0
* 0 0 1   Number of islands = 2
* 0 0 0
* Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.

* 1 1 0
* 0 0 1   Number of islands = 3
* 0 1 0
*
* Operation #5 : addLand(1,1) turns the water at grid[1][1] into a land
* 
* 1 1 0
* 0 1 1	  Number of islands = 1
* 0 1 0
* We return the result as an array [1,1,2,3,1]
* Challenge:

* Can you do it in time complexity O(k log mn), where k is the length of the positions?
 */
public class NumberIsland2_1 {
	public static int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };
	int[][] grid;
	int[] parent;
	boolean[] visited;
	int m;	// number of  rows
	int n; // number of columns
	
	int numElems = 0;
	int rslt[];
	
	int[][] positions;
	public NumberIsland2_1(int m,int n,int[][] positions) {
		this.m = m;
		this.n= n;
		this.positions = positions;
		
		grid = new int[m][n];
		
		this.numElems = m * n;
		parent = new int[numElems];
		visited = new boolean[numElems];
		rslt = new int[positions.length];

		for(int i = 0 ; i < numElems; i++) {
			parent[i] = -1;
			visited[i] = false;
		}
		for(int i = 0; i < positions.length; i++) {
			int[] pos = positions[i];
			// mark this position on the grid.
			grid[pos[0]][pos[1]] = 1;
			
			int curNode = pos[0]*m + pos[1];
			parent[curNode] = curNode;
			
			for(int[] dir: dirs) {
				int arx = pos[0] + dir[0];
				int ary = pos[1] + dir[1];
				
				if (isValid(arx,ary) && grid[arx][ary] == 1) {
					conn(curNode, arx*m+ary);
				}
			}
			int nisles = getNumIslands();
			rslt[i] = nisles;
		}
	}
	private int getNumIslands() {
		Set<Integer> unq = new HashSet<Integer>();
		for(int i = 0 ; i < numElems; i++) {
			if (parent[i] != -1) {
				int par = getPar(parent[i]);
				unq.add(par);
			}
		}
		return unq.size();
	}
	private void conn(int u, int v) {
		int upar = getPar(u);
		int vpar = getPar(v);
		if (upar != vpar) {
			parent[upar] = vpar;
		}
	}
	private int getPar(int u) {
		while (u != parent[u])
			u = parent[u];
		return (u);
	}
	private boolean isValid(int u,int v) {
		if (u < 0 || u >= m || v < 0 || v >= n)
			return (false);
		return (true);
	}
	
	
	public static void main(String[] args) {
		int m = 3,n = 3;
		int[][] positions =  {{0,0}, {0,1}, {1,2}, {2,1},{1,1}};

		NumberIsland2_1 nis = new NumberIsland2_1(m, n,  positions);
		for (int i = 0 ; i < nis.rslt.length; i++) {
			System.out.println("Rslt elements are " + nis.rslt[i]);
		}
	}

}
