package com.venkat.leetfree;
/*
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 */
import java.util.LinkedList;
import java.util.Queue;

public class MovingAvgDataStream {
	int n;
	Queue<Integer> q; 
	public MovingAvgDataStream(int n) {
		this.n= n;
		q = new LinkedList<Integer>();
	}

	public double next(int elem) {
		q.offer(elem);
		while (q.size() > n) {
			q.poll();
		}
		double tot = 0.0;
		for(int x: q) {
			tot += x;
		}
		return (1.0 * tot / q.size());
	}
	public static void main(String[] args) {
		MovingAvgDataStream mads = new MovingAvgDataStream(3);
		System.out.println("next..." + mads.next(1));
		System.out.println("next..." + mads.next(10));
		System.out.println("next..." + mads.next(3));
		System.out.println("next..." + mads.next(5));

	}

}
;