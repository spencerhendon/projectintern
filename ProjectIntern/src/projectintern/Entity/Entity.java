/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|
|   Project: Entity
|   Name: Spencer Hendon, Jaycob Willis, Nathaniel Ogungbuyi, Zane Sandoval
|   Date: September 15, 2017
|   Description: Class for entities
|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
package projectintern.Entity;

import javafx.scene.layout.BorderPane;

public class Entity extends BorderPane {

    

    // Coordinates
    private double xCoord, yCoord;


    public Entity(int xCoord, int yCoord) {
        this.xCoord = xCoord; // Initial x coord
        this.yCoord = yCoord; // Initial y coord
    }

    // Getter methods
    public double getXCoord() {
        return this.xCoord;
    }

    public double getYCoord() {
        return this.yCoord;
    }

    // Setter methods
    public void setXCoord(double x) {
        this.xCoord = x;
    }

    public void setYCoord(double y) {
        this.yCoord = y;
    }
}
