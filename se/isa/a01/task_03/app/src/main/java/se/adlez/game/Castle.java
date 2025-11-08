package se.adlez.game;

/**
 * Concrete Castle-class that can be instantiated.
 */
public class Castle extends AbstractMoveableItem {

    /**
     * Constructs a new Castle-object set with a description and a graphic
     * visualisation.
     */
    public Castle(Position position) {
        super("Castle", "🏛️", position);
    }
}
