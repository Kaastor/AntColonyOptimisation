package ACO;

public class AntColonyOptimisationApp {

    public static void main(String[] args) {

        Environment environment = new Environment();
        AntNodeSelection.setHabitat(environment);

        System.out.println(environment.edgesOf(3));
        new AntColony(environment);
    }
}
