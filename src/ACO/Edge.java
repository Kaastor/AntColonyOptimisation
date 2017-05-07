package ACO;

import lombok.Getter;
import lombok.Setter;

import org.jgrapht.graph.DefaultWeightedEdge;

import static ACO.Parameters.pheromone0;

@Getter @Setter
class Edge extends DefaultWeightedEdge{

    private double pheromoneValue;
    private double heuristicValue;
    private double length;

    Edge(double length){
        this.length = length;
        pheromoneValue = pheromone0;
        heuristicValue = 1.0/length;
    }
}
