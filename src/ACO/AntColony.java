package ACO;

import java.util.ArrayList;

import static ACO.Parameters.*;

class AntColony {

    private final ArrayList<Ant> anthill;


    AntColony(){
        anthill = new ArrayList<>();
        initAnthill();
    }

    private void initAnthill(){
        for(int i = 0; i < NUMBER_OF_ANTS; ++i){
            anthill.add(new Ant());
        }
    }

}
