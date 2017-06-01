package ACO;

import dissimlab.random.SimGenerator;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import javafx.scene.paint.Color;
import lombok.SneakyThrows;
import org.jgrapht.Graph;
import org.jgrapht.ext.GraphExporter;
import org.jgrapht.ext.MatrixExporter;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static ACO.Parameters.*;
import static dissimlab.random.SimGenerator.generateSeed;

public class AntColonyOptimisationApp extends Application{

    private SimGenerator simGenerator = new SimGenerator(generateSeed());
    private ArrayList<Point> nodes = new ArrayList<>();
    private static Environment environment;

    @SneakyThrows
    public static void main(String[] args) {
        long startTime   = System.currentTimeMillis();
        environment = new Environment();

        AntColony antColony = new AntColony();

        for (Ant ant : antColony.getAnthill()) {
            ant.join();
        }
        System.out.println("Rozwiazanie - długość: " + BEST_PATH_SO_FAR_LENGTH);
        System.out.println("Rozwiazanie - ścieżki: ");
        System.out.println(getBestSeparablePaths());


//        GraphExporter matrixExporter = new MatrixExporter();
//        matrixExporter.exportGraph(environment.getEnvironment(), new File("matrix.txt"));
//        System.out.println((environment.getEnvironment().getEdge(1,3).getLength()));

        launch(args);
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

        System.exit(1);
    }

    @Override
    public void start(Stage primaryStage) {
        ACOVisualisation(primaryStage);
    }

    private void ACOVisualisation(Stage primaryStage){
        primaryStage.setTitle("Ant Colony System for separable SPP");
        Group root = new Group();
        Canvas canvas = new Canvas(1000, 1000);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc) {
        gc.setFill(Color.GRAY);
        gc.fillRect(0, 0, 1000, 1000);
        gc.setFill(Color.DARKGREEN);
        gc.setStroke(Color.WHITESMOKE);
        gc.setLineWidth(3);

        for(int i = 0 ; i < VERTEX_NUMBER ; ++i){
            Point node = new Point(simGenerator.uniformInt(VERTEX_NUMBER*10,VERTEX_NUMBER*100),
                    simGenerator.uniformInt(VERTEX_NUMBER*10,VERTEX_NUMBER*100));
            nodes.add(node);
            gc.fillOval(node.getX(), node.getY(), 30, 30);
        }

        for(int i = 0 ; i < nodes.size() ; ++i){
            for(Edge edge : environment.getEnvironment().edgesOf(i+1)){
                gc.strokeLine(nodes.get(edge.getSourceVertex()-1).x+15,
                        nodes.get(edge.getSourceVertex()-1).y+15,
                        nodes.get(edge.getTargetVertex()-1).x+15,
                        nodes.get(edge.getTargetVertex()-1).y+15);
            }
        }
        gc.setFill(Color.YELLOW);
        gc.fillOval(nodes.get(ANTS_START_POSITION-1).x, nodes.get(ANTS_START_POSITION-1).y, 30, 30);
        gc.setFill(Color.RED);
        gc.fillOval(nodes.get(ANTS_FINAL_POSITION-1).x, nodes.get(ANTS_FINAL_POSITION-1).y, 30, 30);

        for(ArrayList<Edge> edges : getBestSeparablePaths()){
            gc.setStroke(Color.color(simGenerator.uniform(0,1),
                    simGenerator.uniform(0,1),
                    simGenerator.uniform(0,1)));
            for(Edge edge : edges){
                gc.strokeLine(nodes.get(edge.getSourceVertex()-1).x+15,
                        nodes.get(edge.getSourceVertex()-1).y+15,
                        nodes.get(edge.getTargetVertex()-1).x+15,
                        nodes.get(edge.getTargetVertex()-1).y+15);
            }
        }

        double midPointX;
        double midPointY;
        for(int i = 0 ; i < nodes.size() ; ++i){
            for(Edge edge : environment.getEnvironment().edgesOf(i+1)){
                midPointX = (nodes.get(edge.getSourceVertex()-1).x+15 + nodes.get(edge.getTargetVertex()-1).x+15) / 2;
                midPointY = (nodes.get(edge.getSourceVertex()-1).y+15 + nodes.get(edge.getTargetVertex()-1).y+15) / 2;
                gc.setFill(Color.BLACK);
                gc.fillText(((Double) edge.getLength()).toString(), midPointX, midPointY);
            }
        }
    }
}
