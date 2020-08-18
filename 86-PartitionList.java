// 86. Partition List
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallNode = new ListNode(0); // at the end, this will be at the end of small LinkedList
        ListNode startSmallNode = smallNode; // this will be at the beginning of small LinkedList
        ListNode bigNode = new ListNode(0); // this will be at the end of big LinkedList
        ListNode startBigNode = bigNode; // this will be at the beginning of big LinkedList
        ListNode current = head;
        
        while(current != null) {
            if(current.val < x) {
                smallNode.next = current;
                smallNode = smallNode.next;
            } else {
                bigNode.next = current;
                bigNode = bigNode.next;
            }
            current = current.next;
        }
        
        bigNode.next = null;
        smallNode.next = startBigNode.next;
        return startSmallNode.next;
    }
}