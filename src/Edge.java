import lombok.Getter;
import lombok.Setter;

import org.jgrapht.graph.DefaultWeightedEdge;

@Getter @Setter
class Edge extends DefaultWeightedEdge{

    private double pheromoneValue;
    private double heuristicValue;
    private double length;

    Edge(double length){
        this.length = length;
        pheromoneValue = 1;
        heuristicValue = 1;
    }
}
