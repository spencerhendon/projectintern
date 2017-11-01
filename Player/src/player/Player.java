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
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
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
    Rectangle rgHead = new Rectangle(WIDTH / 30, WIDTH / 30);
    Rectangle rgLeftArm = new Rectangle(WIDTH / 25, HEIGHT / 50);
    Rectangle rgTorso = new Rectangle(WIDTH / 20, WIDTH / 20);
    Rectangle rgRightArm = new Rectangle(WIDTH / 25, HEIGHT / 50);
    Rectangle rgLeftLeg = new Rectangle(HEIGHT / 50, WIDTH / 25);
    Rectangle rgRightLeg = new Rectangle(HEIGHT / 50, WIDTH / 25);

    // VBox body
    VBox vbBody = new VBox(0);

    // Hbox for mid body
    HBox hbBodyMid = new HBox(0);

    // Hbox for lower body
    HBox hbBodyLower = new HBox(WIDTH / 100);

    @Override
    public void start(Stage stage) throws Exception {
        // Set up stage
        stage.setTitle(title);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        // Draw()
        drawHead();
        drawMidBody();
        drawLowerBody();

        // Add the body to the pane
        main.setCenter(vbBody);

        // Handle walking
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A) {
                handleWalk("left");
            } else if (e.getCode() == KeyCode.D) {
                handleWalk("right");
            }
        });
    }

    public void drawHead() {
        // Rectangle for head
        rgHead.setFill(Color.web("d88c68"));

        // Add the head to the body
        vbBody.getChildren().add(rgHead);

        // Center the body
        vbBody.setAlignment(Pos.CENTER);
    }

    public void drawMidBody() {
        // Rectangle for left arm
        rgLeftArm.setArcHeight(10);
        rgLeftArm.setArcWidth(10);
        rgLeftArm.setFill(Color.web("d88c68"));

        // Rectangle for torso
        rgTorso.setFill(Color.web("d88c68"));

        // Rectangle for right arm
        rgRightArm.setArcHeight(10);
        rgRightArm.setArcWidth(10);
        rgRightArm.setFill(Color.web("d88c68"));

        // Add arms and torso to mid body
        hbBodyMid.getChildren().addAll(rgLeftArm, rgTorso, rgRightArm);

        // Center mid body
        hbBodyMid.setAlignment(Pos.CENTER);

        // Add mid body to body
        vbBody.getChildren().add(hbBodyMid);
    }

    public void drawLowerBody() {
        // Rectangle for left leg
        rgLeftLeg.setArcHeight(10);
        rgLeftLeg.setArcWidth(10);
        rgLeftLeg.setFill(Color.web("d88c68"));

        // Rectangle for right leg
        rgRightLeg.setArcHeight(10);
        rgRightLeg.setArcWidth(10);
        rgRightLeg.setFill(Color.web("d88c68"));

        // Add arms and torso to mid body
        hbBodyLower.getChildren().addAll(rgLeftLeg, rgRightLeg);

        // Center mid body
        hbBodyLower.setAlignment(Pos.CENTER);

        // Add mid body to body
        vbBody.getChildren().add(hbBodyLower);

    }

    public void handleWalk(String direction) {
        if (direction.equals("left")) { // Move left
            //Creating Translate Transition 
            TranslateTransition translateTransition = new TranslateTransition();

            //Setting the duration of the transition  
            translateTransition.setDuration(Duration.millis(1000));

            //Setting the node for the transition 
            translateTransition.setNode(vbBody);

            //Setting the value of the transition along the x axis. 
            translateTransition.setByX(100);

            //Setting the cycle count for the transition 
            translateTransition.setCycleCount(1);

            //Setting auto reverse value to false 
            translateTransition.setAutoReverse(true);

            //Playing the animation 
            translateTransition.play();

            //Creating a Group object  
            Group root = new Group(vbBody);
            
            main.getChildren().add(root);
        } else if (direction.equals("right")) { // Move Right

        }
    }

    public static void main(String[] args) {
        // Launch application
        Application.launch(args);
    }

}
