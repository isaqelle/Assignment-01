package se.adlez.game;

/**
 * The Main class where the game application gets compiled.
 * It is responsible for initializing the Menu and running the main game menu.
 * 
 * Run with: ./gradlew run --console plain -q
 */
public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.runMenu();

    }
}
