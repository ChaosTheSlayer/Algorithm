package Array;

//Question: https://leetcode.com/problems/palindrome-number/

public class PalindromeNumber{

    public static boolean palinNumber(int x){
        if(x < 0){
            return false;
        }
        
        int div = 1;
        while(div <=x/10){
            div *= 10;
        }

        while(x != 0){
            if(x%10 != x/div){
                return false;
            }
            x = x%div;
            x = x/10;
            div /= 100;
        }
        return true;
    }

    public static void main(String[] args){
        int x1 = 3223;
        if(palinNumber(x1)){
            System.out.println(x1+"is Palindrome Number!");
        }else{
            System.out.println(x1+"is not Palindrome Number!");
        }
    }
}

