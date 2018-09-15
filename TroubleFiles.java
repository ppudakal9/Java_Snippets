package com.snippets;

import java.util.Arrays;

public class TroubleFiles {

    int[] troubleFiles(int[][] files, int[] backups) {
        int[] result = new int[backups.length];
        int endTime = 0;
        int fileIndex = 0;
        for (int i = 0; i < backups.length; i++) {
            int conflict = 0;
            if (endTime < backups[i]) {
                endTime = backups[i];
                while (fileIndex < files.length && files[fileIndex][0] <= backups[i]) {
                    endTime += files[fileIndex][1];
                    fileIndex++;
                }
                conflict = 0;
                while (fileIndex < files.length && files[fileIndex][0] <= endTime) {
                    conflict++;
                    fileIndex++;
                }
            }
            result[i] = conflict;
        }
        return result;
    }
    public static void main(String[] args) {
		TroubleFiles obj = new TroubleFiles();
		int[][] changes = new int[5][2];
		changes[0][0] = 461618501;
		changes[0][1] = 3;
		changes[1][0] = 461618502;
		changes[1][1] = 1;
		changes[2][0] = 461618504;
		changes[2][1] = 2;
		changes[3][0] = 461618506;
		changes[3][1] = 5;
		changes[4][0] = 461618507;
		changes[4][1] = 6;
		
		int[] backups = new int[5];
		backups[0] = 461618501;
		backups[1] = 461618502;
		backups[2] = 461618504;
		backups[3] = 461618505;
		backups[4] = 461618506;
		
		System.out.println(Arrays.toString(obj.troubleFiles(changes, backups)));
    }

}
