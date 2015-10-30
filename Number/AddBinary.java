package Algorithm.Number;

public class AddBinary{

	 public String addBinary(String a, String b) {
        if(a.length() == 0 && b.length() == 0){
            return "0";
        }
        if(a.length() == 0 || b.length() == 0){
            return a.length()== 0?a:b;
        }
        a = new StringBuilder(a).reverse().toString();
        b = new StringBuilder(b).reverse().toString();
        int minLen = Math.min(a.length(),b.length());
        int i = 0;
        int carry = 0;
        StringBuilder res = new StringBuilder();
        while(i<minLen){
            int curA = (int)(a.charAt(i)-'0');
            int curB = (int) (b.charAt(i) -'0');
            res.append((curA+curB+carry)%2);
            carry = (curA+curB+carry)/2;
            i++;
        }
        if(a.length() == b.length()&& carry != 0){
            res.append(carry);
            
        }else{
            String longer = a.length()>b.length()?a:b;
            while(i<longer.length()){
              int curL = (int)(longer.charAt(i) -'0');
              res.append((curL+carry)%2);
              carry = (curL+carry)/2;
              i++;
             }
             if(carry != 0){
                  res.append(carry);
             }
            
         }
         return res.reverse().toString();
        
     }
}