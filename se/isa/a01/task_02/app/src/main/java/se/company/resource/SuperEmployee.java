package se.company.resource;

import java.util.ArrayList;

public class SuperEmployee extends Employee {
    private ArrayList<SuperPower> power;

    /**
     * Constructor to create a SuperEmployee instance with a specific name and work
     * description.
     * This constructor calls the Employee constructor to initialize
     * the name, work, and employee ID.
     * It also initializes an empty list of superpowers.
     * 
     * @param name The name of the SuperEmployee
     * @param work The job description or work role of the SuperEmployee
     */
    public SuperEmployee(String name, String work) {
        super(name, work, 0);
        this.power = new ArrayList<>();

    }

    /**
     * Returns a string representation of the SuperEmployee, including their
     * superpowers if they have any.
     * The string includes the employee's ID, name, work description, and
     * superpowers if available.
     * 
     * @return A string representing the SuperEmployee with their ID, name, work,
     *         and superpowers.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        // sb.append("Sup: ").append(super.toString());
        sb.append("Sup").append(("(")).append(getId()).append("): ").append(getName()).append(" (").append(work)
                .append(")");
        if (!power.isEmpty()) {
            sb.append(" - ");
            for (SuperPower p : power) {
                sb.append(p.getType());
            }
        }
        return sb.toString();
    }

    /**
     * Adds a new SuperPower to the list of powers possessed by the SuperEmployee.
     * 
     * @param power The SuperPower to add to the list
     */
    public void addPower(SuperPower power) {
        this.power.add(power);
    }

    /**
     * Overrides the work() method to provide a specific implementation for
     * SuperEmployee.
     * This method returns a description of the SuperEmployee's work, including
     * their superpowers if they have any.
     * 
     * @return A string describing the SuperEmployee's work and the superpowers
     *         used.
     */
    @Override
    public String work() {
        StringBuilder sb = new StringBuilder();
        sb.append(" Sup(" + empID + "): " + name).append(" is the saving the day in ").append(work).append(".");

        if (!power.isEmpty()) {
            for (SuperPower p : power) {
                sb.append(p.usePower());
            }
        }
        return sb.toString();
    }
}
