package ACO;


import dissimlab.random.SimGenerator;
import lombok.Setter;
import lombok.Synchronized;

import java.util.ArrayList;

import static ACO.Parameters.ALPHA;
import static ACO.Parameters.BETA;
import static ACO.Parameters.q0;

class AntNodeSelection {

    @Setter private static Environment habitat;
    private static SimGenerator simGenerator = new SimGenerator();
    private static ArrayList<Edge> possibleChoices = new ArrayList<>();

    @Synchronized
    static Edge getNextVertex(int currentPosition, ArrayList<Integer> visited) {
        Edge nextEdgeACS = pseudoRandomProportionalRule(currentPosition, visited);
        if(nextEdgeACS != null){
            return nextEdgeACS;
        }
        else {
            calculateProbabilities(currentPosition, visited);
            return chooseNextEdge();
        }
    }

    private static Edge pseudoRandomProportionalRule(int currentPosition, ArrayList<Integer> visited){
        double q = simGenerator.uniform(0, 1);
        if(q<q0){
            ArrayList<Edge> possibleDirections = getPossibleDirections(currentPosition, visited);
            ArrayList<Edge> components = calculateACSTransitionRuleComponents(possibleDirections);
            return maxFromComponents(components);
        }
        return null;
    }

    private static ArrayList<Edge> calculateACSTransitionRuleComponents(ArrayList<Edge> possibleDirections){
        double component;
        for (Edge direction: possibleDirections) {
            component = direction.getPheromoneValue()*Math.pow(direction.getHeuristicValue(), BETA);
            direction.setACSComponent(component);
        }
        return possibleDirections;
    }

    private static Edge maxFromComponents(ArrayList<Edge> components){
        double maxComponent = 0.0;
        Edge maxComponentEdge = null;
        for(Edge component : components){
            if(component.getACSComponent() > maxComponent){
                maxComponent = component.getACSComponent();
                maxComponentEdge = component;
            }
        }
        return maxComponentEdge;
    }

    private static void calculateProbabilities(int currentPosition, ArrayList<Integer> visited){
        ArrayList<Edge> possibleDirections = getPossibleDirections(currentPosition, visited);
        double probabilitiesSum = probabilitiesSumForPossibleDirections(possibleDirections);
        for (Edge direction: possibleDirections) {
            possibleChoices.add(calculateProbabilityForEdge(direction, probabilitiesSum));
        }
    }

    private static Edge chooseNextEdge(){
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
