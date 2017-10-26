/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
|
|   Project: "Project: Intern"
|   Name: Spencer Hendon, Jaycob Willis, Nathaniel Ogungbuyi, Zane Sandoval
|   Date: September 15, 2017
|   Description: New Game pane
|
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */
package projectintern;

// Imports
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public final class NewGame extends BorderPane {

    /**
     * BEGINNING OF USER CONFIGURATION
     */
    // Classes
    private final String[][] classes = {
        {"Accountant", "Medium Health, Medium Speed, Medium Damage"},
        {"Secretary", "High Health, Slow Speed, Medium Damage"},
        {"Treasurer", "Medium Health, Fast Speed, Low Damage"},
        {"Mail Boy", "Low Health, Medium Speed, High Damage"}
    };

    /**
     * END OF USER CONFIGURATION
     */
    // WIDTH and HEIGHT
    private final double WIDTH, HEIGHT;

    // Number of classes
    private final int numClasses = classes.length;

    // Array of character imageviews for classes
    ImageView[] ivClasses = new ImageView[numClasses];

    // Array of buttons for the classes
    Button[] btnClasses = new Button[numClasses];

    // Array of text for the classes
    Text[] txtClassDescriptions = new Text[numClasses];

    // VBox for top objects
    VBox vbTopObjects;

    // Home button
    Button btnTitleScreen = new Button("Back to Title Screen");

    // Text to show what to do
    Text txtSelectClass = new Text("Select a class:");

    // HBox for character selection
    HBox hbCharSelection;

    // VBox for character selection
    VBox vbCharSelectionButtons, vbCharSelectionTexts;

    // HBox for name
    HBox hbName;

    // Text for name
    Text txtName = new Text("Enter your name: ");

    // TextField for name
    TextField tfName = new TextField();

    public NewGame(double w, double h) {
        // Get width and height
        this.WIDTH = w;
        this.HEIGHT = h;

        // Setup this borderpane
        this.setWidth(WIDTH);
        this.setHeight(HEIGHT);
        this.setPadding(new Insets(20, 20, 20, 20));

        display(); // Select class
    }

    private void display() {
        displayAuxObjects();
        displayClassSelection();
        displayNameSelection();
    }

    private void displayAuxObjects() {
        // Format btnTitleScreen
        btnTitleScreen.setPrefSize(WIDTH / 4, HEIGHT / 10);
        btnTitleScreen.setAlignment(Pos.CENTER);

        // Format txtSelectClass
        txtSelectClass.setFill(Color.rgb(234, 234, 234));
        txtSelectClass.setFont(Font.font("Verdana", FontWeight.BOLD, 50));

        // Modify vbTopObjects
        vbTopObjects = new VBox(WIDTH / 100);
        vbTopObjects.getChildren().addAll(btnTitleScreen, txtSelectClass);
        vbTopObjects.setAlignment(Pos.CENTER);

        this.setTop(vbTopObjects);
    }

    private void displayClassSelection() {
        // Get the correct amount of spacing
        Text text = new Text();
        text.setFont(Font.font("Verdana",
                FontWeight.BOLD, 15));
        text.applyCss();
        final double textHeight = text.getLayoutBounds().getHeight();

        // Modify vbCharacterSelection and vbCharSelectionText
        vbCharSelectionButtons = new VBox(WIDTH / 100);
        vbCharSelectionButtons.setAlignment(Pos.TOP_LEFT);
        vbCharSelectionTexts = new VBox(textHeight
                + (textHeight / numClasses) / numClasses);
        vbCharSelectionTexts.setAlignment(Pos.TOP_RIGHT);

        // Modify hbCharSelection
        hbCharSelection = new HBox(WIDTH / 100);
        hbCharSelection.setAlignment(Pos.TOP_CENTER);

        // Add each class to vbCharacterSelection
        for (int i = 0; i < numClasses; i++) {
            // Description of the class
            txtClassDescriptions[i] = new Text("- " + classes[i][1]);
            txtClassDescriptions[i].setFont(Font.font("Verdana",
                    FontWeight.BOLD, 15));
            txtClassDescriptions[i].setFill(Color.rgb(234, 234, 234));

            // Button to select the class
            btnClasses[i] = new Button(classes[i][0]);
            btnClasses[i].setMinSize((WIDTH / 50) * classes[i][0].length(),
                    textHeight);

            // Add to vbCharacterSelectionButtons
            vbCharSelectionButtons.getChildren().add(btnClasses[i]);

            // Add to vbCharacterSelectionTexts
            vbCharSelectionTexts.getChildren().add(txtClassDescriptions[i]);
        }

        // Add to hbCharSelection
        hbCharSelection.getChildren().addAll(vbCharSelectionButtons,
                vbCharSelectionTexts);

        // Add to pane
        setCenter(hbCharSelection);
    }

    private void displayNameSelection() {
        // Format txtName
        txtName.setFill(Color.rgb(234, 234, 234));
        txtName.setFont(Font.font("Verdana", FontWeight.BOLD, 15));

        // Set tfName size
        tfName.setMinSize(WIDTH / 8.25, HEIGHT / 25);
        tfName.setPrefSize(WIDTH / 8.25, HEIGHT / 25);
        tfName.setMaxSize(WIDTH / 8.25, HEIGHT / 25);

        // Add to hb
        hbName = new HBox(WIDTH / 100);
        hbName.getChildren().addAll(txtName, tfName);
        hbName.setAlignment(Pos.CENTER);

        // Add to pane
        this.setBottom(hbName);
    }
}
