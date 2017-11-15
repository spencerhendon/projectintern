/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|
|   Project: Entity
|   Name: Spencer Hendon, Jaycob Willis, Nathaniel Ogungbuyi, Zane Sandoval
|   Date: September 15, 2017
|   Description: Title Screen Pane
|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package projectintern;

// Imports
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import projectintern.Entity.Player;

public class TitleScreen extends BorderPane {

    // WIDTH and HEIGHT
    protected final double WIDTH, HEIGHT;

    // Game version
    protected final String GAME_VERSION;

    // Logo dimensions
    protected final int logoWIDTH = 250, logoHEIGHT = 75;

    // Screen state
    protected String screenState = "titleScreen";

    // Player
    Player player;

    // Import a image for background
    //ImageView ivBG = new ImageView(new Image("images\\TitleScreen\\"
    //        + "imgBackground.png"));
    // Image of logo
    //ImageView logo = new ImageView(new Image("images\\Elemonators\\logo.png"));
    // VBox for game buttons
    VBox gameButtons;

    // Create a new game button
    Button btnGameNew = new Button();

    // Create a load game button
    Button btnGameLoad = new Button();

    // Text to show version number
    Text txtVersion;

    // New game pane
    NewGame paneNewGame;
    
    // Game pane
    Game paneGame;

