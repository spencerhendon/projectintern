/*
    Spencer Hendon
    Player
    Novemeber 1, 2017
    Create a player
 */
package player;

// Imports
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Player extends Application {

    // Width and height
    private final double WIDTH = 1280, HEIGHT = 720;

    // Title
    private final String title = "Player";

    // Borderpane main
    BorderPane main = new BorderPane();

    // Scene 
    Scene scene = new Scene(main, WIDTH, HEIGHT);

    // Rectangles for the body
    Rectangle rgHead = new Rectangle(HEIGHT / 48, HEIGHT / 48);
    Rectangle rgTorso = new Rectangle(HEIGHT / 30, HEIGHT / 30);
    Rectangle rgLeftArm = new Rectangle(HEIGHT / 90, HEIGHT / 40);
    Rectangle rgRightArm = new Rectangle(HEIGHT / 90, HEIGHT / 40);
    Rectangle rgLeftLeg = new Rectangle(HEIGHT / 90, HEIGHT / 36);
    Rectangle rgRightLeg = new Rectangle(HEIGHT / 90, HEIGHT / 36);

    // Player Movement
    TranslateTransition translateTransition = new TranslateTransition();
    private final int playerSpeed = 6;
    private final int animationMultiple = 1;

    // Group for body
    Group gBody = new Group();

    @Override
    public void start(Stage stage) throws Exception {
        // Set up stage
        stage.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Draw body
        drawBody();

        // Add the body to the pane
        main.setCenter(gBody);

        // Handle walking
        scene.setOnKeyPressed(e -> {
            if (null != e.getCode()) {
                switch (e.getCode()) {
                    case A:
                        // Move left
                        handleWalk("left");
                        break;
                    case D:
                        // Move Right
                        handleWalk("right");
                        break;
                    case W:
                        // Jump
                        handleJump();
                        break;
                    default:
                        break;
                }
            }
        });

    }

    public void drawBody() {
        // Rectangle for head
        rgHead.setFill(Color.web("d88c68"));
        rgHead.setX(rgLeftArm.getWidth() + rgTorso.getWidth() / 2 - rgHead.getWidth() / 2);

        // Rectangle for left arm
        rgLeftArm.setArcHeight(5);
        rgLeftArm.setArcWidth(5);
        rgLeftArm.setFill(Color.web("d88c68"));
        rgLeftArm.setY(rgHead.getHeight());

        // Rectangle for torso
        rgTorso.setFill(Color.web("d88c68"));
        rgTorso.setX(rgLeftArm.getWidth());
        rgTorso.setY(rgHead.getHeight());

        // Rectangle for right arm
        rgRightArm.setArcHeight(5);
        rgRightArm.setArcWidth(5);
        rgRightArm.setFill(Color.web("d88c68"));
        rgRightArm.setX(rgLeftArm.getWidth() + rgTorso.getWidth());
        rgRightArm.setY(rgHead.getHeight());

        // Rectangle for left leg
        rgRightLeg.setArcHeight(5);
        rgRightLeg.setArcWidth(5);
        rgRightLeg.setFill(Color.web("d88c68"));
        rgRightLeg.setX(rgTorso.getX() + rgLeftLeg.getWidth() * 2
                - rgLeftLeg.getWidth() / 3);
        rgRightLeg.setY(rgHead.getHeight() + rgTorso.getWidth());

        // Rectangle for right leg
        rgLeftLeg.setArcHeight(5);
        rgLeftLeg.setArcWidth(5);
        rgLeftLeg.setFill(Color.web("d88c68"));
        rgLeftLeg.setX(rgTorso.getX() + rgTorso.getWidth()
                - rgRightLeg.getWidth() * 3 + rgRightLeg.getWidth() / 3);
        rgLeftLeg.setY(rgHead.getHeight() + rgTorso.getWidth());

        // Add the head to the body
        gBody.getChildren().addAll(rgHead,
                rgLeftArm, rgTorso, rgRightArm,
                rgLeftLeg, rgRightLeg);
    }

    public void handleWalk(String direction) {
        // Setting the duration of the transition  
        translateTransition.setDuration(Duration.millis(1));

        // Setting the node for the transition 
        translateTransition.setNode(gBody);

        // Setting the cycle count for the transition 
        translateTransition.setCycleCount(animationMultiple);

        if (direction.equals("left")) { // Move left
            // Rotate left leg
            rgLeftLeg.getTransforms().add(new Rotate(-45,
                    rgLeftLeg.getX() + rgLeftLeg.getWidth() / 2,
                    rgLeftLeg.getY()));

            // Rotate right leg
            rgRightLeg.getTransforms().add(new Rotate(-45,
                    rgRightLeg.getX() + rgRightLeg.getWidth() / 2,
                    rgRightLeg.getY()));
            
            // Setting the value of the transition along the x axis. 
            translateTransition.setByX(-playerSpeed);

            // Playing the animation 
            translateTransition.play();
        } else if (direction.equals("right")) { // Move Right
            // Rotate left leg
            rgLeftLeg.getTransforms().add(new Rotate(45,
                    rgLeftLeg.getX() + rgLeftLeg.getWidth() / 2,
                    rgLeftLeg.getY()));

            // Rotate right leg
            rgRightLeg.getTransforms().add(new Rotate(45,
                    rgRightLeg.getX() + rgRightLeg.getWidth() / 2,
                    rgRightLeg.getY()));

            // Setting the value of the transition along the x axis. 
            translateTransition.setByX(playerSpeed);

            // Playing the animation 
            translateTransition.play();
        }
    }

    public void handleJump() {
        // Setting the duration of the transition  
        translateTransition.setDuration(Duration.millis(250));

        // Setting the node for the transition 
        translateTransition.setNode(gBody);

        // Setting the cycle count for the transition 
        translateTransition.setCycleCount(animationMultiple);

        // Setting the value of the transition along the x axis. 
        translateTransition.setByX(0);

        // Setting the value of the transition along the y axis. 
        translateTransition.setByY(-playerSpeed * playerSpeed);

        // Playing the animation 
        translateTransition.play();

        // Setting the value of the transition along the y axis. 
        translateTransition.setByY(playerSpeed * playerSpeed);

        // Playing the animation 
        translateTransition.play();
    }

    public static void main(String[] args) {
        // Launch application
        Application.launch(args);
    }

}
