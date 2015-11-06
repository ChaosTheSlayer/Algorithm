package Algorithm.Other;

public class MaximalRectangle{
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int[] height = new int[matrix[0].length];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                height[j] = matrix[i][j] == '0'?0:height[j]+1;
            }
            int curArea = maxRectangle(height);
            maxArea = Math.max(curArea,maxArea);
        }
        return maxArea;
    }
    
    private int maxRectangle(int[] height){
        if(height == null || height.length == 0){
            return 0;
        }
        int maxArea = 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for(int i = 0;i<height.length;i++){
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int index = stack.pop();
                int curArea = stack.isEmpty()?height[index]*(i): height[index]*(i-1-stack.peek());
                maxArea = Math.max(curArea,maxArea);
            }
            stack.push(i);
        }
        
        while(!stack.isEmpty()){
            int index = stack.pop();
            int curArea = stack.isEmpty()?height[index]*height.length:height[index]*(height.length-1-stack.peek());
            maxArea = Math.max(curArea,maxArea);
        }
        return maxArea;
        
    }
}