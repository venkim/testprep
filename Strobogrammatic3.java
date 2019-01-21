package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class Strobogrammatic3 {

	public Strobogrammatic3() {
		// TODO Auto-generated constructor stub
	}
	public static int[][] base = {{1,1},{6,9},{8,8},{9,6}};
	public static int[] nobeg = {0,0};
					
	public static List<Integer> getStrobos(String lo, String hi){
		int loVal = Integer.parseInt(lo);
		int hiVal = Integer.parseInt(hi);
		
		System.out.println("loVal = " + loVal + "hi Val is " + hiVal);
		int lolen = lo.length();
		int hilen = hi.length();
		System.out.println("loLen = " + lolen + "hi len is " + hilen);
		List<Integer> rslt = new ArrayList<Integer>();
		
		if (loVal >= hiVal) 
			return rslt;
			
		for(int i = lolen; i <= hilen; i++) {
			gen(0,i,"",loVal, hiVal, rslt);
		}
		
		return (rslt);
	}
	private static void gen(int start,int len, String sb,int loVal, int hiVal, List<Integer> rslt) {
		
		if (sb.length() >= len) {
			int currVal = Integer.parseInt(sb.toString());
			if (currVal >= loVal && currVal <= hiVal && sb.charAt(0) != '0') {
				rslt.add(currVal);
			}
		} else {
			if (start == 0) {
				gen(start+1, len, "0",loVal,hiVal,rslt);
				gen(start+1, len, "8",loVal,hiVal,rslt);
				
				gen(start+2,len,base[0][0] + sb + base[0][1],loVal,hiVal,rslt);
				gen(start+2,len,base[1][0] + sb + base[1][1],loVal,hiVal,rslt);
				gen(start+2,len,base[2][0] + sb + base[2][1],loVal,hiVal,rslt);
				gen(start+2,len,base[3][0] + sb + base[3][1],loVal,hiVal,rslt);
				gen(start+2,len,nobeg[0] + sb + nobeg[1],loVal,hiVal,rslt);	
			} else {
				gen(start+2,len,base[0][0] + sb + base[0][1],loVal,hiVal,rslt);
				gen(start+2,len,base[1][0] + sb + base[1][1],loVal,hiVal,rslt);
				gen(start+2,len,base[2][0] + sb + base[2][1],loVal,hiVal,rslt);
				gen(start+2,len,base[3][0] + sb + base[3][1],loVal,hiVal,rslt);
				
				gen(start+2,len,nobeg[0] + sb + nobeg[1],loVal,hiVal,rslt);	
			}
		}
	}
	public static void main(String[] args) {
		String lo = "50", hi = "100";
		List<Integer> lst = getStrobos(lo,hi);
		for(int xx : lst) {
			System.out.println("Another mem " + xx);
		}
		
		lo = "99" ;
		hi = "2222";
		lst = getStrobos(lo,hi);
		for(int xx : lst) {
			System.out.println("Another mem betn " + lo + "$" + hi + "$ ==" + xx);
		}		
	}

}
