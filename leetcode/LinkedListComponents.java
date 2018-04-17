/**
 *Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    HashSet<Integer> set = new HashSet<Integer>();
    public int getSets(ListNode node){
        int count = 0;
        boolean prev_status = false;
        while(node != null){
            if(set.contains(node.val)){
                prev_status = true;
            }
            if(!set.contains(node.val)){
                if(prev_status){
                    count++;
                }
                prev_status = false;
            }
            node = node.next;
        }
        return prev_status == true ? count + 1 : count;
    }
    
    public int numComponents(ListNode head, int[] G) {
        for(int i : G){
            set.add(i);
        }
        return getSets(head);       
    }
}
