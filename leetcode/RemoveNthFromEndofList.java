/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(-1);
        temp.next = head;
        remove(temp, n);
        return temp.next;
    }
    
    public int remove(ListNode node, int n) {
        if(node == null){
            return 0;
        }
        ListNode temp = node;
        int k = remove(node.next, n) + 1;
        if(k-1 == n && temp.next != null){
            temp.next = temp.next.next;
        }
        return k;
    }
}
