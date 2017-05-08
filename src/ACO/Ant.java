package ACO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.stream.IntStream;

import static ACO.Parameters.MAX_ITERATIONS;


@Getter @Setter
class Ant {

    private int currentPosition;
    private int finalPosition;
    private ArrayList<Edge> solutionPath;
    private ArrayList<Integer> visited;
    private double pathLength;


    Ant(Environment habitat, int startPosition, int finalPosition){
        currentPosition = startPosition;
        this.finalPosition = finalPosition;
        solutionPath = new ArrayList<>();
        visited = new ArrayList<>();
        visited.add(currentPosition);
        solutionPath = new ArrayList<>();
        pathLength = 0;

        antLife();
    }

    private void antLife(){
        IntStream.range(1, MAX_ITERATIONS).forEach(epoch -> {
            System.out.print(currentPosition + " ");
            visitNextVertex();
            System.out.println(" NEXT:" + currentPosition );
            updateLocalPheromone();
        });
    }

    private void visitNextVertex(){
        Edge nextEdge = AntNodeSelection.getNextVertex(currentPosition, visited);

        if(nextEdge!=null) {
            visitVertex(nextEdge.getTargetVertex(), nextEdge);
        }
        else{
            System.out.print("NULL");
        }
    }

    private void visitVertex(int nextPosition, Edge edgeToVertex){
        solutionPath.add(edgeToVertex);
        visited.add(currentPosition);
        currentPosition = nextPosition;
    }

    private void updateLocalPheromone(){

    }

    private void updateGlobalPheromone(){

    }

    double finalTrailLength(){
        double length = 0;
        for(Edge edge : solutionPath){
            length += edge.getLength();
        }
        return length;
    }

    void returnToAnthill(){

    }
}
