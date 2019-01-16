package String;

//Question: https://leetcode.com/problems/edit-distance/


public class EditDistance{

	//Insert and Delete is actually the same if you think throughly
	//because Insert A is always same as delete at B

	//This acutally can be solved by using Dynamic Programming
	//suppose we have res[i][j], which means the Edit Distance of first i character of WordA
	//and First J character of WordB

	//So there will be following situation
	// 1. wordA.charAt(i+1) == wordB.charAt(j+1), so res[i+1][j+1] = res[i][j]
	// 2. wordA.charAt(i+1) != wordB.charAt(j+1), so there will be three situation
	//    1) insert at A, res[i+1][j+1] = res[i][j+1]+1
	//    2)  insert at B, res[i+1][j+1] = res[i+1][j] +1
	//    3) replace characters, res[i+1][j+1] = res[i][j] +1

	public static int minDistance(String word1,String word2){
		if(word1.length() == 0){
			return word2.length();
		}
		if(word2.length() == 0){
			return word1.length();
		}
		int[][] res = new int[word1.length()+1][word2.length()+1];
		for(int i = 0;i<=word1.length();i++){
			res[i][0] = i;
		}
		for(int j = 0;j<=word2.length();j++){
			res[0][j] = j;
		}
		for(int i = 0;i<word1.length();i++){
			for(int j = 0;j<word2.length();j++){
				if(word1.charAt(i) == word2.charAt(j)){
					res[i+1][j+1] = res[i][j];
				}else{
					res[i+1][j+1] = Math.min(res[i][j],Math.min(res[i][j+1],res[i+1][j]))+1;
				}
			}
		}
		return res[word1.length()][word2.length()];
	}
}