package Algorithm.String;

import java.util.*;

public class LongestSubStringWithoutRepeating{
	public static String longestSubStringWithoutRepeating(String input){
		if(input == null || input.length() == 0){
			return null;
		}
		//Using to pointer to maintain a window and a hashset, keep moving the right pointer to take in new character
		//If a duplicate character occurs, we move the left pointer, until there is no duplicate in the hashset
		//during this process, we maintain the maxwindow
		//Each character won't in and out the set more than two times
		//so overall time complexity is O(n)

		HashSet<Character> unique = new HashSet<Character>();
		int max = Integer.MIN_VALUE;
		int start = -1;
		int left = 0;
		int right = 0;
		while(right < input.length()){

			//Current character is not duplicate, add it into the hashset
			if(!unique.contains(input.charAt(right))){
				
				unique.add(input.charAt(right));
			}else{
				//if we found duplicate, start to move left, until the character the left pointer points to 
				//is different from the one the right pointer point to 
				//maintian the max length of longest no duplicate string at the mean time
				if(right-left > max){
					max = right-left;
					start = left;
				}
				while(input.charAt(left) != input.charAt(right)){
					unique.remove(input.charAt(left));
					left++;
				}

				left++;
				
			}
			//Always move the right pointer
			right++;
		}
		return input.substring(start,start+max);
	}

	public static void main(String[] args){
		String input = "abcabedfsrpiopiisr";
		System.out.println(input);
		System.out.println(longestSubStringWithoutRepeating(input));

	}

}