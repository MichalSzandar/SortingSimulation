package michal.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SimulationWindow {
    private List<Rectangle> list;

    public SimulationWindow(int numOfElements, int delay, SortingAlgorithm algorithm){
        Stage stage = new Stage();

        double width = Utils.getMaxWidth()/(double)numOfElements;
        double maxHeight = Utils.getMaxHeight();

        Pane root = new Pane();

        Random rand = new Random();

        list = new ArrayList<>();
        for(int i = 0; i<numOfElements; i++){
            int height = rand.nextInt(30, (int)maxHeight);
            Rectangle bar = new Rectangle(
                i * width,                    // x position
                maxHeight - height,           // y position (bottom of scene minus bar height)
                width,                        // width
                height                        // height
            );

            bar.setFill(Utils.getColorForHeight(height));
            root.getChildren().add(bar);
            list.add(bar);
        }

        algorithm.setList(list);
        algorithm.setDelay(delay);

        Scene scene = new Scene(root, Utils.getMaxWidth(), Utils.getMaxHeight());
        stage.setScene(scene);
        stage.show();

        Thread thread = new Thread(algorithm);
        thread.setDaemon(true);
        thread.start();
    }
}
