package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class ACS {
	static class Trie {
		Trie[] children;
		int times;
		public Trie() {
			children = new Trie[27];
			times = 0;
		}
	}
	static class Node {
		String sentence;
		int times;
		public Node(String s,int t) {
			this.sentence = s;
			this.times = t;
		}
	}
	public int getInt(char c) {
		if (c == ' ')
			return 26;
		else
			return (c-'a');
	}
	public void insert(Trie t,String s,int times) {
		for(int i = 0;i < s.length();i++) {
			if (t.children[getInt(s.charAt(i))] == null)
				t.children[getInt(s.charAt(i))] = new Trie();
			t = t.children[getInt(s.charAt(i))];
		}
		t.times += times;
	}

	Trie root;
	public ACS(String[] sentences, int[] times) {
		root = new Trie();
		for(int i = 0;i < sentences.length; i++) {
			insert(root, sentences[i].toLowerCase(), times[i]);
		}
	}
	String curSent = "";
	public List<String> input(char c){
		List<String> rslt = new ArrayList<String>();
		
		if ( c == '#') {
			insert(root,curSent,1);
		} else {
			curSent += c;
			List<Node> list = lookup(root, curSent);
			list.sort((u,v)-> (v.times == u.times) ? u.sentence.compareTo(v.sentence) : (v.times-u.times));
			for(int i = 0 ; i < Math.min(3, list.size()) ; i++) {
				rslt.add(list.get(i).sentence);
			}
		}
		return (rslt);
	}
	List<Node> lookup(Trie t,String sent){
		List<Node> rslt = new ArrayList<>();
		for(int i = 0 ; i < sent.length(); i++) {
			if (t.children[getInt(sent.charAt(i))] != null)
				t = t.children[getInt(sent.charAt(i))];
			else
				return (rslt);
		}
		traverse(sent,t,rslt);
		return (rslt);
	}
	public void traverse(String s, Trie t, List<Node> rslt) {
		if (t.times > 0)
			rslt.add(new Node(s,t.times));
		
		for(int i = 0; i < 27; i++) {
			if (t.children[i] != null) {
				if (i == 26) {
					traverse(s+(char)' ', t.children[i], rslt);
				} else {
					traverse(s+(char)('a'+i), t.children[i], rslt);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		String[] sents = {"I love you","island","ironman","I love leetcode","i want to walk"};
		int[] times = {5,3,2,2,1};
		
		ACS acs1 = new ACS(sents,times);
		
		List<String> lst1 = acs1.input('i');
		System.out.println("List of i is " + lst1);

	}

}
