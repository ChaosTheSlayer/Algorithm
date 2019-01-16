package String;

import java.util.*;

//Give a dictionary and a string, we can delete any number of character from the given String(0 - n)
//to form a new string, try to find the longest new string that contains in the dictionary

public class GetStringInDict{
    //My idea is using BFS, and delete character one by one, and store all the solution in the queue,
    //until we find a new String that is in the dictionary
    //since we using BFS, so the first one we found should be the longest one
    public static String findLongestStringInDict(String str, Set<String> dict){
        //if(dict.contains(str)){
          //  return str;
       // }
        //Worst case complexity should be O(n^2)
        //when couldn't find a valid result
        LinkedList<String> queue = new LinkedList<String>();
        queue.offer(str);
        while(!queue.isEmpty()){
            String cur = queue.poll();
            if(dict.contains(cur)){
                return cur;
            }
            StringBuilder sb = new StringBuilder(cur);
            for(int i = 0;i<cur.length();i++){
                queue.offer(sb.deleteCharAt(i).toString());
                sb = new StringBuilder(cur);
            }
        }
        return null;
    }

    public static void main(String[] args){
        Set<String> dict = new HashSet<String>();
        dict.add("hello");
        dict.add("hellouo");
        dict.add("hell");
        String str = "heaallcouoda";

        String longest = findLongestStringInDict(str,dict);
        if(longest != null){
            System.out.println("Longest String is " + longest);
        }else{
            System.out.println("Sorry, We can find that String!");
        }
    }
}




