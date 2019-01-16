package Number;

public class PlusOne{
	 public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return new int[0];
        }
        int carry = 1;
        for(int i= digits.length-1;i>=0;i--){
            int cur = (digits[i]+carry)%10;
            carry = (digits[i]+carry)/10;
            digits[i] = cur;
        }
        if(carry == 0){
            return digits;
        }else{
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int i= 0;i<digits.length;i++){
                res[i+1] = digits[i];
            }
            return res;
        }
    }
}