package ACO;

import lombok.Getter;

import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;

@Getter
class Environment {

    private final int vertexNumber = 8;
    private SimpleWeightedGraph<Integer, Edge> environment;

    Environment(){
        initEnvironment();

        AntNodeSelection.setHabitat(this);
    }

    private void initEnvironment(){
        environment = new SimpleWeightedGraph<>(Edge.class);

        for(int i = 1 ; i <= vertexNumber ; ++i){
            environment.addVertex(i);
        }
        addEdgesToVertices();
    }

    private void addEdgesToVertices() {
        environment.addEdge(1,2, new Edge(1,2,5));
        environment.addEdge(1,3, new Edge(1,3,8));
        environment.addEdge(2,5, new Edge(2,5,18));
        environment.addEdge(3,4, new Edge(3,4,9));
        environment.addEdge(4,3, new Edge(4,3,9));
        environment.addEdge(4,5, new Edge(4,5,9));
        environment.addEdge(5,4, new Edge(5,4,9));
        environment.addEdge(5,6, new Edge(5,6,7));
        environment.addEdge(6,5, new Edge(6,5,7));
        environment.addEdge(4,6, new Edge(4,6,3));
        environment.addEdge(6,4, new Edge(6,4,3));
        environment.addEdge(3,6, new Edge(3,6,4));
        environment.addEdge(6,3, new Edge(6,3,3));
        environment.addEdge(3,7, new Edge(3,7,47));
        environment.addEdge(5,8, new Edge(5,8,26));
        environment.addEdge(6,8, new Edge(6,8,13));
        environment.addEdge(7,8, new Edge(7,8,34));
    }

    ArrayList<Edge> edgesOf(int vertexNumber) {
        ArrayList<Edge> edges = new ArrayList<>();
        for(Edge edge : environment.edgesOf(vertexNumber)){
            if(edge.getTargetVertex()!=vertexNumber)
                edges.add(edge);
        }
        return edges;
    }

}
