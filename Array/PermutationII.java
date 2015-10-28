package Algorithm.Array;

//Question: https://leetcode.com/problems/permutations-ii/

//This is very similar to permutationI, only  there will be duplicates
//Dealing with duplicates, always remember sort first, so that duplicates will
//stay together, is much easy for us to dealiing with them 

// So when saw a duplicate, we should only call recursive fuction of dfs at the first time
//we saw it.

//How to check that, we have a visited array to mark the visited node
//so we nums[i] == nums[i-1] && visited[i-1] == false, that's means it's the first time we 
//do the recursion, otherwise the visited[i-1] will be set back to true;
import java.util.*;

public class PermutationII{

	public static List<List<Integer>> permuteUnique(int[] nums){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums == null || nums.length == 0){
			return res;
		}
		Arrays.sort(nums);
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
			if(i>0 && visited[i-1] == false && nums[i] == nums[i-1]){
				continue;
			}
			if(!visited[i]){
				curRes.add(nums[i]);
				visited[i] = true;
				helper(res,curRes,visited,nums);
				visited[i] = false;
				curRes.remove(curRes.size()-1);
			}
		}
	}
}