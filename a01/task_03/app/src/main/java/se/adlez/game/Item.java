package se.adlez.game;

/**
 * The interface Item states what can be done with an item
 */
public interface Item {
    /**
     * Gets the description of the item.
     * 
     * @return A string containing the description of the item.
     */
    String getDescription();

    /**
     * Gets the graphic representation of the item.
     * 
     * @return A string containing the graphic representation of the item.
     */
    String getGraphic();
}
