package Array;

public class RemoveDuplicateFromSortedArray{
//Question: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
public static int removeDuplicates(int[] nums){
		//Idea is still using two pointer to do that
		//one keep moving right until it points to a different number
		//then set the left pointer to this value, and moving
		int walker = 0;
		int runner = 0;
		while(runner <nums.length){
			if(runner == 0 || (runner>0 &&nums[runner] != nums[runner-1])){
				nums[walker++] = nums[runner];
			}
			runner++;
		}
		return walker;
	}
}