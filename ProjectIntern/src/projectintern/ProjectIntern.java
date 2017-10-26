/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|
|   Project: "Project: Intern"
|   Name: Spencer Hendon, Jaycob Willis, Nathaniel Ogungbuyi, Zane Sandoval
|   Date: September 15, 2017
|   Description: Top Down 2D CyberPunk Adventure Game
|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
package projectintern;

// Imports 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ProjectIntern extends Application {

    // WIDTH AND HEIGHT
    private final double WIDTH = 1280, HEIGHT = 720;

    // Aspect Ratio
    private final double ASPECT_RATIO = WIDTH / HEIGHT;

    // Title of the game
    private final String title = "Project: Intern";

    // Game Version
    private final String GAME_VERSION = "DRINK MO WUTAR, O U MITE DIE!"; // Game version... i += 0.005'

    // Title Screen Pane
    TitleScreen paneTitle = new TitleScreen(WIDTH, HEIGHT, GAME_VERSION);

    // Scene for the game
    Scene scGame = new Scene(paneTitle, WIDTH, HEIGHT);

    @Override
    public void start(Stage stage) throws Exception {
        // Set the stage
        stage.setTitle(title);
        stage.setScene(scGame);
        stage.setResizable(false);
        stage.show();

        // Handle player actions
        scGame.setOnKeyPressed(e -> {
            if (paneTitle.getChildren().contains(paneTitle.paneGame)) {
                // Player movement
                if (null != e.getCode()) switch (e.getCode()) {
                    case UP:
                        paneTitle.paneGame.move("UP");
                        break;
                    case DOWN:
                        paneTitle.paneGame.move("DOWN");
                        break;
                    case RIGHT:
                        paneTitle.paneGame.move("RIGHT");
                        break;
                    case LEFT:
                        paneTitle.paneGame.move("LEFT");
                        break;
                    default:
                        break;
                }
                
                // Change color of dummy every key push     
                int rand = (int)(Math.random() * (4 - 1) + 1);
                
                if (rand == 1) {
                    paneTitle.paneGame.dummy.setFill(Color.RED);
                    paneTitle.setStyle("-fx-background-color: #" + "0000ff");
                } else if (rand == 2) {
                    paneTitle.paneGame.dummy.setFill(Color.LIGHTGREEN);
                    paneTitle.setStyle("-fx-background-color: #" + "ff0000");
                } else if (rand == 3) {
                    paneTitle.paneGame.dummy.setFill(Color.BLUE);
                    paneTitle.setStyle("-fx-background-color: #" + "00ff00");
                }

            } else {
                // Nothing... You are not in the game field
            }
        });

    }

    public static void main(String[] args) {
        // Launch the game
        Application.launch(args);
    }

}
