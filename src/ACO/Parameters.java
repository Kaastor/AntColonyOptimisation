package ACO;


import java.util.ArrayList;

final class Parameters {
    static final int VERTEX_NUMBER = 8;
    static final int NUMBER_OF_ANTS = 20;
    static final int ANTS_START_POSITION = 1;
    static final int ANTS_FINAL_POSITION = 8;
    static final int MAX_ITERATIONS = 100;
    private static final int averagePathLenghtToDestination = 25;

    static final double INIT_PHEROMONE = 1;
    static final double PHEROMONE_0 = Math.pow(averagePathLenghtToDestination*VERTEX_NUMBER, -1);
    static final double ALPHA = 0.1;
    static final double BETA = 2;
    static final double EVAPORATION = 0.1;
    static final double q0 = 0.95;
    static double BEST_PATH_SO_FAR_LENGTH = 0;
    static ArrayList<Edge> BEST_PATH_SO_FAR = new ArrayList<>();

    static void setBestPathSoFar(ArrayList<Edge> bestPathSoFar) {
        BEST_PATH_SO_FAR.clear();
        BEST_PATH_SO_FAR.addAll(bestPathSoFar);
    }
}

//PHEROMONE_0, alfa, beta -Ant Colony System: A Cooperative Learning Approach to the Traveling Salesman Problem - Dorigo, Gambardella