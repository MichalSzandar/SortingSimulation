package michal.projects;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StartUpPanel {
    @SuppressWarnings("exports")
    public StartUpPanel(Stage stage){
        stage.setTitle("control panel");

        Label numOfElements = new Label("Number of elements: ");
        Spinner<Integer> elementsSpinner = new Spinner<>();
        elementsSpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(10, 300, 200));

        Label algorithmLabel = new Label("choose sorting algorithm: ");
        ComboBox<String> algorithmComboBox = new ComboBox<>();
        algorithmComboBox.getItems().addAll("bubble sort", "quick sort", "insertion sort", "merge sort");
        algorithmComboBox.setValue("insertion sort");

        Label delayLabel = new Label("delay");
        Slider delaySlider = new Slider(5, 1000, 100);
        delaySlider.setBlockIncrement(1);

        
        Button startButton = new Button("Start simulation");
        startButton.setOnAction(event -> new SimulationWindow(elementsSpinner.getValue(), 
            (int)delaySlider.getValue(), 
            AlgorithmMap.getInstance().getAlgorithm(algorithmComboBox.getValue()))
        );

        // Layout configuration
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(numOfElements, 0, 0);
        grid.add(elementsSpinner, 1, 0);
        grid.add(algorithmLabel, 0, 1);
        grid.add(algorithmComboBox, 1, 1);
        grid.add(delayLabel, 0, 2);
        grid.add(delaySlider, 1, 2);
        grid.add(startButton, 0, 3);

        Scene scene = new Scene(grid, 400, 200);
        stage.setScene(scene);
        stage.show();
    }
}
