package model;

import java.util.LinkedList;
import java.util.List;

public class Snake {
    private List<Point> body;      // Snake's body parts as points
    private Direction direction;   // Current move direction

    public enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public Snake() {
        body = new LinkedList<>();
        body.add(new Point(5, 5));
        body.add(new Point(4, 5));
        body.add(new Point(3, 5));
        direction = Direction.RIGHT;
    }

    // Get current snake body points
    public List<Point> getBody() {
        return body;
    }

    // Get current direction
    public Direction getDirection() {
        return direction;
    }

    // Set new direction (prevent reversing)
    public void setDirection(Direction newDirection) {
        if ((direction == Direction.UP && newDirection != Direction.DOWN) ||
            (direction == Direction.DOWN && newDirection != Direction.UP) ||
            (direction == Direction.LEFT && newDirection != Direction.RIGHT) ||
            (direction == Direction.RIGHT && newDirection != Direction.LEFT)) {
            direction = newDirection;
        }
    }

    // Move the snake forward by adding a new head based on direction and removing tail
    public void move() {
        Point head = body.get(0);
        Point newHead = null;

        switch (direction) {
            case UP:
                newHead = new Point(head.getX(), head.getY() - 1);
                break;
            case DOWN:
                newHead = new Point(head.getX(), head.getY() + 1);
                break;
            case LEFT:
                newHead = new Point(head.getX() - 1, head.getY());
                break;
            case RIGHT:
                newHead = new Point(head.getX() + 1, head.getY());
                break;
        }

        // Add new head at front of body list
        body.add(0, newHead);
        // Remove last tail part
        body.remove(body.size() - 1);
    }

    // Grow snake by adding a new head but keeping tail (used when food eaten)
    public void grow() {
        Point head = body.get(0);
        Point newHead = null;

        switch (direction) {
            case UP:
                newHead = new Point(head.getX(), head.getY() - 1);
                break;
            case DOWN:
                newHead = new Point(head.getX(), head.getY() + 1);
                break;
            case LEFT:
                newHead = new Point(head.getX() - 1, head.getY());
                break;
            case RIGHT:
                newHead = new Point(head.getX() + 1, head.getY());
                break;
        }

        // Add new head but do not remove tail so snake length increases by 1
        body.add(0, newHead);
    }
}
