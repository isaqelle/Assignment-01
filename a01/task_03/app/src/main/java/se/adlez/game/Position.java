package se.adlez.game;

import java.io.Serializable;

/**
 * This class represents a position on a 10x10 grid. It is used to track the
 * location of items on the game plan.
 */
public class Position implements Serializable {
    // private static final long serialVersionUID = 1L; // remove?
    private int x;
    private int y;

    /**
     * Constructor to create a Position object with specified x and y coordinates.
     * 
     * @param x The x-coordinate of the position.
     * @param y The y-coordinate of the position.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Copy-Constructor that creates a Position object by copying the values from
     * another
     * Position.
     * 
     * @param position The Position object to copy.
     */
    public Position(Position position) {
        this.x = position.x;
        this.y = position.y;
    }

    /**
     * Getter for the x-coordinate.
     * 
     * @return The x-coordinate of the position.
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for the y-coordinate.
     * 
     * @return The y-coordinate of the position.
     */
    public int getY() {
        return y;
    }

    /**
     * Setter for the x-coordinate.
     * 
     * @param x The new x-coordinate of the position.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter for the y-coordinate.
     * 
     * @param y The new y-coordinate of the position.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Returns a string representation of the position in the format (x, y).
     * 
     * @return A formatted string representing the position.
     */
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * Returns a single number (a hash code) for the object.
     * Every pair gets an unique number.
     * 
     * @return A hash code for this position.
     */
    @Override
    public int hashCode() {
        return 31 * x + y;
    }

    /**
     * Checks if two Position objects are equal based on their x and y coordinates.
     * 
     * @param o The object to compare this Position with.
     * @return True if the two positions have the same coordinates, otherwise false.
     */
    @Override
    public boolean equals(Object o) {
        Position pos = (Position) o;
        return x == pos.x && y == pos.y;
    }

    /**
     * Move the current position by adding the values of x and y from the incoming
     * relative parameter.
     * 
     * @param relative The position to move by, containing x and y.
     */
    public void move(Position relative) {
        this.x += relative.getX();
        this.y += relative.getY();

    }
}
