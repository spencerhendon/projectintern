/*
    Spencer Hendon
    Elevator
    October 30, 2017
    Create a elevator in javafx
 */
package map;

// Imports
import javafx.scene.layout.BorderPane;

public class Elevator extends BorderPane {

    // Width and height
    private final double WIDTH, HEIGHT;

    // Floor number
    private final String floorNum;

    public Elevator(double WIDTH, double HEIGHT, String floorNum, String style) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.floorNum = floorNum;

        draw();
    }

    public void draw() {

    }
}
