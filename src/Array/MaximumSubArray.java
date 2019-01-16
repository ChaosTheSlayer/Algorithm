package Array;

import java.util.*;
public class MaximumSubArray{

	//I would say this is classic dynamic programming problem
	//we need to maitain to variable, localMax and globalMax
	//localMax means the maximum sum we can get which must include current element
	//globalMax means the best result we can get so far

	//local[i] = max(local[i-1]+nums[i],nums[i])
	//global[i] = max(global[i-1],local[i])
	//global will contain all the possible solution, because if it doesn't include current element
	//it will be mantained in previous global 
	//if it does, it hast to be the localmax
	public static int maxSubArray(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int global  = nums[0];;
		int local = nums[0];
		for(int i = 0;i<nums.length;i++){
			local = Math.max(local+nums[i],nums[i]);
			global = Math.max(global,local);
		}
		return global;
	}

	//if we want to return the subarray
	public static List<Integer> maxSubArr(int[] nums){
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null || nums.length == 0){
			return res;
		}
		int global  = nums[0];
		int local = nums[0];
		int end = 0;
		for(int i = 1;i<nums.length;i++){
			local = Math.max(local+nums[i],nums[i]);
			if(local > global){
				end = i;
			}
			global = Math.max(local,global);
		}
		while(global != 0){
			res.add(0,nums[end]);
			global -= nums[end--];
		}
		return res;
	}

	public static void main(String[] args){
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

		System.out.println(maxSubArray(nums));
		List<Integer> res = maxSubArr(nums);
		System.out.println(res.size());
		for(Integer num:res ){
			System.out.print(num+ " ");
		}
	}
}