/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|
|   Project: "Project: Intern"
|   Name: Spencer Hendon, Jaycob Willis, Nathaniel Ogungbuyi, Zane Sandoval
|   Date: September 15, 2017
|   Description: A 2D platformer
|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
package projectintern;

// Imports 
import Menus.PauseMenu;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

public class ProjectIntern extends Application {

    // WIDTH AND HEIGHT
    private final double WIDTH = 1280, HEIGHT = 720;

    // Title of the game
    private final String title = "Project: Intern";

    // Game Version
    private final String GAME_VERSION = "1.005"; // Game version... i += 0.005'

    // Title Screen Pane
    TitleScreen paneTitle = new TitleScreen(WIDTH, HEIGHT, GAME_VERSION);

    // Key bindings
    private String keyUP = "W";
    private String keyDOWN = "S";
    private String keyLEFT = "A";
    private String keyRIGHT = "D";
    private String keyPAUSE = "Z";
    private String keyACTION = "Q";

    // Pause Menu Pane
    PauseMenu menuPause = new PauseMenu(WIDTH - 60, HEIGHT - 60);

    // Scene for the game
    Scene scGame = new Scene(paneTitle, WIDTH, HEIGHT);

    @Override
    public void start(Stage stage) throws Exception {
        // Set the stage
        stage.setTitle(title);
        stage.setScene(scGame);
        stage.setResizable(false);
        stage.show();

        // Key presses
        scGame.setOnKeyPressed(e -> {
            if (paneTitle.getChildren().contains(paneTitle.paneGame)) {
                // Handle walking
                if (null != e.getCode()) {
                    // Reset animations
                    paneTitle.paneGame.player.setAnimations();
                    if (!paneTitle.paneGame.getChildren().contains(menuPause)) {
                        if (e.getCode() == KeyCode.valueOf(keyLEFT)) {
                            // Change body to left side
                            paneTitle.paneGame.player.changeState("sideLeft");
                            paneTitle.paneGame.player.tlWalkLeft.play();
                            paneTitle.paneGame.player.setVelocityX(-5);
                        } else if (e.getCode() == KeyCode.valueOf(keyRIGHT)) {
                            // Change body to right side
                            paneTitle.paneGame.player.changeState("sideRight");
                            paneTitle.paneGame.player.tlWalkRight.play();
                            paneTitle.paneGame.player.setVelocityX(5);
                        } else if (e.getCode() == KeyCode.valueOf(keyUP)) {
                            // Change body to front
                            paneTitle.paneGame.player.changeState("back");
                        } else if (e.getCode() == KeyCode.valueOf(keyDOWN)) {
                            // Change body to right side
                            paneTitle.paneGame.player.changeState("front");
                        }
                    }
                    if (e.getCode() == KeyCode.valueOf(keyPAUSE)) {
                        // Show pause menu
                        if (!paneTitle.paneGame.getChildren().contains(menuPause)) {
                            // Stop player
                            paneTitle.paneGame.player.setVelocityXTemp(paneTitle.paneGame.player.getVelocityX());
                            paneTitle.paneGame.player.setVelocityYTemp(paneTitle.paneGame.player.getVelocityY());
                            paneTitle.paneGame.player.setVelocityX(0);
                            paneTitle.paneGame.player.setVelocityY(0);
                            // Display Menu
                            menuPause.setTranslateX(WIDTH / 2 - menuPause.getBoundsInParent().getWidth() / 2);
                            menuPause.setTranslateY(HEIGHT / 2 - menuPause.getBoundsInParent().getHeight() / 2);
                            paneTitle.paneGame.getChildren().add(menuPause);
                        } else {
                            // Remove pause menu
                            paneTitle.paneGame.getChildren().remove(menuPause);
                            
                            // Return player to normal state
                            paneTitle.paneGame.player.setVelocityX(paneTitle.paneGame.player.getVelocityXTemp());
                            paneTitle.paneGame.player.setVelocityY(paneTitle.paneGame.player.getVelocityYTemp());
                        }
                    }
                }
            }
        });

        // Key releases
        scGame.setOnKeyReleased(e -> {
            if (paneTitle.getChildren().contains(paneTitle.paneGame)) {
                // Handle walking
                if (null != e.getCode()) {
                    // Reset animations
                    paneTitle.paneGame.player.setAnimations();

                    if (!paneTitle.paneGame.getChildren().contains(menuPause)) {
                        if (e.getCode() == KeyCode.valueOf(keyLEFT)) {
                            if (paneTitle.paneGame.player.getVelocityX() == -5) {
                                paneTitle.paneGame.player.setVelocityX(0);
                            }
                        } else if (e.getCode() == KeyCode.valueOf(keyRIGHT)) {
                            if (paneTitle.paneGame.player.getVelocityX() == 5) {
                                paneTitle.paneGame.player.setVelocityX(0);
                            }
                        } else if (e.getCode() == KeyCode.valueOf(keyUP)) {
                            paneTitle.paneGame.player.setVelocityY(0);
                        } else if (e.getCode() == KeyCode.valueOf(keyDOWN)) {
                            paneTitle.paneGame.player.setVelocityX(0);
                        }
                    }
                    if (e.getCode() == KeyCode.valueOf(keyPAUSE)) {
                        // Nothing currently
                    }
                }
            }
        });
        
        // Main game loop
        AnimationTimer playerLoop = new GameTimer();
        playerLoop.start();
    }
    
    private class GameTimer extends AnimationTimer {

        @Override
        public void handle(long l) {
            // Check if the player
            checkPlayerCollision();
        }

    }
    
    public void checkPlayerCollision() {
        if (paneTitle.getChildren().contains(paneTitle.paneGame)) {
            for (int i = 0; i < paneTitle.paneGame.player.getCurrentFloorNum(); i++) {

            }
        }
        
    }

    public static void main(String[] args) {
        // Launch the game
        Application.launch(args);
    }

}
