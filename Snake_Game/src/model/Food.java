package model;

public class Food {
    private Point position;  // Position of the food on the grid

    // Constructor initializes the food at a given position
    public Food(Point position) {
        this.position = position;
    }

    // Getter for food position
    public Point getPosition() {
        return position;
    }

    // Setter for food position (to place new food)
    public void setPosition(Point position) {
        this.position = position;
    }
}
