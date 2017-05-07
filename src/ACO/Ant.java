package ACO;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
class Ant {

    private int currentPosition;
    private int finalPosition;
    private ArrayList<Edge> solutionPath;
    private ArrayList<Integer> visited;
    private double pathLength;

    Ant(int startPosition, int finalPosition){
        currentPosition = startPosition;
        this.finalPosition = finalPosition;
        solutionPath = new ArrayList<>();
        visited.add(currentPosition);
        solutionPath = new ArrayList<>();
        pathLength = 0;
    }

    void visitVertex(int nextPosition, Edge edgeToVertex){
        solutionPath.add(edgeToVertex);
        visited.add(currentPosition);
        currentPosition = nextPosition;
    }

    boolean visited(int position){
        return visited.contains(position);
    }

    double finalTrailLength(){
        double length = 0;

        for(Edge edge : solutionPath){
            length += edge.getLength();
        }
        return length;
    }
}
