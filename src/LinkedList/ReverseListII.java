package LinkedList;

public class ReverseListII{

	public ListNode reverseBetween(ListNode head, int m , int n){
		if(head == null || head.next == null){
			return ;
		}
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		int i = 1;
		while(pre.next != null && i<m){
			pre = pre.next;
			i++;
		}
		if(i<m){
			return head;
		}
		ListNode mNode = pre.next;
		ListNode cur = mNode.next;
		while(i<n){
			ListNode next = cur.next;
			cur.next = pre.next;
			pre.next = cur.next;
			mNode.next = next;
			cur = next;
			i++;
		}
		return fakeHead.next;
	}
}