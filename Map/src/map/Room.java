/*
    Spencer Hendon
    Room
    Novemeber 9, 2017
    Create a room for the game
 */

package map;

// Imports
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Room extends BorderPane {
    // Width and height
    private final double WIDTH, HEIGHT;

    public Room(double WIDTH, double HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        draw();
    }

    public void draw() {
        // Draw Background
        Rectangle rgB = new Rectangle(WIDTH, HEIGHT);
        rgB.setFill(Color.RED);
        this.getChildren().add(rgB);
    }
}