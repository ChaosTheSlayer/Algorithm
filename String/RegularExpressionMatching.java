package Algorithm.String;

//Question: https://leetcode.com/problems/regular-expdpsion-matching/
import java.util.*;

public class RegularExpressionMatching{

    //Brute Force solution
    //We have two pointers, i for string a, b for string b
    //there will be two kinds situations,
    //when p(j+1) is not *, this is easy case
    //we just check a.charAt(i) == b.charAt(j) ('.' is consider eaquals too.

    //when p(j+1) is *, so if a[i],a[i+1],a[i+2] ...a[i+k] is equal to b.charAt(j), we need to check all that situation

    public static boolean isMatchBF(String a, String b){
        return helper(a,b,0,0);
    }

    private static boolean helper(String a, String b, int i ,int j){
        if(j == b.length()){
            return i == a.length();
        }
        //b.charAt(j+1) is not '*'
        //or right now we are at the last character of b, we need to check if i has pass the last character of  character
        //the reason we need to check if j == b.length() -1 is that, because we need to check stuation that 
        //charAt(j+1) is out of bound
        if(j == b.length()-1 || b.charAt(j+1) != '*'){
            if(i == a.length() || a.charAt(i) != b.charAt(j) && b.charAt(j) != '.'){
                return false;
            }else{
                return helper(a,b,i+1,j+1);
            }
        }

        //b.charAt(j+1) is '*'
        
        while(i<a.length()&&(a.charAt(i) == b.charAt(j) || b.charAt(j) == '.')){
            if(helper(a,b,i,j+2)){
                return true;
            }
            i++;
        }
        return helper(a,b,i,j+2);
    }


    //Now we try to use DP to solve this problem, suppose we have dp[i][j] and all the previous dpult
    //There will be different kinds of situation
    //First, b.charAt(j) is not '*'. So we just need to check a.charAt(i) == b.charAt(j) or not '.' is consider as same
    //so if the characters are same and dp[i][j] is true, dp[i+1][j+1] is true

    //Second if b.charAt(j) is '*', but b.charAt(j-1) is not '.'
    //dp[i+1][j+1] will be true under following situation
    //dp[i+1][j] is true, means that we only take the character before '*' one time, 
    //dp[i+1][j-1] is true, means that we don't take the character before '*'.
    //dp[i][j+1] is true, and a.charAt(i-1) = a .charAt(i) and a.charAt(i-1)  == b.charAt(j-1)
    //which means since we got '*', so if there are duplicates we can keep matching
    //a.charAt(i-1) == a.charAt(i) check if they are duplicate, a.charAt(i-1) == b.charAt(j-1) check if the
    //duplicate is the character the right before '*'

    //Third situation, if b.charAt(j) is '*', b.charAt(j-1) is '.'
    //Since ".*" can match any string, so if dp[i+1][j-1] or dp[i+1][j] is true
    //any other dp[i+1][j+1]....dp[i+1][b.length()] is true


    public static boolean isMatchDP(String a,String b){
        if(a.length() == 0 && b.length() == 0){
            return true;
        }
        if(b.length() == 0){
            return false;
        }
        boolean[][] dp = new boolean[a.length()+1][b.length()+1];
        dp[0][0] = true;
        for(int j = 0;j<b.length();j++){
            if(b.charAt(j) != '*'){
                for(int i = 0;i<a.length();i++){
                    if(a.charAt(i) == b.charAt(j) || b.charAt(j) == '.'){
                        dp[i+1][j+1] = dp[i][j];
                    }
                }
            }else{
                if(j<1){
                    //if j is 0, so '*' is useless
                    //just skip
                    continue;
                }
                //we also need to check if string a is empty
                //because '*' could be 0 or any number of character before itself
                //so we can ignore the character before '*'
                if(j>0 && dp[0][j-1]){ 
                    dp[0][j+1] = true;
                }
                if(b.charAt(j-1) != '.'){
                    for(int i = 0;i<a.length();i++){
                        if(dp[i+1][j] || dp[i+1][j-1] ||(i>0 && dp[i][j+1]&& a.charAt(i) == a.charAt(i-1) && a.charAt(i-1) == b.charAt(j-1))){
                         dp[i+1][j+1] = true;
                        }
                    }
                    
                }else{
                    int i = 0;
                    while(i<a.length() && !dp[i+1][j] && !dp[i+1][j-1]){
                        i++;
                    }
                    for(;i<a.length();i++){
                        dp[i+1][j+1] = true;
                    }
                }

            }
        }
        return dp[a.length()][b.length()];
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        if(isMatchBF(a,b)){
            System.out.println("It's Match!");
        }else{
            System.out.println("It's not Match!");
        }
        sc.close();
    }

}
