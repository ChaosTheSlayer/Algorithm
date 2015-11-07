package Algorithm.Tree;

public class InOrderTraversal{

	//Recursive
	public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root,res);
        return res;
    }
    
    private void helper(TreeNode root,List<Integer> res){
        if(root == null){
            return;
        }
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }

    //Iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new  ArrayList<Integer>();
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        while(root != null || !stack.isEmpty()){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}