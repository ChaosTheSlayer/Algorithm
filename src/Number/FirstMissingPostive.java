package Number;

public class FirstMissingPositive{

	// 既然不能用额外空间，那就只有利用数组本身，跟Counting sort一样，
	// 利用数组的index来作为数字本身的索引，把正数按照递增顺序依次放到数组中。
	// 即让A[0]=1, A[1]=2, A[2]=3, ... , 
	// 这样一来，最后如果哪个数组元素违反了A[i]=i+1即说明i+1就是我们要求的第一个缺失的正数。
	// 对于那些不在范围内的数字，我们可以直接跳过，比如说负数，0，或者超过数组长度的正数，
	// 这些都不会是我们的答案。
	public static int firstMissingPositive(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		//basic idea is that if we see a negative value, we simply ignore it
		//for a positive value, we try to put it at the same index as it value
		//for example, if number 5, we try to put it in the 5th position of array

		//after we done that, we can simply traverse the array
		//if the number within current position doesn't match it's index
		//then that's the number we are looking for
		for(int i = 0;i<nums.length;i++){
			//current element doesn't bigger than the length, is positive and haven't been swaped yet
			if(nums[i] <= nums.length && nums[i] > 0 && nums[nums[i]-1] != nums[i]){
				int temp = nums[nums[i]-1];
				nums[nums[i]-1] = nums[i];
				nums[i] = temp;
				i--;
				//remember i--, because the number after the swap we still need to check 
			}
		}

		for(int i = 0;i<nums.length;i++){
			if(nums[i] != i+1){
				return i+1;
			}
		}
		return nums.length+1;
	}
}