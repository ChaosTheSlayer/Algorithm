package Algorithm.Array;

import java.util.*;

public class UniquePath{

    public static int uniquePath(int m,int n){
        if(m <0 || n <0){
            return -1;
        }
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        return helper(map,0,0,m,n);       
    }

    private static int helper(HashMap<String,Integer> map, int curm,int curn,int targetm,int targetn){
        if(curm == targetm-1 && curn == targetn-1){
            return 1;
        }
        if(curm >=targetm || curn >= targetn){
            return 0;
        }

        if(map.containsKey(String.format("%s.%s",curm,curn)))
            return map.get(String.format("%s.%s",curm,curn));
        int right = helper(map,curm,curn+1,targetm,targetn);
        int down = helper(map,curm+1,curn,targetm,targetn);
        map.put(String.format("%s.%s",curm,curn),right+down);
        return right+down;

    }
    
    public static void main(String[] args){
        System.out.println(uniquePath(9,7));
    }
}
        

