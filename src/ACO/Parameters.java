package ACO;

final class Parameters {
    static final int numberOfAnts = 1;
    static final int antsStartPosition = 1;
    static final int antsFinalPosition = 5;
    static final int longestVerticesNumberToDestination = 3;

    static final double PHEROMONE_0 = Math.pow(longestVerticesNumberToDestination*7, -1);
    static final double ALPHA = 0.1;
    static final double BETA = 2;
    static final double EVAPORATION = 0.1;
    static final double Q = 500;
    static final double antFactor = 0.8;
    static final double randomFactor = 0.01;

    static final int MAX_ITERATIONS = 5;
}

//PHEROMONE_0, alfa, beta -Ant Colony System: A Cooperative Learning Approach to the Traveling Salesman Problem - Dorigo, Gambardella