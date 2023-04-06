# Proxy pattern

The proxy pattern is a design pattern that provides a substitute or placeholder for another object to control its access, creation, or behavior. A proxy object allows the client to interact with the original object through an interface and provides an additional layer of abstraction for handling the requests and responses to the original object

First, we will create an interface called Image that defines the operations that can be performed on an image:

```java
public interface Image {
    void display();
}
```
Next, we will create a concrete class RealImage that implements the Image interface:

```java
public class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadImageFromDisk();
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }

    private void loadImageFromDisk() {
        System.out.println("Loading " + fileName);
    }
}
```

Finally, we will create a ProxyImage class that also implements the Image interface. ProxyImage maintains a reference to an instance of RealImage and only creates and loads it into memory when necessary:

```java
public class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }
}
```

This way, we can use ProxyImage to access an image without having to load it into memory until it is actually needed. Here's an example of how it could be used:

```java
public class Main {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // Image 1 is loaded into memory and displayed
        image1.display();

        // Image 2 is not yet loaded into memory
        image2.display();

        // Image 2 is loaded into memory and displayed
        image2.display();
    }
}
```

The image1 is loaded into memory and displayed when display() is called for the first time. image2, on the other hand, is only loaded into memory when display() is called for the first time and then displayed in both calls to display().

## Diagram

![Proxy](https://user-images.githubusercontent.com/67757313/230486607-ae30ef46-271d-45d6-8669-0def003f622f.jpg)

[Back to the list](./README.md)