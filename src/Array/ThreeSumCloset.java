package Array;

import java.util.*;

public class ThreeSumCloset{
	//This is similar to three sum 
	//So the idea is similar to 3Sum
	//is just that for a certain num[i], our helper fucntion should return the closet sum to target -num[i]
	public static int closetSum(int[] nums,int target){
		//Assume there will be a valid out put, so no corner cases
		Arrays.sort(nums);
		//we have a variable that check the smallest diff we get from target
		int diff = Integer.MAX_VALUE;
		for(int i = 0;i<nums.length-2;i++){
			//we have a function, return the smallest differ from target
			int cur  = helper(nums,i+1,target-nums[i]);
			//remember each step , we need to calculate the absolute value of diff
			if(Math.abs(cur)<Math.abs(diff)){
				diff = cur;
			}
		}
		return diff+ target;
	}

	//this function will calculate all the  possible two sum, and return the difference with smallest absolute value
	
	private static int helper(int[] nums,int start, int target){
		int left = start;
		int right = nums.length-1;
		int closet = Integer.MAX_VALUE;
		while(left < right){
			if(nums[left] + nums[right] == target){
				//equal, then we return 0 as diff
				return 0;
			}
			//always the absolute value
			if(Math.abs(nums[left]+nums[right] - target) < Math.abs(closet)){
				closet = nums[left] + nums[right];
			}
			//move the left and right accordingly
			if(nums[left] +nums[right] < target){

				left++;
			}else{
				right--;
			}
		}
		return closet;
	}

	public static void main(String[] args){
		int[] nums = {1,2,4,8,16,32,64,128};
		System.out.println(closetSum(nums,82));
	}
}