package graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Traversal {

    void bfs(ArrayList<ArrayList<Integer>> graph, int start) {
        System.out.println("Printing BFS");
        boolean visited[] = new boolean[graph.size()];
        Queue<Integer> qu = new LinkedList<>();
        qu.add(start);
        visited[start] = true;

        while (!qu.isEmpty()) {
            int u = qu.poll();
            System.out.print(u + "->");
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    qu.add(v);
                    visited[v] = true;
                }
            }
        }
    }

    void dfs(ArrayList<ArrayList<Integer>> graph, int u, boolean[] visited) {
        if (visited[u]) {
            return;
        }
        System.out.print(u + "->");
        visited[u] = true;
        for (int v : graph.get(u)) {
            if (!visited[v]) {
                dfs(graph, v, visited);
            }
        }
    }

    void dfsNonRecursive(ArrayList<ArrayList<Integer>> graph, int start) {
        System.out.println("Non Recursive DFS");
        boolean[] visited = new boolean[graph.size()];
        Stack<Integer> st = new Stack<>();
        st.push(start);
        visited[start] = true;
        while (!st.isEmpty()) {
            int u = st.pop();
            System.out.print(u + "->");
            for (int v : graph.get(u)) {
                if (!visited[v]) {
                    st.push(v);
                    visited[v] = true;
                }
            }
        }
    }


    ArrayList<ArrayList<Integer>> undirectedGraph(int vertices) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        addEdgeUndirected(graph, 0, 1);
        addEdgeUndirected(graph, 0, 4);
        addEdgeUndirected(graph, 0, 5);

        addEdgeUndirected(graph, 1, 4);
        addEdgeUndirected(graph, 1, 2);
        addEdgeUndirected(graph, 1, 3);

        addEdgeUndirected(graph, 2, 3);

        addEdgeUndirected(graph, 3, 4);

        return graph;
    }

    ArrayList<ArrayList<Integer>> directedGraph(int vertices) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            graph.add(new ArrayList<>());
        }
        addEdgeDirected(graph, 0, 1);
        addEdgeDirected(graph, 0, 4);
        addEdgeDirected(graph, 0, 5);

        addEdgeDirected(graph, 1, 3);
        addEdgeDirected(graph, 1, 4);

        addEdgeDirected(graph, 2, 1);

        addEdgeDirected(graph, 3, 2);
        addEdgeDirected(graph, 3, 4);

        return graph;
    }

    void addEdgeUndirected(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }

    void addEdgeDirected(ArrayList<ArrayList<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
    }

    public static void main(String[] args) {
        Traversal tr = new Traversal();
        ArrayList<ArrayList<Integer>> undirectedGraph = tr.undirectedGraph(6);
        ArrayList<ArrayList<Integer>> directedGraph = tr.directedGraph(6);

//        for (int i = 0; i < graph.size(); i++) {
//            for (int j = 0; j < graph.get(i).size(); j++) {
//                System.out.print(graph.get(i).get(j) + " ");
//            }
//        }
        System.out.println("Undirected Graph");
        tr.bfs(undirectedGraph, 0);
        System.out.println();
        tr.dfs(undirectedGraph, 0, new boolean[directedGraph.size()]);

        System.out.println();

        System.out.println("Directed Graph");
        tr.bfs(directedGraph, 0);
        System.out.println();
        tr.dfs(directedGraph, 0, new boolean[directedGraph.size()]);

        tr.dfsNonRecursive(directedGraph, 0);

    }


}
