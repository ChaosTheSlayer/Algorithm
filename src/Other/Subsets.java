package Other;

public class Subsets{

	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        Arrays.sort(nums);
        List<Integer> item = new ArrayList<Integer>();
        for(int i = 1;i<=nums.length;i++){
            helper(res,item,nums,0,i);
        }
        res.add(new ArrayList<Integer>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> item, int[] nums,int start, int len){
        if(item.size() == len){
            res.add(new ArrayList<Integer>(item));
            return;
        }
        for(int i = start;i<nums.length;i++){
            item.add(nums[i]);
            helper(res,item,nums,i+1,len);
            item.remove(item.size()-1);
        }
    }
}