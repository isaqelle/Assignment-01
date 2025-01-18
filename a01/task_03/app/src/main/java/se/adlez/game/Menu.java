package se.adlez.game;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private Forest forest;
    private Item item;
    private Random random;

    /**
     * Constructor for the Menu class.
     * 
     * This constructor initializes the Menu by creating instances of
     * the Scanner and Random objects which are used for user input
     * and random number generation.
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
        this.random = new Random();
    }

    /**
     * Method that prints out the menu.
     */
    public void displayMenu() {
        System.out.println("""
                 -------------------------------------------
                | 1) Create an empty forest                 |
                | p) Print game as JSON                     |
                | s) Save game as JSON                      |
                | 2) Print the forest                       |
                | 3) Add items (tree, rock) to the forest   |
                | 4) List all items in the forest           |
                | 5) Add 5 trees and 5 stones to the forest |
                | 6) Add player, hunter and the home        |
                | 7) Play game                              |
                | 8) Save game to file                      |
                | 9) Load game from file                    |
                | m) Print menu                             |
                | qQ) Quit                                  |
                 -------------------------------------------
                """);
    }

    /**
     * The method where the game is running and the user is interacting with the
     * game.
     * 
     * It contains:
     * - Creating a new forest
     * - Adding items to the forest
     * - Displaying the forest
     * - Saving and loading the game
     * - Printing and loading the game
     * - Printing or saving the game as JSON
     * - The game itself
     * 
     * Error handling is also implemented to prevent the game from crashing.
     */
    public void runMenu() {
        System.out.println("\n          WELCOME TO THE ADLEZ GAME");
        String choice;
        displayMenu();
        Path path = Paths.get("data", "forest.ser");
        ForestToFile forestToFile = new ForestToFile();
        ForestToJson forestToJson = new ForestToJson();

        do {
            System.out.print("\n >> Enter your menu choice: ");
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("""
                             -----------------
                            | 1) Create an empty forest
                             -----------------
                            """);
                    forest = new Forest();
                    System.out.println("INFO: [New forest created]");
                    break;
                case "p":
                    System.out.println("""
                             -----------------
                            | p) Print game as JSON
                             -----------------
                            """);
                    String json = forestToJson.toJson(forest);

                    // forestToJson.saveAsJson(forest, "forest.json");
                    System.out.println(json);
                    break;
                case "s":
                    System.out.println("""
                             -----------------
                            | s) Save game as JSON
                             -----------------
                            """);
                    forestToJson.saveAsJson(forest, "forest.json");

                    break;

                case "2":
                    System.out.println("""
                             -----------------
                            | 2) Print the forest
                             -----------------
                            """);

                    try {
                        System.out.println(forest.getGamePlan());
                    } catch (Exception e) {
                        System.err.println("ERROR: " + e.getMessage()); // TODO: handle exception
                    }
                    break;
                case "3":
                    System.out.println("""
                             -----------------
                            | 3) Add items (tree, rock) to the forest
                             -----------------
                            """);

                    do {
                        System.out.print("Add FirTree 🌲 [1] or Rock 🪨 [2]\nEnter your choice: ");
                        String items = scanner.nextLine();
                        if (items.equals("1")) {
                            item = new FirTree();
                            break;

                        } else if (items.equals("2")) {
                            item = new Rock();
                            break;

                        } else {
                            System.out.println("ERROR: Invalid option, please choose [1] or [2]");

                        }
                    } while (true);

                    do {
                        System.out.print("Set position x y (separate by space)\nEnter your choice: ");
                        String input = scanner.nextLine();
                        try {
                            String[] xy = input.split(" ");

                            if (xy.length != 2) {
                                System.out.println(
                                        "ERROR: Invalid input, please enter two values seperated by a blank space.\n");

                            } else {
                                int x = Integer.parseInt(xy[0]);
                                int y = Integer.parseInt(xy[1]);
                                Position position = new Position(x, y);

                                if (forest.tryAddItem(item, position)) {
                                    System.out.println("Added item to the forest: " + item + " at " + position);
                                    break;
                                } else {
                                    System.out.println("ERROR: Position already occupied.\n");
                                }
                            }
                        } catch (Exception e) {
                            System.err.println("ERROR: " + e.getMessage()); // TODO: handle exception
                            break;
                        }
                    } while (true);
                    break;

                case "4":
                    System.out.println("""
                             -----------------
                            | 4) List all items in the forest
                             -----------------
                            """);
                    if (forest.listItem().isEmpty()) {
                        System.out.println("No items added yet.");
                    } else {
                        System.out.println(forest.listItem());
                    }

                    break;
                case "5":
                    System.out.println("""
                             -----------------
                            | 5) Add 5 trees and 5 stones to the forest
                             -----------------
                            """);
                    int treesAdded = 0;
                    int rocksAdded = 0;

                    while (treesAdded < 5) {
                        Position rndposition = new Position(random.nextInt(10) + 1, random.nextInt(10) + 1);
                        if (forest.tryAddItem(new FirTree(), rndposition)) {
                            treesAdded++;
                        }
                    }

                    while (rocksAdded < 5) {
                        Position rndposition = new Position(random.nextInt(10) + 1, random.nextInt(10) + 1);
                        if (forest.tryAddItem(new Rock(), rndposition)) {
                            rocksAdded++;
                        }
                    }

                    System.out.println("| Added 5 trees and 5 rocks to forest |");
                    System.out.println(forest.listItem());

                    break;
                case "6":
                    System.out.println("""
                             -----------------
                            | 6) Add player, hunter and the home
                             -----------------
                            """);

                    // Declare the player variable once outside the loop to ensure it's accessible
                    // later
                    AbstractMoveableItem player = null;

                    // Select player character
                    do {
                        System.out.print("Select your player, Cat (c), Dog (d) or Robot (r): ");
                        String playerChoice = scanner.nextLine();

                        if (playerChoice.equalsIgnoreCase("c")) {
                            player = new Cat(new Position(1, 1));
                            forest.addPlayerItem(player);
                            System.out.println(
                                    "Selected player: " + player.getDescription() + " " + player.getGraphic() + "\n");
                            break;
                        } else if (playerChoice.equalsIgnoreCase("r")) {
                            player = new Robot(new Position(1, 1));
                            forest.addPlayerItem(player);
                            System.out.println(
                                    "Selected player: " + player.getDescription() + " " + player.getGraphic() + "\n");
                            break;
                        } else if (playerChoice.equalsIgnoreCase("d")) {
                            player = new Dog(new Position(1, 1));
                            forest.addPlayerItem(player);
                            System.out.println(
                                    "Selected player: " + player.getDescription() + " " + player.getGraphic() + "\n");
                            break;
                        } else {
                            System.out.println("Please select 'c', 'd', or 'r'.");
                        }

                    } while (true); // Repeat until a valid player is selected

                    // Difficulty level selection loop
                    String difficulty;
                    do {
                        System.out.print("Select game difficulty: \n[1]\n[2]\n[3]\n ");
                        System.out.print(">> ");
                        difficulty = scanner.nextLine().trim();
                        if (difficulty.equals("1")) {
                            System.out.println("One 🐺 added to the game.");
                            AbstractMoveableItem hunter = new Wolf(new Position(8, 5));
                            forest.addHunterItem(hunter);
                            break;
                        } else if (difficulty.equals("2")) {
                            System.out.println("Two 🐺 added to the game.");
                            AbstractMoveableItem hunter1 = new Wolf(new Position(8, 5));
                            AbstractMoveableItem hunter2 = new Wolf(new Position(5, 4));
                            forest.addHunterItem(hunter1);
                            forest.addHunterItem(hunter2);
                            break;
                        } else if (difficulty.equals("3")) {
                            System.out.println("Three 🐺 added to the game.");
                            AbstractMoveableItem hunter1 = new Wolf(new Position(6, 5));
                            AbstractMoveableItem hunter2 = new Wolf(new Position(3, 2));
                            AbstractMoveableItem hunter3 = new Wolf(new Position(9, 6));
                            forest.addHunterItem(hunter1);
                            forest.addHunterItem(hunter2);
                            forest.addHunterItem(hunter3);
                            break;
                        } else {
                            System.out.println("ERROR: Please enter '1', '2' or '3'.");
                            return;
                        }
                    } while (true); // Continue until valid difficulty is selected

                    // Create and add home (Castle) to the game
                    AbstractMoveableItem home = new Castle(new Position(5, 8));
                    forest.addHomeItem(home);

                    break;

                case "7":
                    System.out.println("""
                             -----------------
                            | 7) Play game
                             -----------------
                            """);
                    System.out.println("LET'S START THE GAME");

                    do {
                        System.out.println(forest.getGamePlan());

                        System.out.println("Move player left=w, right=s, up=a, down=d, quit=q.");

                        choice = scanner.nextLine();
                        switch (choice) {
                            case "a":
                                forest.movePlayer(new Position(0, -1));
                                System.out.println(forest.getStatus());
                                break;
                            case "d":
                                forest.movePlayer(new Position(0, 1));
                                System.out.println(forest.getStatus());
                                break;
                            case "w":
                                forest.movePlayer(new Position(-1, 0));
                                System.out.println(forest.getStatus());
                                break;
                            case "s":
                                forest.movePlayer(new Position(1, 0));
                                System.out.println(forest.getStatus());
                                break;
                            case "q":
                                System.out.println("Bye bye!");

                                break;
                        }

                        if (forest.isGameOver()) {
                            System.out.println(forest.getGamePlan());

                            break;
                        }
                    } while (!choice.equals("q"));

                    break;
                case "8":
                    System.out.println("""
                             -----------------
                            | 8) Save game to file
                             -----------------
                            """);
                    String result = forestToFile.save(forest, path.toString());
                    System.out.println(result);
                    System.out.println("File will be saved at: " + path.toAbsolutePath()); // debug
                    break;
                case "9":
                    System.out.println("""
                             -----------------
                            | 9) Load game from file
                             -----------------
                            """);
                    Forest loadedForest = forestToFile.load(path.toString());

                    if (loadedForest != null) {
                        System.out.println("Game loaded");
                        System.out.println(loadedForest.getGamePlan());
                    } else {
                        System.out.println("Error loading the game.");
                    }
                    break;

                case "m":
                    displayMenu();
                    break;
                case "q":
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Please enter a valid option.");
                    continue;
            }

        } while (!choice.equalsIgnoreCase("q"));
    }
}
