package se.adlez.game;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The ForestToJson class provides methods for converting a Forest object to
 * JSON format
 * and saving it as a JSON file. This class uses the Gson library for JSON
 * serialization.
 */

public class ForestToJson {

    /**
     * Converts a Forest object to JSON format as a string.
     * This method uses Gson to serialize the object into a readable JSON
     * format.
     * 
     * @param forest The Forest object to be converted to JSON.
     * @return A string containing the JSON representation of the Forest object.
     */
    public String toJson(Forest forest) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(forest);
    }

    /**
     * Serializes the Forest object to JSON format and saves it to the file
     * specified.
     * This method uses Gson to convert the object to JSON and write it to the
     * file.
     * 
     * @param forest   The Forest object to be saved as a JSON file.
     * @param fileName The name of the file where the JSON representation of the
     *                 forest will be saved.
     */
    public void saveAsJson(Forest forest, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(fileName)) {
            gson.toJson(forest, writer);
            System.out.println("[Game saved successfully as JSON!]");

        } catch (IOException e) {
            System.out.println("Error saving forest: " + e.getMessage());
        }
    }
}
