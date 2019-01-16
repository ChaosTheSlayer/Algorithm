package Array;

import java.util.*;

//Question: https://leetcode.com/problems/3sum/

public class ThreeSum{
	//Idea, since in this question, we need to filter all the duplicates, so if we didn't sort it or using hashmap 
	//to check duplicate, that will be a little complecated
	//so I am thinking about sort the original array, and if we say duplicates, we only calculate it one time
	//so the total complexity should be (nlogn+n^2) = O(n^2)
	   public static List<List<Integer>> threeSum(int[] nums){
		if(nums == null || nums.length == 0){
			return new ArrayList<List<Integer>>();
		}
		//sort the input aray first
		Arrays.sort(nums);
		//After that, we traverse each element
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		for(int i = nums.length-1;i>=2;i--){
			//we start from the end of array, to get more organized result
			//it really doesn't matter
			//also if we saw duplicates, we just call the helper function at the first time
			if(i <nums.length-1 && nums[i+1] == nums[i]){
				continue;
			}
			List<List<Integer>> curRes = twoSumHelper(nums,-nums[i],i-1);
			for(int j = 0;j<curRes.size();j++){
				curRes.get(j).add(nums[i]);
			}
			res.addAll(curRes);
		}
		return res;

	}

	private static List<List<Integer>> twoSumHelper(int[] nums,int target,int end){
		int left = 0;
		int right = end;
		List<List<Integer>> res = new ArrayList<List<Integer>>();

		while(left < right){
			
			if(nums[left] + nums[right] == target){
				List<Integer> item = new ArrayList<Integer>();
				item.add(nums[left]);
				item.add(nums[right]);
				res.add(item);
				left++;
				right--;
				//skip duplicates too
				//remember we should check nums[left] == nums[left-1]
				//is current left and previous left
				//this kind of stuff is always where bugs occurs
				while(left<right && nums[left] == nums[left-1]){
					left++;
				}
				while(right>left && nums[right] == nums[right+1]){
					right--;
				}
			}else if(nums[left] +nums[right] < target){
				left++;
			}else{
				right--;
			}
		}
		return res;
	}
}