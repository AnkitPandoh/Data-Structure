package graphs.dijkastra;

import java.util.*;
import java.util.stream.Collectors;

public class Dijkastra {

    Map<Vertex, Integer> cost;
    Map<Vertex, Vertex> parent;
    PriorityQueue<VertexMinHeap> pq;
    Set<Vertex> visited;
    List<Vertex> vertices;
    List<Edge> edges;

    public Dijkastra(Graph graph, Vertex source) {
        vertices = graph.vertices;
        edges = graph.edges;
        visited = new HashSet<>();
        pq = new PriorityQueue<>((o1, o2) -> o1.cost == o2.cost ? 0 : o1.cost > o2.cost ? 1 : -1);
        pq.offer(new VertexMinHeap(source, 0));
        cost = new HashMap<>();
        cost.put(source, 0);
        parent = new HashMap<>();
        parent.put(source, null);
    }

    public Map<Vertex, Integer> getShortestPath() {
        while (!pq.isEmpty()) {
            VertexMinHeap vertexMinHeap = pq.poll();
            Vertex currVertex = vertexMinHeap.vertex;

            if (visited.add(currVertex)) {
                List<Edge> edges = getConnectedEdges(currVertex);
                for (Edge edge : edges)
                    if (!visited.contains(edge.to)) {
                        VertexMinHeap obj = new VertexMinHeap(edge.to, edge.cost);
                        int newCost = calculateCost(edge);
                        if (pq.contains(obj)) {
                            if (getCurrentCost(edge.to) > newCost) {
                                cost.put(edge.to, newCost);
                                parent.put(edge.to, edge.from);
                                pq.remove(obj);
                                pq.offer(new VertexMinHeap(edge.to, newCost));
                            }
                        } else {
                            cost.put(edge.to, newCost);
                            parent.put(edge.to, edge.from);
                            pq.offer(new VertexMinHeap(edge.to, newCost));
                        }
                    }
            }

        }
        return cost;
    }

    public List<Edge> getConnectedEdges(Vertex source) {
        return edges.stream().
                filter(edge -> edge.from.equals(source))
                .collect(Collectors.toList());
    }

    public int getCurrentCost(Vertex vertex) {
        return cost.get(vertex) == null ? Integer.MAX_VALUE : cost.get(vertex);
    }

    public int calculateCost(Edge edge) {
        return cost.get(edge.from) + edge.cost;
    }

}
