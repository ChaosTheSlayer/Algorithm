package Other;

import java.util.*;
public class NQueensII{

	public static int totalNQueens(int n) {
        //same idea with NQueens

        if(n<=0){
        	return 0;
        }
        int[] colForRow = new int[n];
        return helper(colForRow ,0,n);
    }

    private static int helper(int[] colForRow, int row, int n){
    	if(row == n){
    		return 1;
    	}
    	int res = 0;
    	for(int i = 0;i<n;i++){
    		colForRow[row] = i;
    		if(isValid(colForRow,row)){
    			res += helper(colForRow,row+1,n);
    		}
    	}
    	return res;
    }

    private static boolean isValid(int[] colForRow,int row){
    	for(int i = 0;i<row;i++){
    		if(colForRow[i] == colForRow[row] || Math.abs(colForRow[i]-colForRow[row]) == row-i){
    			return false;
    		}
    	}
    	return true;
    }
}