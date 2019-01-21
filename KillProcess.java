package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcess {
	static class Node {
		int pid;
		List<Node> children;
		public Node(int id) {
			this.pid = id;
			children = new ArrayList<Node>();
		}
	}
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int killp){
		Map<Integer,Node> pmap = new HashMap<>();
		List<Integer> rslt = new ArrayList<>();
		
		if (pid.size() != ppid.size()) {
			System.out.println("Serious issue with pid and ppid... in doubt to proceed..");
		}
		
		for(int i = 0 ; i < pid.size(); i++) {
			Node curNode = new Node(pid.get(i));
			pmap.putIfAbsent(i, curNode);
		}
		
		for(int i = 0 ; i < ppid.size(); i++) {
			Node par = pmap.get(ppid.get(i));
			par.children.add(pmap.get(pid.get(i)));
		}
		
		rslt.add(killp);
		getAllChildren(pmap.get(killp), rslt);
		return(rslt);
	}
	
	public static void getAllChildren(Node par, List<Integer> rslt) {
		for(Node x : par.children) {
			rslt.add(x.pid);
			getAllChildren(x,rslt);
		}
	}
	public KillProcess() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
