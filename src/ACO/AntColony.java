package ACO;

import java.util.ArrayList;

import java.util.stream.IntStream;
import static ACO.Parameters.*;

class AntColony {

    private ArrayList<Ant> anthill;


    AntColony(){
        anthill = new ArrayList<>();
        initAnthill();
    }

    private void initAnthill(){
        for(int i = 0 ; i < numberOfAnts ; ++i){
            anthill.add(new Ant(antsStartPosition, antsFinalPosition));
        }
    }

    public void startSearching(){
        IntStream.range(0, maxIterations).forEach(i -> {
            moveAntsAndConstructSolutions();
            updatePheromoneTrails();
        });
    }

    private void moveAntsAndConstructSolutions(){

    }

    private void updatePheromoneTrails(){

    }
}
