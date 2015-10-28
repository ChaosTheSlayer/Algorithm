package Algorithm.Graph;

//Question: https://leetcode.com/problems/rotate-image/

public class RotateImage{
	//There is no fancy algorithm about this, is just basic array operation
	//idea is that we divided the array into different layer

		public static void rotate(int[][] matrix){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return ;
		}

		int layerNum = matrix.length /2;
		for(int layer = 0;layer<layerNum;layer++){
			//remember here we use matrix.length-1-layer as bound
			for(int i = layer;i<matrix.length-layer-1;i++){
				int temp = matrix[layer][i];
				matrix[layer][i] = matrix[matrix.length-1-i][layer];
				matrix[matrix.length-1-i][layer] = matrix[matrix.length-1-layer][matrix.length-1-i];
				matrix[matrix.length-layer-1][matrix.length-1-i] = matrix[i][matrix.length-1-layer];
				matrix[i][matrix.length-1-layer] = temp;
			}
		}

	}
}