package Algorithm.Array;

//Question:https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedArray{
	//We can still using binary search
	//get the mid
	//if left > mid ,then mid to right is in order
	//if left < mid, then left to mid is in order
	//cut correspondingly


	//if there is duplicate 
	   public static int search(int[] nums,int target){
		if(nums == null || nums.length == 0){
			return -1;
		}
		int left =0;
		int right = nums.length-1;
		while(left<=right){
			int mid = (left+right)/2;
			if(nums[mid] == target){
				return mid;
			}
			if(nums[left] > nums[mid]){
				//remember the right edge might equal to target
				if(nums[mid]<target && nums[right]>=target){
					left = mid+1;
				}else{
					right = mid-1;
				}
			}else if (nums[left] < nums[mid]{
				if(nums[left]<=target && target<nums[mid]){
					right = mid-1;
				}else{
					left = mid+1;
				}
			}else{
				left++;
			}
		}
		return -1;
	}

}