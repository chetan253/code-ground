/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    boolean flag = false;
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1 == null && l2 == null){
            return l1;
        }
        
        if(!flag && getLength(l1) < getLength(l2)){
            flag = !flag;
            return addTwoNumbers(l2, l1);
        }
        
        Stack<ListNode> s1 = new Stack<ListNode>();
        Stack<ListNode> s2 = new Stack<ListNode>();
        
        addElem(l1, s1);
        addElem(l2, s2);
        
        int rem = 0;
        
        while(!s1.isEmpty()){
            
            ListNode n1 = s1.pop();
            ListNode n2 = s2.isEmpty() ? null : s2.pop();
            
            int num1 = n1.val;
            int num2 = n2 == null ? 0 : n2.val;
            
            int total = num1 + num2 + rem;
            rem = total / 10;
            total = total % 10;
            
            n1.val = total;
        }
        
        ListNode temp = l1;
        
        if(rem == 0){
            return l1;
        }
        
        while(rem != 0){
            int val = rem % 10;
            rem = rem / 10;
            ListNode newNode = new ListNode(val);
            newNode.next = temp;
            temp = newNode;
        }
        
        return temp;
    }
    
    public void addElem(ListNode head, Stack<ListNode> s){
        ListNode temp = head;
        
        while(temp != null){
            s.push(temp);
            temp = temp.next;
        }
    }
    
    public int getLength(ListNode head){
        ListNode temp = head;
        int len = 0;
        
        while(temp != null){
            len++;
            temp = temp.next;
        }
        
        return len;
    }
}
