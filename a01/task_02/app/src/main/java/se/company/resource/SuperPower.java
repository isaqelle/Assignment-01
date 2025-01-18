package se.company.resource;

public class SuperPower {
    private String type;
    private String description;

    /**
     * Constructor to create a SuperPower instance with a specific type and
     * description.
     * 
     * @param type        The type of the superpower
     * @param description A description of what the superpower does
     */
    public SuperPower(String type, String description) {
        this.type = type;
        this.description = description;
    }

    /**
     * Returns a string that describes the use of the superpower, including its type
     * and description.
     * 
     * @return A string representation of the superpower being used, including its
     *         type and description
     */
    public String usePower() {
        return "\n Using superpower: " + type + " - " + description;
    }

    /**
     * Returns the type of the superpower.
     * 
     * @return The type of the superpower (e.g., "Flying", "Invisibility")
     */
    public String getType() {
        return type;
    }
}
