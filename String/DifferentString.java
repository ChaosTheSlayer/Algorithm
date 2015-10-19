package Algorithm.String;

import java.util.*;


//Question 1: Given two String, two String with the same length, they have the same characters, however, for a certain character, one string has one more this character than the other one

//please try to find out the string that has more character.
public class DifferentString{

    public static void findStringWithMoreChar(String strA, String strB){
        //assume the input strings are valid, so we don't check any corner cases
        
        //my idea is that to use create a hashmap<Character,Integer> for one string
        //then traversal the other string, find a match character, we minus the corespoding value for the current key character
        //if we hit a key character with zero value during the process, means that the string we are traversing is that string we are looking for
        //other wise it's the string that we use to created the map

        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for(int i = 0;i<strA.length();i++){
            if(!map.containsKey(strA.charAt(i))){
                map.put(strA.charAt(i),0);
            }
            map.put(strA.charAt(i),map.get(strA.charAt(i))+1);
        }


        for(int j = 0;j<strB.length();j++){
            if(map.get(strB.charAt(j)) > 0){
                map.put(strB.charAt(j),map.get(strB.charAt(j))-1);
            }else{
                //StringB is the string
                System.out.println("String "+ strB + " is the String we are looking for");
                return;
            }
        }
        //Otherwise
        //StringA is the String we are looking for

        System.out.println("String " + strA + " is the String we are looking for");
    }
    
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        String strA = myScanner.nextLine();
        String strB = myScanner.nextLine();
        findStringWithMoreChar(strA,strB);
        System.out.println("Program Finished!");
        myScanner.close();
    }
}
