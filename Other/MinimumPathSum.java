package Algorithm.Other;

//Question: https://leetcode.com/problems/minimum-path-sum/

public class MinimumPathSum{

	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] res= new int[n];
        res[0] = grid[0][0];
        for(int i = 1;i<n;i++){
            res[i] = res[i-1]+grid[0][i];
        }
        for(int i = 1;i<m;i++){
            for(int j = 0;j<n;j++){
                if(j == 0){
                    res[j] += grid[i][j];
                }else{
                    res[j] = Math.min(res[j-1],res[j])+grid[i][j];
                }
            }
        }
        return res[n-1];
    }
}