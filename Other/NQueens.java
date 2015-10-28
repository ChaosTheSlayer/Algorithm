package Algorithm.Other;

//Question: https://leetcode.com/problems/n-queens/

// The n-queens puzzle is the problem of placing n queens on an n×n chessboard 
// such that no two queens attack each other.

// Given an integer n, return all distinct solutions to the n-queens puzzle.

// Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' 
// and '.' both indicate a queen and an empty space respectively.

//Basically idea is that using recursion to solve this
//try to put queens in each diffirent block, see if there will be a valid answer

// to check if a placement is valid, we need to with in the attack range, there is no other queens

//General idea is that using an array to mark the position that a queen is place
//while traversing, we try to put queens on each column of current line, if it's valid we 
//traversal to the next line

//since the pervious result must be valid, then we only need to deal with last recursion. 
//so we can use a 1 dementional array to mark instead of two dimentional 

import java.util.*;
public class NQueens{

	public static List<List<String>> solveNQueens(int n){
		List<List<String>> res = new ArrayList<List<String>>();
		if(n <=0){
			return res;
		}
		//this is to mark for each column, the row number of queens.
		int[] colForRow = new int[n];
		helper(res,colForRow,0,n);
		return res;
	}

	private static void helper(List<List<String>> res,int[] colForRow,int row,int n){
		if(row == n){
			//we got a valid answer;
			List<String> curRes = new ArrayList<String>();
			for(int i = 0;i<n;i++){
				StringBuilder sb = new StringBuilder();
				for(int j = 0;j<n;j++){
					if(colForRow[i] == j){
						sb.append('Q');
					}else{
						sb.append('.');
					}
				}
				curRes.add(sb.toString());

			}
			res.add(curRes);
		}
		for(int i = 0;i<n;i++){
			colForRow[row] = i;
			if(isValid(colForRow,row)){
				helper(res,colForRow,row+1,n);
			}
		}
		
	}

	private static boolean isValid(int[] colForRow,int row){
		for(int i = 0;i<row;i++){
			if(colForRow[i] == colForRow[row] || Math.abs(colForRow[i]-colForRow[row]) == row-i ){
				return false;
			}
		}
		return true;
	}
}
