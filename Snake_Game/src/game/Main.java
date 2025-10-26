package game;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Point;
import model.Snake.Direction;

public class Main extends Application {

    private static final int CELL_SIZE = 30;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 15;

    private Game game;
    private GraphicsContext gc;
    private AnimationTimer gameLoop;
    private Stage primaryStage;
    private StackPane root;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        root = new StackPane();
        Scene scene = new Scene(root, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);

        this.primaryStage.setTitle("Snake Game");
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        this.primaryStage.show();

        showWelcomePage();
    }

    // Display welcome page with Start and Close buttons
    private void showWelcomePage() {
        root.getChildren().clear();

        Label title = new Label("🐍 Snake Game");
        title.setStyle("-fx-font-size: 36px; -fx-text-fill: green; -fx-font-weight: bold;");

        Button startBtn = new Button("Start Game");
        Button closeBtn = new Button("Close");

        startBtn.setOnAction(e -> startGame());
        closeBtn.setOnAction(e -> primaryStage.close());

        VBox vbox = new VBox(20, title, startBtn, closeBtn);
        vbox.setAlignment(Pos.CENTER);

        root.getChildren().add(vbox);
    }

    // Start the game: initialize game and canvas then start game loop
    private void startGame() {
        root.getChildren().clear();

        game = new Game();

        Canvas canvas = new Canvas(WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);
        gc = canvas.getGraphicsContext2D();

        root.getChildren().add(canvas);

        Scene scene = primaryStage.getScene();

        scene.setOnKeyPressed(e -> {
            if (!game.isGameOver()) {
                if (e.getCode() == KeyCode.UP) {
                    game.getSnake().setDirection(Direction.UP);
                } else if (e.getCode() == KeyCode.DOWN) {
                    game.getSnake().setDirection(Direction.DOWN);
                } else if (e.getCode() == KeyCode.LEFT) {
                    game.getSnake().setDirection(Direction.LEFT);
                } else if (e.getCode() == KeyCode.RIGHT) {
                    game.getSnake().setDirection(Direction.RIGHT);
                }
            }
        });

        if (gameLoop != null) {
            gameLoop.stop();
        }

        gameLoop = new AnimationTimer() {
            private long lastUpdate = 0;
            private final long UPDATE_INTERVAL = 200_000_000; // 200ms per move

            @Override
            public void handle(long now) {
                if (now - lastUpdate >= UPDATE_INTERVAL) {
                    game.update();
                    render();

                    if (game.isGameOver()) {
                        showGameOverPage();
                        this.stop();
                    }
                    lastUpdate = now;
                }
            }
        };

        gameLoop.start();
    }

    // Render the game (snake, food, score)
    private void render() {
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, WIDTH * CELL_SIZE, HEIGHT * CELL_SIZE);

        gc.setFill(Color.WHITE);
        gc.fillText("Score: " + game.getScore(), 10, 20);

        gc.setFill(Color.LIMEGREEN);
        for (Point p : game.getSnake().getBody()) {
            gc.fillRect(p.getX() * CELL_SIZE, p.getY() * CELL_SIZE, CELL_SIZE - 1, CELL_SIZE - 1);
        }

        Point foodPos = game.getFood().getPosition();
        gc.setFill(Color.RED);
        gc.fillOval(foodPos.getX() * CELL_SIZE, foodPos.getY() * CELL_SIZE, CELL_SIZE, CELL_SIZE);
    }

    // Show Game Over page with Restart and Close buttons
    private void showGameOverPage() {
        root.getChildren().clear();

        Label gameOverLabel = new Label("GAME OVER!");
        gameOverLabel.setStyle("-fx-font-size: 36px; -fx-text-fill: red; -fx-font-weight: bold;");

        Label scoreLabel = new Label("Final Score: " + game.getScore());
        scoreLabel.setStyle("-fx-font-size: 24px; -fx-text-fill: white;");

        Button restartBtn = new Button("Restart");
        Button closeBtn = new Button("Close");

        restartBtn.setOnAction(e -> startGame());
        closeBtn.setOnAction(e -> primaryStage.close());

        VBox vbox = new VBox(20, gameOverLabel, scoreLabel, restartBtn, closeBtn);
        vbox.setAlignment(Pos.CENTER);
        vbox.setStyle("-fx-background-color: black; -fx-padding: 30;");

        root.getChildren().add(vbox);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
