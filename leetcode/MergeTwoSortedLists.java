/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l1node = l1;
        ListNode l2node = l2;
        ListNode dummyhead = new ListNode(0);
        ListNode node = dummyhead;
        
        while(l1node != null && l2node != null){
            if(l1node.val <= l2node.val){
                node.next = l1node;
                l1node = l1node.next;
            }else{
                node.next = l2node;
                l2node = l2node.next;
            }
            node = node.next;
        }
        if(l1node != null){
            node.next = l1node;
        }
        if(l2node != null){
            node.next = l2node;
        }
        return dummyhead.next;
    }
}
