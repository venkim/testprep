package com.venkat.leetfree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WaGates2 {
	public static final int INF = 2147483647;
	int[][] maze;
	int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
	Queue<String> q;
	Set<String> visited;
	public WaGates2(int[][] maze) {
		this.maze = maze;
		this.m = maze.length;
		this.n = maze[0].length;
		q = new LinkedList<String>();
		visited = new HashSet<>();
		bfs();
	}
	int m, n;
	
	public void bfs() {
		for(int i = 0 ; i < m ; i++) {
			for(int j = 0 ;j < n;j++) {
				if (maze[i][j] == 0) {
					q.offer(i+"$"+j);
					visited.add(i+"$"+j);
				}
			}
		}
		
		while(!q.isEmpty()) {
			String elem = q.poll();
			String[] toks = elem.split("\\$");
			int row = Integer.parseInt(toks[0]);
			int col = Integer.parseInt(toks[1]);
			int dis = maze[row][col];
			
			for(int[] dir: dirs) {
				int nr = row + dir[0];
				int nc = col + dir[1];
				if (isValid(nr,nc) && 
						!visited.contains(nr+"$"+nc) &&
						maze[nr][nc] != -1 &&
						maze[nr][nc] != 0) {
					maze[nr][nc] = dis+1;
					q.offer(nr+"$"+nc);
					visited.add(nr+"$"+nc);
				}
			}
		}
	}
	private boolean isValid(int x,int y) {
		if (x >= 0 && x < maze.length &&
				y >= 0 && y < maze[0].length)
			return (true);
		return (false);
	}
	public void display() {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze[0].length; j++) {
				System.out.print(", " + maze[i][j]);
			}
			System.out.println("");
		}
		System.out.println("");
	}
	
	public static void main(String[] args) {
		int[][] maze = {
				{INF,  -1,  0, INF},
				{INF, INF, INF,  -1},
				{INF,  -1, INF,  -1},
				{  0,  -1, INF, INF}
			};
		WaGates2 wg2 = new WaGates2(maze);
		wg2.display();
	}

}
