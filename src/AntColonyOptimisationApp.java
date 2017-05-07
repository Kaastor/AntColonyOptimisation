

public class AntColonyOptimisationApp {

    public static void main(String[] args) {

        Environment environment = new Environment();

        for(int i = 1 ; i < 6 ; i++){
            System.out.println(
                    environment.edgesOf(i));
        }
    }
}
