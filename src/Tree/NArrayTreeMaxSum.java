package Tree;

import java.util.*;

//Question: Give a N-array tree, the value of each node can be from 1 to 10
//however, a node cannot have same value with its parent
//please return the maximum sum of the values of all the nodese

//Idea: DFS+DP
//For each node, we store when the parent's value is fixed, the maximum sum

//we for each node we need to try everypossible number from 1 to 10
// and in order to reduce the duplicate calculation, we should using a map to store
//when a parrentnode val is fixed, the maximum sum, so in that case we don't need to calculate again
public class NArrayTreeMaxSum{
    static class TreeNode{
        int val;
        List<TreeNode> children;
        TreeNode(int val){
            this.val = val;
            children = new ArrayList<TreeNode>();
        }
    }
    //Using an object to store the node and its corresponding parentval
    static class Wapper{
        int parentval;
        TreeNode node;
        Wapper( TreeNode node,int parentval){
            this.parentval = parentval;
            this.node = node;
        }

        @Override
       public  boolean equals(Object o){
            if(this == o){
                return true;
            }
            if(! (o instanceof Wapper ))
               return false;
            Wapper wa = (Wapper) o;
            return this.node == wa.node && this.parentval == wa.parentval;
        }

        @Override

       public  int hashCode(){
           int res = 17;
            res = res*(parentval) + 39;
            return res;
        }

    }

    public static int maxSum(TreeNode root){
        if(root == null){
            return 0;
        }
        HashMap<Wapper,Integer> map = new HashMap<Wapper,Integer>();
        return maxSumHelper(root,-1,map);
    }

    public static int maxSumHelper(TreeNode root,int parentVal,HashMap<Wapper,Integer> map){
        //Condition to end current recursive
        if(root == null){
            return 0;
        }
        Wapper wa = new Wapper(root,parentVal);
        //if we already calculated node with this parentVal, just return it, no need to calculate again
        if(map.containsKey(wa)){
            return map.get(wa);
        }
        //Keep tracking the bestValue of current node in order to get the max Sum
        int bestVal = 0;
        //kep tracking the maximum sum
        int max = 0;
        for(int i = 1;i<=10;i++){
            //remember the condition, a node cannot have same value as its parent
            if(i == parentVal){
                continue;  
            }
            //calculate the sum
            int sum = i;
            for(TreeNode child: root.children){
                sum += maxSumHelper(child,i,map);
            }
            //update max
            if(sum > max){
                max = sum;
                bestVal = i;
            }
        }
        root.val = bestVal;
        //update the map
        map.put(wa,max);
        return max;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.children.add(new TreeNode(0));
        root.children.get(0).children.add(new TreeNode(0));
        root.children.get(0).children.add(new TreeNode(0));
        root.children.get(0).children.add(new TreeNode(0));
        root.children.get(0).children.get(2).children.add(new TreeNode(0));
        root.children.get(0).children.get(2).children.add(new TreeNode(0));
        root.children.get(0).children.get(2).children.add(new TreeNode(0));
        root.children.get(0).children.get(2).children.add(new TreeNode(0));
        root.children.get(0).children.get(2).children.add(new TreeNode(0));
        System.out.println(maxSum(root));
        
    }
}





