public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null)
            return false;
        ListNode fastPtr = head.next;
        ListNode slowPtr = head;
        
        while(fastPtr != slowPtr){
            if(fastPtr == null || fastPtr.next == null)
                return false;
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        return true;
    }
}
