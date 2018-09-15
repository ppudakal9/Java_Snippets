package com.snippets;

public class MaxIslandArea {
    public int maxAreaOfIsland(int[][] grid) {
        int max_area = 0;
        for(int i = 0; i < grid.length; i++)
            for(int j = 0; j < grid[0].length; j++)
                if(grid[i][j] == 1)max_area = Math.max(max_area, AreaOfIsland(grid, i, j));
        return max_area;
    }
    
    public int AreaOfIsland(int[][] grid, int i, int j){
        if( i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + AreaOfIsland(grid, i+1, j) + AreaOfIsland(grid, i-1, j) + AreaOfIsland(grid, i, j-1) + AreaOfIsland(grid, i, j+1);
        }
        return 0;
    }

    public static void main(String[] args) {
    	
    	int[][] grid = new int[][] {{0,0,1,0,0,0,0,1,0,0,0,0,0},
    	                             {0,0,0,0,0,0,0,1,1,1,0,0,0},
    	                             {0,1,1,0,1,0,0,0,0,0,0,0,0},
    	                             {0,1,0,0,1,1,0,0,1,0,1,0,0},
    	                             {0,1,0,0,1,1,0,0,1,1,1,0,0},
    	                             {0,0,0,0,0,0,0,0,0,0,1,0,0},
    	                             {0,0,0,0,0,0,0,1,1,1,0,0,0},
    	                             {0,0,0,0,0,0,0,1,1,0,0,0,0}};
    	MaxIslandArea obj = new MaxIslandArea();
    	System.out.println("Max area = "+obj.maxAreaOfIsland(grid));

    }
}
