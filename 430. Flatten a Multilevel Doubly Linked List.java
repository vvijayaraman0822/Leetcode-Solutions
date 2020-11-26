// 430. Flatten a Multilevel Doubly Linked List

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        Node dummy = head;
        Stack<Node> stack = new Stack<>();
        while(head != null) {
            if (head.child != null) {
                if (head.next !=  null) {
                    stack.push(head.next); // push all the nodes to the right when you see a child for that node
                }
                head.next = head.child; // set current head's next to the child node
                head.next.prev = head; // setting child's prev to the current head
                head.child = null;
            } else if (head.next == null && !stack.isEmpty()) { // if the there is no next node then you need to get to previous level by popping the nodes
                head.next = stack.pop(); // pop and set the current head's next to it
                head.next.prev = head; // set the popped value's previous to current head; 
            }
            head = head.next;
        }
     
        return dummy;
    }
}