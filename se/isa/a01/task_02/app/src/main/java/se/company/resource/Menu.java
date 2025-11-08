package se.company.resource;

import java.util.Scanner;

/**
 * 
 * This class representes the menu. It conatins methods like 'displaymenu',
 * which
 * will print the menu. The method 'runmenu' makes it possible for the
 * user to navigate in the program.
 */
public class Menu {
    private Scanner scanner;
    private Employee employee;
    private Team team;
    private int salary = 0;
    private boolean isInt = false;

    /**
     * Constructor, initializes the scanner, sets a null team (doesen't point to any
     * objects yet) and a value of 0 for the salary.
     */
    public Menu(Team team) {
        this.scanner = new Scanner(System.in);
        this.team = team;
        this.salary = 0;

    }

    /**
     * Will print out a display of the menu.
     */
    public void displayMenu() {
        System.out.println("""

                                TEAM MANAGEMENT SYSTEM
                 ---------------------------------------------------
                | 1) Create a new empty team                        |
                | 2) Add normal employee to team                    |
                | 3) Add Lilly, Lollo and Leeloo                    |
                | 4) Print out work being done                      |
                | 5) Add super employee to team                     |
                | 6) Add three super employee, with powers, to team |
                | 7) Salary report                                  |
                | m) Print menu                                     |
                | qQ) Quit                                          |
                 ---------------------------------------------------
                """);
    }

    /**
     * In the runMenu method, the program is being executed. It contains a do while
     * loop that will iterate as long as the user does not input "q".
     * It also has a switch case that lets the user select menu option.
     */
    public void runMenu() {

        String choice;
        displayMenu();

        do {
            System.out.print("\n>> Enter menu choice: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("""
                             ------------------
                            | 1) Create new empty team
                             ------------------
                            """);
                    team = new Team();
                    System.out.println(team.toString());
                    break;

                case "2":
                    System.out.println("""
                             -------------------
                            | 2) Add normal employee to team
                             -------------------
                            """);
                    if (team == null) {
                        System.out.println("ERROR: No team created yet.");
                    } else {
                        System.out.print(">> Enter employee name: ");
                        String name = scanner.nextLine();
                        System.out.print(">> Enter work position: ");
                        String work = scanner.nextLine();

                        while (!isInt) {
                            try {
                                System.out.print(">> Enter monthly salary: ");
                                salary = Integer.parseInt(scanner.nextLine());
                                isInt = true;
                            } catch (NumberFormatException exception) {
                                System.out.println("ERROR: Please enter a valid number.");
                            }
                        }

                        employee = new NormalEmployee(name, work, salary);
                        team.add(employee);

                        System.out.println("# TEAM:\n" + team);
                    }

                    break;

                case "3":
                    System.out.println("""
                             -------------------
                            | 3) Add Lilly, Lollo, Leeloo
                             -------------------
                            """);
                    Employee emp1 = new NormalEmployee("Lilly", "Research", 50000);
                    Employee emp2 = new NormalEmployee("Lollo", "IT", 45000);
                    Employee emp3 = new NormalEmployee("Leeloo", "Hacking", 64000);
                    team.add(emp1);
                    team.add(emp2);
                    team.add(emp3);

                    System.out.println("# TEAM:\n" + team);

                    break;

                case "4":
                    System.out.println("""
                             -------------------
                            | 4) Print out work being done
                             -------------------
                            """);

                    System.out.println(team.work());

                    break;

                case "5":
                    System.out.println("""
                             -------------------
                            | 5) Add super employee to team
                             -------------------
                            """);
                    System.out.print(">> Enter name super employee name: ");
                    String name = scanner.nextLine();
                    System.out.print(">> Enter work position: ");
                    String work = scanner.nextLine();
                    SuperEmployee superEmployee = new SuperEmployee(name, work);
                    team.add(superEmployee);

                    System.out.println("#TEAM:\n" + team);
                    break;

                case "6":
                    System.out.println("""
                             -------------------
                            | 6) Add three super employee, with powers, to team
                             -------------------
                            """);
                    SuperEmployee sup1 = new SuperEmployee("MegaLilly", "Technician");
                    SuperEmployee sup2 = new SuperEmployee("SuperLollo", "Game Developing");
                    SuperEmployee sup3 = new SuperEmployee("WonderLeeloo", "Digital design");

                    SuperPower cuteness = new SuperPower("Cuteness",
                            "Being extra cute all the time. Everyone gets out-cuteed");
                    SuperPower superHacker = new SuperPower("Superhacker",
                            "Every big companys worst nightmare. Can hack anything within seconds.");
                    SuperPower chillGuy = new SuperPower("Chill Guy",
                            "Has an ability to be extreamly chill all the time, no matter what.");
                    SuperPower rainMain = new SuperPower("Rainmain",
                            "Sadly no mastermind, but can make it rain anytime.");

                    sup1.addPower(chillGuy);
                    sup2.addPower(superHacker);
                    sup3.addPower(cuteness);
                    sup3.addPower(rainMain);

                    team.add(sup1);
                    team.add(sup2);
                    team.add(sup3);

                    System.out.println("# TEAM:\n" + team);

                    break;

                case "7":
                    System.out.println("""
                             ------------------
                            | 7) Salary report
                             ------------------
                            """);
                    System.out.println(team.salaryReport());
                    break;

                case "m":
                    displayMenu();
                    break;

                case "q":
                    while (true) {
                        System.out.print("Are you sure you want to exit? [y/n] ");
                        String exit = scanner.nextLine();
                        if (exit.equalsIgnoreCase("y")) {
                            System.out.println("Thank you for using this program!");
                            System.out.println("Exiting program...");
                            break;
                        } else if (exit.equalsIgnoreCase("n")) {
                            runMenu();
                            return;
                        } else {
                            System.out.println("Please enter [y/n]");
                        }
                    }

                default:
                    break;
            }
        } while (!choice.equalsIgnoreCase("q"));

    }
}
