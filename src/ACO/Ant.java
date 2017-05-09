package ACO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static ACO.Parameters.ANTS_FINAL_POSITION;
import static ACO.Parameters.ANTS_START_POSITION;
import static ACO.Parameters.MAX_ITERATIONS;


@Getter @Setter
class Ant {

    private int currentPosition;
    private int finalPosition;
    private ArrayList<Edge> solutionPath;
    private ArrayList<Integer> visited;
    private double pathLength;


    Ant(Environment habitat){
        currentPosition = ANTS_START_POSITION;
        this.finalPosition = ANTS_FINAL_POSITION;
        solutionPath = new ArrayList<>();
        visited = new ArrayList<>();
        solutionPath = new ArrayList<>();
        pathLength = 0;

        antLife();
    }

    private void antLife(){
        IntStream.range(1, MAX_ITERATIONS).forEach(epoch -> {
            System.out.print(" TERAZ:" + currentPosition );
            visitNextVertex();

            System.out.println(" NEXT:" + currentPosition );
            AntUpdatePheromone.updateLocalPheromone();
        });
    }

    private void visitNextVertex(){
        Edge nextEdge = AntNodeSelection.getNextVertex(currentPosition, visited);
        if(nextEdge!=null) {
            visitVertex(nextEdge.getTargetVertex(), nextEdge);
            if(currentPosition == finalPosition)
                returnToAnthill();
        }
        else{
            System.out.print("Koniec trasy, brak rozwiązania. Wracam. " + currentPosition);
            returnToAnthill();
        }
    }

    private void returnToAnthill(){
        System.out.print("Jestem w rozwiązaniu. " + currentPosition);
        currentPosition = ANTS_START_POSITION;
        saveSolution();
        AntUpdatePheromone.updateGlobalPheromone();
        restart();
    }

    private void saveSolution(){

    }

    private void restart(){
        solutionPath.clear();
        visited.clear();
        pathLength = 0.0;
    }

    private void visitVertex(int nextPosition, Edge edgeToVertex){
        solutionPath.add(edgeToVertex);
        visited.add(currentPosition);
        currentPosition = nextPosition;
    }


    double finalTrailLength(){
        double length = 0;
        for(Edge edge : solutionPath){
            length += edge.getLength();
        }
        return length;
    }
}
