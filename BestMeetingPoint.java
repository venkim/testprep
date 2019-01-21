package com.venkat.leetfree;

import java.util.Arrays;

public class BestMeetingPoint {
	int[][] mPoint;
	int[] xco;
	int[] yco;
	int mandis = 0;
	public BestMeetingPoint(int[][] mp) {
		this.mPoint = mp;
		int numPts = 0;

		for(int[] row: mp) {
			for(int i = 0 ; i < row.length; i++)
				if (row[i] == 1)
					numPts++;
		}
		xco = new int[numPts];
		yco = new int[numPts];
		int indx = 0;
		for(int r = 0; r < mp.length; r++) {
			for(int col = 0 ; col < mp[r].length; col++) {
				if (mp[r][col] == 1) {
					xco[indx] = r;
					yco[indx] = col;
					indx++;
				}
			}
		}
		Arrays.sort(xco);
		Arrays.sort(yco);
		int ansx = xco[xco.length/2];
		int ansy = yco[yco.length/2];
		this.mandis = 0;
		
		for(int i = 0 ; i < xco.length; i++) {
			System.out.println("manndis halfway $" + mandis);
			mandis += Math.abs(xco[i] - ansx);
			mandis += Math.abs(yco[i] - ansy);
			System.out.println("manndis halfway $" + mandis);
		}
	}
	public int getMandis() {
		return (mandis);
	}

	public static void main(String[] args) {
		int[][] mPoint = {
				{1,0,0,0,1},
				{0,0,0,0,0},
				{0,0,1,0,0}
				} ;
		

		BestMeetingPoint bmp = new BestMeetingPoint(mPoint);
		System.out.println("man dis is " + bmp.getMandis() );
	}

}
