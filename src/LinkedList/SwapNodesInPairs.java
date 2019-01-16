package LinkedList;

//Question:https://leetcode.com/problems/swap-nodes-in-pairs/

public class SwapNodesInPairs{
	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}

	public static ListNode swapInPairs(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		//Still using two pointer to solve this
		//First we need a fakeHead, so that after the swap, we can return the head
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		//ListNode pre means the last node that already been swaped
		ListNode pre = fakeHead;
		//ListNode cur means the next node that need to be swapped
		ListNode cur = head;
		while(cur != null && cur.next != null){
			//cur == null means all the nodes are swapped
			//cur.next == null means that there are odd number nodes, so the last one don't need to be swap

			//save the nextstart
			ListNode nextStart = cur.next.next;
			// using fakehead->1->2->3 as example,cur is 1 right now
			// now 2->1
			cur.next.next = cur;
			//fakeHead->2->1
			pre.next = cur.next;
			//fakeHead->2->1->3
			cur.next = nextStart;
			//pre = 1
			pre = cur;
			//cur = 3
			cur = nextStart;

		}
		return fakeHead.next;
	}
}