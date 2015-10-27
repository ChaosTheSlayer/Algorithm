package Algorithm.Permutation;

import java.util.*;
public class Permutation{


	//Question: https://leetcode.com/problems/permutations/

	// Given a collection of numbers, return all possible permutations.

	// For example,
	// [1,2,3] have the following permutations:
	// [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

	//E..basically Idea is that using DFS while using a boolean[] list to mark if current element
	//has been visited

	//
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return res;
		}
		boolean[] visited = new boolean[nums.length];
		helper(res,new ArrayList<Integer>(),visited,nums);
		return res;
	}

	private static void helper(List<List<Integer>> res, List<Integer> curRes, boolean[] visited,int[] nums){
		if(curRes.size() == nums.length){
			res.add(new ArrayList<Integer>(curRes));
			return;
		}
		for(int i = 0;i<nums.length;i++){
			if(visited[i]){
				continue;
			}
			curRes.add(nums[i]);
			visited[i] = true;
			helper(res,curRes,visited,nums);
			visited[i] = false;
			curRes.remove(curRes.size()-1);
		}
	}

	//Above is recursive solution, we can also using iteration solution
	//basic idea is that first we add have base resu [1]
	//and we try to insert other elements into the remain space

	public static List<List<Integer>> permuteIter(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null){
			return res;
		}
		List<Integer> initial = new ArrayList<Integer>();
		initial.add(nums[0]);
		res.add(initial);
		for(int i = 1;i<nums.length;i++){
			List<List<Integer>> curRes = new ArrayList<List<Integer>>();
			for(int j = 0;j<res.size();j++){
				List<Integer> cur = res.get(j);
				for(int k = 0;k<cur.size()+1;k++){
					List<Integer> item = new ArrayList<Integer>(cur);
					item.add(k,nums[i]);
					curRes.add(item);
				}
			}
			res = curRes;
		}
		return res;
	}
}