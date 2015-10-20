package Algorithm.String;

import java.util.*;

//Question:https://leetcode.com/problems/longest-palindromic-substring/

public class LongestPalin{

    //Two idea, first, for each center of given string, we try to go both left and right, until we found different character
    // during the process, we maitain the longest palindromic string
    // by center, I mean, each character and the space between characters, for example, string "abc", there will be 5 centers
    //Time Complexity,there will be (2n-1) centers, for each center, the check operaton is O(n)
    //So total complexity is O(n^2)

    public static String longestPalinString(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        
        String longestPalin = "";
        for(int i = 0;i<2*str.length();i++){
            int left = i/2;
            int right = i/2;
            if(i%2 == 1){
                right +=1;
            }

            String curPalin = helper(str,left,right);
            longestPalin = curPalin.length()>longestPalin.length()? curPalin:longestPalin;
        }

        return longestPalin;
    }

    private static String helper(String str,int left, int right){
        while(left>=0  && right <=str.length()-1 && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }
        return str.substring(left+1,right);
    }

    //Another way is to use dynamic programming to solve this
    //we use to loops to solve this, the outerloop we start from the end of the array
    //and the inner loop we start from the current outloop index to the end of array
    //so in this case, we will have all the previous information we already need.

    public static String longestPalinDP(String str){
        if(str == null || str.length() == 0){
            return null;
        }
        boolean[][] dp = new boolean[str.length()][str.length()];
        int maxLen = Integer.MIN_VALUE;
        //store all these information, all us to us ay less as substring operation as possible
        //because from java7, is an O(n) operation
        int start = -1;
        for(int i = str.length()-1;i>=0;i--){
            for(int j = i;j<str.length();j++){
                if(str.charAt(i) == str.charAt(j) &&(j-i <=2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                    if(maxLen<(j-i+1)){
                        maxLen = j-i+1;
                        start = i;
                     }   
                }
            }
        }
        return start == -1?"":str.substring(start,start+maxLen);
    }




    public static void main(String[] args){
        String str = "wowaaaaw";
        System.out.println(longestPalinDP(str));
    }
}



            
