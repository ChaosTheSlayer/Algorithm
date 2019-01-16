package LinkedList;

//Question: https://leetcode.com/problems/rotate-list/

public class RotateList{

	static class ListNode{
		int val;
 	  	ListNode next;
 	    ListNode(int x) { val = x; }
	}

	//general idea is that find the kth node from the back, and put it and it's subsequence
	//at the end
	//using two pointer, first pointer move k nodes, then move together
	//when first pointer points at the last node of list, the second.next should be the kth node from the back
	    public static  ListNode rotateRight(ListNode head, int k) {
	    	//check corner cases
        if(head == null ||head.next == null || k<0){
        	return head;
        }
        //get the length of given linkedlist
        //becuase k might be bigger than the length of list
        int len = lengthOfList(head);
       
        //dealing with k > len
        k = k%len;
        if(k == 0){
            return head;
        }
        ListNode runner = head;
        ListNode walker = head;
        int count = 0;
        while(count <k){
        	runner = runner.next;
        	count++;
        }
      
        while(runner.next != null){
        	runner = runner.next;
        	walker = walker.next;
        }
        ListNode newHead = walker.next;
        runner.next = head;
        walker.next = null;
        return newHead;

    }

    private static int lengthOfList(ListNode head){
    	if(head == null){
    		return 0;
    	}
    	int sum = 0;
    	while(head != null){
    		sum++;
    		head = head.next;
    	}
    	return sum;
    }

    //One pass

    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k<= 0){
            return head;
        }
        
        ListNode runner = head;
        ListNode walker = head;
        int count = 0;
        while(count < k ){
            if(runner.next == null){
                k = k%(count+1);
                runner = head;
                count = 0;
            }else{
                runner = runner.next;
                count++;
            }
            
        }
        if(k == 0){
            return head;
        }
        while(runner.next != null){
            walker = walker.next;
            runner = runner.next;
        }
        ListNode newHead = walker.next;
        walker.next = null;
        runner.next = head;
        return newHead;
    }
}