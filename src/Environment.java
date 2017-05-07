import lombok.Getter;

import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;

@Getter
class Environment {

    private int vertexNumber;
    private SimpleWeightedGraph<Integer, Edge> environment;

    Environment(){
        vertexNumber = 5;
        initEnvironment();
    }

    private void initEnvironment(){
        environment = new SimpleWeightedGraph<>(Edge.class);

        for(int i = 1 ; i <= vertexNumber ; i++){
            environment.addVertex(i);
        }
        addEdgesToVertices();
    }

    private void addEdgesToVertices() {
        Edge edge12 = new Edge(2);
        environment.addEdge(1,2, edge12);

        Edge edge13 = new Edge(8);
        environment.addEdge(1,3, edge13);

        Edge edge14 = new Edge(5);
        environment.addEdge(1,2, edge14);

        Edge edge23 = new Edge(1);
        environment.addEdge(2,3, edge23);

        Edge edge35 = new Edge(3);
        environment.addEdge(3,5, edge35);

        Edge edge45 = new Edge(4);
        environment.addEdge(4,5, edge45);
    }

    ArrayList<Edge> edgesOf(int vertexNumber) {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.addAll(environment.edgesOf(vertexNumber));
        return edges;
    }

}
