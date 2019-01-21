package com.venkat.gfg.dynprog;

public class EggDrop {
	/*
	 * nmber of tries n eggs and k floors 
	 */
	public static int eggDrop(int n, int k) {
		if ( k == 0 || k == 1)
			return k;
		
		if ( n == 1)
			return k;
		
		// otherwise consider all floors from 1 to k
		// if a egg cracks on fall from floor x (btween 1 and k)
		// then need to work with n-1 eggs and x floors only
		// if not crack, work with n eggs and (k-x) floors
		// max of the two
		int min = Integer.MAX_VALUE;
		
		for(int x = 1 ; x <= k ; x++) {
			int res = Math.max( eggDrop(n-1, x), eggDrop(n,k-x) );
			if ( res < min)
				min = res;
		}
		return (min+1);
		
	}
	public static int eggDropDP(int n, int k) {
		int[][] edp = new int[n+1][k+1];
		
		// if we only one egg - we need k attempts
		for(int i = 0; i <= k ;i++) {
			edp[1][i] = i;
		}
		
		// if k == 0 or k == 1 i.e., 0 or 1 floors
		// - then k attempts needed( 0 or 1)
		for(int i = 0 ; i <= n ; i++) {
			edp[i][0] = 0;
			edp[i][1] = 1;
		}
		
		for(int i = 2 ; i <= n ; i++) {
			for(int j = 2 ; j <= k ; j++) {
				if ( i == 1) {
					edp[i][j] = j;
				}else if ( j == 0 || j == 1) {
					edp[i][j] = j;
				}else {
					// trying to computer edp[i][j]
					int min = Integer.MAX_VALUE;
					
					for(int x = 1 ; x <= j ; x++) {
						int res = 1 + Math.max( edp[i-1][x-1]  , edp[i][j-x] );
						if ( res < min) {
							min = res;
						}
					}
					edp[i][j] = min;
				}
			}
		}
		return ( edp[n][k]);
	}
	public EggDrop() {
	}
	public static void main(String[] args) {
		// 
		int n = 2, k = 10;
		System.out.println("Minimum number of trials in worst case with " +
					n + " eggs and " + k +  " floors is " +  eggDrop(n, k) );
		System.out.println("DP:-Minimum number of trials in worst case with " +
				n + " eggs and " + k +  " floors is " +  eggDropDP(n, k) );
		
		n = 3; 
		k = 27;
		System.out.println("Minimum number of trials in worst case with " +
				n + " eggs and " + k +  " floors is " +  eggDrop(n, k) );
		System.out.println("DP:-Minimum number of trials in worst case with " +
				n + " eggs and " + k +  " floors is " +  eggDropDP(n, k) );

	}

}
