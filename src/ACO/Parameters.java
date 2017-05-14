package ACO;



import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

final class Parameters {
    static final int VERTEX_NUMBER = 8;
    static final int NUMBER_OF_ANTS = 5000;
    static final int ANTS_START_POSITION = 1;
    static final int ANTS_FINAL_POSITION = 8;
    static final int MAX_ITERATIONS = 2500;
    private static final int averagePathLenghtToDestination = 25;

    static final double PHEROMONE_0 = Math.pow(averagePathLenghtToDestination*VERTEX_NUMBER, -1);
    static final double ALPHA = 0.1;
    static final double BETA = 2;
    static final double EVAPORATION = 0.1;
    static final double q0 = 0.7;
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
        return  BEST_SEPARABLE_PATHS.contains(bestSeparablePath);
    }

    static Set<ArrayList<Edge>> getBestSeparablePaths(){
        return BEST_SEPARABLE_PATHS;
    }
}


//PHEROMONE_0, alfa, beta -Ant Colony System: A Cooperative Learning Approach to the Traveling Salesman Problem - Dorigo, Gambardella