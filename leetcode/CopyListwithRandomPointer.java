/**
 * Definition for singly-linked list with a random pointer.
 * class Node {
 *     int val;
 *     Node next, random;
 *     Node(int x) { this.val = x; }
 * };
 */
public class Solution {
    public Node copyRandomList(Node head) {
        Node newHead = new Node(-1);
        
        Node tempNew = newHead;
        Node tempOld = head;
        
        if(head == null){
            return tempNew.next;
        }
        
        //Make new list with next pointers as old list
        while(tempOld != null){
            Node newNode = new Node(tempOld.val);
            tempNew.next = newNode;
            tempNew = tempNew.next;
            tempOld = tempOld.next;
        }
        
        //Copy random ptrs and poit old list randoms to new lists actual
        tempOld = head;
        tempNew = newHead.next;
        while(tempOld != null){
            tempNew.random = tempOld.random;
            tempOld.random = tempNew;
            tempOld = tempOld.next;
            tempNew = tempNew.next;
        }
        
        //Assign random pointers for new list
        tempNew = newHead.next;
        while(tempNew != null){
            tempNew.random = tempNew.random == null ? null : tempNew.random.random;
            tempNew = tempNew.next;
        }
        return newHead.next;
    }
}
