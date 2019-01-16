package LinkedList;


public class RemoveNthNode{

	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}

	public static ListNode removeNthFromEnd(ListNode head, int n){
		//general idea is that we have two pointer
		//walker and runner
		//runner start first, go n step 
		//and walker start to go together with runner
		//so by the time runner hit the end of the list
		//the walker.next should point the node that need to be deleted

		//so this question is more about corner cases
		//first, n is invalid, return null?
		//second, we want to remove the nth node from the end, which is the head

		if(head == null || n<=0||(head.next == null && n==1)){
			return null;
		}
		ListNode newHead = head;
		ListNode runner = head;
		ListNode walker = head;
		int count = 0;
		while(count != n){
			walker = walker.next;
			count++;
			//means we hit the end of the list, and what we want to delete is the first node of the list
			if(walker.next == null && count == n-1){
				return head.next;
			}else if(walker.next == null && count <n-1){
				//invalid n, there is not enough node to be delete
				return head;
			}
		}
		while(walker.next != null){
			walker = walker.next;
			runner = runner.next;

		}
		runner.next = runner.next.next;
		return head;
	}
}