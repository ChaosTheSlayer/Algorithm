package Algorithm.Number;

//Question: https://leetcode.com/problems/combination-sum-ii/
import java.util.*;
public class CombinationSumII{
	public static List<List<Integer>> combinationSumm2(int[] candidates,int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0){
			return res;
		}
		helper(res,new ArrayList<Integer>(),candidates,0,target);
		return res;
	}

	private static void helper(List<List<Integer>> res, List<Integer> curRes,int[] candidates,int index, int target){
		
		if(target == 0){
			res.add(new ArrayList<Integer>(curRes));
			return;
		}
		//out of bound or invalid answer
		if(target <0 || index >= candidates.length){
			return;
		}
		//very similar to combination sum I
		//just in this case the next recursion, we pass index+1 as input
		//so same number we only use once

		for(int i = index;i<candidates.length;i++){
			//also to avoid duplicates, we only call recursive function once when we sall 
			//the number for the first time

			//for example, when in we dealing with [*,1,1,*,7,*]
			//if we didn't do this , first time we saw 1, we will call a recursive at first 1
			//we can get a 1,7
			//we we see the next 1, we will get another 1,7 in another recursion

			//what if 1,1,1,

			//basically idea is that, if a element can be use as many times as we want,
			//there is no need to worry about duplicates, just skip every duplicate

			//however, otherwise, we need to make sure, that for all the duplicates of one element
			//we only call recursive function one for each duplicate

			//all the combination of duplicates will be considered in the first call
			//when i = index; 
			if(i > index && candidates[i] == candidates[i-1]){
				continue;
			}
			curRes.add(candidates[i]);
			helper(res,curRes,candidates,i+1,target-candidates[i]);
			curRes.remove(curRes.size()-1);
		}
	}
}