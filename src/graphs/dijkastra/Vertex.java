package graphs.dijkastra;

public class Vertex {

    String name;
    int cost;

    public Vertex(String name){
        this.name = name;
    }

    public Vertex(String name, int cost){
        this.name = name;
        this.cost = cost;
    }
}
