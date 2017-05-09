package ACO;

import static ACO.Parameters.BEST_PATH_SO_FAR;
import static ACO.Parameters.BEST_PATH_SO_FAR_LENGTH;

public class AntColonyOptimisationApp {

    public static void main(String[] args) {

        new Environment();
        new AntColony();

        System.out.println("Rozwiazanie - ścieżka: " + BEST_PATH_SO_FAR);
        System.out.println("Rozwiazanie - długość: " + BEST_PATH_SO_FAR_LENGTH);
    }
}
