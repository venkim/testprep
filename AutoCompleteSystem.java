package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Design a search autocomplete system for a search engine. Users may input a 
 * sentence (at least one word and end with a special character '#'). For each 
 * character they type except '#', you need to return the top 3 historical 
 * hot sentences that have prefix the same as the part of sentence already 
 * typed. Here are the specific rules:

 * The hot degree for a sentence is defined as the number of times a 
 * user typed the exactly same sentence before.
 * The returned top 3 hot sentences should be sorted by hot degree 
 * (The first is the hottest one). If several sentences have the same 
 * degree of hot, you need to use ASCII-code order (smaller one appears first).
 * If less than 3 hot sentences exist, then just return as many as you can. 
 * When the input is a special character, it means the sentence ends, 
 * and in this case, you need to return an empty list.
 * Your job is to implement the following functions:

 * The constructor function:
 */
public class AutoCompleteSystem {
	static class Node {
		String sentence;
		int times;
		Node(String st, int t){
			sentence = st;
			times = t;
		}
	}
	class Trie {
		Trie[] children = new Trie[27];
		int times;
	}
	public int getInt(char c) {
		if (c == ' ')
			return 26;
		else
			return (c-'a');
	}
	public void insert(Trie t, String s, int times) {
		for(int i = 0 ; i < s.length(); i++) {
			if (t.children[getInt(s.charAt(i))] == null)
				t.children[getInt(s.charAt(i))] = new Trie();
			t = t.children[getInt(s.charAt(i))];
		}
		t.times += times;
	}
	public List<Node> lookup(Trie t, String s){
		List<Node> rslt = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (t.children[getInt(s.charAt(i))] == null)
                return new ArrayList <Node> ();
            t = t.children[getInt(s.charAt(i))];
        }
        traverse(s, t, rslt);
        return rslt;		
	}
	public void traverse(String s, Trie t, List<Node> rslt) {
		if (t.times > 0) {
			rslt.add(new Node(s,t.times));
		}
		/***********
		for(char i = 'a'; i <= 'z' ; i++) {
			if (t.children[getInt(i)] != null) {
				traverse(s+i,t.children[getInt(i)],rslt);
			}
		}
		*************/
		for(int i = 0 ; i < 27 ; i++) {
			if (t.children[i] != null) {
				if (i == 26) {
					traverse(s+(char)(' '),t.children[i],rslt);
				} else {
					traverse(s+(char)('a'+i),t.children[i],rslt);
				}
			}
		}
		
	}
	Trie root;
	public AutoCompleteSystem(String[] sentences, int[] times) {
		root = new Trie();
		for(int i = 0 ; i < sentences.length; i++) {
			insert(root, sentences[i].toLowerCase(), times[i]);
		}
		
	}
	String cur_sent ="";
	public List<String> input(char c){
		List<String> res = new ArrayList<String>();
		if (c == '#') {
			insert(root, cur_sent, 1);
			cur_sent = "";
		} else {
			cur_sent += c;
			List<Node> list = lookup(root,cur_sent);
			Collections.sort(list,(a,b)->a.times==b.times ? a.sentence.compareTo(b.sentence) : (b.times-a.times));
			for(int i = 0 ; i < Math.min(3, list.size()) ; i++) {
				res.add(list.get(i).sentence);
			}
		}
		return (res);
	}
	public static void main(String[] args) {
		String[] sents = {"I love you","island","ironman","I love leetcode","i want to walk"};
		int[] times = {5,3,2,2,1};
		
		AutoCompleteSystem acs1 = new AutoCompleteSystem(sents,times);
		
		List<String> lst1 = acs1.input('i');
		System.out.println("List of i is " + lst1);
	}

}
