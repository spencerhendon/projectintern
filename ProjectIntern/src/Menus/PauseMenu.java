/*
    Spencer Hendon
    Pause Menu
    November 15, 2017
    A pause menu
 */

package Menus;

// Imports
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class PauseMenu extends BorderPane {
    // Width and height
    private final double WIDTH, HEIGHT;
    
    public PauseMenu(double WIDTH, double HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        
        // Draw menu
        draw();
    }
    
    public void draw() {
        Rectangle rgB = new Rectangle(WIDTH, HEIGHT);
        rgB.setFill(Color.web("DCDCDC"));
        rgB.setOpacity(0.9);
        this.getChildren().add(rgB);
    }
}
