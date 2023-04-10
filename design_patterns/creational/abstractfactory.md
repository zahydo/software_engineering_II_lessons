#  Abstract Factory

The "Abstract Factory" design pattern solves the problem of creating families of related objects without having to explicitly specify their concrete classes. The pattern provides an interface for creating related objects without specifying their concrete classes, which allows changing the families of objects that are created without changing the code that uses them.

The idea behind the pattern is to create an abstract factory that defines a set of methods to create each of the object types that make up the family. Then, different implementations of the abstract factory can be created to create different families of objects. The abstract factory is used to hide the details of object creation and provide a generic way to create related objects.

The Abstract Factory pattern is implemented by creating an abstract interface or class that defines the methods to create the objects. Then, several concrete classes that implement the abstract interface are created to create different families of objects. Finally, a "Factory" class is created that uses the abstract interface to create objects of the corresponding family.

## Diagram class of example
![ClassDiagram](http://www.plantuml.com/plantuml/png/hL31YeCm4BtdAt9K5lq0MHRTWx27fGSfFKzZB86OI3AsbBR_NZKvc61l1WB3l7dlpRpI8XWSUqc4GcuwO9nMPui66DRJr-PE7uHExuiomm7vxuYeLP8Mr5K1M1le-Omj1NaHmYHOIqz2jVfcTrJy1tPeTjIhXa4A1YYqyd8PxPny4IVY1LUKf44Zr2KDh8v_iyzLYtQsYLFzVkPvbClcJ70fMQ-PPJ_nPZ7k4uZR_lZGVG5yozC-3pY1rMeENHgUl0qwOibLE_Ro3G00)

## Example

Suppose we have two families of objects: Buttons and Boxes. Each family has two variants: Buttons for Windows and Buttons for MacOS, Frames for Windows and Frames for MacOS. We want to create an application that can use the different variants depending on the operating system it runs on.

First, we create an "AbstractFactory" interface that defines the methods to create the objects:

``` java
public interface AbstractFactory {
    public Button createButton();
    public Frame createFrame();
}
```
Then, we create the concrete classes that implement the interface for each of the object families:
``` java
public class WindowsFactory implements AbstractFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Frame createFrame() {
        return new WindowsFrame();
    }
}

public class MacOSFactory implements AbstractFactory {
    public Button createButton() {
        return new MacOSButton();
    }

    public Frame createFrame() {
        return new MacOSFrame();
    }
}
```
Finally, we create an "Application" class that uses the "AbstractFactory" interface to create objects of the corresponding family according to the operating system in which it is executed:
``` java
public class Application {
    private AbstractFactory factory;

    public Application(String os) {
        if (os.equals("Windows")) {
            factory = new WindowsFactory();
        } else if (os.equals("MacOS")) {
            factory = new MacOSFactory();
        }
    }

    public void createUI() {
        Button button = factory.createButton();
        Frame frame = factory.createFrame();
        // ...
    }
}
```
In this example, the "Application" class uses the "AbstractFactory" interface to create objects of the corresponding family according to the operating system on which it runs. The "WindowsFactory" class creates objects of the Windows family and the "MacOSFactory" class creates objects of the MacOS family. The "Application" class creates objects using the abstract factory and does not know the concrete details of object creation.

[Back](../creational/README.md)