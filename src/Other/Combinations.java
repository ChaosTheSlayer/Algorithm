package Other;

//Question: https://leetcode.com/problems/combinations/

public class Combinations{

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(n <=0 || k<=0){
            return res;
        }
        int[] nums = new int[n];
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++){
            nums[i] = i+1;
        }
        helper(res,new ArrayList<Integer>(),nums,visited,0,k);
        return res;
    }
    
    private void helper(List<List<Integer>> res,List<Integer> item,int[] nums,boolean[] visited,int index,int k ){
       
        if(item.size() == k){
            res.add(new ArrayList<Integer>(item));
            return;
        }
         if(item.size() > k || index >= nums.length){
            return;
        }
        for(int i = index;i<nums.length;i++){
            if(nums[i] != -1){
                item.add(nums[i]);
                visited[i] = true;
                helper(res,item,nums,visited,i+1,k);
                visited[i] = false;
                item.remove(item.size()-1);
            }
        }
    }
}