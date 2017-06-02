package ACO;

import lombok.Getter;
import lombok.Setter;

import org.jgrapht.graph.DefaultWeightedEdge;

import static ACO.Parameters.PHEROMONE_0;

@Getter @Setter
class Edge extends DefaultWeightedEdge{

    private int targetVertex;
    private int sourceVertex;
    private double pheromoneValue;
    private double heuristicValue;
    private int length;

    private double probabilityForAntK;
    private double ACSComponent;

    Edge(int source, int target, int length){
        super();
        this.sourceVertex = source;
        this.targetVertex = target;
        this.length = length;
        pheromoneValue = PHEROMONE_0;
        heuristicValue = 1.0/length;
        probabilityForAntK = 0.0;
        ACSComponent = 0.0;
    }

}
