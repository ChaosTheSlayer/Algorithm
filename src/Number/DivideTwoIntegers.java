package Number;

//Question: https://leetcode.com/problems/divide-two-integers/

public class DivideTwoIntegers{

	//All the number related question, I would pay more attention to sign and out of bound
	//because that was usually corner cases occurs


	//First solution: keep substract divisor from dividend, until we got 0 or dividend smaller than divisor
	//the complexity will equal to O(k) ,where k is result.

	//Second solution, we might need to use bit manipulation
	//we know that every integer could represented by
	//num = a0 *2^0 + a1*2^1 + a2&2^2 + ...+an&2^n
	//so what we need to do is that first left shift divisor to the largest that smaller than dividend
	//we try to substract this largest one, if it work, then result + 2^k, where k is 
	//the shift we did to get the number

	public static int divide(int dividend,int divisor){
		//Corner case 1: Invalid devisor
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		//we should have a variable that check if the result is negative
		//because later we gonna convert them into non-negative value to calculate
		//>>> no sign shift
		boolean isNeg = (dividend^divisor)>>>31 == 1;
		int res = 0;
		//corner case 2, dividend is Integer.MIN_VALUE
		if(dividend == Integer.MIN_VALUE){
			//we know that Integer.MIN_VALUE is bigger than Integer.MAX_VALUE in absolute value
			//so we need to add a divisor so it can get a abs value

			//Actually, if divisor is Integer.MIN_VALUE 
			if(divisor == Integer.MIN_VALUE){
				return 1;
			}

			dividend += Math.abs(divisor);
			if(divisor == -1){
				return Integer.MAX_VALUE;
			}
			res++;

		}
		//Becuase if divident and divisor both is Integer.MIN_VALUE
		//it will return is previous step, so here is when divident is not Integer.MIN_VALUE
		//but divisor is, result is abviously 0
		if(divisor == Integer.MIN_VALUE){
			return res;
		}
		divisor = Math.abs(divisor);
		dividend = Math.abs(dividend);
		int digit = 0;
		while(divisor <= (dividend >>1)){
			divisor <<= 1;
			digit++;
		}
		while(digit >=0){
			if(dividend>= divisor){
				res += 2<<digit;
				dividend-= divisor;
			}
			divisor >>=1;
			digit--;
		}

		return isNeg?-res:res;

	}
}