package Algorithm.Number;


//Question:https://leetcode.com/problems/powx-n/

public class PowXN{
	//For this kinds of question,usually there are two ways to do 
	//using binary represition, and another way is divide and conquar

	// we consider n as binary number, so first digit of n(binary form)should be
	// x, second should be x*x ... kth digit should be x^(2^(k-1))

	public static double pow(double x, int n){
		//corner cases
		// n = 0
		if(n == 0){
			return 1.0;
		}
		//eventually we still need to change input to absolute value then calculate
		double res = 1.0;
		//when n <0 , our strategy is try to change x to 1/x then calculate n as absolute value
		//but there will be a lot corner cases, we need to dealling with
		if(n<0){
			//when 1/x > Double.MAX_VALUE and 1/X <-Double.MAX_VALUE is false
			if(x >= 1.0/Double.MAX_VALUE || x <= 1.0/-Double.MAX_VALUE){
				x = 1/x;
			}else{
				//Out of bound
				return Double.MAX_VALUE;
			}
			//if n = math.integer.min_value
			//inorder to get a absolute value, we need to add 1
			if(n == Integer.MIN_VALUE){
				res *= x;
				n++;
			}
		}
		n = Math.abs(n);
		boolean isNeg = false;
		if(n%2==1 && x <0){
			isNeg = true;
		}
		x = Math.abs(x);
		while(n>0){
			if((n&1 )== 1){
				if(res > Double.MAX_VALUE/x){
					return Double.MAX_VALUE;
				}
				res *= x;
			}
			x*= x;
			n = n>>1;
		}
		return isNeg?-res:res;

	}

}