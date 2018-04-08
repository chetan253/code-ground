class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy.next;
        ListNode prev = dummy;
        if(head == null){
            return head;
        }
        while(node.next != null){
            if(node.val == val){
                prev.next = node.next;
                node = prev.next;
                continue;
            }
            prev = node;
            node = node.next;
        }
        if(node.val == val)
            prev.next = null;
        return dummy.next;
    }
}
