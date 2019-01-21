package com.venkat.leetfree;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Design a logger system that receive stream of messages along with 
 * its timestamps, each message should be printed if and only if it 
 * is not printed in the last 10 seconds.

 * Given a message and a timestamp (in seconds granularity), return true if 
 * the message should be printed in the given timestamp, otherwise returns false.
 */
public class LoggerRateLimiter {

	public LoggerRateLimiter() {
		msgMap = new ConcurrentHashMap<>();
	}
	Map<String, Integer> msgMap ;
	public boolean shouldPrintMessage(int timestamp,String msg) {
		if (!msgMap.containsKey(msg)) {
			msgMap.put(msg,timestamp);
			return true;
		} else {
			if (timestamp - msgMap.get(msg) > 10) {
				msgMap.put(msg, timestamp);
				return true;
			}
		}
		return (false);
	}
	public static void main(String[] args) {
		LoggerRateLimiter lrl = new LoggerRateLimiter();
		
		int id = 1;
		String msg = "foo";
		System.out.println(id + "$" + msg + " is " + lrl.shouldPrintMessage(id,msg) );
		
		id = 2;
		msg = "bar";
		System.out.println(id + "$" + msg + " is " + lrl.shouldPrintMessage(id,msg) );
		
		id = 3;
		msg = "foo";
		System.out.println(id + "$" + msg + " is " + lrl.shouldPrintMessage(id,msg) );
		
		id = 8;
		msg = "bar";
		System.out.println(id + "$" + msg + " is " + lrl.shouldPrintMessage(id,msg) );

		id = 10;
		msg = "foo";
		System.out.println(id + "$" + msg + " is " + lrl.shouldPrintMessage(id,msg) );
		
		id = 13;
		msg = "foo";
		System.out.println(id + "$" + msg + " is " + lrl.shouldPrintMessage(id,msg) );		
		
		id = 14;
		msg = "foo";
		System.out.println(id + "$" + msg + " is " + lrl.shouldPrintMessage(id,msg) );	
	}

}
