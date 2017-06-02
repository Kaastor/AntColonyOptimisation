package ACO;


import lombok.SneakyThrows;
import org.jgrapht.ext.GraphExporter;
import org.jgrapht.ext.MatrixExporter;
import org.jgrapht.graph.SimpleDirectedGraph;

import java.io.*;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class GraphExport {

    private SimpleDirectedGraph<Integer, Edge> graph;
    private File matrixWithoutWeights;
    private File matrixWithWeights;

    @SneakyThrows
    GraphExport(SimpleDirectedGraph graph){
        this.graph = graph;
        this.matrixWithoutWeights = new File("matrix.txt");
        GraphExporter<Integer, Edge> matrixExporter = new MatrixExporter();
        matrixExporter.exportGraph(graph, matrixWithoutWeights);
        addEdgesWeights();
    }

    @SneakyThrows
    private void addEdgesWeights(){
        matrixWithWeights = new File("matrixWeights.txt");
        Scanner scanner = new Scanner(matrixWithoutWeights);
        FileWriter fileWriter = new FileWriter(matrixWithWeights);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        while(scanner.hasNext()){
            String edge = scanner.nextLine();
            String[] parts = edge.split(" ");
            parts[parts.length - 1].trim();
            String edgeWithWeight = parts[0] + " " + parts[1] + " ";
            Edge edgeFromGraph = graph.getEdge(Integer.parseInt( parts[0]),  Integer.parseInt(parts[1]) );
            Integer edgeWeight = edgeFromGraph.getLength();
            edgeWithWeight = edgeWithWeight.concat(edgeWeight.toString());
            bufferedWriter.write(edgeWithWeight);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }
}
