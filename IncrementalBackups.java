package com.snippets;

import java.util.Arrays;
import java.util.TreeSet;

public class IncrementalBackups {
	public int[] incrementalBackups(int lastBackupTime, int[][] changes) {
		
		int len = changes.length;
		TreeSet<Integer> increments = new TreeSet<Integer>();
		for(int i = 0; i < len; i++) {
			if(changes[i][0] - lastBackupTime > 0) {
				increments.add(changes[i][1]);
			}
		}
		int[] returnArr = new int[increments.size()];
		int index = 0;
		for(int i : increments) {
			returnArr[index] = i;
			index++;
		}
		return returnArr;
	}
	
	public static void main(String[] args) {
		IncrementalBackups obj = new IncrementalBackups();
		int lastBackupTime = 461620205;
		int[][] changes = new int[7][2];
		changes[0][0] = 461620203;
		changes[0][1] = 1;
		changes[1][0] = 461620204;
		changes[1][1] = 2;
		changes[2][0] = 461620205;
		changes[2][1] = 6;
		changes[3][0] = 461620206;
		changes[3][1] = 5;
		changes[4][0] = 461620207;
		changes[4][1] = 3;
		changes[5][0] = 461620207;
		changes[5][1] = 5;
		changes[6][0] = 461620208;
		changes[6][1] = 1;
		
		int[] increments = obj.incrementalBackups(lastBackupTime, changes);
		System.out.println(Arrays.toString(increments));
	}
}
