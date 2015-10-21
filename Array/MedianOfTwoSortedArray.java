package Algorithm.Array;

import java.util.*;

public class MedianOfTwoSortedArray{

	//let's assume the size of two array is m and n
	//this question will equal to find k = (m+n)/2 the element in two array
	//so for each time, we check k/2th element in each array
	//if A[k/2] == B[k/2], this is the element we are looking for
	//if A[k/2] > B[k/2] , then the first k/2 element in B is not gonna be the element we are looking for
	public static double findMedianSortedArray(int[] a, int[] b){
		if((a.length+b.length)%2 == 1){
			return helper(a,0,a.length-1,b,0,b.length-1,(a.length+b.length)/2+1);
		}else{
			return (helper(a,0,a.length-1,b,0,b.length-1,(a.length+b.length)/2)+helper(a,0,a.length-1,b,0,b.length-1,(a.length+b.length)/2+1))/2.0;
		}
	}

	private static int helper(int[] a,int astart, int aend, int[] b, int bstart, int bend, int k){
		int m = aend-astart+1;
		int n = bend-bstart+1;
		if(m>n){
			return helper(b,bstart,bend,a, astart,aend,k);
		}
		if(m == 0){
			return b[k-1];
		}
		if(k == 1){
			return Math.min(a[astart],b[bstart]);
		}
		int posA = Math.min(m,k/2);
		int posB = k-posA;
		if(a[astart+posA-1] == b[bstart+posB-1]){
			return a[astart+posA-1];
		}else if(a[astart+posA-1] > b[bstart+posB-1]){
			return helper(a,astart,aend,b,bstart+posB,bend,k-posB);
		}else{
			return helper(a,astart+posA,aend,b,bstart,bend,k-posA);
		}
		//We can also cut more, since posA+posB = k
		//
		// //return helper(a,astart,astart+posA-1,b,bstart+posB,bend,k-posB);
		// }else{
		// 	return helper(a,astart+posA,aend,b,bstart,bstart+posB-1,k-posA);
		// }

	}

	public static void main(String[] args){
		int[] a = {1,2,7,8,9};
		int[] b = {2,3,4,5,6};
		System.out.println(findMedianSortedArray(a,b));
	}
}