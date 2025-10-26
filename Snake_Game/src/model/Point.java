package model;

// Simple class to hold x and y coordinates on the grid
public class Point {
    private int x;  // x coordinate
    private int y;  // y coordinate

    // Constructor to initialize both coordinates
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Getter for x
    public int getX() {
        return x;
    }

    // Getter for y
    public int getY() {
        return y;
    }

    // Setter for x
    public void setX(int x) {
        this.x = x;
    }

    // Setter for y
    public void setY(int y) {
        this.y = y;
    }

    // Check if two points are equal (same x and y)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return this.x == other.x && this.y == other.y;
    }

    // Generate hash code based on x and y (needed when using in collections)
    @Override
    public int hashCode() {
        return 31 * x + y;
    }
}
