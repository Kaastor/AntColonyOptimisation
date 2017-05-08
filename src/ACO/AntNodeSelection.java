package ACO;


import lombok.Getter;

import java.util.ArrayList;

import static ACO.Parameters.ALPHA;
import static ACO.Parameters.BETA;

@Getter
class AntNodeSelection {

    private Environment habitat;
    private ArrayList<Edge> possibleChoices = new ArrayList<>();

    AntNodeSelection(Environment habitat){
        this.habitat = habitat;
    }

    Integer getNextVertex(int currentPosition, ArrayList<Integer> visited) {
        calculateProbabilities(currentPosition, visited);

        for(Edge edge : possibleChoices){
            System.out.println(edge.getProbabilityForAntK() + " " + edge.getLength());
        }


        double p = Math.random();
        double cumulativeProbability = 0.0;
        for (Edge edge : possibleChoices) {
            cumulativeProbability += edge.getProbabilityForAntK();
            if (p <= cumulativeProbability) {
                return edge.getTargetVertex();
            }
        }
        return 0;
    }

    private void calculateProbabilities(int currentPosition, ArrayList<Integer> visited){
        ArrayList<Edge> possibleDirections = getPossibleDirections(currentPosition, visited);
        double probabilitiesSum = probabilitiesSumForPossibleDirections(possibleDirections);
        for (Edge direction: possibleDirections) {
            possibleChoices.add(calculateProbabilityForEdge(direction, probabilitiesSum));
        }
    }

    private ArrayList<Edge> getPossibleDirections(int currentPosition, ArrayList<Integer> visited){
        ArrayList<Edge> possibleDirections = new ArrayList<>();
        for (Edge direction: habitat.edgesOf(currentPosition)) {
            if (!visited.contains(direction.getTargetVertex())) {
                possibleDirections.add(direction);
            }
        }
        return possibleDirections;
    }

    private double probabilitiesSumForPossibleDirections(ArrayList<Edge> possibleDirections){
        double sum = 0.0;
        for (Edge direction: possibleDirections) {
            sum += Math.pow(direction.getPheromoneValue(), ALPHA) *
                    Math.pow(direction.getHeuristicValue(), BETA);
        }
        return sum;
    }

    private Edge calculateProbabilityForEdge(Edge direction, double probabilitiesSum){
        double probability = (Math.pow(direction.getPheromoneValue(), ALPHA) *
                Math.pow(direction.getHeuristicValue(), BETA))
                /probabilitiesSum;
        direction.setProbabilityForAntK(probability);
        return direction;
    }
}
