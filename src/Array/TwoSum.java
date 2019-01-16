package Array;
//Question: https://leetcode.com/problems/two-sum/

import java.util.*;

public class TwoSum{

    //Two Kinds of solution
    //First one, using hashmap to store the number and it's corresponding index

    //Time Complexity O(n)
    //Space COmplexity O(n)
    public static int[] twoSumMap(int[] nums,int target){
        if(nums == null || nums.length == 0){
            return null;
        }

        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0;i<nums.length;i++){
            int diff = target-nums[i];
            if(map.containsKey(diff)){
                int[] res = {map.get(diff)+1,i+1};
                return res;
            }
            map.put(nums[i],i);
        }
        return null;
    }

    //Second one: make a copy of input array, and sort the copy one, using two pointer, one pointer start at 0, another start at the end of the array, if the sum of two number that the pointers point to is equal the target, remember the two number, and find the index of them in the originmal array
    //If bigger than target, move the right pointer
    //otherwise, move the left pointer

    public static int[] twoSumArrayCopy(int[] nums,int target){
        if(nums == null || nums.length == 0){
            return null;
        }

        int[] copyArray = Arrays.copyOfRange(nums,0,nums.length+1);
        Arrays.sort(copyArray);
        int left = 0;
        int right = copyArray.length-1;
        int num1 = -1;
        int num2 = -1;
        for(int i = 0;i<copyArray.length;i++){
            if(copyArray[left]+copyArray[right] == target){
                num1 = copyArray[left];
                num2 = copyArray[right];
                break;
            }else if(copyArray[left]+copyArray[right] > target){
                right--;
            }else{
                left++;
            }
        }
        int index1 = -1;
        int index2 = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == num1 || nums[i] == num2){
                if(index1 == -1){
                    index1 = i+1;
                }else{
                    index2 = i+1;
                    break;
                }
            }
        }
        int[] res = {index1,index2};
        // Arrays.sort(res);
        return res;
    }

    public static List<String> twoSumDuplicate(int[] nums,int target){
        List<String> res = new ArrayList<String>();
        if(nums == null || nums.length == 0){
            return res;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0;i<nums.length;i++){
            int diff = target-nums[i];
            if(set.contains(diff)){
                res.add(String.format("%s,%s",diff,nums[i]));
            }
            set.add(nums[i]);
        }

        return res;
    }



    public static void main(String[] args){
        int[] nums = {1,3,7,3,6,5,0,3,9,4,2};
        int[] res1 = twoSumMap(nums,9);
        System.out.println(res1[0]+ " "+ res1[1]);
        int[] res2 = twoSumArrayCopy(nums,9);
        System.out.println(res2[0]+ " " + res2[1]);
        List<String> res3 = twoSumDuplicate(nums,9);
        for(String s : res3){
            System.out.println(s);
        }
    }
}

