package String;

//Question: https://leetcode.com/problems/string-to-integer-atoi/

//Basically, whatwe need to do is that convert a given string into corresponding integer
//So there will be a lot of corner cases
//First positive or negative 
//Integer out of bound problem

//There will be 3 kinds of condition to end the loop
//Current character is invalid,ignore all the character after current character, return the result based on previous characters
//Integer outof bound, return the closest integer
//the input String end

public class StringToInteger{

    public static int strToInt(String str){
        if(str == null || str.length() == 0){
            return 0;
        }
        //remove the space
        str = str.trim();
        if(str.length() == 0){
            return 0;
        }
        int res = 0;
        int i = 0;
        //check if it's negative
        boolean negative = false;
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            if(str.charAt(i) == '-'){
                negative = true;
            }
            i++;
        }
        while(i<str.length()){
            if(str.charAt(i) < '0' || str.charAt(i) > '9'){
                break;
            }
            int digit = (int) str.charAt(i) - '0';
            if(negative == false && res > (Integer.MAX_VALUE-digit)/10){
                return Integer.MAX_VALUE;
            }else if(negative && res > -((Integer.MIN_VALUE+digit)/10)){
                return Integer.MIN_VALUE;
            }
            res = res*10+digit;
            i++;
        }
        return negative?res*(-1):res;
    }

    public static void main(String[] args){
        String input = "-322213";
        System.out.println(strToInt(input));
    }
}

