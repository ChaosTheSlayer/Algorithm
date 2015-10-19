//Question:
//Given a Binary tree, cutting a edge of it to form two new tree,
//return the minimum difference between the sum value of two new trees
package Algorithm.Tree;

import java.util.*;

//My Solution:
//when cutting an edge of a node(let's call this node root)
//we have two choice, cutting left edge of root or right one
//let's use cut left one as an example, right are the same logic
//when we cut the left edge and get two tree, the sum of left tree should be the sum of root's left subtree
//the right tree should be the sum of the whole tree minus the sum of root's left subtree
//same for the right subtree

//so my idea is that we do two time dfs, first one calculate the sum of the whole tree
//next time dfs, we calculate the diff of cutting edge, and while do that we maintain a minimum diff

public class ClosestTrees{
    static class TreeNode{
        int value;
        TreeNode left;
        TreeNode right;
        
        public TreeNode(int value){
            this.value = value;
            }
        }

    public static int minDiffOfTrees(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        res.add(Integer.MAX_VALUE);
        int treeSum = sumHelper(root);
        System.out.println(treeSum);
        diffHelper(root,res,treeSum);
        return res.get(0);
    }

    public static int sumHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        return root.value+sumHelper(root.left)+sumHelper(root.right);
    }

    private static int diffHelper(TreeNode root,List<Integer> res,int treeSum){
        if(root == null){
            return 0;
        }
        int left = diffHelper(root.left,res,treeSum);
        int right = diffHelper(root.right,res,treeSum);
        
        if(left != 0 && right != 0){
            int curDiff = Math.min(Math.abs(treeSum-left-left),Math.abs(treeSum-right-right));
            if(res.get(0) >curDiff){
                res.set(0,curDiff);
             }
        }
        return root.value+left+right;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(minDiffOfTrees(root));

    }
}
