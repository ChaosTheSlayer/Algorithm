package Algorithm.Other;

public class JumpGame{

// Question: https://leetcode.com/problems/jump-game-ii/
// 	Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Your goal is to reach the last index in the minimum number of jumps.

// For example:
// Given array A = [2,3,1,1,4]

// The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

	// 只是原来的全局最优现在要分成step步最优和step-1步最优（假设当前步数是step）。
	// 当走到超过step-1步最远的位置时，说明step-1不能到达当前一步，我们就可以更新步数，将step+1。
	// 时间复杂度仍然是O(n)，空间复杂度也是O(1)。
	public static  int jump(int[] nums){
		//just greddy to solve this
		//we tarversal the input list
		//while traversing we mantian the maximum distance that we can reach by add visited list
		//only increase the step we current index is larger than lastreach

		if(nums == null || nums.length == 0){
			return 0;
		}
		//the maximum we can reach, we get it by adding them together
		int reach = 0;
		//the maximum we can reach at previous step
		int lastreach = 0;
		//the step we take 
		int step = 0;
		for(int i = 0;i<=reach && i<nums.length;i++){
			//when current index is bigger than our last jump
			if(i>lastreach){
				lastreach = reach;
				step++;
			}
			//we maintain a global reach, and every loop we consider at to maintain a global reach 
			//and a local reach
			//global reach is the maximum jump distance
			//local reach is if we stop at current location, the maximum jump distance
			reach = Math.max(reach,nums[i]+i);
		}
		//when the input is not valid
		if(reach < nums.length-1){
			return 0;
		}
		return step;
	}

	//idea is that for an element in nums, nums[i]+i is the maximum reach distance
	//then we find the maximum jump distance in this range, it should be the jump point
	//until jump distance is at the end of the array
	public static String jumpPath(int[] nums){
		if(nums == null || nums.length == 0){
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int reach = 0;
		int index = 0;
		sb.append(0);
		while(reach < nums.length-1){
			reach = index+nums[index];
			int j = index +1;
			int nextReach = j+nums[j];
			int nextJumpPoint = j;
			while( j <= reach){
				if(nums[j]+j > nextReach){
					nextJumpPoint = j;
					nextReach = j+nums[j];
				}
				j++;
			}
			reach = nextReach;
			index = nextJumpPoint;
			sb.append("->").append(index);
		}
		sb.append("->").append(nums.length-1);
		return sb.toString();
		


	}
	public static void main(String[] args){
		int[] nums = {2,3,1,5,1,4,1,1,2,4};
		System.out.println("Minimum step is "+ jump(nums));
		System.out.println("Path is "+ jumpPath(nums));
	}
}