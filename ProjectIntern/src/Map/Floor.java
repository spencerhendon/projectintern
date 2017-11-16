/*
    Spencer Hendon
    Floor
    October 30, 2017
    Create a floor in javafx
 */
package Map;

// Imports
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Floor extends BorderPane {
    // Width and height of floor
    private final double WIDTH, HEIGHT;
    
     // Door width and height
    private final double WIDTHDOOR, HEIGHTDOOR;
    
    // Floor number
    private final int FLOORNUM;

    // Doors
    Door doors[] = new Door[5];
    
    // Elevator
    Elevator elevator;

    public Floor(double WIDTH, double HEIGHT, int FLOORNUM) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        this.FLOORNUM = FLOORNUM;
        this.WIDTHDOOR = WIDTH / 25;
        this.HEIGHTDOOR = HEIGHT / 1.75;

        // 192 pixels per room... (WIDTH + HEIGHT) / ((2.0/3.0) * 10)
        draw();
    }

    public void draw() {
        // Background rectangle
        Rectangle rgFlBg = new Rectangle(WIDTH, HEIGHT);
        rgFlBg.setFill(Color.web("eaeaea"));
        this.getChildren().add(rgFlBg);

        // Draw trim
        Rectangle rgFlTr = new Rectangle(WIDTH, (HEIGHT / (HEIGHT / 6)));
        rgFlTr.setX(0);
        rgFlTr.setY(HEIGHT - rgFlTr.getHeight());
        rgFlTr.setFill(Color.web("323232"));
        this.getChildren().add(rgFlTr);

        // Draw floor
        Rectangle rgFlFl = new Rectangle(WIDTH, (HEIGHT / (HEIGHT / 2)));
        rgFlFl.setX(0);
        rgFlFl.setY(HEIGHT - rgFlFl.getHeight());
        rgFlFl.setFill(Color.web("646464"));
        this.getChildren().add(rgFlFl);

        // Create doors
        for (int i = 0; i < doors.length; i++) {
            // Get a random number to determine door state
            int random = (int )(Math.random() * 3 + 1);
            
            // Create a door
            if (random == 1) {
                doors[i] = new Door(WIDTHDOOR, HEIGHTDOOR, "closed");
            } else if (random == 2) {
                doors[i] = new Door(WIDTHDOOR, HEIGHTDOOR, "open");
            } else {
                doors[i] = new Door(WIDTHDOOR, HEIGHTDOOR, "half");
            }
            
            // Position door
            doors[i].setTranslateX(((WIDTH + HEIGHT) / ((2.0/3.0) * 10) * i) + WIDTHDOOR);
            doors[i].setTranslateY(HEIGHT - rgFlFl.getHeight() - HEIGHTDOOR);
            
            // Add door to pane
            this.getChildren().add(doors[i]);
        }
        
        // Elevator
        elevator = new Elevator(WIDTH - ((WIDTHDOOR * 25 + HEIGHTDOOR * 1.75)  / ((2.0/3.0) * 10)) * 5 - WIDTHDOOR, HEIGHT - 2, FLOORNUM, "closed");
        elevator.setTranslateX(WIDTH - elevator.getBoundsInParent().getWidth());
        this.getChildren().add(elevator);
    }
}
