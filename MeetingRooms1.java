package com.venkat.leetfree;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Given an array of meeting time intervals consisting of start and end 
 * times [[s1,e1],[s2,e2],...] (si < ei), determine if a person 
 * could attend all meetings.

 * For example,
 *	Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 */
public class MeetingRooms1 {
	int[][] meetings;
	boolean canAttend;
	public MeetingRooms1(int[][] meetings) {
		this.meetings = meetings;
		canAttend = true;
		
		Arrays.sort(meetings, (f,s)->(f[0]-s[0]));
		Queue<Integer> pq = new PriorityQueue<Integer>();
		pq.offer(meetings[0][1]);
		
		for(int i = 1 ; i < meetings.length; i++) {
			if (pq.peek() > meetings[i][0]) {
				canAttend = false;
				break;
			} else {
				pq.poll();
			}
			pq.offer(meetings[i][1]);
		}
	}
	public boolean canAttend() {
		return (canAttend);
	}

	public static void main(String[] args) {
		int[][] meetings = {{0, 30},{5, 10},{15, 20}};
		MeetingRooms1 mr1 = new MeetingRooms1(meetings);
		System.out.println("MR intervals..." + mr1.canAttend());

		int[][] meetings1 = {{0, 30},{35, 40},{45, 70}};
		mr1 = new MeetingRooms1(meetings1);
		System.out.println("MR intervals..." + mr1.canAttend());
		
	}
}
