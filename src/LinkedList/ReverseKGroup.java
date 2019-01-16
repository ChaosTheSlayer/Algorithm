package LinkedList;

//Question:https://leetcode.com/problems/reverse-nodes-in-k-group/

public class ReverseKGroup{

	static class ListNode{
		int val;
		ListNode next;
		ListNode(int val){
			this.val = val;
		}
	}

	public static ListNode reverseKGroup(ListNode head,int k){
		//so the general idea is that still using two pointer,
		//first we keep moving the right pointer, until we got k nodes,
		//reverse the k nodes, then move the left pointer to the next unreverse nodes
		//keep doing this, until the remain node is smaller than k
		if(head == null){
			return null;
		}
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode pre = fakeHead;
		ListNode cur = head;
		int count = 0;
		while(cur != null){
			count++;
			ListNode next = cur.next;
			if(count == k){
				pre = reverse(pre,next);
				count = 0;
			}
			cur = next;

		}
		return fakeHead.next;

	}

	//First we should have a function that reverse all the nodes between certain two nodes
	//pre means the last node that already been reversed
	//end node means that first node that doesn't need to be reverse
	private static ListNode reverse(ListNode pre,ListNode end){
		if(pre == null || pre.next == null){
			return pre;
		}
		//the head node is the first node of pre-reverse list
		//so after the reverse, it should be the last node
		//we need to connect it to the end node
		ListNode head = pre.next;
		//cur node will be pre.next.next
		ListNode cur = pre.next.next;
		while(cur != end){
			//Mark the nextStart node
			//what we did is actually keep insert curNode right behind pre node
			ListNode nextCur = cur.next;
			cur.next = pre.next;
			pre.next = cur;
			cur = nextCur;
		}
		//so in this case, head will become the next pre node for another reverse call
		head.next = end;
		return head;

	}
}