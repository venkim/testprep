package com.venkat.leetfree;
/*
 * Given an Android 3x3 key lock screen and two 
 * integers m and n, where 1 ≤ m ≤ n ≤ 9, 
 * count the total number of unlock patterns of 
 * the Android lock screen, which consist of 
 * minimum of m keys and maximum n keys.

	* Rules for a valid pattern:

 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 * The order of keys used matters.
 * 
 * Invalid move: 4 - 1 - 3 - 6 
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.

 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.

 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

 * Example:
 * Given m = 1, n = 1, return 9.

 * We sum all the valid patterns when using m keys, m+1keys, … n keys together to get the result.

 * In each case, we use DFS to count the number of valid paths from the current number (1–9)
 * to the remaining numbers. To optimize, calling DFS less than 9 times, we can use the 
 * symmetry of the 3 by 3 matrix. If we start from 1 or 3 or 7 or 9, the valid paths 
 * number should be the same. If we start from 2 or 4 or 6 
 */
public class AndroidUnlock {

	
	public AndroidUnlock() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * m is the minimum number of digits, n is max - inclusive
	 */
	public static int numberOfPatterns(int m, int n) {
		// keep the record of invalid numbers i.e going 
		// from 1 to 3 - 2 is the digit that must be included
		// if not - invalid...
		// let us call it skip digit...
		// 
		int[][] skip = new int[10][10];
		skip[1][3] = skip[3][1] = 2 ;
		skip[1][7] = skip[7][1] = 4;
		skip[3][9] = skip[9][3] = 6;
		skip[7][9] = skip[9][7] = 8;
		skip[1][9] = skip[9][1] = 5;
		skip[2][8] = skip[8][2] = 5;
		skip[3][6] = skip[6][3] = 5;
		skip[4][6] = skip[6][4] = 5;
		boolean[] visited = new boolean[10];
		
		int res = 0;
		for(int i = m ; i <= n ; i++) {
			// use the symmetry to reduce DFS call
			// 1, 3 ,7 and 9 are considered the same...
			res += DFS(visited,skip, 1, i-1) * 4;
			res += DFS(visited,skip, 2, i-1) * 4;
			res += DFS(visited,skip, 5, i-1);
		}
		return (res);
	}
	public static int DFS(boolean[] visited, int[][] skip, int cur, int remain) {
		if (remain < 0)
			return 0;
		if (remain == 0)
			return 1;
		// mark visited as true
		visited[cur] = true;
		int res = 0;
		for(int i = 1 ; i <= 9; i++) {
			if (!visited[i] && ( skip[cur][i] == 0 || visited[ skip[cur][i] ]) ) {
				res += DFS(visited,skip,i,remain-1);
			}
		}
		visited[cur] = false;
		return (res);
	}
	public static void main(String[] args) {
		int m = 1, n = 4;
		System.out.println("Number of patterns ... " + numberOfPatterns(7,7));

	}

}
