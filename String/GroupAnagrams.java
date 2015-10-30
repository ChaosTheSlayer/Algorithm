package Algorithm.String;

//Question: https://leetcode.com/problems/anagrams/
import java.util.*;

public class GroupAnagrams{

	public static  List<List<String>> groupAnagrams(String[] strs){
		//I am thinking about using a hashmap<String,List<String>>
		//key is an anagram, value is a list of all the anagrams of it in input list

		List<List<String>> res = new ArrayList<List<String>>();
		if(strs == null || strs.length == 0){
			return res;
		}
		//since the output should be in order, then we need to sort the list first
		Arrays.sort(strs);
		HashMap<String, List<String>> map = new HashMap<String,List<String>>();
		for(String cur: strs){
			char[] curArray = cur.toCharArray();
			//sort it ,then check it at map
			Arrays.sort(curArray);
			if(!map.containsKey(curArray.toString())){
				map.put(curArray.toString(),new ArrayList<String>());
			}
			map.get(curArray.toString()).add(cur);
		}
		res = new ArrayList<List<String>>(map.values());
		return res;
	}
}