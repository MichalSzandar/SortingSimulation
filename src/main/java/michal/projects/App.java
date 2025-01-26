package michal.projects;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App.
 */
public class App extends Application {

    @SuppressWarnings("exports")
    @Override
    public final void start(final Stage stage) {
        new StartUpPanel(stage);
    }

    /**
     * main method starting application.
     * @param args - array of arguemnts
     */
    public static void main(final String[] args) {
        launch();
    }

}
