package Other;

//Question: https://leetcode.com/problems/trapping-rain-water/

public class TrappingRainWater{
	//Solution:
	//So the basic idea is that:
	//for a centain height[i], we mantain the highest height on its left side
	//and also the highest height on its right side
	//so if the smaller one among left and right max is bigger than the height of current index
	//so at this specific index, it will have water trapped
	//then what we need to do is that just add them together
	public static int trap(int[] height){
		if(height == null || height.length == 0){
			return 0;
		}
		int[] container = new int[height.length];
		int max = 0;
		//for the first element in height, its left max is 0
		for(int i=0;i<height.length;i++){
			container[i] = max;
			max = Math.max(height[i],max);
		}
		max = 0;
		int res = 0;
		for(int i = height.length-1;i>=0;i--){
			//maintain the smaller one among to maxs
			container[i] = Math.min(max,container[i]);
			max = Math.max(height[i],max);
			//if the smaller one of two max is great than current height
			//add the difference into the result
			res += container[i]-height[i] >0? container[i]-height[i]: 0;
		}
		return res;
	}
}