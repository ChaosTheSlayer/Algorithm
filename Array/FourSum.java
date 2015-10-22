package Alogrithm.Array;


import java.util.*;

//Question: https://leetcode.com/problems/4sum/

public class FourSum{
	//General Idea is that fourSum call three sum, three sum call two sum etc
	//so total complexity should be O(n^3)

	public static List<List<Integer>> fourSum(int[] nums,int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);

		//since we need ascending order
		//we need to start from back
		for(int i= nums.length-1;i>=3;i--){
			//dealing with duplicates
			if(i<nums.length-1 && nums[i] == nums[i+1]){
				continue;
			}
			List<List<Integer>> curRes = threeSum(nums,target-nums[i],i-1);
			for(int j = 0;j<curRes.size();j++){
				curRes.get(j).add(nums[i]);
			}
			res.addAll(curRes);
		}
		return res;
	}

	private static List<List<Integer>> threeSum(int[] nums,int target,int start){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for(int i = start;i>=2;i--){
			//dealing with duplicates
			if(i< start && nums[i] == nums[i+1]){
				continue;
			}
			List<List<Integer>> curRes = twoSum(nums,target-nums[i],i-1);
			for(int j = 0;j<curRes.size();j++){
				curRes.get(j).add(nums[i]);
			}
			res.addAll(curRes);
		}
		return res;
	}

	private static List<List<Integer>> twoSum(int[] nums, int target,int start){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		int left = 0;
		int right = start;
		while(left<right){
			if(nums[left] + nums[right] == target){
				List<Integer> item = new ArrayList<Integer>();
				item.add(nums[left]);
				item.add(nums[right]);
				res.add(item);
				left++;
				right--;
				while(left<right && nums[left] == nums[left-1]){
					left++;
				}
				while(left<right && nums[right] == nums[right+1]){
					right--;
				}
			}else if(nums[left]+nums[right] < target){
				left++;
			}else{
				right--;
			}
		}
		return res;

	}
}