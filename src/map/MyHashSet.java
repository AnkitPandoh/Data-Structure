package map;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyHashSet {
    LinkedList<Integer>[] buckets;
    int capacity = 1000;
    double loadFactor = 0.75;
    int count = 0;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        buckets = new LinkedList[capacity];
    }

    public void add(int key) {
        if (contains(key))
            return;
        if (loadFactor * capacity == count) {
            capacity *= 2;
            LinkedList<Integer>[] oldBuckets = buckets;
            buckets = new LinkedList[capacity];
            for (int i = 0; i < oldBuckets.length; i++) {
                if (oldBuckets[i] != null) {
                    for (int k : oldBuckets[i]) {
                        int index = hash(k);
                        LinkedList<Integer> list = buckets[index];
                        if (list == null)
                            list = new LinkedList<>();
                        list.addFirst(k);
                        buckets[index] = list;
                    }

                }
            }
        }
        int index = hash(key);
        LinkedList<Integer> list = buckets[index];
        if (list == null)
            list = new LinkedList<>();
        list.addFirst(key);
        buckets[index] = list;
        count++;
    }

    public void remove(int key) {
        int index = hash(key);
        List<Integer> list = buckets[index];
        if (list == null)
            return;
        Iterator<Integer> itr = list.iterator();
        while (itr.hasNext()) {
            if (itr.next() == key) {
                itr.remove();
                count--;
            }
        }
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        int index = hash(key);
        if (buckets[index] == null)
            return false;

        for (int k : buckets[index]) {
            if (k == key)
                return true;
        }
        return false;
    }

    private int hash(int key) {
        return key % capacity;
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add(2);
        set.add(3);
    }
}
