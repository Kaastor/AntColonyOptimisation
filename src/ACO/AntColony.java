package ACO;

import lombok.Getter;

import java.util.ArrayList;

import static ACO.Parameters.*;

class AntColony {

    @Getter private ArrayList<Ant> anthill;

    AntColony(){
        anthill = new ArrayList<>();
        initAnthill();
    }

    private void initAnthill(){
        for(int i = 0; i < NUMBER_OF_ANTS; ++i){
            Ant ant = new Ant(i);
            ant.setDaemon(true);
            anthill.add(ant);
            ant.start();
        }
    }

}
