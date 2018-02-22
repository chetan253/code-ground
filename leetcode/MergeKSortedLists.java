/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        if(lists.length== 0)return null;
        ListNode node;
        int counter = 0;
        for(ListNode n : lists){
            node = n;
            if(node == null) 
                continue;
            
            while(node!= null){
                counter++;
                queue.add(node.val);
                node = node.next;
            }
        }
        ListNode dummy;
        if(queue.size() != 0){
            node = new ListNode(queue.poll());
            dummy = node;
            while(queue.size() != 0){
                node.next = new ListNode(queue.poll());
                node = node.next;
            }
        }
        else{
            return null;
        }
        return dummy;
    }
}
