
/*
    Nate Ogungbuyi
    Elevator 
    October 30, 2017
    Create a elevator in javafx
 */
package map;

// Imports
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import javafx.scene.text.Text;

public class Elevator extends BorderPane {

    // Width and height
    private final double WIDTH, HEIGHT;

    // Floor number
    private final int FLOORNUM;

    // Elevator style... Open or closed
    private String style;

    Rectangle rgT, rgD1, rgD2;

    public Elevator(double WIDTH, double HEIGHT, int FLOORNUM, String style) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.FLOORNUM = FLOORNUM;
        this.style = style;

        draw();
    }

    public void draw() {
        Rectangle rgB = new Rectangle(WIDTH, HEIGHT);
        rgB.setFill(Color.BLUE);
        this.getChildren().add(rgB);

        //Adding numbers to elevators
        Text t = new Text();
        t.setText("1");
        
        
        rgT = new Rectangle((WIDTH / 3) * 2 + (WIDTH / (WIDTH / 8)), HEIGHT / 1.5 + (HEIGHT / (HEIGHT / 4)));
        rgT.setFill(Color.DARKGRAY);
        rgT.setX(WIDTH / 2 - rgT.getWidth() / 2);
        rgT.setY(HEIGHT - rgT.getHeight());
        this.getChildren().add(rgT);
        
        //Left side elevator shaft door
        rgD1 = new Rectangle(WIDTH / 3, HEIGHT / 1.5);
        rgD1.setFill(Color.GRAY);
        rgD1.setX(WIDTH / 2 - rgD1.getWidth());
        rgD1.setY(HEIGHT - rgD1.getHeight());
        this.getChildren().add(rgD1);

        //Right side elevator shaft door
        rgD2 = new Rectangle(WIDTH / 3, HEIGHT / 1.5);
        rgD2.setFill(Color.GRAY);
        rgD2.setX(WIDTH / 2);
        rgD2.setY(HEIGHT - rgD2.getHeight());
        this.getChildren().add(rgD2);
        
        setAnimations("closed");
    }

    public void setAnimations(String elevatorState) {
        // Left door
        KeyValue kvCDL1 = new KeyValue(rgD1.widthProperty(), 0);
        KeyFrame kfCDL = new KeyFrame(Duration.millis(2500), kvCDL1);
        
        Timeline tlCDL = new Timeline();
        tlCDL.getKeyFrames().add(kfCDL);
        tlCDL.setCycleCount(10);
        tlCDL.setAutoReverse(true);
        tlCDL.play();
        
        // Right door
        KeyValue kvCDR1 = new KeyValue(rgD2.widthProperty(), 0);
        KeyValue kvCDR2 = new KeyValue(rgD2.xProperty(), (WIDTH / 2) + (WIDTH / 3));
        KeyFrame kfCDR2 = new KeyFrame(Duration.millis(2500), kvCDR1, kvCDR2);
        Timeline tlCDR = new Timeline();
        tlCDR.getKeyFrames().addAll( kfCDR2);
        tlCDR.setCycleCount(10);
        tlCDR.setAutoReverse(true);
        tlCDR.play();
    }

}