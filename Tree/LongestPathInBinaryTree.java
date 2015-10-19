package Algorithm.Tree;

import java.util.*;

//The longest path in a binary tree is always from one leave to another leave
//which by defination is called Diameter

public class LongestPathInBinaryTree{
    static  class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }
    }

    //The complexity is O(n^2)

    public static int diameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        int leftDiameter = diameter(root.left);
        int rightDiameter = diameter(root.right);

        return Math.max(1+leftHeight+rightHeight,Math.max(leftDiameter,rightDiameter));
    }

    public static int height(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1+Math.max(height(root.left),height(root.right));
    }
    
    //Above code has O(n^2) complexity, we can get O(n) complexity by 
    //simply using following logic

    // Every path in the tree must formed as the left height of a certain node+ the right height of this certian node + 1
    //so what we need to do is that while we doing recursive(like DFS) to get the max height of binary tree
    //we also calculate for the path of current node during the recursion

    //so for each root, we already have the previous result, so we don't need to calculate again
    
    //Thus, the complexity shoule be a simple DFS, which is O(n)

    public static int diameterOpt(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        helper(root,res);
        return res.get(0);

    }
    
    //The helper function return the height of tree
    private static int helper(TreeNode root, List<Integer> res){
        //when root is null, return 0
        if(root == null){
            return 0;
        }
        //leftHeight
        int leftHeight = helper(root.left,res);
        //rightHeight
        int rightHeight = helper(root.right,res);
        //we calculate the path that from left most left of current root to right deepest leaf of current root
        int cur = 1+leftHeight+rightHeight;
        if(cur>res.get(0)){
            res.set(0,cur);
        }
        return 1+Math.max(leftHeight,rightHeight);
    }


    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(-3);
        root.right.left.right = new TreeNode(13);
        System.out.println("The answer should be 6");
        System.out.println("The answer we calculated is " +diameterOpt(root));
    }
}



