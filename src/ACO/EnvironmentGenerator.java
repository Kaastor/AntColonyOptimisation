package ACO;

import dissimlab.random.SimGenerator;
import lombok.Getter;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.ArrayList;

import static ACO.Parameters.MAX_EDGE_WEIGHT;

@Getter
@SuppressWarnings("unchecked")
class EnvironmentGenerator {

    private int verticesNumber;
    private SimGenerator simGenerator;
    private SimpleWeightedGraph<Integer, Edge> generatedGraph;
    private double[][] weights;
    private ArrayList<Integer> vertices;

    EnvironmentGenerator(int verticesNumber){
        this.verticesNumber = verticesNumber;
        this.simGenerator = new SimGenerator();
        this.generatedGraph = new SimpleWeightedGraph<>(Edge.class);
    }

    SimpleWeightedGraph generate(){
        vertices = generateVertices();
        weights = generateAdjacencyMatrix();
        generateEdges();
        return generatedGraph;
    }

    private double[][] generateAdjacencyMatrix(){
        double[][] weights = new double[verticesNumber][verticesNumber];
        for (int i=0; i<verticesNumber; i++) {
            for (int j=i; j<verticesNumber; j++) {
                if(simGenerator.uniform(0,1) < 0.5){
                    weights[i][j] = simGenerator.uniform(1, MAX_EDGE_WEIGHT);
                }
            }
        }
        for (int i=0; i< verticesNumber; i++) {
           weights[i][i] = 0;
        }
//        for (int i=0; i<verticesNumber; i++) {
//            for (int j = 0; j < verticesNumber; j++) {
//                System.out.print(weights[i][j] + ", ");
//            }
//            System.out.println();
//        }
        return  weights;
    }

    private ArrayList<Integer> generateVertices(){
        ArrayList<Integer> randomVertices = new ArrayList<>();
        for (int i =0 ; i < verticesNumber ; i++) {
            randomVertices.add(i);
        }
        return  randomVertices;
    }

    private void generateEdges(){
        for (int i=0; i<verticesNumber; i++) {
            for (int j = 0; j < verticesNumber; j++) {
                if(weights[i][j] != 0.0){

                }
            }
        }
    }
}
