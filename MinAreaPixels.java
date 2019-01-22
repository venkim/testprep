package com.venkat.leetfree;

import java.util.LinkedList;
import java.util.Queue;

/*
 ** An image is represented by a binary matrix with 0 as 
 ** a white pixel and 1 as a black pixel. The black pixels 
 ** are connected, i.e., there is only one black region. 
 ** Pixels are connected horizontally and vertically. Given 
 ** the location (x, y) of one of the black pixels, return 
 ** the area of the smallest (axis-aligned) rectangle 
 ** that encloses all black pixels.
 ** For example, given the following image:
 ** [
 **   "0010",
 **   "0110",
 **   "0100"
 ** ]
 ** and x = 0, y = 2,
 ** Return 6.
 */
public class MinAreaPixels {
	int[][] pixels;
	int m,n;
	int minArea;
	int top, bottom, left, right;
	public MinAreaPixels(int[][] pixels,int x, int y) {
		this.pixels = pixels;
		m = pixels.length;
		n = pixels[0].length;
		minArea = 0;
		top = y;
		bottom = y;
		left = x;
		right = x;
		boolean[][] visited = new boolean[m][n];
		// dfs(pixels,x,y,visited);
		bfs(pixels,x,y,visited);
		System.out.println("top and bottom are " + top + "$" + bottom );
		System.out.println("left and right are " + left + "$" + right );
		minArea = (bottom-top)*(right-left);
	}
	private void dfs(int[][] grid, int x, int y,boolean[][] visited) {
		if (x < 0 || x >= m || y < 0 || y >= n || 
				grid[x][y] == 0 || visited[x][y])
			return ;
		visited[x][y] = true;
		left = Math.min(left, x);
		right = Math.max(right,x+1);
		top = Math.min(top, y);
		bottom = Math.max(bottom, y+1);
		
		dfs(grid,x,y+1,visited);
		dfs(grid,x,y-1,visited);
		dfs(grid,x-1,y,visited);
		dfs(grid,x+1,y,visited);
	}
	public int getArea() {
		return minArea;
	}
	int[][] dirs = { {1,0},{-1,0},{0,1},{0,-1}};
	private void bfs(int[][] grid, int x, int y, boolean[][] visited) {
		Queue<int[]> q = new LinkedList<int[]>();
		
		q.offer(new int[]{x,y} );
		
		while (!q.isEmpty()) {
			int[] curr = q.poll();
			int u = curr[0];
			int v = curr[1];
			visited[u][v] = true;
			
			top = Math.min(top, v);
			bottom = Math.max(bottom, v+1);
			left = Math.min(left, u);
			right = Math.max(right, u+1);
			
			for(int[] dir: dirs) {
				int candu = u + dir[0];
				int candv = v + dir[1];
				if (candu < 0 || candu >= m || candv < 0 || candv >= n ||
						visited[candu][candv] || grid[candu][candv] == 0)
					continue;
				q.offer(new int[] {candu,candv});
			}
		}
	}
	public static void main(String[] args) {
		int[][] pixels = {
				{0,0,1,0},
				{0,1,1,0},
				{0,1,0,0}
			};
		MinAreaPixels mapx = new MinAreaPixels(pixels,0,2);
		System.out.println(" min area returned is  " + mapx.getArea());
	}

}
