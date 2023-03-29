## Single Responsibility

The Single Responsibility Principle (SRP) states that a class or module should have only one responsibility. In other words, a class or module should have only one reason to change. The SRP promotes cohesion and modularity in software design, which makes the system easier to understand, maintain, and scale.

### Bad example:

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "example.txt";
        read_file(filename);
    }

    public static void read_file(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

### Good example:

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void read_file(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    public static void process_data(String data) {
        // Do some data processing
        // ...
    }

    public static void write_to_database(String data) {
        // Write data to the database
        // ...
    }

    public static void main(String[] args) {
        String filename = "data.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                process_data(line);
                write_to_database(line);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

### Related principles

- BESO
- separation of interests

