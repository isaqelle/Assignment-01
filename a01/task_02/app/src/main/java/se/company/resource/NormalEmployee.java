package se.company.resource;

public class NormalEmployee extends Employee {
    /**
     * Constructor to create a NormalEmployee instance with a name, work
     * description, and salary.
     * This constructor calls the Employee constructor to initialize
     * the inherited fields
     * and assigns a unique employee ID to the new employee.
     * 
     * @param name   The name of the employee
     * @param work   The job description or work role of the employee
     * @param salary The salary of the employee
     */
    public NormalEmployee(String name, String work, int salary) {
        super(name, work, salary);
    }

    /**
     * Overrides the work() method to create a specific implementation for
     * NormalEmployee.
     * 
     * @return A string representing the work description of the NormalEmployee
     */
    @Override
    public String work() {
        return " Emp(" + getId() + "): " + getName() + " is working on a report in " + work;
    }
}
