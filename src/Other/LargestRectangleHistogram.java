package Other;

public class LargestRectangleHistogram{

	public int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        for(int i = 0;i<height.length;i++){
            while(!stack.isEmpty() && height[i] <= height[stack.peek()]){
                int index = stack.pop();
                int curArea = stack.isEmpty()?height[index]*(i):height[index]*(i-1-stack.peek());
                maxArea = Math.max(curArea,maxArea);
            }
            stack.push(i);
            
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            int curArea = stack.isEmpty()?height[index]*(height.length): height[index] *(height.length-1-stack.peek());
            maxArea = Math.max(curArea,maxArea);
        }
        return maxArea;
    }
}