package com.venkat.leetfree;

/*
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts 
 * have the same color.
 * Return the total number of ways you can paint the fence.
 */
public class PaintFence {

	public PaintFence() {
		// TODO Auto-generated constructor stub
	}
	public static int numOfWays(int n, int k){
		// ways [i][0] -- assume the two left posts have same color
		// ways [i][1] -- assume the two left posts have different color
		// then ways[i+1][0] = ways[i][1]*1 ; only way is to select from different form prev * same color = 1
		//  and ways[i+1][1] = ways[1][0]*(k-1) + ways[i][1]*(k-1)                                                
		int[][] ways= new int[n][2];
		ways[0][0] = k;
		ways[0][1] = k;
		for(int ipost = 0; ipost < n-1; ipost++) {
			ways[ipost+1][0] = ways[ipost][1] ;
			ways[ipost+1][1] = (ways[ipost][0] + ways[ipost][1])*(k-1);
		}
		return ways[n-1][0] + ways[n-1][1];
	}

	public static void main(String[] args) {
		int n = 6;
		int k = 4;
		
		System.out.println("with n = " + n + " and k = " + k + "ways = " + numOfWays(n,k));

	}

}
