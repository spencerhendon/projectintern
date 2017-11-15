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
    private final String GAME_VERSION = "1.005"; // Game version... i += 0.005'

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
                // Handle walking
                if (null != e.getCode()) {
                    // Reset animations
                    paneTitle.paneGame.player.setAnimations();

                    if (null != e.getCode()) {
                        switch (e.getCode()) {
                            case A:
                                // Change body to left side
                                paneTitle.paneGame.player.changeState("sideLeft");
                                paneTitle.paneGame.player.tlWalkLeft.play();
                                paneTitle.paneGame.player.setVelocityX(-5);
                                break;
                            case D:
                                // Change body to right side
                                paneTitle.paneGame.player.changeState("sideRight");
                                paneTitle.paneGame.player.tlWalkRight.play();
                                paneTitle.paneGame.player.setVelocityX(5);
                                break;
                            case W:
                                // Change body to front
                                paneTitle.paneGame.player.changeState("back");
                                break;
                            case S:
                                // Change body to right side
                                paneTitle.paneGame.player.changeState("front");
                                break;
                            default:
                                break;
                        }
                    }
                }
            }

        });

        scGame.setOnKeyReleased(e -> {
            if (paneTitle.getChildren().contains(paneTitle.paneGame)) {
                // Handle walking
                if (null != e.getCode()) {
                    // Reset animations
                    paneTitle.paneGame.player.setAnimations();

                    if (null != e.getCode()) {
                        if (null != e.getCode()) {
                            switch (e.getCode()) {
                                case A:
                                    if (paneTitle.paneGame.player.getVelocityX() == -5) {
                                        paneTitle.paneGame.player.setVelocityX(0);
                                    }
                                    break;
                                case D:
                                    if (paneTitle.paneGame.player.getVelocityX() == 5) {
                                        paneTitle.paneGame.player.setVelocityX(0);
                                    }
                                    break;
                                case W:
                                    paneTitle.paneGame.player.setVelocityY(0);
                                    break;
                                case S:
                                    paneTitle.paneGame.player.setVelocityX(0);
                                    break;
                                default:
                                    break;
                            }

                        }

                    }
                }

            }
        });

    }

    public static void main(String[] args) {
        // Launch the game
        Application.launch(args);
    }

}
