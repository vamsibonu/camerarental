package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReadWriteAppend {

    public static void main(String[] args) {
        // Specify the file path
        String filePath = "example.txt";

        // Writing to a file
        writeToFile(filePath, "Hello, this is a sample text for writing to a file.");

        // Reading from a file
        String content = readFromFile(filePath);
        System.out.println("Content read from the file:\n" + content);

        // Appending to a file
        appendToFile(filePath, "\nThis is additional text appended to the file.");

        // Reading again after appending
        content = readFromFile(filePath);
        System.out.println("\nContent read from the file after appending:\n" + content);
    }

    // Method to write to a file
    private static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("Content successfully written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read from a file
    private static String readFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    // Method to append to a file
    private static void appendToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            System.out.println("Content successfully appended to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
