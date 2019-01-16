package String;

public class strStr{

	public static int strStr(String haystack, String needle){
		if(needle.length() == 0){
			return 0;
		}
		if(haystack.length() == 0){
			return -1;
		}
		for(int i = 0;i<=haystack.length()- needle.length();i++){
			boolean flag = true;
			for(int j = 0;j<needle.length();j++){
				if(haystack.charAt(i+j) != needle.charAt(j)){
					flag = false;
					break;
				}
			}
			if(flag){
				return i;
			}
		}
		return -1;
	}
}