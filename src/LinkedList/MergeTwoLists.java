package LinkedList;

//Question: https://leetcode.com/problems/merge-two-sorted-lists/

public class MergeTwoLists{
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}
	//usually take one as basic line,then do the merge
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null && l2 == null){
			return null;
		}
		//if only l1 is null, return l2
		if(l1 == null){
			return l2;
		}
		//same for l1
		if(l2 == null){
			return l1;
		}
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = l1;
		ListNode pre = fakeHead;
		//Usually use one list as baseline, and try to insert the other one to the appropiate
		//position.
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
		}
		return fakeHead.next;
	}
}