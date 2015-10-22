package Algorithm.LinkedList;

//Question: https://leetcode.com/problems/merge-k-sorted-lists/

//First Solution, similar the merge sort, usin divide and conquer, until only one list
//then merge them together

//Time Complexity Analysis: Suppose we have k lists, and the longest lists is n 
//so for each helper function, we have T(k) = 2T(k/2) + O(nk)
//
//so according to master theory, we got O(nklogk)
//time complexity should be O(logk), the size of recursion stack


public class MergeKLists{
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val ){
			this.val = val;
		}
	}

	public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
        	return null;
        }

        return helper(lists,0,lists.length-1);
    }

    private static ListNode helper(ListNode[] lists,int left, int right){
    	if(left < right){
    		int m = left+(right-left)/2;
    		return merge(helper(lists,left,m),helper(lists,m+1,right));
    	}
    	return lists[left];
    }

    private static ListNode merge(ListNode l1, ListNode l2){
    	if(l1 == null && l2 == null){
    		return null;
    	}
    	if(l1 == null){
    		return l2;
    	}
    	if(l2 == null){
    		return l1;
    	}
    	ListNode fakeHead = new ListNode(-1);
    	fakeHead.next = l1;
    	ListNode pre = fakeHead;
    	while(l1 != null && l2 != null){
    		if(l1.val > l2.val){
    		ListNode next = l2.next;
    		l2.next = pre.next;
    		pre.next = l2;
    		l2 = next;
    	}else{
    		l1 = l1.next;
    	}
    	pre = pre.next;
    	}
    	if(l2 != null){
    		pre.next = l2;
   		 return fakeHead.next;
    	}
	}

	//Another possible solution is that using a min heap to solve this problem
	//We maintain a min heap of size k, where k is the number of lists
	//everytime we pop the smallest one from the heap, connect it to the res, 
	//and put the next node of this node in the heap
	//keep doing that until the size of heap is 0
	//the complexity is O(nklogk)
	//totally we need to visit n*k nodes, and for each node, the insertion into min heap is O(logk) operation
	public static ListNode mergeKListsHeap(List[] lists){
		Comparator<ListNode> comp = new Comparator<ListNode>(){
			@Override
			public int compare(ListNode l1, ListNode l2){
				return l1.val-l2.val;
			}
		};
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(10,comp);
		for(int i = 0;i<lists.length;i++){
			if(lists[i] != null){
				queue.offer(lists[i]);
			}
		}
		ListNode head = null;
		ListNode pre = head;
		while(queue.size()>0){
			ListNode cur = queue.poll();
			if(pre == null){
				head = cur;
				pre = head;
			}else{
				pre.next = cur;
				pre = pre.next;

			}
			if(cur.next != null){
				queue.offer(cur.next);
			}
		}
		return head;
	}

	//What if the input is sorted Array, but not lists
	//The tricky part will be how to get which array current element belong to 

	//My idea is that using a Wrapper class like following

	class ArrayElement{
		//array means which array it belongs to 
		int array;
		//index means the index in the array
		int index;
		//element means the actual value 
		int element;
		public ArrayElement(int array, int index, int element){
			this.array = array;
			this.index = index;
			this.element = element;
		}
	}
}
