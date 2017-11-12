/*
    Spencer Hendon
    Room
    Novemeber 9, 2017
    Create a room for the game
 */
package map;

// Imports
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class Room extends BorderPane {

    // Width and height
    private final double WIDTH, HEIGHT;
    
    // Group for Desk
    Group gDesk = new Group();
    
    // Group for File Cabinet
    Group gCabinet = new Group();
    
    // Group for Starage Shelf
    Group gShelf = new Group();
    
    // Group for toilet
    Group gToilet = new Group();
    
    // Group for sink
    Group gSink = new Group();
    
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

        // Three different types of rooms... Storage, Restroom, Office
        // Get a random number to determine which room will be selected
        int random = (int) (Math.random() * 3 + 1);
        
        // Create a room
        if (random == 1) {
            drawOffice();
        } else if (random == 2) {
            drawStorage();
        } else {
            drawRestroom();
        }
    }

    public void drawOffice() { // Desk and cabinet
        // Draw desk
        Rectangle rgDT = new Rectangle(WIDTH / 3, HEIGHT / (HEIGHT / 4));
        rgDT.setFill(Color.web("673232"));
        gDesk.getChildren().add(rgDT);
        
        Rectangle rgDM = new Rectangle(WIDTH / 4, rgDT.getHeight() * 6);
        rgDM.setX(rgDT.getWidth() / 2 - rgDM.getWidth() / 2);
        rgDM.setY(rgDT.getHeight());
        rgDM.setFill(Color.web("4d2626"));
        gDesk.getChildren().add(rgDM);
        
        Rectangle rgDLL = new Rectangle(rgDM.getWidth() / 12, rgDM.getHeight() / 2);
        rgDLL.setX((rgDT.getWidth() - rgDM.getWidth()) / 2);
        rgDLL.setY(rgDT.getHeight() + rgDM.getHeight());
        rgDLL.setFill(Color.web("4d2626"));
        gDesk.getChildren().add(rgDLL);
        
        Rectangle rgDLR = new Rectangle(rgDM.getWidth() / 12, rgDM.getHeight() / 2);
        rgDLR.setX(rgDLL.getX() + rgDM.getWidth() - rgDLR.getWidth());
        rgDLR.setY(rgDT.getHeight() + rgDM.getHeight());
        rgDLR.setFill(Color.web("4d2626"));
        gDesk.getChildren().add(rgDLR);
        
        // Position desk
        gDesk.setTranslateX(WIDTH - gDesk.getBoundsInParent().getWidth() * 2.25);
        gDesk.setTranslateY(HEIGHT - gDesk.getBoundsInParent().getHeight());
        this.getChildren().add(gDesk);
        
         // Draw cabinet
        Rectangle rgCM = new Rectangle(gDesk.getBoundsInParent().getWidth() / 3, gDesk.getBoundsInParent().getHeight());
        rgCM.setX(gDesk.getBoundsInParent().getWidth() + gDesk.getTranslateX());
        rgCM.setY(gDesk.getTranslateY());
        rgCM.setFill(Color.web("bfbfbf"));
        gCabinet.getChildren().add(rgCM);
        
        Rectangle rgCDT = new Rectangle(rgCM.getWidth() - (WIDTH / (WIDTH / 4)), rgCM.getHeight() / 2.25);
        rgCDT.setX(rgCM.getX() + (WIDTH / (WIDTH / 2)));
        rgCDT.setY(rgCM.getY() + (rgCM.getHeight() / 2) - rgCDT.getHeight());
        rgCDT.setFill(Color.web("a5a5a5"));
        gCabinet.getChildren().add(rgCDT);
        
        Rectangle rgCDB = new Rectangle(rgCM.getWidth() - (WIDTH / (WIDTH / 4)), rgCM.getHeight() / 2.25);
        rgCDB.setX(rgCM.getX() + (WIDTH / (WIDTH / 2)));
        rgCDB.setY(rgCM.getY() + (rgCM.getHeight() / 2));
        rgCDB.setFill(Color.web("a5a5a5"));
        gCabinet.getChildren().add(rgCDB);
        
        Rectangle rgCDD = new Rectangle(rgCM.getWidth() - (WIDTH / (WIDTH / 4)), (HEIGHT / (HEIGHT / 2)));
        rgCDD.setX(rgCM.getX() + (WIDTH / (WIDTH / 2)));
        rgCDD.setY(rgCM.getY() + (rgCM.getHeight() / 2) - rgCDD.getHeight() / 2);
        rgCDD.setFill(Color.web("bfbfbf"));
        gCabinet.getChildren().add(rgCDD);
        
        // Position cabinet
        gDesk.setTranslateX(WIDTH - gDesk.getBoundsInParent().getWidth() * 2.25);
        gDesk.setTranslateY(HEIGHT - gDesk.getBoundsInParent().getHeight());
        this.getChildren().add(gCabinet);
    }

    public void drawStorage() { // Shelf and boxes
        // Draw shelf
        Rectangle rgST = new Rectangle(WIDTH / 3, HEIGHT / 2);
        rgST.setFill(Color.web("673232"));
        gShelf.getChildren().add(rgST);
        
        Rectangle rgSB = new Rectangle(rgST.getWidth() - (WIDTH / (WIDTH / 4)), rgST.getHeight() / 12);
        rgSB.setX(rgST.getWidth() / 2 - rgSB.getWidth() / 2);
        rgSB.setY(rgST.getHeight());
        rgSB.setFill(Color.web("4d2626"));
        gShelf.getChildren().add(rgSB);
        
        Rectangle rgSI = new Rectangle(rgST.getWidth() - (WIDTH / (WIDTH / 4)), rgST.getHeight() - (HEIGHT / (HEIGHT / 4)));
        rgSI.setX((WIDTH / (WIDTH / 2)));
        rgSI.setY((HEIGHT / (HEIGHT / 2)));
        rgSI.setFill(Color.web("7d3232"));
        gShelf.getChildren().add(rgSI);
        
        Rectangle rgSDT = new Rectangle(rgST.getWidth(), (HEIGHT / (HEIGHT / 2)));
        rgSDT.setY(rgST.getY() + (rgST.getHeight() / 3));
        rgSDT.setFill(Color.web("673232"));
        gShelf.getChildren().add(rgSDT);
        
        Rectangle rgSDB = new Rectangle(rgST.getWidth(), (HEIGHT / (HEIGHT / 2)));
        rgSDB.setY(rgST.getY() + (rgST.getHeight() / 3) * 2);
        rgSDB.setFill(Color.web("673232"));
        gShelf.getChildren().add(rgSDB);
        
        // Draw boxes
        Rectangle rgB1 = new Rectangle(rgST.getWidth() / 3, rgST.getHeight() / 4);
        rgB1.setX(WIDTH / (WIDTH / 2));
        rgB1.setY(rgSDB.getY() - rgB1.getHeight());
        rgB1.setFill(Color.web("d6b0a0"));
        gShelf.getChildren().add(rgB1);
        
        Rectangle rgB2 = new Rectangle(rgST.getWidth() / 3, rgST.getHeight() / 4);
        rgB2.setX(WIDTH / (WIDTH / 2) + rgB2.getWidth());
        rgB2.setY(rgSDT.getY() - rgB1.getHeight());
        rgB2.setFill(Color.web("d6b0a0"));
        gShelf.getChildren().add(rgB2);
        
        Rectangle rgB3 = new Rectangle(rgST.getWidth() / 3, rgST.getHeight() / 4);
        rgB3.setX(WIDTH / (WIDTH / 2) + rgB2.getWidth() + (rgB2.getWidth() / 2));
        rgB3.setY(rgST.getY() + rgST.getHeight() - rgB1.getHeight() - (HEIGHT / (HEIGHT / 2)));
        rgB3.setFill(Color.web("d6b0a0"));
        gShelf.getChildren().add(rgB3);
        
        // Position shelf
        gShelf.setTranslateX(WIDTH - gShelf.getBoundsInParent().getWidth() * 2.25);
        gShelf.setTranslateY(HEIGHT - gShelf.getBoundsInParent().getHeight());
        this.getChildren().add(gShelf);
    }

    public void drawRestroom() { // Toilet and sink
        // Draw toilet
        Rectangle rgTL = new Rectangle(WIDTH / 8, (HEIGHT / (HEIGHT / 4)));
        rgTL.setFill(Color.web("ffffff"));
        gToilet.getChildren().add(rgTL);
        
        Rectangle rgTT = new Rectangle(WIDTH / 10, HEIGHT / 10);
        rgTT.setX(rgTL.getWidth() / 2 - rgTT.getWidth() / 2);
        rgTT.setY(rgTL.getHeight());
        rgTT.setFill(Color.web("f0f0f0"));
        gToilet.getChildren().add(rgTT);
        
        Polygon rgTB = new Polygon();
        rgTB.getPoints().addAll(new Double[] {
            rgTL.getWidth() * 0.05, rgTT.getY() + rgTT.getHeight(),
            rgTL.getWidth() * 0.95, rgTT.getY() + rgTT.getHeight(),
            rgTL.getWidth() * 0.85, rgTT.getY() + rgTT.getHeight() + rgTL.getHeight() * 3,
            rgTL.getWidth() * 0.15, rgTT.getY() + rgTT.getHeight() + rgTL.getHeight() * 3,
        });
        rgTB.setFill(Color.web("f0f0f0"));
        gToilet.getChildren().add(rgTB);
        
        Rectangle rgTS = new Rectangle(rgTL.getWidth() / 2, rgTL.getHeight() * 2);
        rgTS.setX(rgTL.getWidth() / 2 - rgTS.getWidth() / 2);
        rgTS.setY(rgTB.getBoundsInParent().getMaxY());
        rgTS.setFill(Color.web("e1e1e1"));
        gToilet.getChildren().add(rgTS);
        
        // Position toilet
        gToilet.setTranslateX(WIDTH / 4);
        gToilet.setTranslateY(HEIGHT - gToilet.getBoundsInParent().getHeight());
        this.getChildren().add(gToilet);
        
        // Draw sink
        HBox hbSinkHandles = new HBox(WIDTH / (WIDTH / 4));
        gSink.getChildren().add(hbSinkHandles);
        
        Rectangle rgSHL = new Rectangle(WIDTH / (WIDTH / 4), HEIGHT / (HEIGHT / 8));
        rgSHL.setFill(Color.web("7f7f7f"));
        rgSHL.setTranslateY(2);
        hbSinkHandles.getChildren().add(rgSHL);
        
        Rectangle rgSHM = new Rectangle(WIDTH / (WIDTH / 4), HEIGHT / (HEIGHT / 12));
        rgSHM.setFill(Color.web("7f7f7f"));
        hbSinkHandles.getChildren().add(rgSHM);
        
        Rectangle rgSHR = new Rectangle(WIDTH / (WIDTH / 4), HEIGHT / (HEIGHT / 8));
        rgSHR.setFill(Color.web("7f7f7f"));
        rgSHR.setTranslateY(2);
        hbSinkHandles.getChildren().add(rgSHR);
        
        Rectangle rgST = new Rectangle(WIDTH / 8, (HEIGHT / (HEIGHT / 8)));
        rgST.setFill(Color.web("ffffff"));
        gSink.getChildren().add(rgST);
        
        Rectangle rgSS = new Rectangle(rgST.getWidth() / 2, rgST.getHeight() * 4);
        rgSS.setX(rgST.getWidth() / 2 - rgSS.getWidth() / 2);
        rgSS.setY(rgST.getY() + rgST.getHeight());
        rgSS.setFill(Color.web("e1e1e1"));
        gSink.getChildren().add(rgSS);
        
        // Position sink
        hbSinkHandles.setTranslateX(gSink.getBoundsInParent().getWidth() / 2 - (hbSinkHandles.getSpacing() * 5) / 2);
        hbSinkHandles.setTranslateY(-HEIGHT / (HEIGHT / 8));
        gSink.setTranslateX(WIDTH / 4 + gToilet.getBoundsInParent().getWidth() + (gSink.getBoundsInParent().getWidth() / 2));
        gSink.setTranslateY(HEIGHT - gSink.getBoundsInParent().getHeight() - hbSinkHandles.getTranslateY());
        this.getChildren().add(gSink);
    }
}
