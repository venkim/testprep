package com.venkat.leetfree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * Given a 2D grid, each cell is either a 
 * wall 'W', an enemy 'E' or empty '0' (the number zero), 
 * return the maximum enemies you can kill using one bomb.
 * The bomb kills all the enemies in the same row and column 
 * from the planted point until it hits the wall since the 
 * wall is too strong to be destroyed.
 * Note that you can only put the bomb at an empty cell.
 *
 *Example:
 * For the given grid
 *
 * 0 E 0 0
 * E 0 W E
 * 0 E 0 0
 *
 *	return 3. (Placing a bomb at (1,1) kills 3 enemies)
 */
public class BombEnemy {

	public BombEnemy() {
		// TODO Auto-generated constructor stub
	}


	public static int maxBombImpact(char[][] grid) {
		int[][] impact;
		int row = grid.length;
		int col = grid[0].length;
		int currImp = 0;
		int maxImp = 0;
		
		for(int i = 0;i < row; i++) {
			for(int j = 0 ; j < col; j++) {
				if ( grid[i][j] == '0') {
					System.out.println("current ro and co from out are " + i + "$" + j);
					currImp= countE(grid,i,j);
					maxImp = Math.max(maxImp, currImp);
				}
			}
		}
		return (maxImp);
	}
	public static int countE(char[][] grid, int r, int c) {
		int impCnt = 0;
		System.out.println("Current row and col are " + r + "$" + c);
		for(int colv = c + 1; colv < grid[r].length ; colv++) {
			if (colv < grid[r].length && grid[r][colv] != 'W') {
				if (grid[r][colv] == 'E') {
					impCnt++;
				}
			} else {
				break;
			}
		}
		for(int colv = c-1; colv >= 0 ; colv--) {
			if (colv >= 0 && grid[r][colv] != 'W') {
				if (grid[r][colv] == 'E') {
					impCnt++;
				}
			} else {
				break;
			}
		}
		for(int rowv = r+1;rowv < grid.length;rowv++) {
			if (rowv < grid.length && grid[rowv][c] != 'W') {
				if (grid[rowv][c] == 'E') {
					impCnt++;
				}
			} else {
				break;
			}
		}
		for(int rowv = r-1;rowv>=0; rowv--) {
			if (rowv >= 0 && grid[rowv][c] != 'W') {
				if (grid[rowv][c] == 'E') {
					impCnt++;
				}
			} else {
				break;
			}
		}
		return (impCnt);
	}

	public static void main(String[] args) {
		char[][] grid = {
				{'0', 'E', '0', '0'},
				{'E', '0', 'W', 'E'},
				{'0', 'E', '0', '0'}
		};
		System.out.println("max impact is " + maxBombImpact(grid) );
	}

}
