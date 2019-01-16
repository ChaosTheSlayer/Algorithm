package Other;

import java.util.LinkedList;

public class LongestValidParentheses{

	//Still using stack to solve this 
	//we maintain a stack with index of list at element
	//When we see a '{', we push current index into stack
	//we we see a '}', there will be two kinds of situation

	//we always meantain a start point to calculate the max length
	//First, the stack is empty(), so current '}' doesn't have valid match
	//so set start = curindex+1, start over

	//Second stack is not empty
	//Then we pop out, say the pop out index is left
	//if after pop, stack is Empty, means current parentheses is match, curIndex-start+1 should be 
	//current max length
	//if the stack is not empty, then max = curIndex - (stack.peek()+1)+1
	//because all the element after stack.peek() either doesn't exist or already found match

	//O(n) complexity obviously
	public static int longestValidParentheses(String s){
		if(s == null || s.length() == 0 ){
			return 0;
		}
		LinkedList<Integer> stack = new LinkedList<Integer>();
		int max = 0;
		int start = 0;
		for(int i = 0;i<s.length();i++){
			if(s.charAt(i) == '('){
				stack.push(i);
			}else{
				if(stack.isEmpty()){
					start = i+1;
				}else{
					stack.pop();
					max = stack.isEmpty()?Math.max(max,i-start+1):Math.max(max,i-stack.peek());
				}
			}
		}
		return max;
	}

	//This question probably could be solve by dp 
	//Let's try it 

	public int longestValidParentheses(String s) {
    	char[] S = s.toCharArray();
    	//V[i] means, from 0 to i,how many valid parentheses
    	int[] V = new int[S.length];
    	//Open means the left '(' we have seen so far
    	int open = 0;
   		int max = 0;
    	for (int i=0; i<S.length; i++) {
    		//if current is left parenthese,open++
        	if (S[i] == '(') open++;
        	//if current is right parentheses
        	if (S[i] == ')' && open > 0) {
        	//V[i] = 2+V[i-1] means
        	//2 means current valid pairs
        	//V[i-1] means, if i-1 is ')', we should also add it's valid parenthese into count
        	//this would be like "(())"
            V[i] = 2+V[i-1];
            //we also need to check what outside our current "(....)"",maybe like "()()(.cur..)"
            //so V[i-V[i]] is the number before current big (...)
            if(V[i-V[i]]>0){
            	V[i] += V[i-V[i]];
            }
            open--;
        	}		
        	//maintain max
       	 if (V[i] > max) max = V[i];
    		}
   		 return max;
		}

}