package michal.projects;

import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SimulationWindow {
    private int barWidth;
    public SimulationWindow(int numOfElements, int speed, SortingAlgorithm algorithm){
        Stage stage = new Stage();

        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double width = primaryScreenBounds.getWidth()/(double)numOfElements;
        double maxHeight = primaryScreenBounds.getHeight();

        GridPane root = new GridPane();

        Random rand = new Random();

        for(int i = 0; i<numOfElements; i++){
            int height = rand.nextInt((int)maxHeight) + 1;
            Rectangle bar = new Rectangle(width, height);
            bar.setFill(Color.BLACK);
            root.add(bar, i, 0);
        }

        Scene scene = new Scene(root, 400, 400);
        stage.setScene(scene);
        stage.show();
    }
}
