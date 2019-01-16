package Other;

import java.util.*;

//Question: https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix{
	public static List<Integer> spiralOrder(int[][] nums){
		//Similar idea as rotate image
		//we divide them into different layer
		List<Integer> res = new ArrayList<Integer>();
		if(nums == null||nums.length == 0|| nums[0].length== 0){
			return res;
		}
		//Because the array is not necessarly n*n
		//so the number of layer is determined by the smaller width or length;
		int min = Math.min(nums.length,nums[0].length);
		int layerNum = min/2;
		for(int layer = 0;layer<layerNum;layer++){
			for(int i = layer;i<nums[0].length-1-layer;i++){
				res.add(nums[layer][i]);
			}
			for(int i = layer;i<nums.length-1-layer;i++){
				res.add(nums[i][nums[0].length-1-layer]);
			}
			for(int i = layer;i<nums[0].length-1-layer;i++){
				res.add(nums[nums.length-1-layer][nums[0].length-1-i]);
			}
			for(int i = layer;i<nums.length-1-layer;i++){
				res.add(nums[nums.length-1-i][layer]);
			}
		}
		//if layer is odd, we need to add one remain row or col
		if(min%2 ==1 ){
			if(min == nums.length){
				for(int i = layerNum;i< nums[0].length-layerNum;i++){
					res.add(nums[layerNum][i]);
				}
			}else{
				for(int i = layerNum;i<nums.length-layerNum;i++){
					res.add(nums[i][layerNum]);
				}
			}
		}
		return res;
	}

	public static void main(String[] args){
		int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
		List<Integer> res = spiralOrder(nums);
		for(Integer num: res){
			System.out.print(num+" ");
		}
	}

}