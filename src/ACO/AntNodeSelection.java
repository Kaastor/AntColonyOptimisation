package ACO;


import lombok.Setter;

import java.util.ArrayList;

import static ACO.Parameters.ALPHA;
import static ACO.Parameters.BETA;

class AntNodeSelection {

    @Setter  private static Environment habitat;
    private static ArrayList<Edge> possibleChoices = new ArrayList<>();


    static Edge getNextVertex(int currentPosition, ArrayList<Integer> visited) {
        calculateProbabilities(currentPosition, visited);

        double p = Math.random();
        double cumulativeProbability = 0.0;
        for (Edge nextEdge : possibleChoices) {
            cumulativeProbability += nextEdge.getProbabilityForAntK();
            if (p <= cumulativeProbability) {
                possibleChoices.clear();
                return nextEdge;
            }
        }
        possibleChoices.clear();
        return null;
    }

    private static void calculateProbabilities(int currentPosition, ArrayList<Integer> visited){
        ArrayList<Edge> possibleDirections = getPossibleDirections(currentPosition, visited);
        double probabilitiesSum = probabilitiesSumForPossibleDirections(possibleDirections);
        for (Edge direction: possibleDirections) {
            possibleChoices.add(calculateProbabilityForEdge(direction, probabilitiesSum));
        }
    }

    private static ArrayList<Edge> getPossibleDirections(int currentPosition, ArrayList<Integer> visited){
        ArrayList<Edge> possibleDirections = new ArrayList<>();
        for (Edge direction: habitat.edgesOf(currentPosition)) {
            if (!visited.contains(direction.getTargetVertex())) {
                possibleDirections.add(direction);
            }
        }
        return possibleDirections;
    }

    private static double probabilitiesSumForPossibleDirections(ArrayList<Edge> possibleDirections){
        double sum = 0.0;
        for (Edge direction: possibleDirections) {
            sum += Math.pow(direction.getPheromoneValue(), ALPHA) *
                    Math.pow(direction.getHeuristicValue(), BETA);
        }
        return sum;
    }

    private static Edge calculateProbabilityForEdge(Edge direction, double probabilitiesSum){
        double probability = (Math.pow(direction.getPheromoneValue(), ALPHA) *
                Math.pow(direction.getHeuristicValue(), BETA))
                /probabilitiesSum;
        direction.setProbabilityForAntK(probability);
        return direction;
    }
}
