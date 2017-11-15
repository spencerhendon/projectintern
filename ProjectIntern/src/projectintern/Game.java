/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|
|   Project: Entity
|   Name: Spencer Hendon, Jaycob Willis, Nathaniel Ogungbuyi, Zane Sandoval
|   Date: September 15, 2017
|   Description: Game play pane
|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
package projectintern;

// Imports
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import projectintern.Entity.Player;

public class Game extends BorderPane {

    // WIDTH and HEIGHT
    protected final double WIDTH, HEIGHT;
    protected double newY = 0, newX = 0;

    // Player
    Player player;

    // Hitbox for player
    Rectangle dummy;

    public Game(double w, double h, Player player) {
        // Get width and height
        this.WIDTH = w;
        this.HEIGHT = h;
        this.player = player;
        
        // Get a collision box for the player
        dummy = new Rectangle(player.getBoundsInParent().getWidth(), player.getBoundsInParent().getHeight());

        // Setup this borderpane
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        this.setPadding(new Insets(20, 20, 20, 20));
        
        displayPlayer(); // Display Player
    }

    public void displayPlayer() {
        getChildren().add(player);
    }

    public void move(String direction) {
        switch (direction) {
            case "UP":
                player.setYCoord(dummy.getY() - player.getSpeed());
                dummy.setY(player.getYCoord());
                break;
            case "DOWN":
                player.setYCoord(dummy.getY() + player.getSpeed());
                dummy.setY(player.getYCoord());
                break;
            case "RIGHT":
                player.setXCoord(dummy.getX() + player.getSpeed());
                dummy.setX(player.getXCoord());
                break;
            case "LEFT":
                player.setXCoord(dummy.getX() - player.getSpeed());
                dummy.setX(player.getXCoord());
                break; 
            case "w":
                player.setYCoord(dummy.getY() - player.getSpeed());
                dummy.setY(player.getYCoord());
                break;
            case "s":
                player.setYCoord(dummy.getY() + player.getSpeed());
                dummy.setY(player.getYCoord());
                break;
            case "d":
                player.setXCoord(dummy.getX() + player.getSpeed());
                dummy.setX(player.getXCoord());
                break;
            case "a":
                player.setXCoord(dummy.getX() - player.getSpeed());
                dummy.setX(player.getXCoord());
                break;
                
            default:
                break;
        }
    }
    
    public void displayMenu() {
        
    }
}
