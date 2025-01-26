package michal.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class SimulationWindow {
    /**List of rectangles displayed on screen. */
    private List<Rectangle> list;

    /**Minimum height of each generated rectangle.*/
    private int minHeight = 30;

    /**
     * Starts new simulation window, generates rectangles, sets delay
     * and choses sorting algorithm.
     * @param numOfElements - number of recatngles on screen
     * @param delay - delay between comparison operations
     * @param algorithm - algorithm used to sort rectangles by height
     */
    public SimulationWindow(final int numOfElements, final int delay,
                             final SortingAlgorithm algorithm) {
        Stage stage = new Stage();

        double width = Utils.getMaxWidth() / (double) numOfElements;
        double maxHeight = Utils.getMaxHeight();

        Pane root = new Pane();

        Random rand = new Random();

        list = new ArrayList<>();
        for (int i = 0; i < numOfElements; i++) {
            int height = rand.nextInt(minHeight, (int) maxHeight);
            Rectangle bar = new Rectangle(
                i * width,                    // x position
                maxHeight - height,           // y position
                width,                        // width
                height                        // height
            );

            bar.setFill(Utils.getColorForHeight(height));
            root.getChildren().add(bar);
            list.add(bar);
        }

        algorithm.setList(list);
        algorithm.setDelay(delay);

        Scene scene =
            new Scene(root, Utils.getMaxWidth(), Utils.getMaxHeight());

        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            algorithm.stop();
        });
        stage.show();

        Thread thread = new Thread(algorithm);
        thread.setDaemon(true);
        thread.start();
    }
}
