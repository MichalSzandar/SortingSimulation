package michal.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class SortingAlgorithm implements Runnable {
    protected List<Rectangle> list;
    protected int speed;

    public SortingAlgorithm(){
        this.list = new ArrayList<>();
    }

    @SuppressWarnings("exports")
    public void setList(List<Rectangle> list){
        this.list = list;
    }

    public void setSpeed(int speed){
        this.speed = speed;
    }

    protected void swap(int i, int j) {
        try {
            // Highlight the bars being swapped
            waitForPlatformRunLater(() -> {
                list.get(i).setFill(Color.GRAY);
                list.get(j).setFill(Color.GRAY);
            });
    
            Thread.sleep(speed); // Pause for visualization
    
            // Perform the swap
            double temp = list.get(i).getHeight();
            waitForPlatformRunLater(() -> {
                list.get(i).setHeight(list.get(j).getHeight());
                list.get(j).setHeight(temp);
                list.get(i).setY(Utils.getMaxHeight() - list.get(i).getHeight());
                list.get(j).setY(Utils.getMaxHeight() - list.get(j).getHeight());
            });
    
            Thread.sleep(speed); // Pause for visualization
    
            // Reset bar colors
            waitForPlatformRunLater(() -> {
                list.get(i).setFill(Utils.getColorForHeight(list.get(i).getHeight()));
                list.get(j).setFill(Utils.getColorForHeight(list.get(j).getHeight()));
            });
    
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * A helper method to synchronize UI updates with the JavaFX Application Thread.
     */
    private void waitForPlatformRunLater(Runnable action) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            action.run();
            latch.countDown();
        });
        latch.await(); // Wait for the UI update to complete
    }       

}
