/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode l1Node = l1, l2Node = l2, res= head;
        int carry = 0;
        while(l1Node != null || l2Node != null){
            int l11 = (l1Node == null) ? 0 : l1Node.val;
            int l22 = (l2Node == null) ? 0 : l2Node.val;
            int result = l11 + l22 + carry;
            carry = result / 10;
            res.next = new ListNode(result % 10);
            res = res.next;
            if(l1Node != null)
		    l1Node = l1Node.next;
            if(l2Node != null)
		    l2Node = l2Node.next;
        }
        if(carry > 0){
            res.next = new ListNode(carry);
        }
        return head.next;
    }
}
