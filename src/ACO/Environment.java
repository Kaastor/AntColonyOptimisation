package ACO;

import lombok.Getter;

import org.jgrapht.graph.SimpleDirectedGraph;

import static ACO.Parameters.VERTEX_NUMBER;


@Getter
@SuppressWarnings("unchecked")
class Environment {

    private SimpleDirectedGraph<Integer, Edge> environment;

    Environment(){
        initEnvironment();
        AntNodeSelection.setHabitat(this);
    }

    private void initEnvironment() {
        environment = new SimpleDirectedGraph<>(Edge.class);

        for (int i = 1; i <= VERTEX_NUMBER; ++i) {
            environment.addVertex(i);
        }
        addEdgesToVertices();

//        environment = new EnvironmentGenerator().generate();
    }


    private void addEdgesToVertices() {
        environment.addEdge(1,2, new Edge(1,2,5));
        environment.addEdge(2,1, new Edge(2,1,5));
        environment.addEdge(1,3, new Edge(1,3,8));
        environment.addEdge(3,1, new Edge(3,1,8));
        environment.addEdge(1,4, new Edge(1,4,3));
        environment.addEdge(4,1, new Edge(4,1,3));
        environment.addEdge(2,5, new Edge(2,5,1));
        environment.addEdge(5,2, new Edge(5,2,1));
        environment.addEdge(2,6, new Edge(2,6,1));
        environment.addEdge(6,2, new Edge(6,2,1));
        environment.addEdge(6,2, new Edge(2,6,1));
        environment.addEdge(3,4, new Edge(3,4,2));
        environment.addEdge(4,3, new Edge(4,3,2));
        environment.addEdge(4,5, new Edge(4,5,9));
        environment.addEdge(5,4, new Edge(5,4,9));
        environment.addEdge(5,6, new Edge(5,6,7));
        environment.addEdge(6,5, new Edge(6,5,7));
        environment.addEdge(4,6, new Edge(4,6,3));
        environment.addEdge(6,4, new Edge(6,4,3));
        environment.addEdge(3,6, new Edge(3,6,4));
        environment.addEdge(6,3, new Edge(6,3,4));
        environment.addEdge(3,7, new Edge(3,7,10));
        environment.addEdge(5,8, new Edge(5,8,10));
        environment.addEdge(6,8, new Edge(6,8,13));
        environment.addEdge(7,8, new Edge(7,8,1));

    }

}
