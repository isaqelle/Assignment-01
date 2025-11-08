package se.adlez.game;

/**
 * Concrete Wolf-class that can be instantiated.
 */
public class Wolf extends AbstractMoveableItem {
    /**
     * Constructs a new Wolf-object set with a description and a graphic
     * visualisation.
     */
    public Wolf(Position position) {
        super("Wolf", "🐺", position);
    }
}
