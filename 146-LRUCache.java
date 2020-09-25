// 146. LRU Cache

class LRUCache {
    
    HashMap<Integer, Node> cacheMap;
    Node head = new Node();
    Node tail = new Node();
    int capacity = 0;
    
    public LRUCache(int capacity) {
        cacheMap = new HashMap<>(capacity);
        head.next = tail; // link head and tail in the beginning
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        int result = -1;
        
        Node returnNode = cacheMap.get(key); // return the node from the Map
        if (returnNode != null) { // if the value exists in the map, just return it's value and change position in the list
            result = returnNode.value;
            removeNode(returnNode); // removes the last node
            addNode(returnNode); // add to beginning of the list           
        } 
        return result;
    }
    
    public void put(int key, int value) {
        Node getNode = cacheMap.get(key); //see if the value already exists in the map 
        if (getNode != null) { // if it already exists, all you have to do is update it's value  and change position in the list 
            getNode.value = value; 
            removeNode(getNode);
            addNode(getNode);
        } else {
          if (cacheMap.size() == capacity) { // if cache is at its capacity
              cacheMap.remove(tail.prev.key); // evict last item from map
              removeNode(tail.prev); // also remove from the list
          }  
            
            Node newNode = new Node(key, value);
            cacheMap.put(key, newNode);
            addNode(newNode);
        }     
    }
    
    public void addNode(Node newNode) {
        Node headNext = head.next; //get the currentHead
        head.next = newNode; // real head.next will be the new node we are trying to add 
        newNode.prev = head; // newNode's prev will be the dummy head
        newNode.next = headNext; // new Node's next will be whatever the previous first node was that we saved 
        headNext.prev = newNode; // previous head's prev will be the new node we just added
    }
    
    public void removeNode(Node newNode) {
        Node nextNode = newNode.next; // get the next node of the node you are trying to remove
        Node prevNode = newNode.prev; // get the prev node of the node you are trying to remove
        prevNode.next = nextNode; // link those two nodes
        nextNode.prev = prevNode; 
    }
    
    public static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        public Node() {
            
        }
        
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */