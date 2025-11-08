package se.adlez.game;

import java.io.Serializable;

/**
 * The abstract class AbstractItem provides a default implementation of an item
 * but it can not be instantiated as an object.
 * 
 * AbstractItem should provide default implementations for all methods defined
 * in the interface Item.
 */
public abstract class AbstractItem implements Item, Serializable {
    private String description;
    private String graphic;

    /**
     * Constructs an AbstractItem with a description and graphic representation.
     * The constructor initializes the description and graphic fields for the item.
     * 
     * @param description Describes an item by text.
     * @param graphic     A visual representation of the item.
     */
    public AbstractItem(String description, String graphic) {
        this.description = description;
        this.graphic = graphic;
    }

    /**
     * Returns the description of the item.
     * 
     * @return The description of the item as a string (e.g., "A shiny sword").
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the graphic representation of the item.
     * 
     * @return The graphic representation of the item as a string
     */
    public String getGraphic() {
        return graphic;
    }

    /**
     * Returns a string representation of the item, which includes both the description and graphic.
     * This method combines the description and graphic fields to return a full representation of the item.
     * 
     * @return A string that combines the description and graphic of the item.
     */
    public String toString() {
        return description + graphic;
    }
}
