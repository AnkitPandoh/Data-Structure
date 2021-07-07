package graphs.topological;

import java.util.*;

public class TopoSort {

    Map<Node, List<Node>> graph;

    public Stack<Node> sort() {
        Set<Node> visited = new HashSet<>();
        Stack<Node> st = new Stack<>();
        for (Node vertex : graph.keySet()) {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited, st);
            }
        }
        return st;
    }

    private void dfs(Node vertex, Set<Node> visited, Stack<Node> st) {
        visited.add(vertex);
        for (Node neighbour : graph.get(vertex)) {
            if (!visited.contains(neighbour)) {
                dfs(neighbour, visited, st);
            }
        }
        st.push(vertex);
    }

    private void buildGraph(List<Node> vertices) {
        graph = new HashMap<>();
        for (Node vertex : vertices) {
            graph.put(vertex, new ArrayList<>());
        }
    }

    private void addEdge(Node from, Node to) {
        graph.get(from).add(to);
    }

    static class Node {
        String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(name, node.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

        public Node(String name) {
            this.name = name;
        }
    }


    public static void main(String[] args) {
        TopoSort toposort = new TopoSort();
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");

        toposort.buildGraph(Arrays.asList(a, b, c, d, e, f, g, h));

        toposort.addEdge(a, c);
        toposort.addEdge(b, c);
        toposort.addEdge(c, d);
        toposort.addEdge(b, e);
        toposort.addEdge(d, f);
        toposort.addEdge(e, f);
        toposort.addEdge(f, g);
        toposort.addEdge(f, h);

        Stack<Node> st = toposort.sort();
        while (!st.isEmpty()) {
            System.out.print(st.pop().name + "->");
        }
    }


}
