// 141. Linked List Cycle

// Using a Set. O(n) - Time & Space complexity

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
    public boolean hasCycle(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode current = head;
        while (current != null) {
          if(!nodeSet.contains(current)) {
              nodeSet.add(current);
          } else {
              return true;
          }
            current = current.next;
        }
        return false;
    }
}

// Without Using any DS. O(n) - Time complexity & O(1) - Space Complexity

public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
}
