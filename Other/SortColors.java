package Algorithm.Other;

public class SortColors{

	    public void sortColors(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int notRed = 0;
        int notBlue = nums.length-1;
        while(notRed<nums.length && nums[notRed] == 0){
            notRed++;
        }
        while(notBlue>=0 && nums[notBlue] == 2){
            notBlue--;
        }
        for(int i = notRed;i<=notBlue;i++){
            if(nums[i] == 0){
                swap(nums,notRed,i);
                notRed++;
            }else if(nums[i] == 2){
                swap(nums,i,notBlue);
                notBlue--;
                i--;
            }
        }
        
        
    }
    
    private void swap(int[] nums,int left,int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}