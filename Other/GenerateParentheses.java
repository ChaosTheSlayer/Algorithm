package Algorithm.Other;

// Question:https://leetcode.com/problems/generate-parentheses/
import java.util.*;
public class GenerateParentheses{

	//idea is that using DFS to solve this
	//but rememeber, the left parenthesis should always bigger or equal than the right one
	public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if(n <= 0){
        	return res;
        }
        helper(res,0,0,n,"");
        return res;
    }

    private static void helper(List<String> res, int leftNum,int rightNum,int n,String curRes){
    	if(rightNum > leftNum){
    		return;
    	}
    	if(leftNum == n && rightNum == n){
    		res.add(curRes);
    		return;
    	}
    	if(leftNum >n || rightNum > n){
    		return;
    	}
    	helper(res,leftNum+1,rightNum,n,curRes+'(');
    	helper(res,leftNum,rightNum+1,n,curRes+')');


    }


    //What if we want to know how many diffrent solutions
    //I think we might be able to use dynamic programming to solve this

    //Remember, the left need always bigger or equal to left side
    //so we can use dp to solve this
    //suppose dp[i][j] means how many combinations we have when we have i left parentheses, j right parentheses
    // where always i>=j
    //so the equation dp[i][j] = dp[i-1][j] + dp[i][j-1]

    //because when i-1 >= j, so i also >=j, 
    //similar about dp[i][j-1] because dp[i][j-1] means that i>=j-1, and also i>=j, so it's also valid
    public static int generateParenthesisDP(int n ){
    	if(n <= 0){
    		return 0;
    	}
    	int[][] dp = new int[n+1][n+1];
    	for(int i = 0;i<=n;i++){
    		dp[i][0] = 1;
    	}
    	for(int i = 1;i<=n;i++){
    		for(int j = 1;j<=n&&j<=i;j++){
    			dp[i][j] = dp[i][j-1] +dp[i-1][j];
    		}
    	}
    	return dp[n][n];
    }

    public static void main(String[] args){
    	List<String> res = generateParenthesis(5);
    	System.out.println("We have "+res.size()+" different combinations!");
    	System.out.println("We have "+generateParenthesisDP(5)+" different combinations!");
    }
}