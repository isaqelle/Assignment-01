package se.company.resource;

/**
 * The main method is used to initiate the execution of a the program.
 * It creates a new Menu object and then calls the runMenu method.
 * 
 * Run with: ./gradlew run --console plain -q
 */

public class Main {
    public static void main(String[] args) {
        Team team = new Team();
        Menu menu = new Menu(team);
        menu.runMenu();
    }
}
