package com.venkat.gfg.dynprog;

public class AssemblyLinesTwo {

	public AssemblyLinesTwo() {
		// TODO Auto-generated constructor stub
	}

	public static int carAssembly(int[][] a, int[][] t, int[]e, int[] x) {
		// Keep two separate arrays for exiting time from station 1 and 2
		int num_stn = a[0].length;
		int T1[] = new int[num_stn];
		int T2[] = new int[num_stn];
		
		T1[0] = e[0] + a[0][0];
		T2[0] = e[1] + a[1][0];
		
		for(int i = 1 ; i < num_stn ; i++) {
			int xx = T1[i-1] + a[0][i];
			int yy = T2[i-1] + t[1][i] + a[0][i];
			T1[i] = Math.min(xx , yy);
			
			xx = T2[i-1] + a[1][i];
			yy = T1[i-1] + t[0][i] + a[1][i];
			T2[i] = Math.min(xx,yy);
		}
		T1[num_stn-1] += x[0];
		T2[num_stn-1] += x[1];
		return (Math.min(T1[num_stn-1], T2[num_stn-1]));
	}
	public static void main(String[] args) {
        int a[][] = {{4, 5, 3, 2},
        			 {2, 10, 1, 4}};
        int t[][] = {{0, 7, 4, 5},
                	 {0, 9, 2, 8}};
        int e[] = {10, 12}, x[] = {18, 7};
 
        System.out.println(carAssembly(a, t, e, x));    

	}

}
