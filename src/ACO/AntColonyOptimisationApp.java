package ACO;

public class AntColonyOptimisationApp {

    public static void main(String[] args) {

        Environment environment = new Environment();
        AntColony antColony = new AntColony(environment);

        antColony.startSearching();
    }
}
