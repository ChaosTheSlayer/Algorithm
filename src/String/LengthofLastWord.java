package String;

public class LengthofLastWord{

	public static int lengthOfLastWord(String s) {
		//corner cases
        if(s == null || s.length() == 0){
            return 0;
        }
        //basically we just use to pointer to mark the start of last word
        //and the end of the last word
        int lastEnd = s.length()-1;
        //igonore the space at the end of the array.
        while(lastEnd >= 0 &&s.charAt(lastEnd) == ' ' ){
            lastEnd--;
        }
        //corner case, when there is only space
        if(lastEnd <0){
            return 0;
        }
        int lastStart = lastEnd;
        while(lastStart >=0 &&s.charAt(lastStart) != ' '){
            lastStart--;
        }
        return lastEnd-lastStart;
    }
}