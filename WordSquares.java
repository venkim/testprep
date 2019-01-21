package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

public class WordSquares {
    static class TrieNode {
        List<String> words = new ArrayList<>();
        TrieNode[] next = new TrieNode[26];
    }
    TrieNode root ;
    String[] words;
	public WordSquares(String[] words) {
		root = new TrieNode();
		this.words = words;
	}
	public List<List<String>> getWordSquares(){
		List<List<String>> rslt = new ArrayList<>();
		if (words.length == 0)
			return (rslt);
		buildTrie();
		int len = words[0].length();
		findSquare(rslt,len,new ArrayList<String>());
		return (rslt);
	}
	private void buildTrie() {
		for(String word: words) {
			TrieNode currNode = root;
			char[] array = word.toCharArray();
			for(char c: array) {
				currNode.words.add(word);
				if (currNode.next[c-'a'] == null) {
					currNode.next[c-'a'] = new TrieNode();
				}
				currNode = currNode.next[c-'a'];
			}
			currNode.words.add(word);
		}
	}
	private void findSquare(List<List<String>> rslt,int len, List<String> temp) {
		if (temp.size() == len) {
			rslt.add(new ArrayList<String>(temp));
			return;
		}
		int indx = temp.size();
		System.out.println("indx is " + indx + " ad temp is " + temp);
		StringBuilder sb = new StringBuilder();
		for(String s:temp) {
			sb.append(s.charAt(indx));
		}
		String s = sb.toString();
		System.out.println("s the string is " + s + "len is " + s.length());
		TrieNode node = root;
		for(int i = 0; i < s.length(); i++) {
			System.out.println("Inside that s length loop..." + i);
			if ( node.next[s.charAt(i)-'a'] != null) {
				node = node.next[s.charAt(i)-'a'];
			} else {
				node = null;
				break;
			}
		}
		if (node != null) {
			for(String nxt: node.words) {
				temp.add(nxt);
				System.out.println("now curr contains...." + temp);
				findSquare(rslt,len,temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		String[] words = {"area","lead","wall","lady","ball"};
		WordSquares ws = new WordSquares(words);
		List<List<String>> rslt = ws.getWordSquares();
		for(List<String> lst : rslt) {
			System.out.println("list is " + lst);
		}

	}

}
