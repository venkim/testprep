package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.List;

/*
 * Given a set of words (without duplicates), find all word squares you can build from them.
 *
 *	A sequence of words forms a valid word square if the kth row and column 
 * read the exact same string, where 0 ≤ k < max(numRows, numColumns).

 * For example, the word sequence ["ball","area","lead","lady"] forms a word 
 * square because each word reads the same both horizontally and vertically.

 * b a l l
 * a r e a
 * l e a d
 * l a d y
 * Note:
 * There are at least 1 and at most 1000 words.
 * All words will have the exact same length.
 * Word length is at least 1 and at most 5.
 * Each word contains only lowercase English alphabet a-z.
 * Example 1:
 * 
 * Input:
 * ["area","lead","wall","lady","ball"]
 * 
 * Output:
 * [
 * [ "wall",
 *   "area",
 *   "lead",
 *   "lady"
 * ],
 *  [ "ball",
 *   "area",
 *   "lead",
 *   "lady"
 * ]
 * ]
 *
 *  Explanation:
 * The output consists of two word squares. The order of output does not matter 
 * (just the order of words in each word square matters).
 * Example 2:
 *
 *  Input: 
  * ["abat","baba","atan","atal"]
 *
 *Output:
 * [
  *[ "baba",
  *  "abat",
  *  "baba",
  *  "atan"
  *],
  *[ "baba",
  *  "abat",
  *  "baba",
  *  "atal"
  *]
 * ]
 * 
 * Explanation:
 * The output consists of two word squares. The order of output does not matter 
 * (just the order of words in each word square matters).
 * 
 */
public class WordSquares2 {
	String[] words;
	TrieNode root;
	static class TrieNode {
		List<String> words;
		TrieNode[] next;
		public TrieNode() {
			words = new ArrayList<String>();
			next = new TrieNode[26];
		}
	}
	public WordSquares2(String[] words) {
		this.words = words;
		root = new TrieNode();
	}
	public void buildTrie() {
		
		for(String word: words) {
			TrieNode currNode = root;
			char[] chary = word.toCharArray();
			for(char ch : chary) {
				currNode.words.add(word);
				if (currNode.next[ch-'a'] == null)
					currNode.next[ch-'a'] = new TrieNode();
				currNode = currNode.next[ch-'a'];
			}
			currNode.words.add(word);
		}
	}
	public List<List<String>> getWordSquares(){
		List<List<String>> rslt = new ArrayList<>();
		if (words.length == 0)
			return rslt;
		buildTrie();
		int len = words[0].length();
		findSquares(rslt,len,new ArrayList<String>());
		return (rslt);
	}
	public void findSquares(List<List<String>> rslt, int len, List<String> temp) {
		if (temp.size() == len) {
			rslt.add( new ArrayList<String>(temp));
			return;
		}
		int index = temp.size();
		StringBuilder sb = new StringBuilder();
		for(String s: temp) {
			sb.append(s.charAt(index));
		}
		String s = sb.toString();
		TrieNode node = root;
		
		for(int i = 0;i < s.length();i++) {
			if (node.next[s.charAt(i)-'a'] != null) {
				node = node.next[s.charAt(i)-'a'];
			} else {
				node = null;
				break;
			}
		}
		if (node != null) {
			for(String nxt : node.words) {
				temp.add(nxt);
				findSquares(rslt, len, temp);
				temp.remove(temp.size()-1);
			}
		}
	}
	public static void main(String[] args) {
		String[] words =  {"area","lead","wall","lady","ball"};
		WordSquares2 ws2 = new WordSquares2(words);
		
	}

}
