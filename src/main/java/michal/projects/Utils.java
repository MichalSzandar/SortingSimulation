package michal.projects;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Color;
import javafx.stage.Screen;

public class Utils {
    private static Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
    
    public static double getMaxHeight(){
        return primaryScreenBounds.getHeight();
    }

    public static double getMaxWidth(){
        return primaryScreenBounds.getWidth();
    }

    @SuppressWarnings("exports")
    public static Color getColorForHeight(double height) {
        double ratio = (double) height / getMaxHeight(); // Normalize height to a range [0, 1]
        return Color.color(1 - ratio, 0, ratio); // Gradient from red (shorter) to blue (taller)
    }
}
