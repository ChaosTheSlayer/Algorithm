package LinkedList;

public class AddTwoNumber{
	static class ListNode{
		int val;
		ListNode next;
		public ListNode(int val){
			this.val = val;
		}
	}

	public static ListNode addTwoNumber(ListNode a, ListNode b){
		if(a == null || b == null){
			return a == null? b:a;
		}

		int carry = 0;
		ListNode head = new ListNode(-1);
		ListNode fakeHead = head;
		while(a != null && b != null){
			int cur = (a.val+b.val+carry)%10;
			carry = (a.val+b.val+carry)/10;
			head.next = new ListNode(cur);
			a = a.next;
			b = b.next;
			head = head.next;
		}
		if(a != null){
			int cur = (a.val+carry)%10;
			carry = (a.val+carry)/10;
			head.next = new ListNode(cur);
			head = head.next;
			a = a.next;
		}
		if(b != null){
			int cur = (b.val+carry)%10;
			carry = (b.val+carry)/10;
			head.next = new ListNode(cur);
			head = head.next;
			b = b.next;
		}
		if(carry != 0){
			head.next = new ListNode(carry);
		}
		return fakeHead.next;

	}

	public static void main(String[] args){
		ListNode a = new ListNode(7);
		a.next = new ListNode(3);
		a.next.next = new ListNode(4);
		ListNode b = new ListNode(4);
		b.next = new ListNode(8);
		b.next.next = new ListNode(9);

		ListNode res = addTwoNumber(a,b);
		while(res != null){
			System.out.print(res.val);
			res = res.next;
		}
	}
}