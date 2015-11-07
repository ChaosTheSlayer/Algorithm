package Alogrithm.Tree;

public class UniqueBinaryTree{

	 public int numTrees(int n) {
        if(n <= 0){
            return 0;
        }
        //Catalan number acutally
        //Didn't really understand it 
        int[] res = new int[n+1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2;i<=n;i++){
            for(int j = 0;j<i;j++){
                res[i] += res[j] * res[i-1-j];
            }
        }
        return res[n];
    }
}