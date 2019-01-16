package Array;

import java.util.*;

public class PermutationArray{
    //check if two given array are permutations

    //Solution 1: sort two array, and then compare each element
    //TimeCoplexity: O(nlgn)
    //SpaceComplexity: O(1) if we are allowed to change the original array

    //Solution 2: using hashmap to connt the number of appereance of element in on array
    //and then compare it with the other one

    //Time Complexity:O(n);
    //Space Complexity:O(n);

    public static void isPermutationSpaceEff(int[] a, int[] b){
        if(a.length != b.length){
            System.out.println("They are not permutations!");
        }
        Arrays.sort(a);
        Arrays.sort(b);

        for(int i = 0;i<a.length;i++){
            if(a[i] != b[i]){
                System.out.println("They are not permutations");
                return;
            }
        }
        System.out.println("They are permutations!");
    }
    
    public static void isPermutationTimeEff(int[] a, int[] b){
        if(a.length != b.length){
            System.out.println("They are not permutations!");
        }
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<a.length;i++){
            if(!map.containsKey(a[i])){
                map.put(a[i],0);
            }
            map.put(a[i],map.get(a[i])+1);
        }
        for(int i = 0;i<b.length;i++){
            if(map.get(b[i]) <= 0){
                System.out.println("They are not permutations!");
                return;
            }
            map.put(b[i],map.get(b[i])-1);
        }
        System.out.println("They are permutations!");
    }


    public static void main(String[] args){
        int[] a = {3,1,6,7, 9,0,3,5,2};
        int[] b = {0,1,2,5,7,6,3,9,3};
        System.out.println("Space Efficiency!");
        isPermutationSpaceEff(a,b);
        System.out.println("Time Efficiency!");
        isPermutationTimeEff(a,b);
    }
}
