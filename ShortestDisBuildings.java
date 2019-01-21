package com.venkat.leetfree;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDisBuildings {
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	
	int[][] grid;
	int ans;
	int[] ansPoint;
	
	int m,n;
	int[][] reachable;
	int[][] distance;
	
	public ShortestDisBuildings(int[][] grid) {
		this.grid = grid;
		if (grid.length == 0) {
			return ;
		}
		this.m = grid.length;
		this.n = grid[0].length;
		
		System.out.println("Inside and m and n are " + m + "$" + n);
		ansPoint = new int[2];
		for(int i = 0 ; i < ansPoint.length;i++) {
			ansPoint[i] = -1;
		}
		reachable = new int[m][n];
		distance = new int[m][n];
		sdUtil();
	}
	private void sdUtil() {
		int nBldgs = 0;
		System.out.println("sdUtil -- nBldgs is " + nBldgs);
		for(int ri = 0 ; ri < m; ri++) {
			for(int cj = 0 ; cj < n; cj++) {
				if (grid[ri][cj] == 1) {
					System.out.println("ri and cj " + ri + "$" + cj);
					nBldgs++;
					boolean[][] visited = new boolean[m][n];
					Queue<int[]> q = new LinkedList<int[]>();
					q.offer( new int[] {ri,cj} );
					int dist = 0;
					while (!q.isEmpty()) {
						int sz = q.size();
						System.out.println("sz of q is " + sz);
						for(int i = 0; i < sz; i++) {
							int[] node = q.poll();
							int x = node[0];
							int y = node[1];
							distance[x][y] = dist;
							reachable[x][y]++;
							for(int[] dir: dirs) {
								int mx = x + dir[0];
								int my = y + dir[1];
								if (mx < 0 || mx >= m || my < 0 || my >= n ) {
									continue;
								}
								if (grid[mx][my] == 0 && !visited[mx][my]) {
									q.offer(new int[] {mx,my});
									visited[mx][my] = true;
								}
							}
						}
						dist++;
					}
				}
			}
		}
		
		int rslt = Integer.MAX_VALUE;
		for(int r = 0; r < m; r++) {
			for(int c = 0; c < n; c++) {
				if (grid[r][c] == 0 && 
					reachable[r][c] == nBldgs &&
					distance[r][c] < rslt) {
					System.out.println("R and C are " + r + "$" + c);
					rslt = distance[r][c];
					this.ansPoint[0] = r;
					this.ansPoint[1] = c;
				}
			}
		}
		if (rslt == Integer.MAX_VALUE)
			this.ans = -1;
		else
			this.ans = rslt;
	}
	public int[] getPoint() {
		return ansPoint;
	}

	public static void main(String[] args) {
		int[][] grid = {
				{1 , 0 , 2 , 0 , 1},
				{0 , 0 , 0 , 0 , 0},
				{0 , 0 , 1 , 0 , 0}
			};
		
		ShortestDisBuildings sdb = new ShortestDisBuildings(grid);
		
		int[] pt = sdb.getPoint();
		System.out.print("(");
		for(int i = 0; i < pt.length; i++) {
			System.out.print(" " + pt[i] + ",");
		}
		System.out.println(")");
		
	}

}
