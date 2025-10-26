package game;

import model.Food;
import model.Point;
import model.Snake;

import java.util.Random;

public class Game {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 15;

    private Snake snake;
    private Food food;
    private Random random;
    private boolean gameOver;
    private int score;  // To track player score

    public Game() {
        reset();
    }

    // Resets the game state to start a new game
    public void reset() {
        snake = new Snake();
        random = new Random();
        placeFoodRandomly();
        gameOver = false;
        score = 0;
    }

    private void placeFoodRandomly() {
        Point newFoodPos;
        do {
            int x = random.nextInt(WIDTH);
            int y = random.nextInt(HEIGHT);
            newFoodPos = new Point(x, y);
        } while (snake.getBody().contains(newFoodPos));

        food = new Food(newFoodPos);
    }

    public Snake getSnake() {
        return snake;
    }

    public Food getFood() {
        return food;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getScore() {
        return score;
    }

    public void update() {
        if (gameOver) {
            return;
        }

        snake.move();
        Point head = snake.getBody().get(0);

        if (head.getX() < 0 || head.getX() >= WIDTH || head.getY() < 0 || head.getY() >= HEIGHT) {
            gameOver = true;
            return;
        }

        for (int i = 1; i < snake.getBody().size(); i++) {
            if (head.equals(snake.getBody().get(i))) {
                gameOver = true;
                return;
            }
        }

        if (head.equals(food.getPosition())) {
            snake.grow();
            placeFoodRandomly();
            score += 10;   // Increase score by 10 for each food eaten
        }
    }
}
