package Tree;

public class ValidateBinarySearchTree{

	public boolean isValidBST(TreeNode root) {
        return helper(root,null,null);
    }
    
    //left is the lower bound, right is the uper bound
    //recursively call the function
    private boolean helper(TreeNode root, TreeNode left,TreeNode right){
        if(root == null){
            return true;
        }
        if(left != null && left.val >= root.val || right != null && right.val <=root.val){
            return false;
        }
        return helper(root.left,left,root) && helper(root.right,root,right);
    }

    //Another solution is that do a inorder traversal of the bst, and maintain the previous node
    public boolean isValidBST(TreeNode root) {
        List<Integer> pre = new ArrayList<Integer>();
        pre.add(null);
        return helper(root,pre);
        
    }
    private boolean helper(TreeNode root,List<Integer> pre){
        if( root == null){
            return true;
        }
        boolean left = helper(root.left,pre);
        if(left == false){
            return false;
        }
        if(pre.get(0) != null && root.val <= pre.get(0)){
            return false;
        }
        pre.set(0,root.val);
        return helper(root.right,pre);
    }
}