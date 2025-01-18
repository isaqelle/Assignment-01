package se.company.resource;

/**
 * This class represents the Employees. It contains methods like:
 * -work
 * -toString
 * -getNewEmployeeId
 * -getName
 * -getId
 * -getSalary
 */
public class Employee {

    protected String name;
    protected String work;
    private int salary;
    private static int globalEmpId = 1;
    protected int empID;

    /**
     * Constructor to initialize an Employee with a name, work, salary, and
     * automatically generate a unique employee ID.
     * 
     * @param name   The name of the employee
     * @param work   The job or work role of the employee
     * @param salary The salary of the employee
     */
    public Employee(String name, String work, int salary) {
        this.name = name;
        this.work = work;
        this.salary = salary;
        this.empID = Employee.getNewEmployeeId();

    }

    /**
     * Returns the job description of the employee.
     * This method can be overridden by subclasses to specify their work.
     * 
     * @return A string describing the work of the employee
     */
    public String work() {
        return "";
    }

    /**
     * Returns a string representation of the employee with their ID, name, and work
     * role.
     * 
     * @return A string that represents the employee
     */
    public String toString() {
        return "Emp(" + getId() + "): " + getName() + " (" + work + ")";
    }

    /**
     * Generates and returns a new unique employee ID.
     * The ID is automatically incremented with each new employee created.
     * 
     * @return A unique employee ID
     */
    public static int getNewEmployeeId() {
        return globalEmpId++;
    }

    /**
     * Returns the name of the employee.
     * 
     * @return The name of the employee
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the unique ID of the employee.
     * 
     * @return The employee ID
     */
    public int getId() {
        return empID;
    }

    /**
     * Returns the salary of the employee.
     * 
     * @return The salary of the employee
     */
    public int getSalary() {
        return salary;
    }

}
