package Algorithm.Number;

//Question:https://leetcode.com/problems/valid-number/

//There will be a lot of corner cases in this
//In this particular question, we only consider Scientific notation

//First of all, the onlynon digit character allowed is '-','+','.','e','E'
//any other will be consider as invalid
//Then there are certian rules
//Case '.': either the character before '.' is digit or the character after '.' is digit
//     there is not '.' before it(no two '.' i one digits), also no e,E before it
//Case '+','-', 1) at the first character 2) right after 'e' or 'E'
//Case 'e','E': 1) no 'e' 'E' before 2)cant be last or first character

public class ValidNumber{
 	public static boolean isNumber(String s){
		if(s == null){
			return false;
		}
		//remove the spaces at the front or end of given string
		s = s.trim();
		//corner case
		if(s.length() == 0){
			return false;
		}
		//a flag to mark if a '.' has been seen
		boolean dotFlag = false;
		//a flag to mark if a ‘e' or 'E' has been seen
		boolean eFlag = false;

		for(int i = 0;i<s.length();i++){
			switch(s.charAt(i)){
				case '.':
					//if there is previous '.' || ther is previous '.' || (the character before '.' is not digt || the character after '.' is not digit)
					if(dotFlag || eFlag ||!( (i>0 &&Character.isDigit(s.charAt(i-1)))||(i<s.length()-1 && Character.isDigit(s.charAt(i+1))))){
						//the input is invalid
						return false;
					}
					//mark the dot
					dotFlag = true;
					break;
				case '+':
				case '-':
					//if '+' '-' is not after 'e''E' or '+-' is the last character or "+-" is not infront of digit or '.'
					if((i>0 && (s.charAt(i-1)!='e' && s.charAt(i-1)!='E'))  
                  || (i==s.length()-1 || !(Character.isDigit(s.charAt(i+1))||s.charAt(i+1)=='.'))){
						//invalid case
                      return false;
                  }
					break;
				case 'e':
				case 'E':
					//pervious 'eE', 'e' is the firt or last
					if(eFlag || i == 0 || i == s.length()-1){
						return false;
					}
					eFlag = true;
					break;
				case '0':
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
					break;
				default:
					return false;
			}
		}
		return true;
	}
}