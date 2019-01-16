package Number;

//Question:https://leetcode.com/problems/climbing-stairs/

public class Solution{
	 public int climbStairs(int n) {
        //斐波那契数列
        if(n<=0){
            return 0;
        }
        if(n<=2){
            return n;
        }
        int[] res = new int[3];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2;i<=n;i++){
            res[2] = res[0]+res[1];
            res[0] = res[1];
            res[1] = res[2];
        }
        return res[2];
    }
}