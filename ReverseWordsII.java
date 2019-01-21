package com.venkat.leetfree;
/*
*  * Given an input string, reverse the string word by word. A word is defined as 
* a sequence of non-space characters.
*
* The input string does not contain leading or trailing spaces and the words 
* are always separated by a single space.
*
* For example,
* Given s = "the sky is blue",
* return "blue is sky the".
* 
* Reverse -- each word - letter by letter
* eht yks si eulb - reverse the entire reversed....
* blue is sky the
* Could you do it in-place without allocating extra space?
*
* Related problem: Rotate Array
*
* Update (2017-10-16):
* We have updated the function signature to accept a character array, 
* so please reset to the default code definition by clicking on the reload 
* button above the code editor. Also, Run Code is now available!
*/
public class ReverseWordsII {

	public ReverseWordsII() {
		// TODO Auto-generated constructor stub
	}
	public static void reverseWords(char[] chs) {
		// reverse each word except last one in place
		int idx = 0;
		for(int i = 0 ; i < chs.length; i++) {
			if (chs[i] == ' ') {
				reverseWord(chs,idx,i-1);
				idx = i+1;
			}
		}
		
		// reverse the last word...
		reverseWord(chs,idx, chs.length-1);
		
		// now reverse the entire string...
		reverseWord(chs,0,chs.length-1);
	}
	public static void reverseWord(char[] charr, int x, int y) {
		while (x < y) {
			char curr = charr[x];
			charr[x] = charr[y];
			charr[y] = curr;
			x++;
			y--;
		}
	}
	public static void main(String[] args) {
		String s = "The sky is blue and red and white";
		char[] chs = s.toCharArray();
		
		System.out.println("String before .. " + s);
		
		reverseWords(chs);
		
		printChs(chs);

	}
	public static void printChs(char[] chary){
		for(int i = 0 ; i < chary.length;i++) {
			System.out.print(chary[i]);
		}
		System.out.println();
	}

}
