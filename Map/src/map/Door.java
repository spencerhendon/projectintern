/*
    Spencer Hendon
    Door
    October 30, 2017
    Create a door in javafx
 */
package map;

// Imports
import javafx.scene.layout.BorderPane;

public class Door extends BorderPane {

    // Width and height
    private final double WIDTH, HEIGHT;

    // Floor Number
    private final String floorNum;

    public Door(double WIDTH, double HEIGHT, String floorNum) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.floorNum = floorNum;

        draw();
    }

    public void draw() {

    }
}
