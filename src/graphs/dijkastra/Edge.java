package graphs.dijkastra;

public class Edge {
    Vertex to;
    Vertex from;
    int cost;

    public Edge(Vertex from, Vertex to, int cost){
        this.to = to;
        this.from = from;
        this.cost = cost;
    }
}
