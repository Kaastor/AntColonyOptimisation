package ACO;


import java.util.ArrayList;

final class Parameters {
    static final int NUMBER_OF_ANTS = 10;
    static final int ANTS_START_POSITION = 1;
    static final int ANTS_FINAL_POSITION = 8;
    static final int MAX_ITERATIONS = 100;
    private static final int longestVerticesNumberToDestination = 5;

    static final double PHEROMONE_0 = Math.pow(longestVerticesNumberToDestination*7, -1);
    static final double ALPHA = 0.1;
    static final double BETA = 2;
    static final double EVAPORATION = 0.1;
    static final double Q = 8; //najdłuższa krawędz w sieci, moze tez byc długość najlepszej ścieżki dotychczas znalezionej
    static double BEST_PATH_SO_FAR_LENGTH = 0;
    static ArrayList<Edge> BEST_PATH_SO_FAR = new ArrayList<>();

    static void setBestPathSoFar(ArrayList<Edge> bestPathSoFar) {
        BEST_PATH_SO_FAR.clear();
        BEST_PATH_SO_FAR.addAll(bestPathSoFar);
    }
}

//PHEROMONE_0, alfa, beta -Ant Colony System: A Cooperative Learning Approach to the Traveling Salesman Problem - Dorigo, Gambardella