package ComputerEngine;

import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;

public class DataSystem implements DataSystemInterface {

    private String sourceFilePath;
    private String destinationFilePath;
    private String[] numberStrings;

    public DataSystem(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    File file = new File("/Users/davidvenuto/Desktop/TestCodeShit/ComputerEngine/document.csv");

    @Override
    public void readFromFile() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            if (line != null) {
                this.numberStrings = line.split(",");
            }
        }
    }

    public String[] getNumberStrings() {
        return numberStrings;
    }

    public void writeToFile(long[][] results, String delimiter) throws IOException {
        if (delimiter == null || delimiter.isEmpty()) {
            delimiter = ","; // Default delimiter
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(this.destinationFilePath))) {
            for (long[] row : results) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < row.length; i++) {
                    sb.append(row[i]);
                    if (i < row.length - 1) {
                        sb.append(delimiter);
                    }
                }
                writer.write(sb.toString());
                writer.newLine();
            }
        }
    }

    public void setDestination(String destinationFilePath) {
        this.destinationFilePath = destinationFilePath;
    }

    // updateData and deleteData still need to be implemented

    @Override
    public String updateData(String identifier, String[] newData) {
        // Updates the current data
        return identifier;
    }

    // Delete data
    @Override
    public String deleteData(String identifier) {
        // Returns the deleted data
        return identifier;
    }
}

