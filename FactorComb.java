package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class FactorComb {
	int n;
	List<List<Integer>> factList;
	public FactorComb(int n) {
		this.n = n;
		factList = new ArrayList<>();
		
		List<Integer> curr = new ArrayList<Integer>();
		popFacts(n, curr);
	}
	public void popFacts(int x,List<Integer> curr) {
		for(int i = 2 ; i < x/i ; i++ ) {
			if ( x % i == 0) {
				List<Integer> xcurr = new ArrayList<>(curr);
				xcurr.add(i);
				xcurr.add(x/i);
				factList.add(xcurr);
				
				List<Integer> ncurr = new ArrayList<Integer>(curr);
				ncurr.add(i);
				popFacts(x/i, ncurr);
			}
		}
	}
	
	public List<List<Integer>> getFactorList(){
		return factList;
	}

	public static void main(String[] args) {
		FactorComb fc1 = new FactorComb(12);
		System.out.println("Printing for 12");
		for(List<Integer> lst : fc1.getFactorList()) {
			System.out.println("lst is " + lst);
		}
		
		fc1 = new FactorComb(31);
		System.out.println("Printing for 31");
		for(List<Integer> lst : fc1.getFactorList()) {
			System.out.println("lst is " + lst);
		}		
		
		fc1 = new FactorComb(32);
		System.out.println("Printing for 32");
		for(List<Integer> lst : fc1.getFactorList()) {
			System.out.println("lst is " + lst);
		}	
		
		fc1 = new FactorComb(64);
		System.out.println("Printing for 64");
		for(List<Integer> lst : fc1.getFactorList()) {
			System.out.println("lst is " + lst);
		}

	}

}
