# Proxy pattern

The Proxy pattern is a structural design pattern that involves a class representing the functionality of another class. It provides a surrogate object that controls access to the real object, allowing for additional functionality such as access control, caching, or lazy initialization.

This pattern is particularly useful when you want to control access to a resource, optimize performance, or add functionality to an object without changing its implementation.

<p align="center">
<img src="https://res.cloudinary.com/dzxhdnqm4/image/upload/v1681172218/uml_proxy_idrwa0.png" alt="uml-proxy" width="65%">
</p>

## 😟 Problem

Imagine you are developing an application that retrieves large images from a remote server. Loading large images takes time and consumes bandwidth. If you fetch the images directly every time they are needed, the application performance will be negatively affected.

Without an appropriate solution, you'll face:

1. Slow application performance
2. Unnecessary bandwidth consumption
3. Difficulty in implementing access control

Here is the problematic code without using the Proxy pattern:

```java
public interface Image {
    void displayImage();
}

public class RealImage implements Image {
    private String imageUrl;

    public RealImage(String imageUrl) {
        this.imageUrl = imageUrl;
        loadImageFromServer();
    }

    private void loadImageFromServer() {
        System.out.println("Loading image from server: " + imageUrl);
    }

    public void displayImage() {
        System.out.println("Displaying image: " + imageUrl);
    }
}
```

In this example, the `RealImage` class loads the image from the server in its constructor. Every time a new `RealImage` object is created, the image is fetched from the server, causing slow performance and consuming bandwidth.

## 🙂 Solution

The Proxy pattern addresses these issues by creating a new class that implements the same interface as the real object and contains a reference to the real object. The proxy class controls access to the real object and adds functionality like caching or lazy loading.

Here is an implementation of the Proxy pattern in Java:

```java
public class ImageProxy implements Image {
    private RealImage realImage;
    private String imageUrl;

    public ImageProxy(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void displayImage() {
        if (realImage == null) {
            realImage = new RealImage(imageUrl);
        }
        realImage.displayImage();
    }
}
```

In this example, we create a new class `ImageProxy` that implements the Image interface. It contains a reference to a `RealImage` object and only creates the object when the `displayImage()` method is called. This is known as lazy loading. When the `displayImage()` method is called again, the cached `RealImage` object is used, avoiding the need to load the image from the server again.

```java
public class ProxyDemo {
    public static void main(String[] args) {
        Image image = new ImageProxy("http://example.com/large-image.jpg");
        image.displayImage(); // Image is loaded and displayed
        image.displayImage(); // Image is displayed from cache, no additional loading
    }
}
```

With the Proxy pattern, we can now control access to the `RealImage` object, optimize performance, and reduce bandwidth consumption.

In summary, the Proxy pattern allows controlling access to an object by creating a surrogate object that implements the same interface as the real object. In this example, the `ImageProxy` class acts as a proxy for the `RealImage` class, providing caching and lazy loading functionality.
