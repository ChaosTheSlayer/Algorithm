package Other;

import java.util.*;

//Question: https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses{
	//Using a stack to solve this, left parenthese push into stack
	//got right, pop out, see if match
	public static boolean isValid(String s) {
        if(s == null || s.length() == 0 || s.length()%2 == 1){
        	return false;
        }

        LinkedList<Character> stack = new LinkedList<Character>();
        for(int i = 0;i<s.length();i++){
        	Character cur = s.charAt(i);
        	if(cur == '(' || cur == '{' || cur == '['){
        		stack.push(cur);
        	}else{
        		if(stack.isEmpty()){
        			return false;
        		}
        		Character top = stack.pop();
        		if(cur == '}' && top != '{' || cur == ']' && top != '[' || cur == ')' && top != '('){
        			return false;
        		}
        	}
        }
        if(!stack.isEmpty()){
        	return false;
        }
        return true;
    }
}