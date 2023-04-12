## Adapter pattern

## Description

The Adapter pattern is a design pattern that allows objects with incompatible interfaces to work together by 
creating a middleman object that acts as a translator between the two. It is also known as the Wrapper pattern.

The Adapter pattern is useful when an existing class does not meet the requirements of a new class but cannot be 
modified directly. By creating an adapter, the new class can communicate with the existing class through the adapter 
without needing to modify the existing class.

In this pattern, the adapter wraps an existing class and exposes a compatible interface that the client can use. The 
adapter then translates the client's requests into calls to the wrapped object's methods.

The Adapter pattern is often used to integrate legacy code with new systems or to make two incompatible systems work 
together. It is commonly used in software engineering and is a powerful tool for achieving code reuse and 
flexibility.

## Problem

Suppose you have an application that reads data from a CSV file and processes it to display it in a table. The 
application uses a class called "CSVReader" to read the data from the file. However, it is required to change the 
format of the data to JSON so that it can be used in another application. The problem is that the new application 
can only read data in JSON format, so a way is needed to adapt the interface of the CSVReader class so that it can 
output data in JSON format.

## Solution

To work around this problem, the Adapter pattern can be used. A class called "CSVToJsonAdapter" will be created that 
implements the interface required by the new application and that adapts to the interface of the CSVReader class.

Here is an example of Java code that implements the Adapter pattern to solve this problem:

```Java: 

    // Interface for the adapter
    public interface DataProvider {
        public String getData();
    }

    // Existing CSVReader class
    public class CSVReader {
        public String readCSV() {
            // Read the data from the CSV file and process it
            return "data in CSV format";
        }
    }

    // Adapter to generate data in JSON format
    public class CSVToJsonAdapter implements DataProvider {
        private CSV Reader reader;

        public CSVToJsonAdapter(CSVReader reader) {
            this.reader = reader;
        }

        public String getData() {
            String csvData = reader.readCSV();
            // Convert the data from CSV to JSON
            String jsonData = "data in JSON format";
            return jsonData;
        }
    }

    // Usage example
    public class Main {
        public static void main(String[] args) {
            CSVReader csvReader = new CSVReader();
            DataProvider adapter = new CSVToJsonAdapter(csvReader);

            // Use the adapter to output data in JSON format
            String jsonData = adapter.getData();
            System.out.println(jsonData);
        }
    }

```

In this example, the CSVReader class represents the existing class with an interface that is incompatible with the 
new application. The CSVToJsonAdapter class acts as the adapter, implementing the interface required by the new 
application and using the CSVReader class to generate the necessary data in CSV format and then convert it to JSON 
format.

By using the Adapter pattern, you achieve an elegant and flexible solution that allows you to integrate your 
existing class with your new application without the need to make significant changes to your existing code.