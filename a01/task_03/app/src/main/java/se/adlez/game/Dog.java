package se.adlez.game;
/**
 * Concrete Dog-class that can be instantiated.
 */
public class Dog extends AbstractMoveableItem {
    /**
     * Constructs a new Dog-object set with a description and a graphic
     * visualisation.
     */
    public Dog(Position position) {

        super("Dog", "🐶", position);
    }
}
