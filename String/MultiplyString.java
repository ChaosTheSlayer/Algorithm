package Algorithm.String;

//Question:https://leetcode.com/problems/multiply-strings/

public class MultiplyString{

	//In think the approach is to simulate the digit multiplication
	//But remember after the multiplication, we need to reverse the output string

	//This O(mn) time, and O(m+n) space

		public static String multiply(String num1,String num2){
		//Assume the inputs are valid,

		//Suppose num1 has m digits, num2 has n digits
		//so the result should have at most m+n digits
		//so we use a list of integer to store mutiply result on each digit
		int[] digits = new int[num1.length()+num2.length()];

		for(int i = num1.length()-1;i>=0;i--){
			int digitI = (int) (num1.charAt(i) -'0');
			for(int j = num2.length()-1;j>=0;j--){
				int digitJ = (int) (num2.charAt(j) - '0');
				//this need to be noted, so all the '0' at the front of digits list, will be ignored
				digits[i+j+1] += digitI*digitJ;
			}
		}

		StringBuilder sb = new StringBuilder();
		int carry = 0;
		int current = 0;
		for(int i = digits.length-1;i>=0;i--){
			current = (digits[i] + carry)%10;
			carry = (digits[i] + carry)/10;
			sb.append(current);

		}
		
		while(sb.length()> 0&& sb.charAt(sb.length()-1) == '0'){
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.length() == 0?"0":sb.reverse().toString();

	}

	//We can also solve this problem by using O(m+n)^2 time, but O(1) space
}