    public TitleScreen(double w, double h, String version) {
        this.WIDTH = w; // Set width
        this.HEIGHT = h; // Set height
        this.GAME_VERSION = version;

        // Setup this borderpane
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        this.setPadding(new Insets(20, 20, 20, 20));

        displayBackgroud(true); // Display background
        //displayTitle(true);
        displayGameButtons(true); // Display new and load game buttons
        displayVersion(true); // Dispaly version

        // When enter is pushed do default operation
        this.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                performOperation();
            }

        });

        // Make a new character when new game button is pushed
        btnGameNew.setOnAction(e -> {
            newGame();
        });

        // Load a character when load game button is pushed
        btnGameLoad.setOnAction(e -> {
            loadGame();
        });
    }

    public void displayBackgroud(boolean display) {
        if (display == true) { // Display
            /*
            // Resize background
            ivBG.setFitWidth(WIDTH + 12);
            ivBG.setFitHeight(HEIGHT + 12);

            // Add image to pane
            getChildren().add(ivBG);
             */
            setStyle("-fx-background-color: #" + "232323");
        } else if (display == false) { // Do not display
            /*
            getChildren().remove(ivBG);
             */
        }
    }

    /*
    public void displayTitle(boolean display) {
        if (display == true) { // Display
            // Re-position
            logo.setX(((WIDTH / 2) - (WIDTH / 5) / 2) - logoWIDTH + (WIDTH / 25) * 3);
            logo.setY((HEIGHT / 2) - (HEIGHT / 10) - logoHEIGHT * 3);
            logo.setScaleX(0.75);
            logo.setScaleY(0.75);

            // Add to pane
            getChildren().add(logo);
        } else if (display == false) { // Do not display
            getChildren().remove(logo);
        }

    }
     */
    public void displayGameButtons(boolean display) {
        // Button width
        double btnWidth = WIDTH / 5;
        double btnHeight = HEIGHT / 10;
        if (display == true) { // Display logo
            // VBox for new and load game
            gameButtons = new VBox(WIDTH / 50);
            gameButtons.setTranslateX((WIDTH / 2) - btnWidth / 2);
            gameButtons.setTranslateY((HEIGHT / 2) - btnHeight);

            // Import a image for new game button
            //ImageView ivNewGame = new ImageView(new Image("images\\TitleScreen\\"
            //        + "imgNewGame.png"));
            //ivNewGame.setFitWidth(WIDTH / 5);
            //ivNewGame.setFitHeight(HEIGHT / 10);
            // Import a image for load game button
            //ImageView ivLoadGame = new ImageView(new Image("images\\TitleScreen\\"
            //        + "imgLoadGame.png"));
            //ivLoadGame.setFitWidth(WIDTH / 5);
            //ivLoadGame.setFitHeight(HEIGHT / 10);
            // Customise btnGameNew
            btnGameNew.setMinSize(btnWidth, btnHeight);
            btnGameNew.setPrefSize(btnWidth, btnHeight);
            btnGameNew.setMaxSize(btnWidth, btnHeight);
            btnGameNew.setText("NEW GAME");
            //btnGameNew.setGraphic(ivNewGame);
            btnGameNew.setStyle("-fx-background-color: #eaeaea; ");

            // Customise btnGameLoad
            btnGameLoad.setMinSize(btnWidth, btnHeight);
            btnGameLoad.setPrefSize(btnWidth, btnHeight);
            btnGameLoad.setMaxSize(btnWidth, btnHeight);
            btnGameLoad.setText("LOAD GAME");
            //btnGameLoad.setGraphic(ivLoadGame);
            btnGameLoad.setStyle("-fx-background-color: #eaeaea; ");

            // Add buttons to vbox
            gameButtons.getChildren().addAll(btnGameNew, btnGameLoad);

            // Add vbox to pane
            getChildren().add(gameButtons);
        } else if (display == false) { // Do not display
            getChildren().remove(gameButtons);
        }
    }

    public void displayVersion(boolean display) {
        if (display == true) { // Display
            // Assign value
            txtVersion = new Text("Version: " + GAME_VERSION);
            // Label for display version
            txtVersion.setFill(Color.rgb(234, 234, 234));

            // Move txtVersion to bottom left of pane
            txtVersion.setY(HEIGHT + 8);

            getChildren().add(txtVersion); // Add txtVersion to pane
        } else if (display == false) { // Do not display
            getChildren().remove(txtVersion);
        }
    }

    private void newGame() {
        // State of screen
        screenState = "newGame";

        // Clear all items from the scene except the background and version
        //displayTitle(false);
        displayGameButtons(false);

        // Make a new pane
        paneNewGame = new NewGame(WIDTH, HEIGHT);
        getChildren().add(paneNewGame);
        
        // Go to title screen
        paneNewGame.btnTitleScreen.setOnAction(e -> {
            getChildren().remove(paneNewGame);
            //displayTitle(true);
            displayGameButtons(true); // Display new and load game buttons
            screenState = "titleScreen";
        });

        // Buttons actions for each class
        paneNewGame.btnClasses[0].setOnAction(e -> { // Accountant class
            if (!paneNewGame.tfName.getText().trim().isEmpty()) { // Check text
                game(paneNewGame.tfName.getText().trim(), "Accountant");
            }
        });
        paneNewGame.btnClasses[1].setOnAction(e -> { // Secretary class
            if (!paneNewGame.tfName.getText().trim().isEmpty()) { // Check text
                game(paneNewGame.tfName.getText().trim(), "Secretary");
            }
        });
        paneNewGame.btnClasses[2].setOnAction(e -> { // Treasurer class
            if (!paneNewGame.tfName.getText().trim().isEmpty()) { // Check text
                game(paneNewGame.tfName.getText().trim(), "Treasurer");
            }
        });
        paneNewGame.btnClasses[3].setOnAction(e -> { // MailBoy class
            if (!paneNewGame.tfName.getText().trim().isEmpty()) { // Check text
                game(paneNewGame.tfName.getText().trim(), "MailBoy");
            }
        });

    }

    private void loadGame() {
        // State of screen
        screenState = "loadGame";
    }

    private void performOperation() {
        // Perform operation when enter key is pressed on title screen
        if (screenState.equals("titleScreen")) {
            newGame();
        } else if (screenState.equals("newGame")) {
            getChildren().remove(paneNewGame);
            //displayTitle(true);
            displayGameButtons(true); // Display new and load game buttons
            screenState = "titleScreen"; // Screen state = title screen
        } else if (screenState.equals("loadGame")) {
            loadGame();
        } else {
            // Nothing
        }
    }
    
    private void game(String name, String loadout) {
        // Create player
        player = new Player(name, loadout,
                        0, 0, 0, WIDTH, HEIGHT);
        
        // Remove pane for new game
        getChildren().remove(paneNewGame);
        
        // Remove version
        displayVersion(false);
        
        // Create pane for game
        paneGame = new Game(WIDTH, HEIGHT, player);
        
        // Add game pane to main pane
        getChildren().add(paneGame);
    }
    
}
