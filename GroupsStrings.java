package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class GroupsStrings {
	String[] sary;
	List<List<String>> rslt;
	public GroupsStrings(String[] sary) {
		this.sary = sary;
		rslt = new ArrayList<>();
		popList();
	}
	private void popList() {
		boolean sAdded = false;
		for(String s: sary) {
			sAdded = false;;
			if (rslt.size() == 0) {
				List<String> lst = new ArrayList<>();
				lst.add(s);
				rslt.add(lst);
				continue;
			}
			for(int i = 0 ;i < rslt.size();i++) {
				List<String> lst = rslt.get(i);
				String smem = lst.get(0);
				if (smem.length() != s.length())
					continue;
				
				if (isShifted(smem,s)) {
					lst.add(s);
					sAdded = true;
				}
			}
			if (!sAdded) {
				List<String> lst = new ArrayList<>();
				lst.add(s);
				rslt.add(lst);				
			}
		}
	}
	private static boolean isShifted(String x,String y) {
		int fdiff = (x.charAt(0) - y.charAt(0)+26)%26;
		for(int i = 1; i < x.length(); i++) {
			if ( (x.charAt(i) - y.charAt(i)+26)%26 != fdiff)
				return (false);
		}
		return (true);
	}
	public List<List<String>> getList() {
		return rslt;
	}

	public static void main(String[] args) {
		String[] sary = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		GroupsStrings gs = new GroupsStrings(sary);
		for(List<String> lst: gs.getList()) {
			System.out.println("New list is " + lst);
		}
	}

}
