package com.TripAdvisor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ArraysPrac {
	
	public static void main(String[] args) {
		int[] nums = {1, 14, 0, 4, 7, 8, 3, 5, 7};
		findPairs(nums, 11);
		findSecondLargest(nums);
		findTwoMin(nums);
		findLongestSubString("abcabcbb");
		findLongestSubString("bbbbb");
		findLongestSubString("pwwkew");
		findLongestSubString("dvdf");
		lengthOfLongestSubstring("dvdf");
		stringImmutable();
		System.out.println("Length of kongest substring = "+longestSubstringWithoutMapOrSet("dvdf"));

	}
	//find pairs of integers summing to given total.  

	public static void findPairs(int[] nums, int total) {
		if(nums.length < 2) {
			return;
		}
		
		Arrays.sort(nums);
		
		int left = 0;
		int right = nums.length - 1;
		while(left < right) {
			int sum = nums[left] + nums[right];
			if(sum == total) {
				System.out.println("("+ nums[left] + "," + nums[right] + ")");

				left = left + 1;
				right = right - 1;
			} else if(sum < total) {
				left = left + 1;
			} else if(sum > total) {
				right = right - 1;
			}
		}
	}

	public static void findSecondLargest(int[] nums) {
		if(nums.length < 2) {
			return;
		}
		
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		
		for(int n : nums) {
			if(n > first) {
				second = first;
				first = n;
			} else if(n < first && n > second){
				second = n;				
			}
		}
		if(second == Integer.MIN_VALUE) 
			System.out.println("There is no second largest element");
		System.out.println("First largest = "+first+"second largest = "+second);
	}
	
	public static void findTwoMin(int[] nums) {
		if(nums.length < 2) {
			return;
		}
		
		int first = Integer.MAX_VALUE;
		int second = Integer.MAX_VALUE;
		
		for(int n : nums) {
			if(n < first) {
				second = first;
				first = n;
			} else if(n > first && n < second){
				second = n;				
			}
		}
		if(second == Integer.MAX_VALUE) 
			System.out.println("There is no second smallest element");
		System.out.println("First minimum = "+first+"second minimum = "+second);
	}
	
	public static void findLongestSubString(String s) {
		String str = "";
		System.out.println(s);

		char[] c = s.toCharArray();
		int j = 0, len = 0;
		for(int i = 1; i <= s.length(); i++) {
			if(!str.contains(Character.toString(c[i-1]))) {
				str = s.substring(j, i);
			} else {
				j++;
				if(j==i-1) 
					str = Character.toString(s.charAt(j));
				else
					i = j+1;
					str = s.substring(j, i);
			}
			len = Math.max(str.length(), len);
			System.out.println(str+" : "+" j = "+j+" i=" +i+"len="+len);
		}
		System.out.println("Longest substring without repeating characters is of length: "+len);
	
	}
	
	public static void stringImmutable() {
		String s = "Pallavi";
		s.concat("Pudakalakatti");
		System.out.println(s); //will print Pallavi
		s = s.concat(" Pudakalakatti!");
		System.out.println(s); //will print Pallavi Pudakalakatti!

	}
	public static void lengthOfLongestSubstring(String s) {
	    			   
		    int len = s.length();
		    HashSet<Character> set = new HashSet<>();
		    int i=0,j=0,max = 0; 
		    
		    while(i<len&&j<len){
		        if(!set.contains(s.charAt(i))) {
		        	set.add(s.charAt(i++));
		        	max = Math.max(max,i-j);
		        }
		        else {
		        	set.remove(s.charAt(j++));
		        }
		    }
	    System.out.println(max);
	    
	}
	
	//Passed all 983 test cases. Solution accepted on LeetCode. 
	//Below solution does not use HashSet or HashMap.
	    public static int longestSubstringWithoutMapOrSet(String s) {
	     String str = "";
			System.out.println(s);

			char[] c = s.toCharArray();
			int j = 0, len = 0;
			for(int i = 1; i <= s.length(); i++) {
				if(!str.contains(Character.toString(c[i-1]))) {
					str = s.substring(j, i);
				} else {
					j++;
					if(j==i-1) 
						str = Character.toString(s.charAt(j));
					else
						i = j+1;
						str = s.substring(j, i);
				}
				len = Math.max(str.length(), len);
	        }
	        return len;	

	    }

}
