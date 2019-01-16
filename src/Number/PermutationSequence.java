package Number;

//To be finished
public class PermutationSequence{

	 public static String getPermutation(int n, int k) {
        //here k-- is to match the index of array
        //will talk about this later
        k--;
        if(n<=0){
            return "";
        }
        int factor = 1;
        for(int i = 2;i<n ;i++){
            factor *= i;
        }
        //Have a list to store number
        List<Integer> nums = new ArrayList<Integer>();
        for(int i = 1;i<=n;i++){
            nums.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int round = n-1;
        while(round>=0){
            int index = k/factor;
            k %=factor;
            sb.append(nums.get(index));
            nums.remove(index);
            if(round >0){
                factor /= round;
            }
            round--;
        }
        return sb.toString();
    }
}