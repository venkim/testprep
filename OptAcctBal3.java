package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * Minimize Cash Flow among a given set of friends who 
 * have borrowed money from each other
 * Given a number of friends who have to give or
 * take some amount of money from one another. Design an 
 * algorithm by which the total 
 * cash flow among all the friends is minimized.
 */
public class OptAcctBal3 {
	int rslt;
	public OptAcctBal3(int[][] trans) {
		
		rslt = 0;
		// split the transaction into debit and credits.
		Map<Integer,Integer> debtMap = new HashMap<>();
		
		for(int[] tran: trans) {
			debtMap.put(tran[0], debtMap.getOrDefault(tran[0],0) - tran[2]);
			debtMap.put(tran[1], debtMap.getOrDefault(tran[1],0) + tran[2]);
		}
		
		boolean done = false;
		while (!done) {
			int credId =0, debtId=0;
			int minCred = Integer.MAX_VALUE, maxDebt = Integer.MIN_VALUE;
			for(Map.Entry<Integer, Integer> ent: debtMap.entrySet()){
				if (ent.getValue() < minCred){
					credId = ent.getKey();
					minCred = ent.getValue();
				}
				if (ent.getValue() > maxDebt){
					debtId = ent.getKey();
					maxDebt = ent.getValue();
				}
				if (minCred == 0 && maxDebt == 0) {
					done = true;
					break;
				}
			}
			if (done)
				continue;
			int absMinCred = Math.abs(minCred);
			int absMaxDebt = Math.abs(maxDebt);
			if (absMinCred < absMaxDebt) {
				System.out.println("debtor " + debtId + "paying off " + absMinCred + " to " + credId);
				debtMap.put(credId,0);
				debtMap.put(debtId, debtMap.get(debtId)-absMinCred);
				rslt++;
			} else {
				System.out.println("Creditor " + credId + "getting paid " + absMaxDebt + " by debtor " + debtId);
				debtMap.put(debtId,0);
				debtMap.put(credId, debtMap.get(credId)+absMaxDebt);
				rslt++;
			}
		}
		
		
	}
	private void helper(List<Integer> dList,int start, int cnt) {
		while ( start < dList.size() && dList.get(start) == 0)
			start++;
		if (start >= dList.size()) {
			rslt = Math.min(rslt, cnt);
			return;
		}
		for(int i = start + 1; i < dList.size(); i++) {
			// see if start and i can do adjustment - 
			if (dList.get(start) > 0 && dList.get(i) < 0 ||
					dList.get(start) < 0 && dList.get(i) > 0) {
				dList.set(i, dList.get(i) + dList.get(start));
				helper(dList,start+1,cnt+1);
				dList.set(i, dList.get(i) - dList.get(start));
			}
		}
	}
	public int getNumTrans() {
		return rslt;
	}


	public static void main(String[] args) {
		
		int[][] trans1 = {{0,1,10}, {2,0,5}};
		OptAcctBal3 oab1 = new OptAcctBal3(trans1);
		System.out.println("minimal trans cnt is " + oab1.getNumTrans());
		
		int[][] trans2 = {
		{0,1,10}, {1,0,1}, {1,2,5}, {2,0,5}
		};
		OptAcctBal3 oab2 = new OptAcctBal3(trans2);
		System.out.println("minimal trans cnt is " + oab2.getNumTrans());
	}



}
