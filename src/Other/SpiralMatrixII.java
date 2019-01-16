package Other;
//Question: https://leetcode.com/problems/spiral-matrix-ii/
public class SpiralMatrixII{
	  //idea is very similar to spiral matrix,just put the corresponding number in
	// layer by layer
	  public static int[][] generateMatrix(int n) {
        if(n <=0){
           return new int[0][0];
        }
        int[][] nums = new int[n][n];
        int layerNum = n/2;
        int num = 1;
        for(int layer = 0;layer<layerNum;layer++){
            for(int i = layer;i<n-1-layer;i++){
                nums[layer][i] = num++;
            }
            for(int i = layer;i<n-1-layer;i++){
                nums[i][n-1-layer] = num++;
            }
            for(int i = layer;i<n-1-layer;i++){
                nums[n-1-layer][n-1-i] = num++;
            }
            for(int i = layer;i<n-1-layer;i++){
                nums[n-1-i][layer] = num++;
            }
        }
        if(n%2 ==1){
            nums[layerNum][layerNum] = num;
        }
        return nums;
    }
}