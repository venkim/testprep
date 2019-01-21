package com.venkat.leetfree;

import java.util.TreeSet;

public class FlowerKEmptySlots {
	int[] bloom;
	public FlowerKEmptySlots(int[] bloom) {
		this.bloom = bloom;
	}
	public int getFlo(int k) {
		TreeSet<Integer> tsorted = new TreeSet<>();
		if (bloom == null || bloom.length == 0)
			return -1;
		tsorted.add(bloom[0]);
		for(int i = 1 ; i < bloom.length; i++) {
			int currFlower = bloom[i];
			if (tsorted.size() >= 1) {
				System.out.println("tsorted is " + tsorted);
				if (tsorted.floor(currFlower) != null) {
					int flr = tsorted.floor(currFlower);
					if (currFlower - flr == k)
						return i;
				}
				if (tsorted.ceiling(currFlower) != null) {
					int cel = tsorted.ceiling(currFlower);
					if (cel - currFlower == k)
						return(i) ;
				}
			}
			tsorted.add(currFlower);
		}
		return (-1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bloom[] = {6,15,2,13,7,3,11,9,5,12,8,4,1,14};
		FlowerKEmptySlots fkes = new FlowerKEmptySlots(bloom);
		for(int k = 1; k < 10; k++) {
			System.out.println("For k value = " + k + "value is " + fkes.getFlo(k));
		}
	}

}
