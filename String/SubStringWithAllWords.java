package Algorithm.String;

//Question: https://leetcode.com/problems/substring-with-concatenation-of-all-words/
import java.util.*;

//Right now it has bug, haven't found it yet.. 
//very tiny bug...

public class SubStringWithAllWords{
	//General Idea is that first we should have a hashmap to map each string in the lists 
	//and the number it appears

	public static List<Integer> findSubstring(String s, String[] words){
		List<Integer> res = new ArrayList<Integer>();
		//some corner cases
		if(s == null || s.length() == 0 || words == null || words.length == 0|| s.length() < words[0].length()){
			return res;
		}

		//Building our hashmap
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		for(int i = 0;i<words.length;i++){
			if(!map.containsKey(words[i])){
				map.put(words[i],0);
			}
			map.put(words[i],map.get(words[i])+1);
		}
		//Then we need to try to find the result
		//since all the string in wordslist have same length
		//so the possible start point is 0 to words[0].length
		for(int i = 0;i<words[0].length();i++){
			HashMap<String,Integer> curMap = new HashMap<String,Integer>();
			int count = 0;
			//we should have a left pointer, which will move in certain condition
			//assume we already have all the words in our current window, and the next one it's a duplicate
			//what we need to do is that keep deleting from left side, until there is no duplicate
			//see if we can get a new result
			int left = i;
			for(int j = i;j<=s.length()-words[0].length();j+=words[0].length()){
				String cur = s.substring(j,j+words[0].length());
				//which means it's a valid string
				if(map.containsKey(cur)){
					if(!curMap.containsKey(cur)){
						curMap.put(cur,1);
					}else{
						curMap.put(cur,curMap.get(cur)+1);
					}
					//we need to check if the number of curString in our cur window is valid
					if(curMap.get(cur)<=map.get(cur)){
						count++;
					}else{
						while(curMap.get(cur) > map.get(cur)){
							String temp = s.substring(left,left+words[0].length());
							
							curMap.put(temp,curMap.get(temp)-1);
							//if(curMap.get(temp)<map.get(temp)){
							count--;
							//}
							//count--;
							
							left+=words[0].length();
						}
					}
					if(count == words.length){
						res.add(left);
						String temp = s.substring(left,left+words[0].length());
						curMap.put(temp,curMap.get(temp)-1);
						count--;
						left+= words[0].length();
					}

				}
				else{
					map.clear();
					count = 0;
					left = j+words[0].length();
				}
			}
		}
		return res;
	}
}