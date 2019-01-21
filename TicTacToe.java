package com.venkat.leetfree;

public class TicTacToe {
	int[][] grid;
	int gameWon = 0;
	public TicTacToe(int n) {
		grid = new int[n][n];
	}
	/*
	 * pre condition
	 * r c - has not already been taken
	 *  turn will be a valid number 1 or 2
	 *  return 0 - if no one wins
	 *  return 1, or 2 if player 1 or 2 wins.
	 */
	public int move(int r, int c, int turn) {
		
		if (gameWon != 0) {
			System.out.println("Your move " + r + "," + c + " turn = " + turn + " not done....");
			System.out.println("Game is already over... Winner is" + gameWon);
			return gameWon;
		}
		
		grid[r][c] = turn;
		// check row r 
		boolean rowWin = true;
		for(int i = 0 ; i < grid.length; i++) {
			if (grid[r][i] != turn)
				rowWin = false;
		}
		if (rowWin) {
			gameWon = turn;
			return (turn);
		}

		// check that column
		boolean colWin = true;
		for(int i = 0 ; i < grid.length; i++) {
			if (grid[i][c] != turn)
				colWin = false;
		}
		if (colWin) {
			gameWon = turn;
			return (turn);
		}
		
		// diagonal - major
		boolean diagMajWin = true;
		if ( r == c) {
			for(int i = 0 ; i < grid.length; i++) {
				if (grid[i][i] != turn)
					diagMajWin = false;
			}
		
			if (diagMajWin) {
				gameWon = turn;
				return turn;
			}
		}
		boolean diagMinWin = true;
		if ( r == c) {
			for(int i = 0; i < grid.length; i++) {
				int cj = grid.length -1 - i;
				if (grid[i][cj] != turn)
					diagMinWin = false;
			}
			if (diagMinWin) {
				gameWon = turn;
				return turn;
			}
		}
		
		return 0;
	}

	public static void main(String[] args) {
		TicTacToe tt = new TicTacToe(3);
		System.out.println("Move 1 " + tt.move(0, 0, 1) );
		System.out.println("Move 2 " + tt.move(0, 2, 2) );

		System.out.println("Move 3 " + tt.move(2, 2, 1) );
		System.out.println("Move 4 " + tt.move(1, 1, 2) );
		
		System.out.println("Move 5 " + tt.move(2, 0, 1) );
		System.out.println("Move 6 " + tt.move(1, 0, 2) );
		
		System.out.println("Move 7 " + tt.move(2, 1, 1) );
		System.out.println("Move 8 " + tt.move(0, 1, 2) );
		

	}

}
