package Number;

public class ReverseInteger{
    public static int reverseInteger(int input){
        if(input == 0){
            return input;
        }
        boolean negative = input<0? true:false;

        input = Math.abs(input);
        int res = 0;
        while(input  != 0){
            if(res>(Integer.MAX_VALUE-input%10)/10){
                return 0;
            }
            res = res*10 + input%10;
            input /=10;
        }
        return negative?res*(-1):res;
    }


    public static void main(String[] args){
        int x = 321;
        System.out.println("Current X is "+x);
        System.out.println("Reverse X is "+reverseInteger(x));

        int y = -321;
        System.out.println("Current Y is "+y);
        System.out.println("Reverse Y is "+reverseInteger(y));
    }
}


