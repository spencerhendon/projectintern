/*
    Spencer Hendon
    Floor
    October 30, 2017
    Create a floor in javafx
 */
package map;

// Imports
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Floor extends BorderPane {

    // Width and height
    private final double WIDTH, HEIGHT;

    // Floor number
    private final String floorNum;

    public Floor(double WIDTH, double HEIGHT, String floorNum) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.floorNum = floorNum;

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
        rgFlTr.setFill(Color.web("702626"));
        this.getChildren().add(rgFlTr);

        // Draw floor
        Rectangle rgFlFl = new Rectangle(WIDTH, 2);
        rgFlFl.setX(0);
        rgFlFl.setY(HEIGHT - rgFlFl.getHeight());
        rgFlFl.setFill(Color.web("471212"));
        this.getChildren().add(rgFlFl);
    }
}
