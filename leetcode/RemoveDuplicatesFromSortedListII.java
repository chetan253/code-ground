/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode lastUnique = dummy, prev = head, node = head.next;
        boolean flag = false;
        while(node != null){
            while(node != null && node.val == prev.val){
                node = node.next;
                flag = true;
            }
            if(node == null)
                break;
            if(flag){
                lastUnique.next = node;
                prev = lastUnique;
                flag = false;
                continue;
            }
            lastUnique = prev;
            prev = node;
            node = node.next;
        }
        if(flag){
            lastUnique.next = null;
        }
        return dummy.next;
    }
}
