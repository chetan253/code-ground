/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        //d-1-2-2-1
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = reverse(slow.next);
        slow = head;
        
        while(slow != null && fast != null){
            if(slow.val == fast.val){
                slow = slow.next;
                fast = fast.next;
                continue;
            }
            return false;
        }
        return true;
    }
    
    public ListNode reverse(ListNode node){
        if(node == null || node.next == null){
            return node;
        }
        ListNode head = reverse(node.next);
        node.next.next = node;
        node.next = null;
        return head;
    }
}
