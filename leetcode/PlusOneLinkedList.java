/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode plusOne(ListNode head) {
        if(head == null){
            return head;
        }
        
        int rem = addOne(head);
        
        while(rem != 0){
            ListNode node = new ListNode(rem%10);
            node.next = head;
            head = node;
            rem /= 10;
        }
        
        return head;
    }
    
    public int addOne(ListNode node){
        if(node.next == null){
            int num = node.val + 1;
            node.val = num % 10;
            return num/10;
        }
        int n = addOne(node.next);
        int sum = n + node.val;
        node.val = sum % 10;
        return sum / 10;
    }
}
