package se.isa.a01.task_01;

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissor {
    private int myScore = 0;
    private int kittyScore = 0;

    /**
     * Plays Rock Paper Scissor game
     */
    public void play() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to a game of rock ✊, scissor ✂, paper ✋!");
        System.out.println("You will play against Kitty and we keep score.");
        System.out.println("\n>> Score: You " + myScore + " - " + "Kitty " + kittyScore + " <<");
        System.out.println("\nSelect rock ✊ [r], scissor ✂ [s], paper ✋ [p] or quit [q]: ");

        while (true) {
            String choice = getChoice(scanner);
            if (choice.equals("q")) {
                System.out.println("Thanks for playing!");
                Menu menu = new Menu();
                menu.printMenu();
                break;
            }

            String kittyChoice = kittyPlay();
            System.out.println(" You played: [" + choice + "]");
            System.out.println(" Kitty played: [" + kittyChoice + "]");

            findWinner(choice, kittyChoice);
        }

    }

    public String getChoice(Scanner scanner) {
        System.out.print("Your choice: ");

        String choice = scanner.nextLine().toLowerCase();
        if ("rspq".contains(choice) && choice.length() == 1) {
            return choice;
        } else {
            System.out.println("Invalid choice. Please enter 'r', 's', 'p', or 'q'.");
            return getChoice(scanner); 
        }
    }

    public String kittyPlay() {
        char[] choices = { 'r', 's', 'p' };
        Random rand = new Random();
        char kittyChoice = choices[rand.nextInt(choices.length)];
        return String.valueOf(kittyChoice);
    }

    private void findWinner(String player, String kitty) {
        String rock = "rock ✊";
        String scissor = "scissor ✂";
        String paper = "paper ✋";

        if (player.equals("r") && kitty.equals("s")) {
            myScore++;
            System.out.println("\nYou did " + rock + " and Kitty did " + scissor);
            System.out.println("Score: You " + myScore + " Kitty " + kittyScore);
        } else if (player.equals("p") && kitty.equals("r")) {
            myScore++;
            System.out.println("\nYou did " + paper + " and Kitty did " + rock);
            System.out.println("Score: You " + myScore + " Kitty " + kittyScore);

        } else if (player.equals("s") && kitty.equals("p")) {
            myScore++;
            System.out.println("\nYou did " + scissor + " and Kitty did " + paper);
            System.out.println("Score: You " + myScore + " Kitty " + kittyScore);

        } else if (kitty.equals("r") && player.equals("s")) {
            kittyScore++;
            System.out.println("\nYou did " + rock + " and Kitty did " + scissor);
            System.out.println("Score: You " + myScore + " Kitty " + kittyScore);

        } else if (kitty.equals("p") && player.equals("r")) {
            kittyScore++;
            System.out.println("\nYou did " + paper + " and Kitty did " + rock);
            System.out.println("Score: You " + myScore + " Kitty " + kittyScore);

        } else if (kitty.equals("s") && player.equals("p")) {
            kittyScore++;
            System.out.println("\nYou did " + scissor + " and Kitty did " + paper);
            System.out.println("Score: You " + myScore + " Kitty " + kittyScore);

        } else {
            System.out.println("\nTie!");
            System.out.println(">> Score: You " + myScore + " | Kitty " + kittyScore + " <<");
        }

    }
}