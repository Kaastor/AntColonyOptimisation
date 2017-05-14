package ACO;


import lombok.Synchronized;

import java.util.ArrayList;

import static ACO.Parameters.*;

class AntUpdatePheromone {

    static void updateLocalPheromone(Edge edgeToUpdate){
        if(edgeToUpdate!=null) {
            double newPheromone = (1 - EVAPORATION) * edgeToUpdate.getPheromoneValue() +
                    EVAPORATION * PHEROMONE_0;
            edgeToUpdate.setPheromoneValue(newPheromone);
        }
    }

    @Synchronized
    static void updateGlobalPheromone(ArrayList<Edge> solutionPath){
        if(updateBestPath(solutionPath)) {
            for (Edge edge : solutionPath) {
                double newPheromone = (1 - EVAPORATION) * edge.getPheromoneValue() +
                        EVAPORATION * deltaPheromone();
                edge.setPheromoneValue(newPheromone);
            }
        }
    }

    private static boolean updateBestPath(ArrayList<Edge> solutionPath){
        double trailLength = finalTrailLength(solutionPath);
        if(trailLength == BEST_PATH_SO_FAR_LENGTH){
            if(!bestSeparablePathContain(solutionPath)) {
                if (isSeparable(solutionPath)) {
                    addBestSeparablePath(solutionPath);
                }
            }
            return true;
        }
        if(trailLength < BEST_PATH_SO_FAR_LENGTH){
            updateNewShortestPath(trailLength, solutionPath);
            return true;
        }
        if(BEST_PATH_SO_FAR_LENGTH == 0) {
            BEST_PATH_SO_FAR_LENGTH = trailLength;
            setBestPathSoFar(solutionPath);
        }
        return false;
    }

    private static void updateNewShortestPath(double trailLength, ArrayList<Edge> solutionPath){
        BEST_PATH_SO_FAR_LENGTH = trailLength;
        setBestPathSoFar(solutionPath);
        clearBestSeparablePaths();
        addBestSeparablePath(solutionPath);
    }

    private static boolean isSeparable(ArrayList<Edge> solutionPath) {
        int numberOfTheSameEdges = 0;
        for (ArrayList<Edge> separablePath : getBestSeparablePaths()) {
            for (Edge edge : solutionPath) {
                if (separablePath.contains(edge))
                    numberOfTheSameEdges++;
            }
        }
        return (numberOfTheSameEdges == 0);
    }

    private static double deltaPheromone(){
        return 1/BEST_PATH_SO_FAR_LENGTH;
    }

    private static double finalTrailLength(ArrayList<Edge> solutionPath){
        double length = 0;
        for(Edge edge : solutionPath){
            length += edge.getLength();
        }
        return length;
    }
}
