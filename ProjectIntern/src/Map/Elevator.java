/*
    Nate Ogungbuyi
    Elevator 
    October 30, 2017
    Create a elevator in javafx
 */
package Map;

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
import javafx.scene.text.Font;
import javafx.util.Duration;
import javafx.scene.text.Text;

public class Elevator extends BorderPane {

    // Width and height
    private final double WIDTH, HEIGHT;

    // Floor number
    private final int FLOORNUM;

    // Elevator style... Open or closed
    private String style;

    // Elevator rectangles
    Rectangle rgT, rgD1, rgD2;
    
    // Text for floor number
    Text tFloorNum;

    public Elevator(double WIDTH, double HEIGHT, int FLOORNUM, String style) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.FLOORNUM = FLOORNUM;
        this.style = style;

        draw();
        
        changeState("open");
    }

    public void draw() {
        // Draw elevator
        Rectangle rgB = new Rectangle(WIDTH, HEIGHT);
        rgB.setFill(Color.TRANSPARENT);
        this.getChildren().add(rgB);
        
        rgT = new Rectangle((WIDTH / 3) * 2 + (WIDTH / (WIDTH / 8)), HEIGHT / 1.5 + (HEIGHT / (HEIGHT / 4)));
        rgT.setFill(Color.web("bfbfbf"));
        rgT.setX(WIDTH / 2 - rgT.getWidth() / 2);
        rgT.setY(HEIGHT - rgT.getHeight());
        this.getChildren().add(rgT);

        //Left side elevator shaft door
        rgD1 = new Rectangle(WIDTH / 3, HEIGHT / 1.5);
        rgD1.setFill(Color.web("a5a5a5"));
        rgD1.setX(WIDTH / 2 - rgD1.getWidth());
        rgD1.setY(HEIGHT - rgD1.getHeight());
        this.getChildren().add(rgD1);

        //Right side elevator shaft door
        rgD2 = new Rectangle(WIDTH / 3, HEIGHT / 1.5);
        rgD2.setFill(Color.web("a5a5a5"));
        rgD2.setX(WIDTH / 2);
        rgD2.setY(HEIGHT - rgD2.getHeight());
        this.getChildren().add(rgD2);
        
        // Draw text
        tFloorNum = new Text(String.valueOf(FLOORNUM));
        tFloorNum.setFill(Color.web("bfbfbf"));
        tFloorNum.setFont(Font.font("Verdana", 20));
        tFloorNum.setX(WIDTH / 2 - tFloorNum.getBoundsInParent().getWidth() / 2);
        tFloorNum.setY(rgT.getY() - tFloorNum.getBoundsInParent().getHeight() / 2);
        this.getChildren().add(tFloorNum);
    }

    public void changeState(String elevatorState) {
        if (elevatorState.equals("closed")) {
            // Left door
            KeyValue kvCDL1 = new KeyValue(rgD1.widthProperty(), WIDTH / 3);
            KeyFrame kfCDL = new KeyFrame(Duration.millis(1250), kvCDL1);

            Timeline tlCDL = new Timeline();
            tlCDL.getKeyFrames().add(kfCDL);
            tlCDL.setCycleCount(10);
            tlCDL.setAutoReverse(true);
            tlCDL.play();

            // Right door
            KeyValue kvCDR1 = new KeyValue(rgD2.widthProperty(), WIDTH / 3);
            KeyValue kvCDR2 = new KeyValue(rgD2.xProperty(), WIDTH / 2);
            KeyFrame kfCDR2 = new KeyFrame(Duration.millis(1250), kvCDR1, kvCDR2);
            Timeline tlCDR = new Timeline();
            tlCDR.getKeyFrames().addAll(kfCDR2);
            tlCDR.setCycleCount(10);
            tlCDR.setAutoReverse(true);
            tlCDR.play();
        } else {
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
            tlCDR.getKeyFrames().addAll(kfCDR2);
            tlCDR.setCycleCount(10);
            tlCDR.setAutoReverse(true);
            tlCDR.play();
        }

    }

}
