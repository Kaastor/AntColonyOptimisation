package ACO;

import java.util.ArrayList;

import java.util.stream.IntStream;
import static ACO.Parameters.*;

class AntColony {

    private Environment habitat;
    private ArrayList<Ant> anthill;
    private ArrayList<Ant> antsSearching;
    private ArrayList<Ant> antsWithFood;

    AntColony(Environment habitat){
        this.habitat = habitat;
        anthill = new ArrayList<>();
        antsSearching = new ArrayList<>();
        antsWithFood = new ArrayList<>();
        initAnthill();
    }

    private void initAnthill(){
        for(int i = 0 ; i < numberOfAnts ; ++i){
            anthill.add(new Ant(habitat, antsStartPosition, antsFinalPosition));
        }
    }

    void startSearching(){
        anthill.get(0).chooseNextVertex();
//        IntStream.range(0, MAX_ITERATIONS).forEach(i -> {
//            moveAntsAndConstructSolutions();
//            updatePheromoneTrails();
//        });
    }

    private void moveAntsAndConstructSolutions(){

    }

    private void updatePheromoneTrails(){

    }
}
