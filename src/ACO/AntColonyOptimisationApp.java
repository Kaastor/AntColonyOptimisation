package ACO;

import static ACO.Parameters.BEST_PATH_SO_FAR;
import static ACO.Parameters.BEST_PATH_SO_FAR_LENGTH;

class AntColonyOptimisationApp {

    public static void main(String[] args) {

        Environment environment = new Environment();
        new AntColony();

        System.out.println("Rozwiazanie - ścieżka: " + BEST_PATH_SO_FAR);
        System.out.println("Rozwiazanie - długość: " + BEST_PATH_SO_FAR_LENGTH);

        System.out.println("Rozwiazanie - feromony: ");
        for(Edge edge : BEST_PATH_SO_FAR){
            System.out.println("Rozwiazanie - feromon: " + edge + " " + edge.getPheromoneValue());
        }

        System.out.println("Rozwiazanie - feromony: ");
        for(Edge edge : environment.getEnvironment().edgeSet()){
            System.out.println("Rozwiazanie - feromon: " + edge + " " + edge.getPheromoneValue());
        }
    }
}
