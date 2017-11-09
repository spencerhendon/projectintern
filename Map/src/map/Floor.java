/*
    Spencer Hendon
    Floor
    October 30, 2017
    Create a floor in javafx
 */
package map;

// Imports
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Floor extends BorderPane {
    // Width and height of floor
    private final double WIDTH, HEIGHT;

    // Floor number
    private final String floorNum;
    
    // VBox for left doors
    private HBox hbDoorsLeft;
    
    // VBox for middle doors
    private HBox hbDoorsMid;
    
    // VBox for right doors
    private HBox hbDoorsRight;

    public Floor(double WIDTH, double HEIGHT, String floorNum) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.floorNum = floorNum;
        
        hbDoorsLeft = new HBox((WIDTH + HEIGHT) / ((2.0/3.0) * 10));
        hbDoorsMid = new HBox((WIDTH + HEIGHT) / ((2.0/3.0) * 10));
        hbDoorsRight = new HBox((WIDTH + HEIGHT) / ((2.0/3.0) * 10));
        
        draw();
    }

    public void draw() {
        // Background rectangle
        Rectangle rgFlBg = new Rectangle(WIDTH, HEIGHT);
        rgFlBg.setFill(Color.web("eaeaea"));
        this.getChildren().add(rgFlBg);

        // Draw trim
        Rectangle rgFlTr = new Rectangle(WIDTH, 6);
        rgFlTr.setX(0);
        rgFlTr.setY(HEIGHT - rgFlTr.getHeight());
        rgFlTr.setFill(Color.web("323232"));
        this.getChildren().add(rgFlTr);

        // Draw floor
        Rectangle rgFlFl = new Rectangle(WIDTH, 2);
        rgFlFl.setX(0);
        rgFlFl.setY(HEIGHT - rgFlFl.getHeight());
        rgFlFl.setFill(Color.web("646464"));
        this.getChildren().add(rgFlFl);
        
        // Draw doors
        Door doorLM = new Door(WIDTH / 25, HEIGHT / 1.75, "open");
        Door doorML = new Door(WIDTH / 25, HEIGHT / 1.75, "closed");
        Door doorMR = new Door(WIDTH / 25, HEIGHT / 1.75, "half");
        Door doorRL = new Door(WIDTH / 25, HEIGHT / 1.75, "closed");
        Door doorRR = new Door(WIDTH / 25, HEIGHT / 1.75, "open");
        
        // Add doors to pane
        hbDoorsLeft.getChildren().addAll(doorLM, doorML, doorMR, doorRL, doorRR);
        hbDoorsLeft.setTranslateX(doorLM.getBoundsInParent().getWidth());
        hbDoorsLeft.setTranslateY(HEIGHT - rgFlFl.getHeight() - doorLM.getBoundsInParent().getHeight());
        this.getChildren().addAll(hbDoorsLeft, hbDoorsMid, hbDoorsRight);
    }
}
