package Algorithm.Number;

//Question: https://leetcode.com/problems/next-permutation/

public class NextPermutation{

	public static  void nextPermutation(int[] nums){
		//According to wiki, the solution should be 
		//Step One: Start from the end of the array, find the first element that smaller than the element
		//at its right side

		//Step Two: There will be two situation: 
		// Situation one: no such element exist, which means that current is the largest permutation
		//so we just need to reverse current list
		// Situation two: such element exist, so we start from be back again, and find the first element larger than 
		//the element we found in previous step
		//swap them, and reverse all the element after the element we found in previous step

		if(nums == null || nums.length == 0){
			return;
		}
		//just assume the input is valid
		int i = nums.length-2;
		while(i>=0 && nums[i] >= nums[i+1]){
			i--;
		}
		if(i>=0){
			int j = nums.length-1;
			while(nums[j] <=nums[i]){
				j--;
			}
			swap(nums,i,j);
		}
		reverse(nums,i+1);
	}

	private static void swap(int[] nums,int left,int right){
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}

	private static void reverse(int[] nums,int start){
		int left = start;
		int right = nums.length-1;
		while(left<right){
			swap(nums,left,right);
			left++;
			right--;
		}
	}
}