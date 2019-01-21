package com.venkat.leetfree;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class HitCounter {
	Map<Integer, Integer> hitCnt;
	public HitCounter() {
		hitCnt = new TreeMap<Integer,Integer>();
	}
	public void hit(int n) {
		hitCnt.put(n, 1 + hitCnt.getOrDefault(n, 0));
		Iterator<Integer> kiter = hitCnt.keySet().iterator();
		while(kiter.hasNext()) {
			Integer k = kiter.next();
			if (k < n - 300) {
				kiter.remove();
			} else {
				break;
			}
		}
	}
	public int getHits(int n) {
		int sum = 0;
		Iterator<Integer> kiter = hitCnt.keySet().iterator();
		while( kiter.hasNext() ) {
			Integer k = kiter.next();
			if (k <= n - 300) {
				kiter.remove();
			} else {
				sum += hitCnt.get(k);
			}
		}
		return (sum);
	}

	public static void main(String[] args) {
		HitCounter counter = new HitCounter();
		
		// hit at timestamp 1.
		for(int j = 0 ; j < 45; j++)
			counter.hit(1);
		

		// hit at timestamp 2.
		counter.hit(2);

		// hit at timestamp 3.
		counter.hit(3);
		
		for(int i = 50; i < 250 ; i++) {
			counter.hit(i);
			counter.hit(i);
			counter.hit(i);
			counter.hit(i);
		}

		// get hits at timestamp 4, should return 3.
		System.out.println("Counter of hits at 4 " + counter.getHits(4) );

		// hit at timestamp 300.
		counter.hit(300);

		// get hits at timestamp 300, should return 4.
		System.out.println("Counter of hits at 300 " + counter.getHits(300));

		// get hits at timestamp 301, should return 3.
		System.out.println("Counter of hits at 301 " +counter.getHits(301)); 		

	}

}
