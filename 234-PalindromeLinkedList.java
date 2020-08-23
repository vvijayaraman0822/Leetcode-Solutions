// 234 - Palindrome Linked List

class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        } 
        
        slowPointer = reverseLinkedList(slowPointer);
        fastPointer = head;
        while(slowPointer != null) {
            if (slowPointer. val != fastPointer.val) {
                return false;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        
        return true;
       
    }
        
        public ListNode reverseLinkedList(ListNode slowPointer) {
            ListNode prev = null;
            ListNode current = slowPointer;
            ListNode next = null;
            while (current != null) {
               next = current.next;
               current.next = prev;
               prev = current;
               current = next;               
            }
            
            return prev;
        }
} 