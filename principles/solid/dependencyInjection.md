## Dependency Injection

It aims to reduce the coupling between the classes of a system, thus improving its modularity, facilitating maintenance, scalability and code reuse. In simple terms, dependency injection refers to the way in which objects of one class are created and injected into another class that needs them. Instead of the dependent class creating the objects itself, they are supplied to it from the outside. In this way, the dependencies of the class can be changed without having to modify it.

### Bad Example
Suppose we have a 'Logger' class that is responsible for logging error messages to a log file. To do this, we need a 'FileWriter' class that handles writing to the file.

``` java
public class Logger {
    private String filePath;

    public Logger(String filePath) {
        this.filePath = filePath;
    }

    public void log(String message) {
        // Escribir mensaje en archivo en el filePath
    }
}
```
In this example, the 'Logger' class writes error messages directly to a file using the 'filePath' that is passed to the constructor. This violates the principle of Dependency Injection since we are not supplying the 'FileWriter' dependency through the constructor.

Now, when we need to use Logger, we have to create an instance of 'Logger' with the appropriate 'filePath':
``` java
public class Main {
    public static void main(String[] args) {
        Logger logger = new Logger("logs.txt");

        logger.log("Error en la aplicación");
    }
}
```
In this example, we create an instance of 'Logger' with the appropriate 'filePath' and call the log method to log an error message to the log file.
The problem with this approach is that 'Logger' is not easily configurable to use different 'FileWriter' implementations. If we want to change the log file, for example, we have to modify the 'Logger' code. This makes the code more rigid and difficult to maintain in the long run.

## Good Example
To solve this rigidity and poor maintainability, the 'Logger' class has a dependency on the 'FileWriter' interface. But instead of directly creating an instance of 'FileWriter', it is supplied through the constructor. This makes 'Logger' more flexible and easier to maintain.
``` java
public interface FileWriter {
    void writeToFile(String message);
}

public class Logger {
    private FileWriter fileWriter;

    public Logger(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public void log(String message) {
        fileWriter.writeToFile(message);
    }
}
```
Now, to inject the FileWriter dependency into Logger, we can create an implementation of the FileWriter interface and then instantiate Logger with that implementation:
``` java
public class FileWriterImpl implements FileWriter {
    private String filePath;

    public FileWriterImpl(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(String message) {
        // Escribir mensaje en archivo en el filePath
    }
}

public class Main {
    public static void main(String[] args) {
        FileWriter fileWriter = new FileWriterImpl("logs.txt");
        Logger logger = new Logger(fileWriter);

        logger.log("Error en la aplicación");
    }
}

```
Therefore, we create an implementation of 'FileWriter' called 'FileWriterImpl' that writes the messages to a file in the 'filePath'. Then, we instantiate 'Logger' with that implementation and call the log method to log an error message to the log file.

In this way, 'Logger' is easily configurable to use different 'FileWriter' implementations, thus complying with the principle

## Related principles
- [Code for maintainer](../general/codeformantainer.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)
- [Separation of Concerns](../general/separationofconcerns.md)

[Back to the list](./README.md)