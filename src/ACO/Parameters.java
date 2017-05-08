package ACO;

final class Parameters {
    static final int NUMBER_OF_ANTS = 1;
    static final int ANTS_START_POSITION = 1;
    static final int ANTS_FINAL_POSITION = 5;
    static final int MAX_ITERATIONS = 20;
    static final int longestVerticesNumberToDestination = 3;

    static final double PHEROMONE_0 = Math.pow(longestVerticesNumberToDestination*7, -1);
    static final double ALPHA = 0.1;
    static final double BETA = 2;
    static final double EVAPORATION = 0.1;
    static final double Q = 500;
}

//PHEROMONE_0, alfa, beta -Ant Colony System: A Cooperative Learning Approach to the Traveling Salesman Problem - Dorigo, Gambardella