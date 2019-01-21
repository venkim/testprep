package com.venkat.gfg.dynprog;

public class WordBreak {

	public WordBreak() {
		// TODO Auto-generated constructor stub
	}

	static String[] dictionary = {"mobile","samsung","sam","sung",
            "man","mango","icecream","and",
            "go","i","like","ice","cream"};
	public static boolean dictContains(String word) {
		for(int i = 0 ; i < dictionary.length ; i++) {
			if ( dictionary[i].equals(word))
				return true;
		}
		return false;
	}
	public static boolean wordBreak(String sentence) {
		int len = sentence.length();
		if ( len == 0)
			return true;
		
		for(int i = 1 ; i <= sentence.length(); i++) {
			if ( dictContains(sentence.substring(0, i)) &&
					wordBreak(sentence.substring(i)) )
					return (true);
		}
		
		return (false);
	}
	public static boolean wordBreakDP(String sent) {
		int len = sent.length();
		if ( len == 0 )
			return true;
		boolean[]  dpwb = new boolean[len+1];
		
		for(int i = 1; i <= len ; i++) {
			if ( dpwb[i] == false && dictContains(sent.substring(0, i)))
					dpwb[i] = true;
			

			// if dpwb is true, then check all substring from there on
			if ( dpwb[i] == true) {

				if (i == len )
					return ( true );
				
				for(int j = i+1; j < len ; j++) {
					if ( dpwb[j] == false && dictContains( sent.substring(i,j)) ) {
						dpwb[j] = true;
					}
					if (j == len && dpwb[j] == true)
						return true;
				}
			}
		}
		return (false);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sent = "ilikesamsung";
		System.out.println("sentence = " + sent + " wordBreak = " + wordBreak(sent) );
		System.out.println("sentence = " + sent + " wordBreakDP = " + wordBreakDP(sent) );
		
		sent = "ilikesamsungmangoicecream";
		System.out.println("sentence = " + sent + " wordBreak = " + wordBreak(sent) );
		System.out.println("sentence = " + sent + " wordBreakDP = " + wordBreakDP(sent) );
		
		sent = "ilikesamsungkajaicecream";		
		System.out.println("sentence = " + sent + " wordBreak = " + wordBreak(sent) );
		System.out.println("sentence = " + sent + " wordBreakDP = " + wordBreakDP(sent) );
		
	}
}
