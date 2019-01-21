package com.venkat.leetfree;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * mplement an iterator to flatten a 2d vector.
 *
 *For example,
 * Given 2d vector =
 *
 * [
 * [1,2],
 *  [3],
 * [4,5,6]
 * ]
 */
public class Flatten2DVector {
	int[][] mat;
	int row, col;

	int mxr;
	public Flatten2DVector(int[][] mat) {
		this.mat = mat;
		row = 0;
		col = 0;
		mxr = mat.length;
	}
	public boolean hasNext() {
		if (row < mxr) {
			if ( col < mat[row].length) {
				return (true);
			} else {
				row++; 
				col = 0;
				return hasNext();
			}
		} else {
			return (false);
		}
	}
	public int next() {
		int elem = 0;
		if (hasNext()) {
			elem = mat[row][col++];
			return (elem);
		} else {
			throw new NoSuchElementException("Iterating beyond valid boundary.");
		}
	}

	public static void main(String[] args) {
		int[][] mat = {
				{1,2,3,4,5,6,7},
				{8,9,10,11,12,13,14,15,16,17},
				{18,19,20,21,22,23,24},
				{25,26,27,28,29,30}
			};
		Flatten2DVector fv = new Flatten2DVector(mat);
		while (fv.hasNext()) {
			System.out.println("Next = " + fv.next());
		}

	}

}
