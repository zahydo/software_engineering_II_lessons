# Proxy pattern

## Description

<<<<<<< HEAD
The proxy pattern is a design pattern that provides a substitute or placeholder for another object to control its access, creation, or behavior. A proxy object allows the client to interact with the original object through an interface and provides an additional layer of abstraction for handling the requests and responses to the original object

## Problem:

We are developing an application to access a remote server that stores and processes large amounts of data. However, due to limitations in the network or server, direct connection to this server may be slow or unreliable. To solve this problem, we can use the Proxy pattern.

## Solution:

The solution would be to create a Proxy object that acts as an intermediary between the application and the remote server. The Proxy will handle communication with the server and optimize data transfer, so that the application can access the data more quickly and efficiently.

## Example:

The Proxy pattern is useful when we need to control access to a resource, such as a large image, that is expensive to create or load into memory. We'll use the ProxyImage class to control access to RealImage objects that represent images on disk.

### Structure:

<p align="center">
    <img src="diagrams/Proxy.drawio.svg"/>
</p>

### Implementation:

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
=======
In proxy pattern, a class represents functionality of another class. This type of design pattern comes under structural pattern.

In proxy pattern, we create object having original object to interface its functionality to outer world.

### Example

In this example, we have a Subject interface called Internet which defines the interface for the Real subject class and the Proxy class.

```Java
// Subject interface
public interface Internet {
    void connectTo(String serverHost) throws Exception;
}
```

We have a Real subject class called RealInternet which implements the Internet interface and represents the actual object that the client wants to use.

```Java
// Real subject class
public class RealInternet implements Internet {
    public void connectTo(String serverHost) throws Exception {
        System.out.println("Connecting to " + serverHost);
>>>>>>> 1cd8696 (Update info)
    }
}
```

<<<<<<< HEAD
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
=======
We also have a Proxy class called InternetProxy which also implements the Internet interface and acts as a proxy for the RealInternet object. The InternetProxy class maintains a set of blocked websites and prevents the client from accessing those websites by throwing an exception.

```Java
// Proxy class
public class InternetProxy implements Internet {
    private Internet internet;
    private Set<String> blockedSites;

    public InternetProxy() {
        internet = new RealInternet();
        blockedSites = new HashSet<>();
        blockedSites.add("facebook.com");
        blockedSites.add("twitter.com");
    }

    public void connectTo(String serverHost) throws Exception {
        if (blockedSites.contains(serverHost)) {
            throw new Exception("Access Denied to " + serverHost);
        }

        internet.connectTo(serverHost);
>>>>>>> 1cd8696 (Update info)
    }
}
```

<<<<<<< HEAD
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

[Back to the list](./README.md)
=======
In the client code, we create an instance of the InternetProxy class and use it to connect to Google, Facebook, and Twitter. We can see that access to Facebook and Twitter is denied because they are blocked by the InternetProxy.

```Java
// Client code
public class Client {
    public static void main(String[] args) throws Exception {
        Internet internet = new InternetProxy();

        internet.connectTo("google.com");
        internet.connectTo("facebook.com"); // Access denied
        internet.connectTo("twitter.com"); // Access denied
    }
    
}
```

By using the Proxy pattern, we can add an additional layer of security or functionality to our program without modifying the original code. This can be useful when we want to control access to an object or add logging, caching, or other features.

The result will be the following.

```Java
//To google
run:
Connecting to google.com
BUILD SUCCESSFUL (total time: 0 seconds)
```

```Java
//To Facebook
run:
Exception in thread "main" java.lang.Exception: Access Denied to facebook.com
	at proxy.InternetProxy.connectTo(InternetProxy.java:19)
	at proxy.Client.main(Client.java:9)
BUILD FAILED (total time: 0 seconds)
```

```Java
//To Twitter
run:
Exception in thread "main" java.lang.Exception: Access Denied to twitter.com
	at proxy.InternetProxy.connectTo(InternetProxy.java:19)
	at proxy.Client.main(Client.java:10)
BUILD FAILED (total time: 0 seconds)
```

Next, we have the diagram class of Proxy example:

![Proxy](Diagrams/Proxy.jpg)

A description of the Proxy pattern:

![Proxy](Diagrams/ProxyDescription.jpg)
Image taken from https://refactoring.guru/design-patterns/proxy
>>>>>>> 1cd8696 (Update info)
