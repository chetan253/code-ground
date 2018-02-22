/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode curr= dummyhead;
        int c = 0;
        while(curr != null){
            c++;
            curr = curr.next;
        }
        curr = dummyhead;
        ListNode prev= null;
        int counter = 1;
        c = c % 2 == 0? c - 1 : c;
        while(counter < c){
            if(counter % 2 == 0){
                ListNode temp = curr.next.next;
                prev.next = curr.next;
                prev.next.next = curr;
                curr.next = temp;
                
                prev = prev.next;
                curr = prev.next;
                counter++;
                continue;
            }
            prev = curr;
            curr = curr.next;
            counter++;
        }
        return dummyhead.next;
    }
}
