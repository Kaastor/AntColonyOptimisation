import java.util.ArrayList;

class AntColony {

    private int antsStartingPosition;
    private int antsNumber;
    private ArrayList<Ant> anthill;

    AntColony(int antsNumber, int antsStartingPosition){
        this.antsNumber = antsNumber;
        this.antsStartingPosition = antsStartingPosition;
        anthill = new ArrayList<>();
        initAnthill();
    }

    private void initAnthill(){
        for(int i = 0 ; i < antsNumber ; ++i){
            anthill.add(new Ant(antsStartingPosition));
        }
    }

    public void startSearching(){

    }
}
