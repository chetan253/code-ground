/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode node = head;
        ListNode prev = null;
        ListNode tail = null;
        int length = 0;
        while(node != null){
            length++;
            prev = node;
            node = node.next;
        }
        tail = prev;
        if(length == 0 || length == 1 || k%length == 0 || tail == null){
            return head;
        }
        node = head;
        prev = null;
        int i = 0;
        while(i != length - (k%length)){
            prev = node;
            node = node.next;
            i++;
        }
        ListNode newHead = prev.next;
        tail.next = head;
        prev.next = null;
        return newHead;
    }
}
