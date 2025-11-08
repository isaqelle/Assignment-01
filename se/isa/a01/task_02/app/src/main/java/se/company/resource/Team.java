package se.company.resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Team {
    private ArrayList<Employee> member;

    /**
     * Constructor to initialize a Team instance with an empty list of employees.
     * This constructor creates a new team with no members.
     */
    public Team() {
        this.member = new ArrayList<>();
    }

    /**
     * Adds an Employee to the team.
     * 
     * @param emp The Employee object to be added to the team
     */
    public void add(Employee emp) {
        member.add(emp);
    }

    /**
     * Returns a string representation of the Team. If the team has no members,
     * it returns a message stating that the team is empty. Otherwise, it returns
     * the string representation of each employee in the team.
     * 
     * @return A string representing the team and its members
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (member.isEmpty()) {
            this.member = new ArrayList<>();
            return "# TEAM:\n (empty team)";
        }

        for (Employee emp : member) {
            sb.append(emp.toString()).append("\n");
        }
        return sb.toString();

    }

    /**
     * Returns a string representing the work being done by the employye in the
     * whole team.
     * 
     * @return A string describing the work being done by the team
     */
    public String work() {
        StringBuilder sb = new StringBuilder();
        for (Employee emp : member) {
            String task = emp.work();
            if (!task.isEmpty()) {
                sb.append(task).append("\n");
            }
        }

        return "# TEAM is working:\n" + sb.toString();
    }

    /**
     * Generates a salary report for the team, showing the salary of each employee
     * and the total salary of all employees. The report includes the current date
     * and the month/year of the salary report.
     * 
     * @return A formatted string representing the salary report for the team
     */
    public String salaryReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("# TEAM Salary ").append(new SimpleDateFormat("yyyy MMMM").format(new Date())).append("\n");
        sb.append("-------------------------------------\n");
        int totalSalary = 0;

        for (Employee emp : member) {
            String formatSalary = String.format("%d", emp.getSalary());
            sb.append(String.format(" (%d) %-20s %10s\n", emp.empID, emp.name, formatSalary));

            totalSalary += emp.getSalary();
        }

        sb.append("-------------------------------------\n");
        sb.append(String.format("Total salary is %20d", totalSalary) + "$\n");
        sb.append("Report generated ").append(new SimpleDateFormat("yyyy-MM-dd").format(new Date())).append(".\n");

        return sb.toString();

    }
}
