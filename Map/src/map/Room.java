/*
    Spencer Hendon
    Room
    Novemeber 9, 2017
    Create a room for the game
 */

package map;

// Imports
import javafx.scene.layout.BorderPane;

public class Room extends BorderPane {
    // Width and height
    private final double WIDTH, HEIGHT;

    public Room(double WIDTH, double HEIGHT, String style) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;

        draw();
    }

    public void draw() {

    }
}