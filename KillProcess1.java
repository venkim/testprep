package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class KillProcess1 {

	public KillProcess1() {
		// TODO Auto-generated constructor stub
	}
	public static List<Integer> kill(int[] pid, int[] ppid, int killp) {
		Map<Integer,List<Integer>> graph = new HashMap<>();
		
		for(int i = 0 ; i < pid.length; i++) {
			int proc = pid[i];
			int pproc = ppid[i];
			// make an edge from pproc to proc
			graph.putIfAbsent(pproc,new ArrayList<Integer>());
			graph.get(pproc).add(proc);
		}
		
		// Now for killp - check the child processes
		// and all processes that can rach down there DFS
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(killp);
		List<Integer> rslt = new ArrayList<Integer>();
		rslt.add(killp);
		while (!q.isEmpty()) {
			Integer curr = q.poll();
			if (!graph.containsKey(curr))
				continue;
			for(Integer x: graph.get(curr)) {
				rslt.add(x);
				q.offer(x);
			}
		}
		return (rslt);
	}
	public static void main(String[] args) {
		int[] pid = {1,3,10,5};
		int[] ppid = {3,0,5,3};
		
		int killp = 5;
		List<Integer> lst = kill(pid,ppid,killp);
		System.out.println("Killing " + killp + " will cause "  + lst);
		

	}

}
