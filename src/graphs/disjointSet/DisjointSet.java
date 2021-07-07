package graphs.disjointSet;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    private Map<Integer, Node> map;

    public DisjointSet() {
        this.map = new HashMap<>();
    }

    public void makeSet(int val) {
        Node node = new Node(val);
        node.parent = node;
        node.rank = 0;
        map.put(val, node);
    }

    public void union(int val1, int val2) {
        Node node1 = map.get(val1);
        Node node2 = map.get(val2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        //if they are part of same set do nothing
        if (parent1.val == parent2.val)
            return;

        //else whoever's rank is higher becomes parent of other
        // if we don't use rank then tree would become skewed and
        // find operation will have O(n) complexity in worst case.
        if (parent1.rank >= parent2.rank) {
            //increment rank only if both sets have same rank
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            parent1.parent = parent2;
        }
    }

    public Node findSet(Node node) {
        if (node == node.parent)
            return node.parent;
        node.parent = findSet(node.parent);
        return node.parent;
    }

    public long findSet(int val) {
        return findSet(map.get(val)).val;
    }

    public static void main(String args[]) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));
    }

    static class Node {
        int val;
        int rank;
        Node parent;

        public Node(int val) {
            this.val = val;
        }
    }
}
