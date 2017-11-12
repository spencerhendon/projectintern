/*
    Spencer Hendon
    Map
    October 30, 2017
    Create a map for Project Intern
 */
package map;

// Imports
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Map extends Application {

    // Width and height
    private final double WIDTH = 1920, HEIGHT = 1080;

    // Title
    private final String title = "Map";

    // BorderPane
    BorderPane main = new BorderPane();

    // Scene
    Scene scene = new Scene(main, WIDTH, HEIGHT);

    // Vbox for floors
    VBox vbFloors = new VBox((HEIGHT / 6));

    @Override
    public void start(Stage stage) throws Exception {
        // Change background color
        main.setStyle("-fx-background-color: #3d3d3d;");

        // Setup stage
        stage.setTitle(title);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

        // Create floors
        Floor flOne = new Floor(WIDTH - (HEIGHT / 6), HEIGHT / 6, String.valueOf(vbFloors.getChildren().size() + 1));
        Floor flTwo = new Floor(WIDTH - (HEIGHT / 6), HEIGHT / 6, String.valueOf(vbFloors.getChildren().size() + 1));
        Floor flThree = new Floor(WIDTH - (HEIGHT / 6), HEIGHT / 6, String.valueOf(vbFloors.getChildren().size() + 1));
        Floor flFour = new Floor(WIDTH - (HEIGHT / 6), HEIGHT / 6, String.valueOf(vbFloors.getChildren().size() + 1));
        Floor flFive = new Floor(WIDTH - (HEIGHT / 6), HEIGHT / 6, String.valueOf(vbFloors.getChildren().size() + 1));
        vbFloors.getChildren().addAll(flOne, flTwo, flThree, flFour, flFive);

        // Center the vb (top/right/bottom/left)
        vbFloors.setPadding(new Insets((HEIGHT - (vbFloors.getChildren().size() * (HEIGHT / 6))) / 2, (HEIGHT / 6) / 2,
                (HEIGHT - (vbFloors.getChildren().size() * (HEIGHT / 6))) / 2, (HEIGHT / 6) / 2));
        main.getChildren().add(vbFloors);
    }

    public static void main(String[] args) {
        // Launch application
        Application.launch(args);
    }

}
