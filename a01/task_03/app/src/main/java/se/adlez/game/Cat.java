package se.adlez.game;

/**
 * Concrete Cat-class that can be instantiated.
 */
public class Cat extends AbstractMoveableItem {
    /**
     * Constructs a new Cat-object set with a description and a graphic
     * visualisation.
     */
    public Cat(Position position) {
        super("Cat", "🐱", position);
    }
}
