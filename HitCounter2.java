package com.venkat.leetfree;

public class HitCounter2 {
	public static final int MAXINTVL = 300;
	long timestamp[];
	int hits[];
	/*
	 * 5 minutes or 300 seconds is hte requirement
	 */
	public HitCounter2() {
		timestamp = new long[MAXINTVL];
		hits = new int[MAXINTVL];
	}
	public void hit(long n) {
		int rem = (int)(n % MAXINTVL);
		if (timestamp[rem] == n) {
			hits[rem]++;
		} else {
			timestamp[rem] = n;
			hits[rem] = 1;
		}
	}
	public int getHits(long n) {
		long threshold = (n - 300);
		int sum =0;
		for(int i = 0 ; i < MAXINTVL; i++) {
			if (timestamp[i] > threshold) {
				sum += hits[i];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		HitCounter2 counter = new HitCounter2();
		
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
