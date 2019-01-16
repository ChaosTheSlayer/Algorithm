package LinkedList;

public class RemoveDuplicatefromSortedListII{
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode fakeHead = new ListNode(-1);
        ListNode pre = fakeHead;
        fakeHead.next = head;
        ListNode cur = head;
        while(cur != null){
            while(cur.next != null && pre.next.val == cur.next.val){
                cur = cur.next;
            }
            if(pre.next == cur){
                pre = pre.next;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return fakeHead.next;
    }
}