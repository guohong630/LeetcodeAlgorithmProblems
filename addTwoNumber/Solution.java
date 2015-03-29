package addTwoNumber;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode fakeHead = new ListNode(0);
        ListNode cur = fakeHead;
        
        while (l1 != null || l2 !=null) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            ListNode temp = new ListNode(carry%10);
            cur.next = temp;
            cur = cur.next;
            carry = carry/10;
        }
        
        if (carry != 0) {
            ListNode temp = new ListNode(carry);
            cur.next = temp;
        }
        
        return fakeHead.next;
    }
}
