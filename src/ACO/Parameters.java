package ACO;

final class Parameters {
    static final int numberOfAnts = 10;
    static final int antsStartPosition = 1;
    static final int antsFinalPosition = 5;
    static final int longestVerticesNumberToDestination = 3;

    static final double pheromone0 = Math.pow(longestVerticesNumberToDestination*7, -1);
    static final double alpha = 0.1;
    static final double beta = 2;
    static final double evaporation = 0.1;
    static final double Q = 500;
    static final double antFactor = 0.8;
    static final double randomFactor = 0.01;

    static final int maxIterations = 1000;
}

//pheromone0 -Ant Colony System: A Cooperative Learning Approach to the Traveling Salesman Problem - Dorigo, Gambardella