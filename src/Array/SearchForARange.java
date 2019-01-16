package Array;

import java.util.*;

public class SearchForARange{

	//So basically Idea is that we do 3 binary search
	//First Binary Search to find if the given target exist in this array
	//Second binary Search to find the left bound(or right bound) 
	//Third binary Search to find the other bound
	 public static int[] searchRange(int[] nums, int target){
		int[] res = {-1,-1};
		if(nums == null || nums.length == 0){
			return res;
		}
		int ll = 0;
		int rr = nums.length-1;
		//standar binary search
		while(ll<=rr){
			int m = (ll+rr)/2;
			if(nums[m] == target){
				res[0] = m;
				res[1] = m;
				break;
			}else if(nums[m] > target){
				rr = m-1;
			}else{
				ll = m+1;
			}
		}
		if(res[0]== -1){
			return res;
		}

		ll = 0;
		int lr = res[0];
		//in this binary search, because the right side is target
		//so there will only be equal target and smaller than target to situation,
		//so since the end of the loop is condition where ll>lr
		//and we mantian lr always smaller or equal to target
		//and we mantain ll is always bigger than nums[m] when nums[m] is smaller than target
		//so in most case, the lr will be the biggest one the smaller or equal to target
		//ll will be the smallest one that bigger or equal to target

		//so ll is the left boung of target range
		while(ll<=lr){
			int newM = (ll+lr)/2;
			if(nums[newM] == target){
				lr = newM-1;
			}else{
				ll = newM+1;
			}
		}
		res[0] = ll;

		int rl = res[1];
	     rr = nums.length-1;
		while(rl<=rr){
			int newM = (rl+rr)/2;
			if(nums[newM] == target){
				rl = newM+1;
			}else{
				rr = newM-1;
			}
		}
		res[1] = rr;
		return res;
	}

	//A more optimal way is that we oly do two binary search, 
	//so first binary search, we try to find the left most point
	//the seconde binary search, we try to find the right most point

	public static int[] searchRangeTwoBinarSearch(int[] nums, int target){
		int[] res = {-1,-1};
		if(nums == null || nums.length == 0){
			return res;
		}
		int ll = 0;
		int lr = nums.length-1;
		
		while(ll<=lr){
			int m = (ll+lr)/2;
			if(nums[m] >= target){
				lr = m-1;
			}else{
				ll = m+1;
			}
		}

		int rl = 0;
		int rr = nums.length-1;
		while(rl<=rr){
			int m = (rl+rr)/2;
			if(nums[m] <= target){
				rl = m+1;
			}else{
				rr= m-1;
			}
		}
		if(ll<=rr){
			res[0] = ll;
			res[1] = rr;

		}
		return res;
	}


}