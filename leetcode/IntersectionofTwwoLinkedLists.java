/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int cA = getCount(headA);
        int cB = getCount(headB);
        
        if(cA > cB){
            int d = cA - cB;
            return getIntersection(d, headA, headB);
        }
        else{
            int d = cB - cA;
            return getIntersection(d, headB, headA);
        }
    }
    
    public ListNode getIntersection(int d, ListNode node1, ListNode node2){
        ListNode temp1 = node1;
        ListNode temp2 = node2;
        
        for(int i = 0; i < d; i++){
            temp1 = temp1.next;
        }
        
        while(temp1 != null && temp2 != null){
            if(temp1 == temp2){
                return temp1;
            }
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        
        return null;
    }
    
    public int getCount(ListNode node){
        int c = 0;
        ListNode temp = node;
        
        while(temp != null){
            c++;
            temp = temp.next;
        }
        return c;
    }
}
