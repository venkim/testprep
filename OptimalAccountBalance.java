package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalance {
	int rslt;
	public OptimalAccountBalance(int[][] transactions) {
		// debtMap is from ID to actual debt i.e., number
		// if 0 gave 20 then it will be recorded as -20 to 0
		rslt = Integer.MAX_VALUE;
		Map<Integer,Integer> debtMap = new HashMap<Integer,Integer>();
		for(int[] trans: transactions) {
			debtMap.put(trans[0], debtMap.getOrDefault(trans[0],0) - trans[2]);
			debtMap.put(trans[1], debtMap.getOrDefault(trans[1], 0) + trans[2]);
		}
		List<Integer> debts = new ArrayList<Integer>();
		for(Integer v : debtMap.values()) {
			if (v != 0) 
				debts.add(v);
		}
		helper(debts,0,0);
	}
	private void helper(List<Integer> debts, int start, int cnt) {
		while (start < debts.size() && debts.get(start) == 0) 
			start++;
		
	    if (start == debts.size()) {
	    	rslt = Math.min(rslt, cnt);	
	    	return;
	    }
	    
	    for (int i = start+1; i < debts.size(); i++) {
	    	if (debts.get(start) < 0 &&	debts.get(i) > 0 || 
	    			debts.get(start) > 0 && debts.get(i) < 0) {
	    		debts.set(i, debts.get(i)+debts.get(start));	
	    		helper(debts, start+1, cnt+1);
	    		debts.set(i, debts.get(i)-debts.get(start));
	    	}
	    }		
	}
	public int getNumTrans() {
		return (rslt);
	}
	public static void main(String[] args) {
		
		int[][] trans1 = {{0,1,10}, {2,0,5}};
		OptimalAccountBalance oab1 = new OptimalAccountBalance(trans1);
		System.out.println("minimal trans cnt is " + oab1.getNumTrans());
		
		int[][] trans2 = {
		{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}
		};
		OptimalAccountBalance oab2 = new OptimalAccountBalance(trans2);
		System.out.println("minimal trans cnt is " + oab2.getNumTrans());
	}

}
