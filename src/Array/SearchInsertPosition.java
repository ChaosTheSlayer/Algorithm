package Array;

import java.util.*;

public class SearchInsertPosition{

	public static int searchInsert(int[] nums,int target){
		//I think the idea will be like this
		//do binary search, if we find the target, we return the index, 
		//if not we try to find the index of the smallest element that bigger than 
		//given target, so if that's exist, that's where we should put it. 

		//if it doesn't, means ,the new element is the biggest, return the length of 
		//the array

		if(nums == 0 || nums.length == 0){
			return 0;
		}
		int left = 0;
		int right = nums.length-1;
		while(left<=right){
			int mid = (left+right)/2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] < target){
				left = mid+1;
			}else{
				right = mid-1;
			}
			
		}
		//it actually will be looks like that
		//the smallest element that bigger than target exist
		// if(left <nums.length){
		// 	return left;
		// }else{
		// 	//at this stiuation it doesn't exsit, so we should insert it at the end of the array
		// 	//but at the situation, left == num.length;
		// 	return nums.length;
		// }
		return left;
	}
}