 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ListNode rem;
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        while(curr != null || curr.next != null){
            ListNode temp = curr.next;
            ListNode newHead = reverse(curr.next, k);
            if(newHead == null){
                break;
            }
            curr.next = newHead;
            curr = temp;
            curr.next = rem;
        }
        return dummyHead.next;
    }
    
    public ListNode reverse(ListNode n, int k){
        if(n == null || k == 1){
            if(n != null){
                rem = n.next;
            }
            return n;
        }
        ListNode head = reverse(n.next, k-1);
        if(head != null){
            n.next.next = n;
            n.next = null;
        }
        return head;
    }
}
