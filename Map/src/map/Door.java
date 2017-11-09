/*
    Spencer Hendon
    Door
    October 30, 2017
    Create a door in javafx
 */
package map;

// Imports
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Door extends BorderPane {
    // Width and height
    private final double WIDTH, HEIGHT;
    
    // Door state
    private final String doorState;

    public Door(double WIDTH, double HEIGHT, String doorState) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.doorState = doorState;

        draw();
    }

    public void draw() {
        if (doorState.equals("closed")) {
            doorClosed();
        } else if (doorState.equals("open")) {
            doorOpen();
        } else {
            doorHalf();
        }
    }
    
    public void doorClosed() {
        // Draw trim
        Rectangle rgDT = new Rectangle(WIDTH, HEIGHT);
        rgDT.setFill(Color.web("471212"));
        this.getChildren().add(rgDT);
        
        // Draw door
        Rectangle rgDD = new Rectangle(WIDTH - (WIDTH / (WIDTH / 4)) , HEIGHT - (HEIGHT / (HEIGHT / 2)));
        rgDD.setTranslateX((WIDTH / (WIDTH / 2)));
        rgDD.setTranslateY((HEIGHT / (HEIGHT / 2)));
        rgDD.setFill(Color.web("e50404"));
        this.getChildren().add(rgDD);
        
        // Draw three hinges
        VBox vbHinges = new VBox(WIDTH / 3);
        Rectangle rgDH1 = new Rectangle((WIDTH / (WIDTH / 2)), (HEIGHT / (HEIGHT / 8)));
        rgDH1.setFill(Color.web("969696"));
        Rectangle rgDH2 = new Rectangle((WIDTH / (WIDTH / 2)), (HEIGHT / (HEIGHT / 8)));
        rgDH2.setFill(Color.web("969696"));
        Rectangle rgDH3 = new Rectangle((WIDTH / (WIDTH / 2)), (HEIGHT / (HEIGHT / 8)));
        rgDH3.setFill(Color.web("969696"));
        vbHinges.getChildren().addAll(rgDH1, rgDH2, rgDH3);
        vbHinges.setTranslateX(rgDH1.getWidth() / 2);
        vbHinges.setTranslateY(rgDH1.getHeight());
        this.getChildren().add(vbHinges);
        
        // Draw door handle block
        Rectangle rgDHM = new Rectangle((WIDTH / (WIDTH / 4)), (WIDTH / (WIDTH / 4)));
        rgDHM.setTranslateX(WIDTH - rgDHM.getWidth() * 2);
        rgDHM.setTranslateY(HEIGHT / 2 - rgDHM.getHeight() / 2);
        rgDHM.setFill(Color.web("e1e1e1"));
        this.getChildren().add(rgDHM);
        
        // Draw door handle
        Rectangle rgDHL = new Rectangle((WIDTH / (WIDTH / 8)), (WIDTH / (WIDTH / 2)));
        rgDHL.setTranslateX(WIDTH - rgDHL.getWidth() * 2);
        rgDHL.setTranslateY(HEIGHT / 2 - rgDHL.getHeight() / 2);
        rgDHL.setFill(Color.web("c8c8c8"));
        this.getChildren().add(rgDHL);
    }
    
    public void doorOpen() {
        // Draw trim
        Rectangle rgDT = new Rectangle(WIDTH, HEIGHT);
        rgDT.setFill(Color.TRANSPARENT);
        rgDT.setStroke(Color.web("471212"));
        rgDT.setStrokeWidth((WIDTH / (WIDTH / 2)));
        this.getChildren().add(rgDT);
        
        // Draw three hinges
        VBox vbHinges = new VBox(WIDTH / 3);
        Rectangle rgDH1 = new Rectangle((WIDTH / (WIDTH / 2)), (HEIGHT / (HEIGHT / 8)));
        rgDH1.setFill(Color.web("969696"));
        Rectangle rgDH2 = new Rectangle((WIDTH / (WIDTH / 2)), (HEIGHT / (HEIGHT / 8)));
        rgDH2.setFill(Color.web("969696"));
        Rectangle rgDH3 = new Rectangle((WIDTH / (WIDTH / 2)), (HEIGHT / (HEIGHT / 8)));
        rgDH3.setFill(Color.web("969696"));
        vbHinges.getChildren().addAll(rgDH1, rgDH2, rgDH3);
        vbHinges.setTranslateX(rgDH1.getWidth() / 2);
        vbHinges.setTranslateY(rgDH1.getHeight());
        this.getChildren().add(vbHinges);
        
        // Draw door
        Rectangle rgDD = new Rectangle(WIDTH - (WIDTH / (WIDTH / 4)) , HEIGHT);
        rgDD.setTranslateX((WIDTH / (WIDTH / 2)) - rgDD.getWidth());
        rgDD.setTranslateY((HEIGHT / (HEIGHT / 2)) / 2);
        rgDD.setFill(Color.web("e50404"));
        this.getChildren().add(rgDD);
    }
    
    public void doorHalf() {
        // Draw trim
        Rectangle rgDT = new Rectangle(WIDTH, HEIGHT);
        rgDT.setFill(Color.TRANSPARENT);
        rgDT.setStroke(Color.web("471212"));
        rgDT.setStrokeWidth((WIDTH / (WIDTH / 2)));
        this.getChildren().add(rgDT);
        
        // Draw three hinges
        VBox vbHinges = new VBox(WIDTH / 3);
        Rectangle rgDH1 = new Rectangle((WIDTH / (WIDTH / 2)), (HEIGHT / (HEIGHT / 8)));
        rgDH1.setFill(Color.web("969696"));
        Rectangle rgDH2 = new Rectangle((WIDTH / (WIDTH / 2)), (HEIGHT / (HEIGHT / 8)));
        rgDH2.setFill(Color.web("969696"));
        Rectangle rgDH3 = new Rectangle((WIDTH / (WIDTH / 2)), (HEIGHT / (HEIGHT / 8)));
        rgDH3.setFill(Color.web("969696"));
        vbHinges.getChildren().addAll(rgDH1, rgDH2, rgDH3);
        vbHinges.setTranslateX(rgDH1.getWidth() / 2);
        vbHinges.setTranslateY(rgDH1.getHeight());
        this.getChildren().add(vbHinges);
        
        // Draw door
        Rectangle rgDD = new Rectangle((WIDTH / (WIDTH / 2)) , HEIGHT);
        rgDD.setTranslateX((WIDTH / (WIDTH / 2)) - rgDD.getWidth());
        rgDD.setTranslateY((HEIGHT / (HEIGHT / 2)) / 2);
        rgDD.setFill(Color.web("e50404"));
        this.getChildren().add(rgDD);
        
        // Draw door handle block
        Rectangle rgDHM = new Rectangle((WIDTH / (WIDTH / 2)), (WIDTH / (WIDTH / 4)));
        rgDHM.setTranslateX(rgDD.getX() - rgDD.getWidth());
        rgDHM.setTranslateY(rgDD.getY() + rgDD.getHeight() / 2 - rgDHM.getHeight() / 2);
        rgDHM.setFill(Color.web("e1e1e1"));
        this.getChildren().add(rgDHM);
        
        // Draw door handle
        Rectangle rgDHL = new Rectangle((WIDTH / (WIDTH / 2)), (WIDTH / (WIDTH / 2)));
        rgDHL.setTranslateX(rgDD.getX() - rgDHL.getWidth() - rgDD.getWidth());
        rgDHL.setTranslateY(rgDD.getY() + rgDD.getHeight() / 2 - rgDHL.getHeight() / 2);
        rgDHL.setFill(Color.web("c8c8c8"));
        this.getChildren().add(rgDHL);
    }
}
