package se.isa.a01.task_01;

import java.util.Scanner;

/**
 * This is the menu class. It contains a constructor, a run method, a
 * displaymenu method and a printmenu method. The menu class makes it possible
 * for the user to interact with the program.
 */
public class Menu {
    private Scanner scanner;

    /**
     * The constructor initializes an instance of the menu class.
     */
    public Menu() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * This method runs the whole menu and lets the user decide on what do to in the
     * program.
     */
    public void run() {
        String choice;

        printMenu();
        do {
            System.out.print("\n>> Enter you choice: ");
            choice = getChoice().toUpperCase();
            switch (choice) {
                case "1":
                    Avatar.print();
                    break;
                case "2":
                    Today.print();
                    break;
                case "M":
                    printMenu();
                    break;
                case "3A":
                    RockPaperScissor rpsgame = new RockPaperScissor();
                    rpsgame.play();
                    break;
                case "3B":
                    DiceGame21 game = new DiceGame21();
                    game.play();
                    break;
                case "Q":
                    System.out.println("Thanks for using the program! Exiting...");
                    break;
                default:
                    System.out.println("ERROR: Invalid option, please select [1,2,m,3A,3B,q]");

            }
        } while (!(choice.equals("q") || choice.equals("Q")));
        scanner.close();
    }

    /**
     * Printmenu displays the menu.
     */
    public void printMenu() {
        System.out.println("""

                            MENU
                 ---------------------------
                | 1) Print my avatar        |
                | 2) Print todays date/time |
                | 3A) Rock, paper, scissor  |
                | 3B) Dice game 21          |
                | m) Print menu             |
                | qQ) Quit                  |
                 ---------------------------
                """);

    }

    /**
     * This method returns a string of the users input.
     * 
     * @return
     */
    private String getChoice() {
        return scanner.nextLine();

    }

}
