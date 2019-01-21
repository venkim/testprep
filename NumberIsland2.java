package com.venkat.leetfree;

public class NumberIsland2 {
	public static int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };
	public NumberIsland2() {
		// TODO Auto-generated constructor stub
	}
	public static int[] getNumIslands(int m, int n, int[][] posns) {
		int[][] grid = new int[m][n];
		int[] rslt = new int[posns.length];
		
		for(int i = 0 ; i < posns.length;i++) {
			int nisle = dfsDrive(grid,posns[i]);
			rslt[i] = nisle;
		}
		return (rslt);
	}
	public static int dfsDrive(int[][] grid, int[] posn) {

		int numIslands = 0;
		
		int currx = posn[0];
		int curry = posn[1];
		grid[currx][curry] = 1;
		
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		
		for(int i = 0 ; i < grid.length;i++) {
			for(int j = 0 ; j < grid[0].length; j++) {
				if (!visited[i][j] && grid[i][j] == 1) {
					visited[i][j] = true;
					int sz = dfs(i,j,grid,visited,0); 
					numIslands++;
				}
			}
		}
		return (numIslands);
	}
	public static int dfs(int r, int c, int[][] grid,boolean[][] visited,int size) {
		
		for (int[] dir : dirs) {
			int row = r + dir[0];
			int col = c + dir[1];
			if (isValid(row,col,grid) && grid[row][col] == 1 && !visited[row][col]) {
				visited[row][col] = true;
				size++;
				dfs(row,col,grid,visited,size);
			}
		}
		return (size);
	}
	public static boolean isValid(int r, int c, int[][] grid) {
		if (r < 0 || r >= grid.length)
			return false;
		if ( c < 0 || c >= grid[0].length)
			return false;
		return (true);
	}
	
	public static void main(String[] args) {
		int m = 3,n = 3;
		int[][] positions =  {{0,0}, {0,1}, {1,2}, {2,1},{1,1}};

		int [] rslt = getNumIslands(m, n,  positions);
		for (int i = 0 ; i < rslt.length; i++) {
			System.out.println("Rslt elements are " + rslt[i]);
		}
	}

}
