package String;

public class RestoreIPAddress{

	public List<String> restoreIpAddresses(String s) {
        //This question is actually a NP problem, however in this particular question
        //since each segment of an IP address, can only be 1,2,3 digits, so the recursion will only go into 3 level
        //so the complexity would be close to O(2^k) where k is a constant number
        
        //and we also need to have a function that valid if a string is a valid String IP segment
        List<String> res = new ArrayList<String>();
        if(s == null || s.length() == 0){
            return res;
        }
        helper(res,"",s,0,1);
        return res;
    }
    
    private void helper(List<String> res, String curRes,String input, int index, int segment){
        if(index >= input.length()){
            return;
        }
        //we reached the last segment
        if(segment == 4){
            String str = input.substring(index);
            if(isValid(str)){
                res.add(curRes+"."+str);
            }
            return;
        }
        
        for(int i = 1;i<4 && (index+i) <=input.length();i++){
            String str = input.substring(index,index+i);
            if(isValid(str)){
                if(segment == 1){
                    helper(res,str,input,index+i,segment+1);
                }else{
                    helper(res,curRes+"."+str,input,index+i,segment+1);
                }
            }
        }
    }
    
    //valid IP segement is 0-255
    private boolean isValid(String str){
        if(str.length()== 0 || str.length() >=4){
            return false;
        }
        int num = Integer.parseInt(str);
        if(str.charAt(0) == '0' && str.length() >1){
            return false;
        }
        if(num>=0 && num<=255){
            return true;
        }
        return false;
    }
    
}