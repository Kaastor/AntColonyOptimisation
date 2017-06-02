package ACO;

import dissimlab.random.SimGenerator;
import lombok.Getter;
import org.jgrapht.graph.SimpleDirectedGraph;


import static ACO.Parameters.MAX_CONNECTIONS_BETWEEN_NODES;
import static ACO.Parameters.MAX_EDGE_WEIGHT;
import static ACO.Parameters.VERTEX_NUMBER;

@Getter
class EnvironmentGenerator {

    private SimGenerator simGenerator;
    private SimpleDirectedGraph<Integer, Edge> generatedGraph;
    private double[][] weights;

    EnvironmentGenerator(){
        this.simGenerator = new SimGenerator();
        this.weights = new double[VERTEX_NUMBER][VERTEX_NUMBER];
        this.generatedGraph = new SimpleDirectedGraph<>(Edge.class);
        generate();
    }

    SimpleDirectedGraph generate(){
        generateVertices();
        generateAdjacencyMatrix();
        generateEdges();
        return generatedGraph;
    }

    private void generateAdjacencyMatrix(){
        for (int i=0; i<VERTEX_NUMBER; i++) {
            int connectionNumber = 0;
            for (int j=i; j<VERTEX_NUMBER; j++) {
                weights[i][j] = simGenerator.uniform(1, MAX_EDGE_WEIGHT);
                if(++connectionNumber==MAX_CONNECTIONS_BETWEEN_NODES) break;
            }
        }
        for (int i=0; i< VERTEX_NUMBER; i++) {
           weights[i][i] = 0;
        }
//        for (int i=0; i<VERTEX_NUMBER; i++) {
//            for (int j = 0; j < VERTEX_NUMBER; j++) {
//                System.out.print(weights[i][j] + ", ");
//            }
//            System.out.println();
//        }
    }

    private void generateVertices(){
        for (int i =1 ; i <= VERTEX_NUMBER ; i++) {
            generatedGraph.addVertex(i);
        }
    }

    private void generateEdges(){
        for (int i=0; i<VERTEX_NUMBER; i++) {
            for (int j = i; j < VERTEX_NUMBER; j++) {
                Double weight = weights[i][j];
                if(!weight.equals(0.0)){
                    generatedGraph.addEdge(i+1,j+1, new Edge(i+1,j+1,weights[i][j] ));
                    generatedGraph.addEdge(j+1,i+1, new Edge(j+1,i+1,weights[i][j] ));
                }
            }
        }
    }
}
