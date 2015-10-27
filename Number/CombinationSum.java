package Algorithm.Number;

//Question: https://leetcode.com/problems/combination-sum/

public class CombinationSum{
	//So Obviously using DFS to solve this
	//Since we have to maintain order, we need to sort first, it will also help 
	//to deal with duplicate
	public static List<List<Integer>> combinationSum(int[] candidates,int target){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(candidates == null || candidates.length == 0){
			return res;
		}
		//sort first
		Arrays.sort(candidates);
		helper(res,new ArrayList<Integer>(),candidates,0,target);
		return res;
	}

	private static void helper(List<List<Integer>> res, List<Integer> curRes, int[] candidates,int index,int target){
		//if currently target is 0
		//that means we got a result
		//so we make a copy of curRes and add it to res
		//we can not add curRes directly because, curRes will still be used for other recursivion
		if(target == 0){
			res.add(new ArrayList<Integer>(curRes));
			return;
		}
		if(target <0){
			return;
		}
		//go throught remain elements,
		for(int i = index;i<candidates.length;i++){
			//if we see a duplicates, we just skip it
			//because next recursive call we still using current i as index
			//that's because even though duplicate is not allowed, 
			//but a same element can be use multiple times.
			if(i>index && candidates[i] == candidates[i-1]){
				continue;
			}
			curRes.add(candidates[i]);
			helper(res,curRes,candidates,i,target-candidates[i]);
			curRes.remove(curRes.size()-1);
		}
	}

}