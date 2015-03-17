package removeNthNodeFromEndofList;

import sortList.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null ;
        }
        int i = 0;
        ListNode beast = head;
        ListNode pre = head;
        while (beast != null && i < n) {
            beast = beast.next;
            i++;
        }
       
        if (i < n) {
            return head;
        }
        if (beast == null) {
            // remove head
            return head.next;
        }
        // here is beast.next != null
        while (beast.next != null) {
            beast = beast.next;
            pre = pre.next;
        }
       
        pre.next = pre.next.next;
       
        return head;
    }

}
