package com.snippets;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalanceParentheses {
	
	private Map<Character, Character> map = new HashMap<Character, Character>();
	
	public BalanceParentheses() {
		this.map.put('}', '{');
		this.map.put(']', '[');
		this.map.put(')', '(');
	}
	
	public boolean balance(String str) {
		char[] arr = str.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		int index = 0;
		char top = ' ';
		
		while (index < arr.length) {
			if (arr[index] == '(' || arr[index] == '{' || arr[index] == '[') {
				stack.push(arr[index]);
			} else if (arr[index] == ')' || arr[index] == '}' || arr[index] == ']') {
				if (!stack.isEmpty()) {
					top = stack.pop();
					if (top != this.map.get(arr[index])) {
						return false;
					}
				}
			}
			index+=1;
		}
		
		if (stack.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		BalanceParentheses obj = new BalanceParentheses();
		String[] inputArr = {"This is a {string}.", "{}][", "([]{})"};
		for (String input : inputArr) {
			if(obj.balance(input)) {
				System.out.println("String : "+input+" is Valid!");
			} else {
				System.out.println("String : "+input+" is not Valid!");
			}
		}
	}
}
