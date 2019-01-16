package String;

//Question: https://leetcode.com/problems/wildcard-matching/

public class WildcardMatching{

// 	'?' Matches any single character.
// '*' Matches any sequence of characters (including the empty sequence).

// The matching should cover the entire input string (not partial).

// The function prototype should be:
// bool isMatch(const char *s, const char *p)

// Some examples:
// isMatch("aa","a") → false
// isMatch("aa","aa") → true
// isMatch("aaa","aa") → false
// isMatch("aa", "*") → true
// isMatch("aa", "a*") → true
// isMatch("ab", "?*") → true
// isMatch("aab", "c*a*b") → false

	//Solution: 
	//using dp to slove this, dp[i][j] means whether at ith character in first string and jth character
	//in second string, they are match
	//Let's analyze what kinds  of situation we might run into during the matching
	//First: if(j+1) is not "*", so we only need to check if char(i+1) == char(j+1) ? is also match
	//Second: if(j+1) is "*", then we need to check all the previous, if there is a match, then this one is match
	//also all the result after current is also a match

	//and I also think we don't need to use two dimentional array to solve this problem
	//one dimentional will be fine.
	public static boolean isMatch(String s, String p){
		if(p.length() == 0){
			return s.length() == 0;
		}
		if(s.length()>300 && p.charAt(0)=='*' && p.charAt(p.length()-1)=='*'){
    		  return false;
		} 
    		  
		boolean[] res = new boolean[s.length()+1];
		res[0] = true;
		for(int j = 0;j<p.length();j++){
			//go through string p 
			//Situation one: 
			//If p.charAt(j) != '*'
			if(p.charAt(j) != '*'){
				//we update the res, since we use one dimentional array, we cannot mess with previous result will update it
				//so we from the back to the front
				for(int i = s.length()-1;i>=0;i--){
					res[i+1] = res[i] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?');
				}
			}else{
				//we check previous res[i], see if we can found a previous match
				int i = 0;
				while(i<=s.length() && !res[i]){
					i++;
				}
				//then all the rest are true;
				for(;i<=s.length();i++){
					res[i] = true;
				}
			}
			//we also need to update res[0], because res[0] is initially true
			//and when we start to traversing string p
			//the only way it still is true is that all the character in p is '*'
			//otherwise won't match an empty string
			res[0] = res[0] && p.charAt(j) == '*';
		}
		return res[s.length()];
	}


	//Another solution without DP, but the idea is similar

	//We need two pointer, one to mark previous '*' position
	//one to mark previous i
	//I will illustrate

	//when go through two strings, A and B
	//Now we use i to respesent ith character of A
	//j to respresent jth character of B

	//So there will be two major situation: 
	//b.charAt(j) != '*'
	//	this is the easy case, we only need to check if A.charAt(i) == B.charAt(j) || B.charAt(j) == '?'
	//then we can i++,j++

	//b.charAt(j) == '*'
	// in this situation we will need to check when this "*" stands for anysequence, the remain character will match or not
	//For example, if we first test '*' stands for 1 character, turns out doesn't work out
	//we need to go back and try '*' stands for 2 character etc.

	public static boolean isMatch(String s,String p){
		//index of string s
		int i = 0;
		//index of string p 
		int j = 0;
		//pointer to mark '*'
		int star = 0;
		//pointer to mark i
		int mark
		while(i<s.length()){
			//p.charAt(j) is not '*' and charAt(i) charAt(j) match
			if(j<p.length() && p.charAt(j) != '*' && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
				i++;
				j++;
			}else if (j<p.length() && p.charAt(j) == '*'){
				//if we saw '*', mark the current j as  '*' position and i position
				//then j++, nothing to do with i
				//because we should check '*' stands for no character
				star = j;
				mark = i;
				j++;
			}else if(star != -1){
				//current doesn't match
				//roll back, then try different combination
				j = star+1;
				i = ++mark;
			}else{
				return false;
			}
		}
		//don't forget after the match, there might be '*' remain
		//and sense '*' match any sequence
		//when we saw '**', we could just ignore the previous '*'
		while(j<p.length() && p.charAt(j) == '*'){
			j++;
		}

		return j == p.length();
	}
}