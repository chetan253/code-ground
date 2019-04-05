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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m == n){
            return head;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curr = dummyHead;
        int mP = 0;
        while(mP != m - 1){
            curr = curr.next;
            mP++;
        }
        
        ListNode tempNext = curr.next;
        curr.next = reverse(curr.next, n - m);
        tempNext.next = rem;
        return dummyHead.next;
    }
    
    public ListNode reverse(ListNode node, int n){
        if(n == 0 || node == null || node.next == null){
            if(n == 0){
                rem = node.next;
                node.next = null;
            }
            return node;
        }
        ListNode head = reverse(node.next, n-1);
        node.next.next = node;
        node.next = null;
        return head;
    }
}
