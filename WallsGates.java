package com.venkat.leetfree;
/*
 * You are given a m x n 2D grid initialized with these three possible values.
 *
 *		-1 - A wall or an obstacle.
 *		0 - A gate.
 *		INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 *	Fill each empty room with the distance to its nearest gate. 
 *	If it is impossible to reach a gate, it should be filled with INF.
 ** Implementation notes:
 *		Could have used the visited logic instead of limiting by level < row
 *      since BFS guarantees that all the closest ones to locks are visited first.
 *      so if it has been visited - that would be the closest.
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WallsGates {
	public static final int INF = 2147483647 ;
	int[][] maze;
	Queue<String> dfState;
//	Set<String> visited;
	int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
	int row, col;
	int lvl = 0;
	public WallsGates(int[][] maze) {
		this.maze = maze;
		this.row = maze.length;
		this.col = maze[0].length;
		dfState = new LinkedList<String>();
//		visited = new HashSet<>();
		display();
		update();
		display();
	}
	public void update() {
		for(int i = 0 ; i < row; i++) {
			for(int j = 0 ; j < col; j++) {
				if (maze[i][j] != -1 && 
						maze[i][j] != INF) {
					dfState.offer(i+"$"+j);
				}
			}
		}
		
		while( !dfState.isEmpty() && lvl < row) {
			int sz = dfState.size();
			lvl++;
			for(int i = 0 ; i < sz; i++) {
				String curr = dfState.poll();
				String[] rcinfo = curr.split("\\$");
				int xr = Integer.parseInt(rcinfo[0]);
				int yc = Integer.parseInt(rcinfo[1]);
				int dist = maze[xr][yc];
				for(int[] dir: dirs) {
					int nxr = xr + dir[0];
					int nyc = yc + dir[1];
					if (isValid(nxr,nyc) && maze[nxr][nyc] != -1 && maze[nxr][nyc] != 0) {
						maze[nxr][nyc] = Math.min(maze[nxr][nyc],dist + 1);
						dfState.offer(nxr+"$"+nyc);
//						visited.add(nxr+"$"+nyc);
					}
				}
			}
		}
	}
	private boolean isValid(int x, int y) {
		if ( x >= 0 && x < row && y >= 0 && y < col)
			return true;
		return (false);
	}
	public  void display() {
		for(int i = 0 ; i < row; i++) {
			for(int j = 0 ; j < col; j++) {
				System.out.print( maze[i][j] + " , ");
			}
			System.out.println();;
		}
	}

	public static void main(String[] args) {
		int [][] maze = {
				{INF,  -1,  0, INF},
				{INF, INF, INF,  -1},
				{INF,  -1, INF,  -1},
				{0,  -1, INF, INF}
		};
		WallsGates wg = new WallsGates(maze);

	}

}
