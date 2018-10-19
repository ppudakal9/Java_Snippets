package com.snippets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
	
	private Map<Character, char[]> map = new HashMap<Character, char[]>();
	
	LetterCombinations() {
		this.map.put('2', new char[] {'a', 'b', 'c'});
		this.map.put('3', new char[] {'d', 'e', 'f'});
		this.map.put('4', new char[] {'g', 'h', 'i'});
		this.map.put('5', new char[] {'j', 'k', 'l'});
		this.map.put('6', new char[] {'m', 'n', 'o'});
		this.map.put('7', new char[] {'p', 'q', 'r', 's'});
		this.map.put('8', new char[] {'t', 'u', 'v'});
		this.map.put('9', new char[] {'w', 'x', 'y', 'z'});
	}
	public List<String> comb(String digits) {
		List<String> list = new ArrayList<String>();
		if(digits.equals("")) {
			return list;
		}
		StringBuilder sb = new StringBuilder();
		int currIndex = 0;
		
		combDFS(digits, sb, list, currIndex);
		return list;
	}
	
	public void combDFS(String digits, StringBuilder sb, List<String> list, int index) {
		if(index >= digits.length()) {
			list.add(sb.toString());
			return;
		}
		
		char[] cArr = this.map.get(digits.charAt(index));
		
		for(char c : cArr) {
			sb.append(c);
			combDFS(digits, sb, list, index+1);
			//delete last char appended to the string in order to form more combinations
			sb.deleteCharAt(sb.length() - 1);
		}
		
	}
	public static void main(String[] args) {
		LetterCombinations combinations = new LetterCombinations();
		String input = "23";
		System.out.println(combinations.comb(input));
	}
}
