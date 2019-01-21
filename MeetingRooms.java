package com.venkat.leetfree;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms {
/*
 * 
 * Given an array of meeting time intervals consisting of start and end times 
 * [[s1,e1],[s2,e2],...] find the minimum number of conference rooms required.
 *
 */
	int[][] intervals;
	int minRooms;
	public MeetingRooms(int[][] intervals) {
		this.intervals = intervals;
		this.minRooms = 0;
		minMeetingRooms();
	}
	private int minMeetingRooms() {
		if (intervals == null || intervals.length == 0)
			return 0;
		Arrays.sort(intervals, (f,s)->(f[0]-s[0]));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(intervals[0][1]);
		minRooms = 1;
		for(int i = 1; i < intervals.length; i++) {
			if ( intervals[i][0] < pq.peek()) {
				minRooms++;
			} else {
				pq.poll();
			}
			pq.offer(intervals[i][1]);
		}
		return (minRooms);
	}
	public int getMinRooms() {
		return this.minRooms;
	}
	public static void main(String[] args) {
		int[][] intervals = { {10,16}, {11,13}, {14,17} };
		MeetingRooms meetr = new MeetingRooms(intervals);
		System.out.println(" Rooms = " + meetr.getMinRooms());
		
		int[][] intervals1 = { {1,7}, {3, 6}, {5,11},{7,15}, {9,17}};
		meetr = new MeetingRooms(intervals1);
		System.out.println(" Rooms = " + meetr.getMinRooms());		
	}
}
