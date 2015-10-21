package Algorithm.String;

import java.util.*;

//Qusetion: https://leetcode.com/problems/longest-common-prefix/

public class LongestCommonPrefix{
	public static String longestCommonPrefix(String[] strs){
		if(strs == null || strs.length == 0){
			return "";
		}

		if(strs.length == 1){
			return strs[0];
		}

		//The idea is that we use the any string to compare with other strings in the array
		//if all the character with same index are same, add it to stringbuilder
		//otherwise, return the current result

		//suppose we have n string, and the length of shortest string is k
		//so worst case complexity should be O(nk)
		StringBuilder res = new StringBuilder();
		for(int i = 0;i<strs[0].length();i++){
			for(int j = 1;j<strs.length;j++){
				if(i>=strs[j].length() || strs[0].charAt(i) != strs[j].charAt(i)){
					return res.toString();
				}
			}
			res.append(strs[0].charAt(i));
		}
		return res.toString();
	}
}