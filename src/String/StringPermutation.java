package String;

import java.util.*;

public class StringPermutation{

	public static List<String> permutation(String str){
		List<String> res = new ArrayList<String>();
		if(str == null ||str.length() == 0){
			return res;
		}
		boolean[] visited = new boolean[str.length()];
		char[] charArray = str.toCharArray();
		helper(res,visited,charArray,new StringBuilder());
		return res;
	}

	private static void helper(List<String> res, boolean[] visited,char[] charArray,StringBuilder temp){
		if(temp.length() == charArray.length){
			res.add(temp.toString());
			return;
		}

		for(int i = 0;i<charArray.length;i++){
			if(!visited[i]){
				visited[i] = true;
				temp.append(charArray[i]);
				helper(res,visited,charArray,temp);
				temp.deleteCharAt(temp.length()-1);
				visited[i] = false;
			}
		}
	}

	public static List<String> permutationIteration(String str){
		List<String> res = new ArrayList<String>();
		if(str == null || str.length() == 0){
			return res;
		}
		List<StringBuilder> temp = new ArrayList<StringBuilder>();
		temp.add(new StringBuilder());
		temp.get(0).append(str.charAt(0));
		for(int i = 1;i<str.length();i++){
			List<StringBuilder> curRes = new ArrayList<StringBuilder>();
			for(int j= 0;j<temp.size();j++){
				StringBuilder cur = temp.get(j);
				for(int k = 0;k<cur.length()+1;k++){
					StringBuilder item = new StringBuilder(cur.toString());
					item.insert(k,str.charAt(i));
					curRes.add(item);
				}
			}
			temp = curRes;
		}
		for(StringBuilder sb: temp){
			res.add(sb.toString());
		}
		return res;
	}

	public static void main(String[] args){
		List<String> res = permutationIteration("4321");
		for(String s :res){
			System.out.println(s);
		}
		System.out.println("The size of result is " + res.size());
	}
}