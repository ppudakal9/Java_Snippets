package com.snippets;

public class DutchNationFlagProblem {
	
	public void swap(int l, int h, int[] arr) {
		int temp = arr[l];
		arr[l] = arr[h];
		arr[h] = temp;
	}
	public int[] sortArray(int[] arr) {
		
		int low = 0, mid = 0, high = arr.length - 1;
		
		while (mid <= high) {
			if (arr[mid] == 0) {
				swap(low, mid, arr);
				low+=1;
				mid+=1;
			} else if (arr[mid] == 1) {
				mid+=1;
			} else if (arr[mid] == 2) {
				swap(mid, high, arr);
				high-=1;
			}
			
		}
		return arr;
		
	}
	public static void main(String[] args) {
		DutchNationFlagProblem obj = new DutchNationFlagProblem();
		int[] input = {2,2,2,0,0,0,0,1,1};
		input = obj.sortArray(input);
		for (int i : input) {
			System.out.print(i+" ");
		}
	}
}
