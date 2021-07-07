package map;

import java.util.*;

public class MyHashMap {
    private LinkedList<Node>[] buckets;
    private int capacity;
    private int count;
    private double loadFactor;
    private Node head;
    private Node tail;


    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
        this.capacity = 10;
        this.buckets = new LinkedList[capacity];
        this.count = 0;
        this.loadFactor = 0.75;
        this.head = new Node(-1,-1);
        this.tail = new Node(-2,-2);
        this.head.next = this.tail;
        this.tail.prev = head;
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int index = hash(key);
        // key already present in the hashmap
        if (this.buckets[index] != null) {
            LinkedList<Node> nodes = this.buckets[index];
            for (Node node : nodes) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
            }
        }
        // key doesn't exist in the hashmap
        // check if capacity is full
        if (this.capacity * this.loadFactor == this.count) {
            // rehash the existing keys
            this.capacity *= 2;
            LinkedList<Node>[] oldBuckets = this.buckets;
            this.buckets = new LinkedList[this.capacity];
            for (int i = 0; i < oldBuckets.length; i++) {
                if (oldBuckets[i] != null) {
                    for (Node node : oldBuckets[i]) {
                        int indx = hash(node.key);
                        LinkedList<Node> nodes = this.buckets[indx];
                        if (nodes == null)
                            nodes = new LinkedList<>();
                        nodes.addFirst(node);
                        buckets[indx] = nodes;
                    }
                }
            }
        }

        LinkedList<Node> nodes = this.buckets[index];
        if (nodes == null)
            nodes = new LinkedList<>();
        Node node = new Node(key, value);
        nodes.addFirst(node);
        addToDoublyLinkedList(node);
        buckets[index] = nodes;
        this.count++;
    }

    /**
     * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
     */
    public int get(int key) {
        int index = hash(key);
        if (this.buckets[index] == null || this.buckets[index].isEmpty())
            return -1;
        LinkedList<Node> nodes = this.buckets[index];
        for (Node node : nodes) {
            if (node.key == key)
                return node.value;
        }
        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     */
    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null || this.buckets[index].isEmpty())
            return;
        List<Node> nodes = this.buckets[index];
        Iterator<Node> itr = nodes.iterator();
        while (itr.hasNext()) {
            Node node = itr.next();
            if (node.key == key) {
                itr.remove();
                count--;
                removeFromDoublyLinkedList(node);
                return;
            }
        }
    }

    public List<Integer> keySet() {
        if (buckets.length == 0)
            return null;
        List<Integer> keys = new ArrayList<>();
        Node curr = head.next;
        while(curr != tail){
            keys.add(curr.key);
            curr = curr.next;
        }
        return keys;
    }

    private int hash(int key) {
        return key % this.capacity;
    }

    private void addToDoublyLinkedList(Node node){
        node.next = tail;
        node.prev = tail.prev;
        tail.prev = node;
        node.prev.next = node;
    }

    private void removeFromDoublyLinkedList(Node node){
        Node next = node.next;
        next.prev = node.prev;
        node.prev.next = node.next;
    }

    static class Node {
        int value;
        int key;
        Node next;
        Node prev;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return key == node.key;
        }

        @Override
        public int hashCode() {
            return Objects.hash(key);
        }

        Node(int key, int value) {
            this.value = value;
            this.key = key;

        }
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put(3, 7);
        map.put(4, 8);
        System.out.println(map.get(3)); // 7
        System.out.println(map.get(4)); // 8
        map.put(2, 3);
        map.put(3, 9);
        map.put(1, 2);

        map.put(4, 5);
        map.put(6, 7);
        map.put(7, 8);
        map.put(8, 9);
        map.put(9, 10);

        map.remove(2);

        System.out.println(map.get(3)); // 9
        System.out.println(map.get(4)); // 5
        System.out.println(map.get(5)); // -1
        System.out.println(map.get(6)); // 7
        System.out.println(map.get(7)); // 8

        for(int key : map.keySet())
            System.out.print(key +" ");
    }
}
