package graphs.dijkastra;

import java.util.Objects;

public class VertexMinHeap {

    Vertex vertex;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VertexMinHeap that = (VertexMinHeap) o;
        return Objects.equals(vertex, that.vertex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vertex);
    }

    int cost;

    public VertexMinHeap(Vertex vertex, int cost){
        this.vertex = vertex;
        this.cost = cost;
    }
}
