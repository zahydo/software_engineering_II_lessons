# Factory pattern

The Factory pattern is an object-oriented design pattern in object-oriented programming that provides an interface for creating objects in a superclass, while allowing subclasses to determine which object class to instantiate.

This pattern facilitates the creation of objects without exposing the creation logic to the client, promoting code decoupling and scalability.

<p align="center">
<img src="https://res.cloudinary.com/dzxhdnqm4/image/upload/v1680996327/UML_Factory_2_siieqw.png" alt="mypic" width="75%">
</p>

## 😟 Problem

Imagine you are developing an application to manage different types of files. Every time you want to create a file object (`TextFile`, `ImageFile`, `AudioFile`), you would have to instantiate the concrete class directly.

```java
public interface File {
    void open();
    void save();
    void close();
}

// Concrete file classes
public class TextFile implements File {
    @Override
    public void open() {
        //...
    }

    @Override
    public void save() {
        //...
    }

    @Override
    public void close() {
       //...
    }
}

public class ImageFile implements File {
    @Override
    public void open() {
        //...
    }

    @Override
    public void save() {
        //...
    }

    @Override
    public void close() {
        //...
    }
}

public class AudioFile implements File {
    @Override
    public void open() {
        //...
    }

    @Override
    public void save() {
       //...
    }

    @Override
    public void close() {
       //...
    }
}

public class Main {
    public static void main(String[] args) {
         // Instantiating concrete classes directly without using FileFactory
        File textFile = new TextFile();
        textFile.open();
        textFile.save();
        textFile.close();

        File imageFile = new ImageFile();
        imageFile.open();
        imageFile.save();
        imageFile.close();

        File audioFile = new AudioFile();
        audioFile.open();
        audioFile.save();
        audioFile.close();
    }
}
```

This approach makes your application highly coupled to the concrete classes, which makes it difficult to adapt and maintain the code if you decide to add new file types or modify existing classes.

## 🙂 Solution

To address this issue, the Factory pattern can be used to create objects of different file types without directly instantiating the concrete classes. Instead, a separate factory class `FileFactory` will be responsible for creating objects of the concrete classes based on the given input.

This approach promotes loose coupling, making the code more flexible and easier to maintain.

```java
// Component interface
public interface File {
    void open();
    void save();
    void close();
}
// Concrete file classes
public class TextFile implements File {
    @Override
    public void open() {
        System.out.println("Opening a text file.");
    }

    @Override
    public void save() {
        System.out.println("Saving a text file.");
    }

    @Override
    public void close() {
        System.out.println("Closing a text file.");
    }
}

public class ImageFile implements File {
    @Override
    public void open() {
        System.out.println("Opening an image file.");
    }

    @Override
    public void save() {
        System.out.println("Saving an image file.");
    }

    @Override
    public void close() {
        System.out.println("Closing an image file.");
    }
}

public class AudioFile implements File {
    @Override
    public void open() {
        System.out.println("Opening an audio file.");
    }

    @Override
    public void save() {
        System.out.println("Saving an audio file.");
    }

    @Override
    public void close() {
        System.out.println("Closing an audio file.");
    }
}
```

In this example, it needs to create different objects of different File subclasses at runtime without coupling the code to specific concrete classes.

The File interface defines the operations required to open, save, and close a file, and there are three concrete classes that implement the interface: `TextFile`, `ImageFile`, and `AudioFile`.

```java
// FileFactory class
public class FileFactory {
    public static File createFile(String fileType) {
        if (fileType.equalsIgnoreCase("text")) {
            return new TextFile();
        } else if (fileType.equalsIgnoreCase("image")) {
            return new ImageFile();
        } else if (fileType.equalsIgnoreCase("audio")) {
            return new AudioFile();
        } else {
            throw new IllegalArgumentException("Invalid file type.");
        }
    }
}
```

The `FileFactory` class is responsible for creating objects from the subclasses of File according to the type of file required.

Thus, the Factory pattern creates a File interface, concrete subclasses (`TextFile`, `ImageFile`, `AudioFile`), and a `FileFactory` class to manage object creation. This results in more modular, maintainable, and flexible code, enabling the creation of various file types without altering the Main class code.

```java
// Main class
public class Main {
    public static void main(String[] args) {
        File textFile = FileFactory.createFile("text");
        textFile.open();
        textFile.save();
        textFile.close();

        File imageFile = FileFactory.createFile("image");
        imageFile.open();
        imageFile.save();
        imageFile.close();

        File audioFile = FileFactory.createFile("audio");
        audioFile.open();
        audioFile.save();
        audioFile.close();
    }
}
```

The main class Main creates different types of files using the FileFactory class, and calls the `open()`, `save()`, and `close()` operations on each. In this way, the Factory pattern is used to create different file objects according to the file type.
