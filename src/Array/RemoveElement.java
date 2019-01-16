package Array;

//Questions:https://leetcode.com/problems/remove-element/

public class RemoveElements{

	public static int removeElements(int[] nums,int val){
		//still two pointer
		//what we want to do is that swap all the elment in nums with val to the end of nums

		//we will have two pointers
		// one start from 0
		int left = 0;
		//another at the end of the array
		int right = nums.length-1;
		while(left<=right){
			if(nums[left] == val){
				//the element that right points to still might equals to val, so we cannot change move left pointer
				swap(nums,left,right);
				//but current right is gurateed to be val, so move it
				right--;
			}else{
				//left is not val
				//move the left pointer
				left++;
			}
		}
		return left;
	}

	//So first we need to have a swap function
	private static void swap(int[] nums,int left,int right){
		if(left< 0 || right > nums.length-1 || left>right){
			return;
		}
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
	}
}
