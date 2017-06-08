package ACO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

final class Parameters {
    //vertices numerated from 1.
    //graf przykladowy - 8 wierzcholkow
    static final int VERTEX_NUMBER = 8;
    static final int MAX_CONNECTIONS_BETWEEN_NODES = VERTEX_NUMBER/4;

    static final int NUMBER_OF_ANTS = VERTEX_NUMBER * 3;
    static final int ANTS_START_POSITION = 1;
    static final int ANTS_FINAL_POSITION = VERTEX_NUMBER;
    static final int MAX_ITERATIONS = 1000*MAX_CONNECTIONS_BETWEEN_NODES;
    static final int MAX_EDGE_WEIGHT = 20;
    private static final int MAX_PATH_LENGTH_TO_DESTINATION = (int)(MAX_EDGE_WEIGHT*MAX_CONNECTIONS_BETWEEN_NODES);

    static final double EVAPORATION = 0.2;
    static final double PHEROMONE_0 = Math.pow(MAX_PATH_LENGTH_TO_DESTINATION *VERTEX_NUMBER, -1);
    static final double ALPHA = 0.1;
    static final double BETA = 2;
    static final double q0 = 0.8;

    static double BEST_PATH_SO_FAR_LENGTH = 0;
    private static ArrayList<Edge> BEST_PATH_SO_FAR = new ArrayList<>();
    private static Set<ArrayList<Edge>> BEST_SEPARABLE_PATHS = new HashSet<>();

    static void setBestPathSoFar(ArrayList<Edge> bestPathSoFar) {
        BEST_PATH_SO_FAR.clear();
        BEST_PATH_SO_FAR.addAll(bestPathSoFar);
    }

    static void clearBestSeparablePaths(){
        BEST_SEPARABLE_PATHS.clear();
    }

    static void addBestSeparablePath(ArrayList<Edge> bestSeparablePath) {
        BEST_SEPARABLE_PATHS.add(new ArrayList<>(bestSeparablePath));
    }

    static boolean bestSeparablePathContain(ArrayList<Edge> bestSeparablePath) {
        boolean contain = true;
        for(ArrayList<Edge> path : BEST_SEPARABLE_PATHS){
            if(!path.containsAll(bestSeparablePath))
                contain = false;
        }
        return contain;
    }

    static Set<ArrayList<Edge>> getBestSeparablePaths(){
        return BEST_SEPARABLE_PATHS;
    }
}


//PHEROMONE_0, alfa, beta -Ant Colony System: A Cooperative Learning Approach to the Traveling Salesman Problem - Dorigo, Gambardella