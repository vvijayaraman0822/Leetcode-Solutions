706. Design HashMap

class MyHashMap {
    
      ListNode[] bucket;
    
    /** Initialize your data structure here. */
    public MyHashMap() {
       bucket = new ListNode[10000];   
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getIndex(key);
        ListNode prev = findLastElement(index, key);
        
        if (prev.next == null) {
            prev.next = new ListNode(key, value);
        } else {
            prev.next.value = value;
        }
    }
    
    // which bucket should the Node go into
    public int getIndex(int key) {
        int hashCode = Integer.hashCode(key);
        return hashCode % bucket.length;
    }
    
    public ListNode findLastElement(int index, int key) {
        if (bucket[index] == null) {
            return bucket[index] = new ListNode(-1, -1);
        }
        
        ListNode prev = bucket[index];
        while (prev.next != null && prev.next.key != key) {
            prev = prev.next;
        }
        return prev;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = getIndex(key);
        ListNode prev = findLastElement(index, key);
        return prev.next == null ? -1 : prev.next.value;       
        
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getIndex(key);
        
        ListNode prev = findLastElement(index, key);
        if (prev.next != null) {
            prev.next = prev.next.next;
        }
    }
    
    public static class ListNode {
        int key;
        int value;
        ListNode next;
    
    public ListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */