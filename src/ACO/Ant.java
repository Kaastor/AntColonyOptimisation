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


    Ant(){
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
            Edge nextEdge = AntNodeSelection.getNextVertex(currentPosition, visited);
            visitNextVertex(nextEdge);
            AntUpdatePheromone.updateLocalPheromone(nextEdge);
        });
    }

    private void visitNextVertex(Edge nextEdge){
        if(nextEdge!=null) {
            visitVertex(nextEdge.getTargetVertex(), nextEdge);
            if(currentPosition == finalPosition)
                returnToAnthill();
        }
        else{
            returnToAnthill();
        }
    }

    private void visitVertex(int nextPosition, Edge edgeToVertex){
        solutionPath.add(edgeToVertex);
        visited.add(currentPosition);
        currentPosition = nextPosition;
    }

    private void returnToAnthill(){
        AntUpdatePheromone.updateGlobalPheromone(solutionPath);
        currentPosition = ANTS_START_POSITION;
        restart();
    }

    private void restart(){
        solutionPath.clear();
        visited.clear();
        pathLength = 0.0;
    }
}
