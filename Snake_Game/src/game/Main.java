package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Create a label
        Label label = new Label("🐍 Snake Game - Ready to Code!");
        label.setStyle("-fx-font-size: 24px; -fx-text-fill: green; -fx-font-weight: bold;");
        
        // Create layout
        StackPane root = new StackPane();
        root.getChildren().add(label);
        root.setStyle("-fx-background-color: #1a1a1a;");
        
        // Create scene
        Scene scene = new Scene(root, 600, 400);
        
        // Setup stage
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
