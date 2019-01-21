package com.venkat.leetfree;
/*
 * 
 * Sentence Screen Fitting
* Question
*  Solution
*
* Given a rows x cols screen and a sentence represented by a list of non-empty words, find how many times the given sentence can be fitted on the screen.
*
* Note:
*
* A word cannot be split into two lines.
* The order of words in the sentence must remain unchanged.
* Two consecutive words in a line must be separated by a single space.
* Total words in the sentence won't exceed 100.
* Length of each word is greater than 0 and won't exceed 10.
* 1 ≤ rows, cols ≤ 20,000.
* Example 1:
*
* Input:
* rows = 2, cols = 8, sentence = ["hello", "world"]
*
* Output: 
* 1
*
* Explanation:
* hello---
* world---
*
* The character '-' signifies an empty space on the screen.
* Example 2:
*
* Input:
* rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
*
* Output: 
* 2
*
* Explanation:
* a-bcd- 
* e-a---
* bcd-e-
*
* The character '-' signifies an empty space on the screen.
* Example 3:
*
* Input:
* rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
*
* Output: 
* 1
*
* Explanation:
* I-had
* apple
* pie-I
* had--
*
* The character '-' signifies an empty space on the screen.
 * 
 */
public class SentenceScreenFit {
	int rows;
	int cols;
	String[] sentence;
	int numTimes;
	public SentenceScreenFit(int rows, int cols, String[] sentence) {
		this.rows = rows;
		this.cols = cols;
		this.sentence = sentence;
		this.numTimes = 0;
		findFit();
	}
	private void findFit() {
		String sent = "";
		for(String x:this.sentence) {
				sent += x + " ";
		}
		int slen = sent.length();
		
		int i = 0;
		int pos = 0;
		
		while (i < rows) {
			pos += cols;
			if (sent.charAt(pos % slen) == ' ')
				pos++;
			else {
				while ( sent.charAt( (pos-1) % slen ) != ' ' )
					pos--;
			}
			i++;
		}
		this.numTimes = pos/slen;
	}

	public static void main(String[] args) {
		int rows = 8, cols = 8;
		String[] sentence = {"hello","world"};
		
		SentenceScreenFit ssf1 = new SentenceScreenFit(rows,cols,sentence);
		System.out.println(" result is " + ssf1.numTimes);

		rows = 3;
		cols = 12;
		String[] sentence1 = {"a","bcd","e"};
		ssf1 = new SentenceScreenFit(rows,cols,sentence1);
		System.out.println(" result is " + ssf1.numTimes);
		

		rows = 4;
		cols = 5;
		String[] sentence2 = {"I","had","apple","pie"};
		ssf1 = new SentenceScreenFit(rows,cols,sentence2);
		System.out.println(" result is " + ssf1.numTimes);
	}

}
