package se.adlez.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * The Forest class represents the game environment where the player, hunters
 * (wolves),
 * and items are stored. The forest consists of a "grid" where players and
 * hunters can
 * move around. This class manages the positions of players, hunters, and items
 * in the forest.
 * It also handles the game status.
 */

public class Forest implements Serializable {
    // private static final long serialVersionUID = 1L;
    private int WIDTH = 10;
    private int HEIGHT = 10;
    private AbstractMoveableItem player;
    private AbstractMoveableItem home;
    private boolean gameOver;
    private StringBuilder status;
    private List<AbstractMoveableItem> hunters;

    private Map<Position, Item> items; // <Key, Value>

    /**
     * Constructs a new forest object and initializes the game state.
     */
    public Forest() {
        this.items = new HashMap<>();
        this.status = new StringBuilder();
        this.hunters = new ArrayList<>();
        init();
    }

    /**
     * Initializes the forest with a green 10x10 grid.
     * This method is called when the game is first created or reset.
     */
    public void init() {
        StringBuilder sb = new StringBuilder();
        for (int row = 1; row <= WIDTH; row++) {
            sb.append("\n");
            for (int col = 1; col <= HEIGHT; col++) {
                Position position = new Position(row, col);

                if (items.containsKey(position)) {
                    sb.append("🟩");
                } else {
                    sb.append("🟩");
                }
            }
        }
        status = sb;
    }

