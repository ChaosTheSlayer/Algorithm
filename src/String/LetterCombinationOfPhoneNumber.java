package String;

import java.util.*;

//Question: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationOfPhoneNumber{

	public static List<String> letterCombination(String digits){
		String[] dic = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		List<String> res = new ArrayList<String>();
		if(digits == null || digits.length() == 0){
			return res;
		}
		StringBuilder sb = new StringBuilder();
		helper(digits,res,0,sb,dic);
		return res;
	}

	private static void helper(String digits, List<String> res, int index, StringBuilder curRes,String[] dic){
		if(index >=digits.length()){
			res.add(curRes.toString());
			return;
		}
		int curDigit = (int) (digits.charAt(index)-'0');
		for(int i = 0;i<dic[curDigit].length();i++){
			curRes.append(dic[curDigit].charAt(i));
			helper(digits,res,index+1,curRes,dic);
			curRes.deleteCharAt(curRes.length()-1);
		}
	}
}