package Algorithm.Tree;

public class UniqueBinaryTree{
	 public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }
    //Still a NP Problem, so the time complexity should be expenential
    
    //The idea is that every time we pick a single node as root
    //recursively get all the possible left subtree, and right subtree
    //put different combinations to this root, and add it to the result
    private List<TreeNode> generate(int left,int right){
        List<TreeNode> res = new ArrayList<TreeNode>();
        if(left > right){
            res.add(null);
            return res;
        }
       for(int i = left;i<=right;i++){
           List<TreeNode> leftList = generate(left,i-1);
           List<TreeNode> rightList = generate(i+1,right);
           for(int j = 0;j<leftList.size();j++){
               for(int k = 0;k<rightList.size();k++){
                   TreeNode root = new TreeNode(i);
                   root.left = leftList.get(j);
                   root.right = rightList.get(k);
                   res.add(root);
               }
           }
       }
       return res;
    }
}