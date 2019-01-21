package com.venkat.gfg.dynprog;

public class CountMazePaths {

	public CountMazePaths() {
		// TODO Auto-generated constructor stub
	}

	public static int countMazePaths(int[][] maze) {
		int mz_row = maze.length;
		int mz_col = maze[0].length;
		int[][] cntp = new int[mz_row][mz_col];
		
		for(int i = 0 ; i < mz_row ;i++) {
			for(int j = 0 ; j < mz_col ;j++) {
				if ( maze[i][j] != -1)
					cntp[i][j] = 1;
				else
					cntp[i][j] = -1;
			}
		}
		
		for(int i = 0 ; i < maze.length ;i++) {
			for(int j = 0 ; j < maze[0].length ;j++) {
				if  (i == 0 || j == 0)
					continue; 
				else if ( maze[i-1][j] != -1)
					cntp[i][j] += cntp[i-1][j];
				else if (maze[i][j-1] != -1)
					maze[i][j] += cntp[i][j-1];
			}
		}
		
		return cntp[mz_row - 1][mz_col - 1];
	}
	public static void main (String[] args) 
    {
        int maze[][] = {{0, 0, 0, 0},
                       {0, -1, 0, 0},
                       {-1, 0, 0, 0},
                       {0, 0, 0, 0}};
        System.out.println (countMazePaths(maze));
     
    }

}
