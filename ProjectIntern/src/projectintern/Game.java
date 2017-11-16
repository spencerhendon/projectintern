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
import Map.Floor;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import projectintern.Entity.Player;

public class Game extends BorderPane {
    // WIDTH and HEIGHT
    protected final double WIDTH, HEIGHT;
    protected double newY = 0, newX = 0;

    // Player
    public Player player;

    // Hitbox for player
    public Rectangle dummy;

    // Number of floors
    private final int NUMFLOORS = 5;

    // Vbox for floors
    public VBox vbFloors;

    public Game(double w, double h, Player player) {
        // Get width and height
        this.WIDTH = w;
        this.HEIGHT = h;
        this.player = player;

        // Set the vbox for floors
        vbFloors = new VBox((HEIGHT / 6));

        // Get a collision box for the player
        dummy = new Rectangle(player.getBoundsInParent().getWidth(), player.getBoundsInParent().getHeight());

        // Setup this borderpane
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        this.setPadding(new Insets(20, 20, 20, 20));

        displayGame(); // Display game
        displayPlayer(); // Display Player
    }

    public void displayPlayer() {
        player.setTranslateX(vbFloors.getChildren().get(0).getBoundsInLocal().getWidth() / 2 - player.getBoundsInParent().getWidth());
        System.out.println(-player.getBoundsInParent().getWidth() + player.getChildren().get(0).getBoundsInLocal().getWidth() / 2);
        player.setTranslateY(vbFloors.getChildren().get(0).getBoundsInParent().getHeight() * (NUMFLOORS / 2.5));
        this.getChildren().add(player);
    }

    public void displayGame() {
        // Create floors
        for (int i = 0; i < NUMFLOORS; i++) {
            vbFloors.getChildren().add(new Floor(WIDTH - (HEIGHT / 6), HEIGHT / 6, NUMFLOORS - i));
        }

        // Center the vb (top/right/bottom/left)
        vbFloors.setPadding(new Insets((HEIGHT - (vbFloors.getChildren().size() * (HEIGHT / 6))) / 2, (HEIGHT / 6) / 2,
                (HEIGHT - (vbFloors.getChildren().size() * (HEIGHT / 6))) / 2, (HEIGHT / 6) / 2));
        this.getChildren().add(vbFloors);
    }
}
