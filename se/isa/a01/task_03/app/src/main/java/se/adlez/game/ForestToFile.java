package se.adlez.game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * The ForestToFile class provides methods to save and load the game state
 * to and from a file using serialization.
 */

public class ForestToFile {

    /**
     * Serializes the Forest object and saves it to a file with the
     * specified file name.
     * 
     * @param forest   The Forest object representing the current game state to be
     *                 saved.
     * @param fileName The name of the file to save the game state to.
     * @return A string message indicating the result of the save operation.
     */
    public String save(Forest forest, String fileName) {

        File file = new File(fileName);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs(); // Create the directory if it does not exist
        }
        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(forest);
            }

        } catch (IOException e) {
            System.err.println("Error saving game: " + e.getMessage());
        }
        return "Game saved to " + fileName;
    }

    /**
     * Deserializes and loads the saved Forest object from the specified file.
     * 
     * @param fileName The name of the file from which to load the saved game state.
     * @return The Forest object representing the game state loaded from the file,
     *         or null if loading did not succeed.
     */
    public Forest load(String fileName) {
        try {

            FileInputStream fileIn = new FileInputStream(fileName);
            try (ObjectInputStream in = new ObjectInputStream(fileIn)) {
                return (Forest) in.readObject();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading game: " + e.getMessage());

        }
        return null;

    }
}
