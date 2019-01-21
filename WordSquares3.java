package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class WordSquares3 {
	static class TrieNode {
		TrieNode[] next;
		List<String> words;
		public TrieNode(){
			words = new ArrayList<String>();
			next = new TrieNode[26];
		}
	}
	String[] candWords;
	TrieNode root;
	
	public WordSquares3(String[] candWords) {
		root = new TrieNode();
		this.candWords = candWords;
		buildTrie();
	}

	private void buildTrie() {
		for(String candwd: this.candWords) {
			TrieNode node = root;
			char[] candary = candwd.toCharArray();
			for(char ch: candary) {
				node.words.add(candwd);
				if (node.next[ch-'a'] == null) {
					node.next[ch-'a'] = new TrieNode();
				}
				node = node.next[ch-'a'];
			}
			node.words.add(candwd);
		}
	}
	public List<List<String>> getWordSquares(){
		List<List<String>> rslt = new ArrayList<>();
		
		int len = this.candWords[0].length();
		findSquares(rslt,len,new ArrayList<String>());
		return (rslt);
	}
	private void findSquares(List<List<String>> rslt, int len, ArrayList<String> curr) {
		if (curr.size() == len) {
			rslt.add( new ArrayList<String>(curr));
			return;
		}
		
		int indx = curr.size();
		StringBuffer sb = new StringBuffer();
		for(String x: curr) {
			sb.append(x.charAt(indx));
		}
		
		// make a string out of those leading characters...
		String curs = sb.toString();
		TrieNode node = root;
		for(int i = 0 ; i < curs.length(); i++) {
			char ch = curs.charAt(i);
			if (node.next[ch-'a'] == null) {
				node = null;
				break;
			} else {
				node = node.next[ch-'a'];
			}
		}
		if (node != null) {
			for(String xyz:node.words) {
				curr.add(xyz);
				findSquares(rslt,len,curr);
				curr.remove(curr.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		String[] words = {"area","lead","wall","lady","ball"};
		WordSquares3 ws = new WordSquares3(words);
		List<List<String>> rslt = ws.getWordSquares();
		for(List<String> lst : rslt) {
			System.out.println("list is " + lst);
		}		

	}

	
	private void findSquares1(List<List<String>> rslt, int len, List<String> curr) {
		if (curr.size() == len) {
			rslt.add( new ArrayList<String>(curr));
			return ;
		}
		
		int index = curr.size();
		StringBuilder sb = new StringBuilder();
		for(String xy: curr) {
			sb.append(xy.charAt(index));
		}
		String s = sb.toString();
		
		TrieNode node = root;
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (node.next[ch-'a'] == null) {
				node = null;
				break;
			} else {
				node = node.next[ch-'a'];
			}
		}
		
		if (node == null)
			return;
		for(String sxy: node.words) {
			curr.add(sxy);
			findSquares1(rslt,len,curr);
			curr.remove(curr.size()-1);
		}
	}
}
