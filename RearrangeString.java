package com.venkat.leetfree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeString {

	public RearrangeString() {
		// TODO Auto-generated constructor stub
	}
	public static String rearrangeString(String str, int k) {
	    if(k==0)
	        return str;
	 
	    //initialize the counter for each character
	    final HashMap<Character, Integer> map = new HashMap<Character, Integer>();
	    for(int i=0; i<str.length(); i++){
	        char c = str.charAt(i);
	        if(map.containsKey(c)){
	            map.put(c, map.get(c)+1);
	        }else{
	            map.put(c, 1);
	        }
	    }
	 
	    //sort the chars by frequency
	    PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>(){
	        public int compare(Character c1, Character c2){
	            if(map.get(c2).intValue()!=map.get(c1).intValue()){
	                return map.get(c2)-map.get(c1);
	            }else{
	                return c1.compareTo(c2);
	            }
	        }
	    });
	 
	 
	    for(char c: map.keySet())
	        queue.offer(c);
	 
	    StringBuilder sb = new StringBuilder();
	 
	    int len = str.length();
	 
	    while(!queue.isEmpty()){
	 
	        int cnt = Math.min(k, len);
	        ArrayList<Character> temp = new ArrayList<Character>();
	 
	        for(int i=0; i<cnt; i++){
	            if(queue.isEmpty())
	                return "";
	 
	            char c = queue.poll();
	            sb.append(String.valueOf(c));
	            System.out.println("sb now is " + sb);
	 
	            map.put(c, map.get(c)-1);
	 
	            if(map.get(c)>0){
	                temp.add(c);
	            }
	 
	            len--;
	        }
	 
	        for(char c: temp)
	            queue.offer(c);
	    }
	 
	    return sb.toString();
	}
	public static void main(String[] args) {
		String s = "aabbcc";
		int k = 3;
		System.out.println(" returned string is " + rearrangeString(s,k));
		System.out.println(" returned string 2 is " + rearrString2(s,k));
		
		s = "aaaabbaacc";
		k = 2;
		System.out.println(" returned string is " + rearrangeString(s,k));
		System.out.println(" returned string 2 is " + rearrString2(s,k));
	}
	public static String rearrString2(String str,int k) {
		if (k == 0)
			return str;
		
		// count the number of chars
		int len = str.length();
		Map<Character,Integer> frqMap = new HashMap<>();
		for(int i = 0; i <  len;i++) {
			frqMap.put(str.charAt(i), 1 + frqMap.getOrDefault(str.charAt(i), 0));
		}
		
		PriorityQueue<Character> pq = new PriorityQueue<Character>( 
					(x,y)->{ if (frqMap.get(x) == frqMap.get(y))
								return (x.compareTo(y));
							 else
								 return (frqMap.get(y) - frqMap.get(x)); });
		
		for(Character ch: frqMap.keySet()) {
			pq.offer(ch);
		}
		StringBuffer sb = new StringBuffer();
		while (!pq.isEmpty()) {
			int cnt = Math.min(k, len);
			List<Character> temp = new ArrayList<Character>();
			for(int i = 0; i < cnt; i++) {
				if (pq.isEmpty())
					return "";
				
				char ch = pq.poll();
				sb.append(String.valueOf(ch));
				frqMap.put(ch,frqMap.get(ch)-1);
				if (frqMap.get(ch) > 0)
					temp.add(ch);
				len--;
			}
			for(Character cch:temp)
				pq.offer(cch);
		}
		return (sb.toString());
	}

}
