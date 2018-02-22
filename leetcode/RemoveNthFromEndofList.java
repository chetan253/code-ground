/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    int d = 0;
    public ListNode printList(ListNode node, int n){
        if(node == null){
            return null;
        }
        printList(node.next, n);
        d--;
        if(d == -1){
            node.next = node.next.next;
        }
        return null;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        d = n;
        ListNode h = new ListNode(0);
        h.next = head;
        printList(h, n);
        return h.next;
    }
}
