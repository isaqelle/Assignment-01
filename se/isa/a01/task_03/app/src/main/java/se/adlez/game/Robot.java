package se.adlez.game;

/**
 * Concrete Robot-class that can be instantiated.
 */
public class Robot extends AbstractMoveableItem {
    /**
     * Constructs a new Robot object with a description, graphic, and a specified
     * position.
     * 
     * @param position The initial position of the Robot on the game board.
     */
    public Robot(Position position) {
        super("Robot", "🤖", position);
    }
}
