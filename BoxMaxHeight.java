package com.venkat.gfg.dynprog;

import java.util.Arrays;

public class BoxMaxHeight {
	static class Box implements Comparable<Box>{
		int h;
		/* arbitrarily follow convention that w < d
		 * and enforce in constructor. Also make the area
		 * a proxy for comparison.
		 */
		int w;
		int d;
		int area;

		public Box(int h, int w, int d) {
			this.h = h;
			
			this.w = Math.min(w, d);
			this.d = Math.max(w, d);
			this.area = this.w * this.d ;
		}
		/*
		 * This will do a reverse sort i.e., bigger one will land up first
		 * @see java.lang.Comparable#compareTo(java.lang.Object)
		 */
		public int compareTo(Box other) {
			return (other.area - this.area);
		}
	}
	public BoxMaxHeight() {
		// TODO Auto-generated constructor stub
	}
	public static int maxStackHeight(Box[] arr) {
		int n = arr.length;
		Box[] bwRot  = new Box[n*3];
		for(int i = 0 ; i < n ; i++) {
			bwRot[3*i] = new Box(arr[i].h, arr[i].d, arr[i].w);
			bwRot[3*i+1] = new Box(arr[i].w, arr[i].h, arr[i].d);
			bwRot[3*i+2] = new Box(arr[i].d, arr[i].w, arr[i].h);
		}
		// sort the boxes by area
		Arrays.sort(bwRot);
		
		// dynamic max ht array to keep track of max ht at each index
		int[] dmht = new int[3*n+1];
		dmht[0] = 0;
		// initialize saying that - very minimum that box can be tallest box at that spot 
		for(int i = 1 ; i <= 3*n ; i++) {
			dmht[i] = bwRot[i-1].h;
		}
		// now dynamically go through each position and try to better that
		for(int i = 2 ; i < 3*n ;i++) {
			int maxSoFar = dmht[i];
			for(int j = 1; j < i ; j++) {
				// sort is cursory - the actual truth is enforced here.
				if ( bwRot[j].w > bwRot[i].w && 
					 bwRot[j].d > bwRot[i].d &&
					 dmht[j] + bwRot[i-1].h > maxSoFar) {
					maxSoFar = dmht[j] + bwRot[i-1].h;
				}
			}
			dmht[i] = maxSoFar;
		}
		
		// now that dmht is populated - go through and pick the tallest.
		int maxUltim = Integer.MIN_VALUE;
		for(int i = 1 ; i <= 3*n ; i++) {
			maxUltim = Math.max( maxUltim, dmht[i]);
		}
		return maxUltim;
	}
	public static void main(String[] args) {

		  Box[] arr = new Box[4];
	        arr[0] = new Box(4, 6, 7);
	        arr[1] = new Box(1, 2, 3);
	        arr[2] = new Box(4, 5, 6);
	        arr[3] = new Box(10, 12, 32);
	         
	        System.out.println("The maximum possible "+
	                           "height of stack is " + 
	                           maxStackHeight(arr) );
	}

}
