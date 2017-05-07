import lombok.Getter;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

@Getter
class Environment {

    private int vertexNumber;
    private SimpleWeightedGraph<Integer, DefaultWeightedEdge> environment;

    Environment(){
        vertexNumber = 5;
        initEnvironment();
    }

    private void initEnvironment(){
        environment = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        for(int i = 1 ; i <= vertexNumber ; i++){
            environment.addVertex(i);
        }
        addEdgesToVertices();
    }

    private void addEdgesToVertices() {
        DefaultWeightedEdge edge12 = new DefaultWeightedEdge();
        environment.addEdge(1,2, edge12);
        environment.setEdgeWeight(edge12, 2);

        DefaultWeightedEdge edge13 = new DefaultWeightedEdge();
        environment.addEdge(1,3, edge13);
        environment.setEdgeWeight(edge13, 8);

        DefaultWeightedEdge edge14 = new DefaultWeightedEdge();
        environment.addEdge(1,2, edge14);
        environment.setEdgeWeight(edge14, 4);

        DefaultWeightedEdge edge23 = new DefaultWeightedEdge();
        environment.addEdge(2,3, edge23);
        environment.setEdgeWeight(edge23, 1);

        DefaultWeightedEdge edge35 = new DefaultWeightedEdge();
        environment.addEdge(3,5, edge35);
        environment.setEdgeWeight(edge35, 3);

        DefaultWeightedEdge edge45 = new DefaultWeightedEdge();
        environment.addEdge(4,5, edge45);
        environment.setEdgeWeight(edge45, 4);
    }
}
