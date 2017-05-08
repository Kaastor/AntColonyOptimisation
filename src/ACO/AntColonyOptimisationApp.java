package ACO;

public class AntColonyOptimisationApp {

    public static void main(String[] args) {

        Environment environment = new Environment();
        AntNodeSelection.setHabitat(environment);

        new AntColony(environment);
    }
}
