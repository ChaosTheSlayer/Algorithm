package Algorithm.String;

public class CountandSay{
	//Time comlexity should be O(n*k) where k is the length of the result
	//Space complexity should be O(k),
	//when n is big, the k should be exponential 
	//so time complexity shouldbe (n^)
	public static String countAndSay(int n){
		if(n<=0){
			return "";
		}
		String sequence = "1";
		
		for(int i = 1;i<n;i++){
			StringBuilder sb = new StringBuilder();
			int count = 1;
			for(int j = 0;j<sequence.length();j++){
				while(j<sequence.length()-1 && sequence.charAt(j) == sequence.charAt(j+1)){
					count++;
					j++;
				}
				sb.append(count);
				sb.append(sequence.charAt(j));
				count = 1;

			}
			sequence = sb.toString();
		}
		return sequence;
	}
}