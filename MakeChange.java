package com.venkat.gfg.dynprog;

public class MakeChange {

	public MakeChange() {
		// TODO Auto-generated constructor stub
	}

	public static int mkChange(int val, int[] denom, int index) {
		int numWays = 0;
		if (index >= denom.length-1)
			return 1;
		
		int denAmount = denom[index];
		
		for(int i = 0; i*denAmount <= val ; i++) {
			numWays += mkChange( val - i*denAmount, denom, index+1);
		}
		return (numWays);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] denom = { 25, 10, 5, 1};
		int index = 0;
		System.out.println("Ways to make change " + mkChange(20,denom,0));
		
		int[] shots = {3, 5, 10};
		System.out.println("Ways to make change " + mkChange(20,shots,0));
		System.out.println("Ways to make shots to RR" + makeScore(20, shots,0));
		System.out.println("Ways to make shots to DP" + makeScoreDP(20, shots));
		
		int[] dnm = {2,3,5,6};
		System.out.println("MM - Ways to make change " + makeScore(10,dnm,0));
		System.out.println("MM - Ways to make changeDP " + makeScoreDP(10,dnm));
	}
	public static int makeScore(int val, int[] shots,int index) {
		int numWays = 0;
		if ( index >= shots.length) {
			return 1;
		}
		
		for(int i = 0 ; val - i*shots[index] > 0; i++) {
			numWays += makeScore(val - i*shots[index], shots, index+1);
		}
		return (numWays);
	}
	public static int makeScoreDP(int val, int[] shots) {
		int[] dpv = new int[val+1];
		
		dpv[0] = 1;
		for(int i = 0 ; i < shots.length; i++) {
			int currShot = shots[i];
			System.out.println("currshot is " + currShot);
			for(int j = currShot ; j <= val; j++) {
				dpv[j] += dpv[j-currShot];
			}
		}
		for(int i = 0 ; i <= val ; i++)
			System.out.println("[index=" + i + "," + dpv[i]+"]");
		return (dpv[val]);
	}

}
