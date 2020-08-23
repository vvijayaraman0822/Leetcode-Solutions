142. Linked List Cycle II

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
           return null; 
        }
        
        ListNode slowPointer = head;
        ListNode fastPointer = head.next;
        
        while(slowPointer != fastPointer) {
            if (slowPointer == null || fastPointer == null || fastPointer.next == null) {
                return null;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        
        // Slow and Fast Pointer will eventually meet 
        slowPointer = head;
        while (slowPointer != fastPointer.next) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        
        return slowPointer;
    }
}