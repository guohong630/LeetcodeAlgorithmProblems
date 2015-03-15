package sortList;

public class Sort {
    public static ListNode merge( ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(0);
       
        ListNode pos = fakeHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pos.next = l1;
                l1 = l1.next;
            }
            else {
                pos.next = l2;
                l2 = l2.next;
            }
            pos = pos.next;
        }
       
        if (l1 == null ) {
            pos.next = l2;
        }
        if (l2 == null ) {
            pos.next = l1;
        }
       
        return fakeHead.next;
}
    
    public static ListNode sortList(ListNode head){
        if (head==null || head.next==null){
            return head;
        }
       
        ListNode counter=head;
        int len=0;
        while(counter!=null){
            counter=counter.next;
            len++;
        }
        ListNode[] headArray={head};
        return mergeSort(headArray, len);
       
                
     }
    
     private static ListNode mergeSort(ListNode[] headArray, int len){
         if (len==1){
            
             ListNode temp=headArray[0];
             headArray[0]=headArray[0].next;
            
             temp.next= null;
            
             return temp;
         }
        
         ListNode left=mergeSort(headArray, len/2);
         ListNode right=mergeSort(headArray, len-len/2);
        
         return merge(left, right);
        
        
     }
     
     public static void main(String args[]) {
         ListNode l1 = new ListNode(1);
         ListNode l2 = new ListNode(5);
         ListNode l3 = new ListNode(3);
         ListNode l4 = new ListNode(6);
         l1.next=l2;
         l2.next = l3;
         l3.next = l4;
         
         ListNode cur = Sort.sortList(l1);;
         ListNode cur1 = null;
         while(cur != null) {
             System.out.println(cur.val);
             cur= cur.next;
         }
         cur = Sort.sortList(cur1);
         while(cur != null) {
             System.out.println(cur.val);
             cur= cur.next;
         }
     }
    
}
