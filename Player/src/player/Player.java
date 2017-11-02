/*
    Spencer Hendon
    Player
    Novemeber 1, 2017
    Create a player
 */
package player;

// Imports
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
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
    Timeline jump = new Timeline();
    private final int playerSpeedWalk = 6;
    private final int playerSpeedJump = 75;
    private final int playerHeightJump = 500;
    private final int playerAngleWalk = 25;
    private final int animationMultiple = 1;
    private final String playerState = "forward"; // forward, backward, walk

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
        setAnimations();

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
        rgHead.setFill(Color.web("ff0000"));
        rgHead.setX(rgLeftArm.getWidth() + rgTorso.getWidth() / 2 - rgHead.getWidth() / 2);

        // Rectangle for left arm
        rgLeftArm.setArcHeight(5);
        rgLeftArm.setArcWidth(5);
        rgLeftArm.setFill(Color.web("0000ff"));
        rgLeftArm.setY(rgHead.getHeight());

        // Rectangle for torso
        rgTorso.setFill(Color.web("000000"));
        rgTorso.setX(rgLeftArm.getWidth());
        rgTorso.setY(rgHead.getHeight());

        // Rectangle for right arm
        rgRightArm.setArcHeight(5);
        rgRightArm.setArcWidth(5);
        rgRightArm.setFill(Color.web("0000ff"));
        rgRightArm.setX(rgLeftArm.getWidth() + rgTorso.getWidth());
        rgRightArm.setY(rgHead.getHeight());

        // Rectangle for left leg
        rgRightLeg.setArcHeight(5);
        rgRightLeg.setArcWidth(5);
        rgRightLeg.setFill(Color.web("00ff00"));
        rgRightLeg.setX(rgTorso.getX() + rgLeftLeg.getWidth() * 2
                - rgLeftLeg.getWidth() / 3);
        rgRightLeg.setY(rgHead.getHeight() + rgTorso.getWidth());

        // Rectangle for right leg
        rgLeftLeg.setArcHeight(5);
        rgLeftLeg.setArcWidth(5);
        rgLeftLeg.setFill(Color.web("00ff00"));
        rgLeftLeg.setX(rgTorso.getX() + rgTorso.getWidth()
                - rgRightLeg.getWidth() * 3 + rgRightLeg.getWidth() / 3);
        rgLeftLeg.setY(rgHead.getHeight() + rgTorso.getWidth());

        // Add the head to the body
        gBody.getChildren().addAll(rgHead,
                rgLeftArm, rgTorso, rgRightArm,
                rgLeftLeg, rgRightLeg);
    }
    
    public void setAnimations() {
        // Create all key frames for jump
        KeyValue kvJump = new KeyValue(gBody.translateYProperty(),
                -playerHeightJump);
        KeyFrame kfJump = new KeyFrame(Duration.millis(playerSpeedJump), kvJump);
        
        // Setup jump timeline
        jump.setCycleCount(2);
        jump.setAutoReverse(true);
        jump.getKeyFrames().add(kfJump);
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
            rgLeftLeg.getTransforms().add(new Rotate(-playerAngleWalk,
                    rgLeftLeg.getX() + rgLeftLeg.getWidth() / 2,
                    rgLeftLeg.getY()));

            // Rotate right leg
            rgRightLeg.getTransforms().add(new Rotate(-playerAngleWalk,
                    rgRightLeg.getX() + rgRightLeg.getWidth() / 2,
                    rgRightLeg.getY()));

            // Setting the value of the transition along the x axis. 
            translateTransition.setByX(-playerSpeedWalk);

            // Playing the animation 
            translateTransition.play();
        } else if (direction.equals("right")) { // Move Right
            // Rotate left leg
            rgLeftLeg.getTransforms().add(new Rotate(playerAngleWalk,
                    rgLeftLeg.getX() + rgLeftLeg.getWidth() / 2,
                    rgLeftLeg.getY()));

            // Rotate right leg
            rgRightLeg.getTransforms().add(new Rotate(playerAngleWalk,
                    rgRightLeg.getX() + rgRightLeg.getWidth() / 2,
                    rgRightLeg.getY()));

            // Setting the value of the transition along the x axis. 
            translateTransition.setByX(playerSpeedWalk);

            // Playing the animation 
            translateTransition.play();
        }
    }

    public void handleJump() {
        jump.play();
    }

    public static void main(String[] args) {
        // Launch application
        Application.launch(args);
    }

}