    /**
     * Returns a string representation of the current state of the game grid. Each
     * cell represents an
     * area in the forest with different graphics depending on the contents of the
     * cell (items, player, hunters, etc.).
     * 
     * @return A string representing the game plan of the forest.
     */
    public String getGamePlan() {
        StringBuilder sb = new StringBuilder();
        for (int row = 1; row <= WIDTH; row++) {
            sb.append("\n");
            for (int col = 1; col <= HEIGHT; col++) {
                Position position = new Position(row, col);

                if (items.containsKey(position)) {
                    sb.append(items.get(position).getGraphic());
                } else if (player != null && player.getPosition().equals(position)) {
                    sb.append(player.getGraphic());
                } else {
                    // Loop through all wolves (hunters)
                    boolean foundWolf = false;
                    for (AbstractMoveableItem hunter : hunters) {
                        if (hunter.getPosition().equals(position)) {
                            sb.append("🐺");
                            foundWolf = true;
                            break;
                        }
                    }
                    if (!foundWolf) {
                        // No wolf at this position
                        if (home != null && home.getPosition().equals(position)) {
                            sb.append("🏛️ ");
                        } else {
                            sb.append("🟩"); // Empty space
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * Adds an item to the forest at a specified position.
     * 
     * @param item     The item to add.
     * @param position Position to place item.
     */
    public void addItem(Item item, Position position) {
        items.put(position, item);
    }

    /**
     * Returns a string representation of all items in the forest and their
     * positions.
     * 
     * @return A string listing all items with their positions.
     */
    public String listItem() {
        StringBuilder together = new StringBuilder();

        for (Map.Entry<Position, Item> string : items.entrySet()) {
            Position position = string.getKey();
            Item item = string.getValue();
            together.append(item.toString()).append(" ").append(position.toString()).append("\n");
        }

        return together.toString();
    }

    /**
     * Attempts to add a new item to the forest at a specified position.
     * Returns false if the position is already occupied.
     * 
     * @param item     The item to be added.
     * @param position Position to place item.
     * @return True if the item could be added, false if the position is
     *         occupied.
     */
    public boolean tryAddItem(Item item, Position position) {
        if (items.containsKey(position)) {
            // If the item at the position is a Player, Wolf, or Castle, don't place new
            // items
            Item existingItem = items.get(position);
            if (existingItem instanceof Dog || existingItem instanceof Cat || existingItem instanceof Robot
                    || existingItem instanceof Wolf || existingItem instanceof Castle) {
                return false; // Cannot place a new item here
            }
        }

        // If no conflicts, add the item to the map
        items.put(position, item);
        return true;
    }

    /**
     * Adds a new player to the forest.
     * 
     * @param player The player to be added.
     */
    public void addPlayerItem(AbstractMoveableItem player) {
        this.player = player;

    }

    /**
     * Adds a new hunter (wolf) to the forest.
     * 
     * @param hunter The hunter to be added.
     */
    public void addHunterItem(AbstractMoveableItem hunter) {
        hunters.add(hunter);
    }

    /**
     * Sets the home (goal) location in the forest.
     * 
     * @param home The home location of the player.
     */
    public void addHomeItem(AbstractMoveableItem home) {
        this.home = home;
    }

    /**
     * Method moves the player relative to its current position by a specified
     * relative
     * distance.
     * The move will be validated to ensure it doesn't result in an faulty state.
     * If the player reaches the home position, the game is over and player wins.
     * 
     * @param relative The relative position to move the player.
     */
    public void movePlayer(Position relative) {
        // Get the current player position
        Position playerPos = player.getPosition();

        // Prepare the new position, by using the playerPos to initiate the position
        Position newPos = new Position(playerPos);

        // Move to the new position using the relative position
        newPos.move(relative);

        if (newPos.equals(home.getPosition())) {
            gameOver = true;
            status.append("Player reached home!\nGame is over");
            return;
        }

        if (!items.containsKey(newPos)) {
            items.remove(playerPos);
            playerPos.move(relative);
            items.put(playerPos, player);
            status.append("Player moved successfully!\n");
        } else {
            status.append("Player could not move!\n");
        }

        // Move each wolf (hunter) randomly, if there are wolves
        if (hunters != null && !hunters.isEmpty()) { // Ensure there are wolves before moving them
            List<Position> wolfMoves = new ArrayList<>();
            wolfMoves.add(new Position(0, -1)); // go up
            wolfMoves.add(new Position(0, 1)); // go down
            wolfMoves.add(new Position(-1, 0)); // go left
            wolfMoves.add(new Position(1, 0)); // go right

            Random random = new Random();

            // Loop through each wolf (hunter)
            for (AbstractMoveableItem hunter : hunters) {
                if (hunter != null) { // Check that the hunter is not null
                    Position wolfPos = hunter.getPosition();
                    Position newWolpos = new Position(wolfPos);

                    // Randomly move the wolf
                    Position rndMove = wolfMoves.get(random.nextInt(wolfMoves.size()));
                    newWolpos.move(rndMove); // Move wolf to a random position

                    // Check if the hunter caught the player
                    if (newWolpos.equals(player.getPosition())) {
                        status.append("Hunter caught the player, argh!\nGame is over!");
                        gameOver = true;
                        return;
                    }

                    // Update wolf's position
                    if (!wolfPos.equals(newWolpos)) {
                        // Here, directly change the position of the hunter (wolf)
                        hunter.setPosition(newWolpos); // Update the position of the wolf
                        status.append("Hunter is coming closer...\n");
                    }

                    // Check if the player walks into a wolf
                    if (newPos.equals(wolfPos)) {
                        status.append("Player walked onto the Wolf and disappeared, argh!\nGame is over!\n");
                        gameOver = true;
                        return;
                    }

                    // Check if the wolf has an item
                    if (items.containsKey(newWolpos)) {
                        status.append("Wolf is lurking");
                    }
                }
            }
        } else {
            status.append("No wolves to move!\n");
        }
    }

    /**
     * Returns true if the game is over (either player reached home or was caught by
     * a hunter/wolf).
     * 
     * @return True if the game is over, false if not.
     */
    public boolean isGameOver() {
        if (player.getPosition().equals(home.getPosition())) {
            return true;
        }
        return gameOver;
    }

    /**
     * Returns a string containing the current status of the game, describing
     * actions taken in the game such as movements and events.
     * 
     * 
     * @return The current status of the game as a string.
     */
    public String getStatus() {
        return status.toString();
    }

}
