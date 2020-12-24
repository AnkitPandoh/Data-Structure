package graphs.dijkastra;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Vertex a = new Vertex("A");
        Vertex b = new Vertex("B");
        Vertex c = new Vertex("C");
        Vertex d = new Vertex("D");
        Vertex e = new Vertex("E");
        Vertex f = new Vertex("F");

        Edge ab = new Edge(a,b,10);
        Edge ac = new Edge(a,c,15);
        Edge bd = new Edge(b,d,12);
        Edge df = new Edge(d,f,1);
        Edge de = new Edge(d,e,2);
        Edge ba = new Edge(b,a,10);
        Edge ca = new Edge(c,a,15);
        Edge fd = new Edge(f,d,1);
        Edge ed = new Edge(e,d,2);

//        Edge ab = new Edge(a, b, 5);
//        Edge ad = new Edge(a, d, 9);
//        Edge ae = new Edge(a, e, 2);
//        Edge bc = new Edge(b, c, 2);
//        Edge ba = new Edge(b, a, 5);
//        Edge cb = new Edge(c, b, 2);
//        Edge cd = new Edge(c, d, 3);
//        Edge da = new Edge(d, a, 9);
//        Edge dc = new Edge(d, c, 3);
//        Edge df = new Edge(d, f, 2);
//        Edge ea = new Edge(e, a, 2);
//        Edge ef = new Edge(e, f, 3);
//        Edge fd = new Edge(f, d, 2);
//        Edge fe = new Edge(f, e, 3);

        List<Vertex> vertices = Arrays.asList(a, b, c, d, e, f);
       // List<Edge> edges = Arrays.asList(ab, ad, ae, bc, ba, cb, cd, da, dc, df, ea, ef, fd, fe);
        List<Edge> edges = Arrays.asList(ab, ac, bd, df, de, ba, ca, fd, ed);
        Graph graph = new Graph(vertices, edges);
        Dijkastra dijkastra = new Dijkastra(graph, a);
        Map<Vertex, Integer> shortestPath = dijkastra.getShortestPath();
        shortestPath.entrySet().stream()
                .forEach(entry -> System.out.println("Vertex:" + entry.getKey().name + "," + "Cost:" + entry.getValue()));
    }
}
