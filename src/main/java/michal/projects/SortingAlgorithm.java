package michal.projects;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class SortingAlgorithm implements Runnable {
    /**list of rectangles to sort by their height. */
    protected List<Rectangle> list;
    /**delay between swaping elements or setting
     * new values measured in miliseconds.*/
    protected int delay;
    /**defines if thread is supposedto still be running. */
    protected boolean isRunning;

    /**
     * method to stop running algorithm.
     */
    public final void stop() {
        isRunning = false;
    }

    /** default constructor, initializes list of rectangles. */
    public SortingAlgorithm() {
        isRunning = true;
        this.list = new ArrayList<>();
    }

    /**
     * method to set the list of rectangles to sort.
     * @param list
     */
    @SuppressWarnings("exports")
    public final void setList(final List<Rectangle> list) {
        this.list = list;
    }

    /**
     * sets the delay between operations.
     * @param delay - miliseconds between operations
     */
    public void setDelay(final int delay) {
        this.delay = delay;
    }

    /**
     * swaps heights and colors of rectangles at i and j position.
     * @param i - index of the first element
     * @param j - index of the second element
     */
    protected void swap(final int i, final int j) {
        try {
            // Highlight the bars being swapped
            waitForPlatformRunLater(() -> {
                list.get(i).setFill(Color.GRAY);
                list.get(j).setFill(Color.GRAY);
            });

            Thread.sleep(delay); // Pause for visualization

            // Perform the swap
            double temp = list.get(i).getHeight();
            waitForPlatformRunLater(() -> {
                list.get(i).setHeight(list.get(j).getHeight());
                list.get(j).setHeight(temp);
                list.get(i).setY(
                    Utils.getMaxHeight() - list.get(i).getHeight());
                list.get(j).setY(
                    Utils.getMaxHeight() - list.get(j).getHeight());
                list.get(i).setFill(
                    Utils.getColorForHeight(list.get(i).getHeight()));
                list.get(j).setFill(
                    Utils.getColorForHeight(list.get(j).getHeight()));
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * sets height of Rectangle at i position to val.
     * @param i   - index of rectangle
     * @param val - new height of rectangle
     */
    protected void setVal(final int i, final double val) {
        try {
            waitForPlatformRunLater(() -> {
                list.get(i).setFill(Color.GREY);
            });

            Thread.sleep(delay);

            waitForPlatformRunLater(() -> {
                list.get(i).setHeight(val);
                list.get(i).setY(
                    Utils.getMaxHeight() - list.get(i).getHeight());
                list.get(i).setFill(
                    Utils.getColorForHeight(list.get(i).getHeight()));
            });
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * A helper method to synchronize UI updates
     * with the JavaFX Application Thread.
     */
    private void waitForPlatformRunLater(final Runnable action)
                                        throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            action.run();
            latch.countDown();
        });
        latch.await(); // Wait for the UI update to complete
    }

}
