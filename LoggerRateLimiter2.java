package com.venkat.leetfree;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class LoggerRateLimiter2 {
	static class Log {
		int time;
		String msg;
		public Log(int timestamp,String message) {
			this.time = timestamp;
			this.msg = message;
		}
	}
	Queue<Log>  rcntMsgq;
	public LoggerRateLimiter2() {
		rcntMsgq = new PriorityQueue<Log>(10, (m1,m2)->(m1.time-m2.time));
	}
	public boolean shouldPrintMessage(int timestamp, String msg) {
		if (rcntMsgq.size() == 0) {
			rcntMsgq.offer(new Log(timestamp,msg));
			return (true);
		} 
		while(rcntMsgq.size() > 0) {
			Log currLog = rcntMsgq.peek();
			if (currLog.time <= timestamp -10) {
				rcntMsgq.poll();
			} else 
				break;
		}
		boolean rslt = true; 
		for(Log logElem: rcntMsgq) {
			if (logElem.msg.equals(msg)) {
				rslt = false;
				break;
			}
		}
		rcntMsgq.add(new Log(timestamp,msg));
		return (rslt);
	}
	public static void main(String[] args) {
		LoggerRateLimiter2 logger = new LoggerRateLimiter2();
		// logging string "foo" at timestamp 1
		System.out.println( logger.shouldPrintMessage(1, "foo") + " Expect true" ); 
		//returns true; 

		// logging string "bar" at timestamp 2
		System.out.println( logger.shouldPrintMessage(2,"bar") + " Expect true"); 
		//returns true;

		// logging string "foo" at timestamp 3
		System.out.println( logger.shouldPrintMessage(3,"foo") + " Expect false"); 
		// returns false;

		// logging string "bar" at timestamp 8
		System.out.println( logger.shouldPrintMessage(8,"bar") +  " Expect false"); 
		// returns false;

		// logging string "foo" at timestamp 10
		System.out.println( logger.shouldPrintMessage(10,"foo") + " Expect false"); 
		// returns false;

		// logging string "foo" at timestamp 11
		System.out.println( logger.shouldPrintMessage(11,"foo") + " Expect fale"); 
		// returns true;
		
		// logging string "foo" at timestamp 13
		System.out.println( logger.shouldPrintMessage(13,"foo") + " Expect false"); 
		// returns false;
		
		// logging string "phew" at timestamp 14
		System.out.println( logger.shouldPrintMessage(11,"phew") + " Expect true"); 
		// returns true;
		
		// logging string "foo" at timestamp 23
		System.out.println( logger.shouldPrintMessage(23,"foo") + " Expect true"); 
		// returns false;
	}

}
