package se.isa.a01.task_01;

import java.util.Random;
import java.util.Scanner;

public class DiceGame21 {
    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private int playerWins = 0;
    private int kittyWins = 0;

    public void play() {
        System.out.println("⚁ Welcome to the Dice Game 21 ⚄");
        String input;

        while (true) {
            System.out.println("\nEnter 'q' to quit or press ENTER to start a new game: ");
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("q")) {
                System.out.println("Exiting game");
                break;
            }

            int playerScore = playerTurn(); // Store the scored from each turn in this integer
            if (playerScore == 21) {
                System.out.println("You got 21 and wins this round!");
                playerWins++;
                displayScore();
                continue;
            } else if (playerScore > 21) {
                System.out.println("Too high! Kitty wins this round! ");
                kittyWins++;
                displayScore();
                continue;
            }
            int kittyScore = kittyTurn(); // Store the scored from each turn in this integer
            findWinner(playerScore, kittyScore);
            displayScore();
        }
    }

    public int playerTurn() {
        int total = 0;
        while (true) {
            System.out.println("You total is: " + total);
            System.out.println("Roll dice? [y/n] ");
            String choice = scanner.nextLine().trim().toLowerCase();
            if (choice.equals("y")) {
                int roll = rollDice();
                total += roll;
                System.out.println("You rolled a: " + roll);
                if (total > 21) {
                    System.out.println("Your total is " + total + ". You rolled too high!");
                    return total;
                }
            } else if (choice.equals("n")) {
                System.out.println("Your round has ended. You have a total of: " + total);
                return total;
            } else {
                System.out.println("ERROR: Invalid input, enter 'y' or 'n'.");
            }
        }
    }

    public int kittyTurn() {
        int total = 0;
        System.out.println("\nIt's Kittys turn to play!");
        while (total <= 17) {
            int roll = rollDice();
            total += roll;
            System.out.println("Kitty rolled a: " + roll);
            System.out.println("Kitty's total is: " + total);
        }
        System.out.println("Kitty's round has ended. She has a total of: " + total);
        return total;
    }

    public void findWinner(int playerScore, int kittyScore) {
        System.out.println("Results:");
        if (kittyScore > 21 || playerScore > kittyScore) {
            System.out.println("You won!");
            playerWins++;
        } else if (playerScore > 21 || kittyScore > playerScore) {
            System.out.println("Kitty won!");
            kittyWins++;
        } else {
            System.out.println("It's a tie, Kitty wins!");
            kittyWins++;
        }

    }

    public void displayScore() {
        System.out.println("Scores: ");
        System.out.println("Your wins: " + playerWins);
        System.out.println("Kitty wins: " + kittyWins);
    }

    public int rollDice() { // Kitty's dice
        return random.nextInt(6) + 1;
    }

}
