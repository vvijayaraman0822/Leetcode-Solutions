// 160 - Intersection of Two Linked Lists

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        Set<ListNode> set = new HashSet<>();
        
        while(first != null) {
            set.add(first);
            first = first.next;
        }
        
        ListNode second = headB;
        while(second != null) {
            if(set.contains(second)) {
                return second;
            }
            second = second.next;
        }
        return null;
    }
    
}