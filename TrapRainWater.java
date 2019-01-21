package com.venkat.leetfree;

public class TrapRainWater {
	int[] a;
	public TrapRainWater(int[] arr) {
		this.a = arr;
	}
	/*
	 * trapped rain water - brute force...
	 */
	public int trappedVol1() {
		int tvol = 0;
		for(int i = 1 ; i < a.length; i++) {
			int curht = a[i];
			System.out.print("curht is " + curht + "$");
			int lft = i, rgt = i;
			int lftMax = curht, rgtMax = curht;
			int lftInd = lft, rgtInd = rgt;
			while (lft >= 0) { 
				if (a[lft] > lftMax) {
					lftInd = lft;
					lftMax = a[lftInd];
				}
				lft--;				
			}
			System.out.print("lft indx = " + lftInd + "lftht is " + lftMax + "$");
			
			while (rgt < a.length) {
				if (a[rgt] > rgtMax) {
					rgtInd = rgt;
					rgtMax = a[rgtInd];
				}
				rgt++;
			}
			System.out.print("rgt indx = " + rgtInd + "rgtht is " + rgtMax + "$");
			

			int minHt = Math.min(lftMax, rgtMax);
			tvol += (minHt-curht);
			System.out.println(" ###$$$ Current Tvol = " + tvol);
		}
		return (tvol);
	}
	public int trappedVol2() {
		
		int n = a.length;
		int[] left = new int[n];
		left[0] = a[0];
		for(int i = 1 ; i < n;i++) {
			left[i] = Math.max(left[i-1], a[i]);
		}
		
		int[] right = new int[n];
		right[n-1] = a[n-1];
		for(int i = n-2; i >=0 ; i--) {
			right[i] = Math.max(a[i], right[i+1]);
		}
		
		int tvol = 0;
		for(int i = 1 ; i < n-1; i++) {
			int lft = left[i];
			int rgt = right[i];
			int colheight = Math.min(lft,rgt);
			tvol += (colheight-a[i]);
		}
		
		return (tvol);
	}

	public static void main(String[] args) {
		int arr[] = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		TrapRainWater trw = new TrapRainWater(arr);
		System.out.println(" " + trw.trappedVol1());
		System.out.println(" " + trw.trappedVol2());
	}

}
