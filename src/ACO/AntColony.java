package ACO;

import static ACO.Parameters.*;

class AntColony {

    AntColony(){
        initAnthill();
    }

    private void initAnthill(){
        for(int i = 0; i < NUMBER_OF_ANTS; ++i){
            new Ant(i);
        }
    }

}
