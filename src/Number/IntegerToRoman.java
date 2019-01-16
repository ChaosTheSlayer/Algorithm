package Number;

import java.util.*;

public class IntegerToRoman{

    public static String intToRoman(int num){
        if(num < 1 || num > 3999){
            return "";
        }

        int digit = 1000;
        List<Integer> digits = new ArrayList<Integer>();
        while(digit != 0){
            digits.add(num/digit);
            num %= digit;
            digit /= 10;
        }
        StringBuilder res = new StringBuilder();
        res.append(helper(digits.get(0),'M',' ',' '));
        res.append(helper(digits.get(1),'C','D','M'));
        res.append(helper(digits.get(2),'X','L','C'));
        res.append(helper(digits.get(3),'I','V','X'));
        return res.toString();
    }

    private static String helper(int digit, char one, char five, char ten){
        StringBuilder sb = new StringBuilder();
        switch(digit){
            case 9:
                sb.append(one);
                sb.append(ten);
                break;
            case 8:
            case 7:
            case 6:
            case 5:
                sb.append(five);
                for(int i = 6;i<=digit;i++){
                    sb.append(one);
                }
                break;
            case 4:
            case 3:
            case 2:
            case 1:
                for(int i = 1;i<=digit;i++){
                    sb.append(one);
                }
                break;
            default:
                break;
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Integer input = sc.nextInt();
        System.out.println("Roman Number is "+intToRoman(input));
        sc.close();
    }
}
            

