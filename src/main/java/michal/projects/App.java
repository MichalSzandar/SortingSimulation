package michal.projects;

import javafx.application.Application;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) {
        new StartUpPanel(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}