package Algorithm.Array;

//Question: https://leetcode.com/problems/container-with-most-water/
public class ContainMostWater{

    //Idea:This kind of question I ususally using two pointer to maintain a window,and we calculate what we need to calculate in this certain window
    //And after that we find under what kind of situation we move certian pointer

    //For this question, I would like use two pointers, one at the beginning of the array, and another one at the end of array, let's call them pointer A, and pointer B
    //Say if array[pointA] is smaller thatn array[pointB], means that pointerA is the weak spot for current window, we need to move pointerA to right, say if we may get a better result
    //Similarly, if pointB is smaller, we move pointerB

    public static int containWater(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = array.length-1;
        while(left<right){
            max = Math.max(max,Math.min(array[left],array[right])*(right-left));
            if(array[right] > array[left]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}


