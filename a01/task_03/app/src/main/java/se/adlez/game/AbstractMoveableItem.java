package se.adlez.game;

/**
 * The abstract class AbstractMoveableItem provides a default implementation for
 * an object that is moveable. It extends AbstractItem and implements the
 * Moveable
 * interface, adding functionality for managing the position of the item.
 * 
 * It contains methods for getting and setting an item's position and a
 * toString() method for returning a String.
 */
public abstract class AbstractMoveableItem extends AbstractItem implements Moveable {
    private Position position;

    /**
     * Constructor, creates an intance of AbstractMoveableItem with a description,
     * graphic representation and a set position.
     * 
     * @param description describes an item with text.
     * @param graphic     represents the item in a graphic.
     * @param position    the initial position of an item.
     */
    public AbstractMoveableItem(String description, String graphic, Position position) {
        super(description, graphic);
        this.position = new Position(position);

    }

    /**
     * Returns the current position of the item.
     * 
     * @return The current position of the item as a Position object.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the new position for the item.
     * 
     * @param newPosition The new position to set for the item.
     */
    public void setPosition(Position newPosition) {
        this.position = newPosition;
    }

    /**
     * Returns a string representation of the moveable item, which includes the
     * description,
     * graphic, and position of the item.
     * 
     * @return A string combining the description, graphic, and position of the
     *         item.
     */
    public String toString() {
        return getDescription() + " " + getGraphic() + " " + position;
    }

}
