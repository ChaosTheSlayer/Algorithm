package Algorithm.String;

public class InterLeavingString{

	 public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        
        //This kind of String Problem, Dynamic programming is always a great way to solve it
        //using res[i][j] to represent whether the first i characters of s1 and first j charcaters of s2 can represent
        //the first (i+j) characters in s3
        //assume we have all the previous result, want to know res[i][j] 
        //only two situation, using char from s1 or s2
        
        //res[i][j] = res[i-1][j] && s1.charAt(i) == s3.charAt(i+j) || res[i][j-1] && s2.charAt(j) == s3.charAt(i+j);
        
        boolean[][] res = new boolean[s1.length()+1][s2.length()+1];
        res[0][0] = true;
        for(int i = 1;i<=s1.length();i++){
            res[i][0] = res[i-1][0] && s1.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1;i<= s2.length();i++){
            res[0][i] = res[0][i-1] && s2.charAt(i-1) == s3.charAt(i-1);
        }
        for(int i = 1;i<=s1.length();i++){
            for(int j = 1;j<=s2.length();j++){
                res[i][j] = res[i-1][j] && s1.charAt(i-1)== s3.charAt(i+j-1) || res[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1);
            }
        }
        return res[s1.length()][s2.length()];
       
    }

    //to reduce the space complexity,since we only need the result of last level
    //we can use one dimentional array
    //and to further reduce the complexity, we could use the shorted string as the size of the dp array
     public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        String min = s1.length() > s2.length()?s2:s1;
        String max = s1.length() > s2.length()? s1:s2;
        boolean[] res = new boolean[min.length()+1];
        res[0] = true;
        for(int i =1;i<=min.length();i++){
            res[i] = res[i-1] && min.charAt(i-1) == s3.charAt(i-1);
        }
        
        for(int i = 1;i<=max.length();i++){
            //this is always needed, inorder to check only using max string to match s3
            res[0] = res[0] && max.charAt(i-1) == s3.charAt(i-1);
            for(int j = 1;j<=min.length();j++){
            	//res[j-1] is equals res[i][j-1] which is this line and already updated
            	//res[j] is equals to res[i-1][j], which is last line and haven't been updated yet
                res[j] = res[j-1] && min.charAt(j-1) == s3.charAt(i+j-1) || res[j] && max.charAt(i-1) == s3.charAt(i+j-1);
            }
        }
        return res[min.length()];
    }
}