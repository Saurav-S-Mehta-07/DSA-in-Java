package Hashing;
import java.util.*;

class LRUCache {

    // Doubly Linked List Node
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    // Constructor
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        // Dummy nodes for easy head/tail handling
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    // Remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Insert a node right after head (most recently used)
    private void insertAtHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // Get value of key
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);         // remove from current position
        insertAtHead(node);   // move to head as most recently used
        return node.value;
    }

    // Put key-value pair
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;  // update value
            remove(node);
            insertAtHead(node);
        } else {
            if (map.size() == capacity) {
                // Evict LRU node
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertAtHead(node);
        }
    }

    // For testing
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache: {1=1}
        lruCache.put(2, 2); // cache: {1=1, 2=2}
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2
        System.out.println(lruCache.get(2)); // returns -1
        lruCache.put(4, 4); // evicts key 1
        System.out.println(lruCache.get(1)); // returns -1
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}
