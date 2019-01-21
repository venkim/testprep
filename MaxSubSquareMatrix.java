package com.venkat.gfg.dynprog;

public class MaxSubSquareMatrix {

	/*
	 * Given a binary matrix, find out the 
	 * maximum size square sub-matrix with all 1s. 
	 */
	public static int getMaxSubSquare(int[][] mat) {
		int numR = mat.length;
		int numC = mat[0].length;
		int[][] rslt = new int[numR][numC];
		
		//Idea is for the result matrix to keep the size of matrix that is
		//formed with that square as the right-bottom most edge of the mat
		
		// rows - remain the same
		// i.e., each row - very first column stays as is - 
		for(int i = 0 ; i < numR ; i++)
			rslt[i][0] = mat[i][0];
		
		// similar logic for columns - each column -very first row remains
		for(int j = 0 ; j < numC; j++)
			rslt[0][j] = mat[0][j];
		
		// starting with 1,1 onwards - the size
		for(int i = 1 ; i < numR ;i++) {
			for(int j = 1 ; j < numC ; j++) {
				if ( mat[i][j] == 0)
					rslt[i][j] = 0;
				else {
					int fMin = Math.min( Math.min( rslt[i-1][j-1], rslt[i-1][j]) , rslt[i][j-1] );
					rslt[i][j] = 1 + fMin;
				}
			}
		}
		// Now find the max element
		int maxSize = Integer.MIN_VALUE;
		int maxR = 0;
		int maxC = 0;
		for(int i = 1 ; i < numR ;i++) {
			for(int j = 1 ; j < numC ; j++) {
				if ( rslt[i][j] > maxSize ) {
					maxSize = rslt[i][j];
					maxR = i;
					maxC = j;
				}
			}
		}
		
		// print the result matrix
		printMat(rslt);
		// print the matrix and then return
		int staR = (maxR - maxSize) + 1;
		int staC = (maxC - maxSize) + 1;
		
		System.out.println("MAXR and MAXC " + maxR + " " + maxC);
		System.out.println("STAR and STAC " + staR + " " + staC);	
		
		for(int i = staR; i <= maxR ; i++) {
			System.out.print("|");
			for(int j = staC ; j <= maxC ; j++) {
				System.out.print( mat[i][j]) ;
				System.out.print("|");
			}
			System.out.println();
		}
		
		return maxSize;
	}
	public static void printMat(int[][] mat) {
		int numR = mat.length;
		int numC = mat[0].length;
		for(int i = 0; i < numR ; i++) {
			System.out.print("|");
			for(int j = 0 ; j < numC ; j++) {
				System.out.print( mat[i][j]) ;
				System.out.print("|");
			}
			System.out.println();
		}
	}
	public MaxSubSquareMatrix() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M[][] =  {{0, 1, 1, 0, 1}, 
                {1, 1, 0, 1, 0}, 
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};
		System.out.println("Max sub sq is" + getMaxSubSquare(M) );
	}

}
