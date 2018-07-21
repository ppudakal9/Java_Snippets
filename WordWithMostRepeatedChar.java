package com.snippets;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class WordWithMostRepeatedChar {
	
	public int mostRepeatedChar(String word) {
		
		char[] charArr = word.toCharArray();
		int maxCount = 0;
		Map<Character, Integer> hmCount = new HashMap<Character, Integer>();
		
		for(char c : charArr) {
			if(hmCount.containsKey(c)) {
				hmCount.put(c, hmCount.get(c)+1);
			} else {
				hmCount.put(c, 1);
			}
		}
		
		maxCount = Collections.max(hmCount.values());
		return maxCount;
	}
	
	public void wordWithMostRepeatedChar(String sentence) {
		int max = 0;
		sentence = sentence.replaceAll("[!?,.]", "");
		String[] words = sentence.split("\\s+");
		int value = 0;
		String answer = "";
		for(String word : words) {
			value = mostRepeatedChar(word);
			if(max < value) {
				max = value;
				answer = word;
			}
		}
		System.out.println("Word with most repeated character is - " + answer);
	}

	public static void main(String[] args) {
		WordWithMostRepeatedChar obj = new WordWithMostRepeatedChar();
		String input = "O Romeo, Romeo, wherefore art thou Romeo?";
		obj.wordWithMostRepeatedChar(input);
		String input2 = "Some people feel the rain, while others just get wet.";
		obj.wordWithMostRepeatedChar(input2);
	}
}
