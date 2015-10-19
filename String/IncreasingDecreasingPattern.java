package Algorithm.String;

import java.util.*;

//Give a string only contains "i" and "d", we only allow to use integer from 1 to 9 once, when saw a "i" the next number should bigger than current, when we saw "d", the next number should be smaller than current"

//return the string that following above pattern, assume the input is valid, and the length of input string will smaller than 8


//My idea is that using following facts
//Since 'i' stand for increase,and 'd' stands for decrease, and the input is valid
//assume all the number that corresponding to 'i', we use the bigger integer from 1-9(start from 9)
//and all the number that corresponding to 'd', we use the smaller integer from 1-9(start from 2, because 1 is the first in the result)
//since the input is valid, so the nums that i used is alway bigger than the number that d used, so whenever we //saw a 'i' and 'd' combine together, they are always valid

//but what if we saw 'iiiii' or 'ddddd'
//so what we need to do is that we reverse both iNum and dNum we used, we use the smallest iNum first(same for the dNum

//So in that case, cases like 'iiiii' or 'dddd' will not become a problem
public class IncreasingDecreasingPattern{

    public static String incDecPattern(String input){
        int i = 9;
        int d = 2;
        Set<Integer> dPos = new HashSet<Integer>();
        StringBuilder iNum = new StringBuilder();
        StringBuilder dNum = new StringBuilder();
        for(int j = 0;j<input.length();j++){
            if(input.charAt(j) == 'i'){
                iNum.append(i);
                i--;
            }else{
                dPos.add(j+1);
                dNum.append(d);
                d++;
            }
        }
        StringBuilder res = new StringBuilder();
        iNum.reverse();
        dNum.reverse();
        for(int j = 0;j<=input.length();j++){
            if(j == 0){
                res.append(1);
            }else if( dPos.contains(j)){
                res.append(dNum.charAt(0));
                dNum.deleteCharAt(0);
            }else{
                res.append(iNum.charAt(0));
                iNum.deleteCharAt(0);
            }
        }
        return res.toString();
    }

    

    public static void main(String[] args){
        String input = "iiiiiddd";
        System.out.println("Result is "+incDecPattern(input));
        String input2 = "ididid";
        System.out.println("Result is "+ incDecPattern(input2));
    }
}

