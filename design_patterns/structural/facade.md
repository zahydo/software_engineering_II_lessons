# Facade pattern

In software development, a facade is a design pattern that provides a simplified interface to a set of more complex subsystems. The facade acts as an abstraction layer that hides the complexity of the underlying system and provides an easy-to-use interface for the client. In other words, the facade is a class that wraps a set of more complex classes and provides a simple, easy-to-use interface for interacting with them.

Suppose we have a music system with several complex classes and methods that interact with each other. Instead of exposing all these details to the user, we can create a facade that offers a simplified interface for the most common operations. Let's see how this could be implemented in Java:

```java
// We create a facade class that encapsulates the complexity of the music system
public class MusicFacade {
    private Amplifier amplifier;
    private CDPlayer cdPlayer;
    private Speakers speakers;

    public MusicFacade() {
        this.amplifier = new Amplifier();
        this.cdPlayer = new CDPlayer();
        this.speakers = new Speakers();
    }

    // We offer a simple method to turn on the music system
    public void turnOn() {
        System.out.println("Turning on the music system...");
        amplifier.turnOn();
        cdPlayer.turnOn();
        speakers.turnOn();
    }

    // We offer a simple method to turn off the music system
    public void turnOff() {
        System.out.println("Turning off the music system...");
        amplifier.turnOff();
        cdPlayer.turnOff();
        speakers.turnOff();
    }

    // We offer a simple method to play a CD
    public void playCD() {
        System.out.println("Playing CD...");
        cdPlayer.insertCD();
        amplifier.increaseVolume();
        speakers.turnOn();
    }
}

// We create some of the complex classes that are part of the music system
public class Amplifier {
    public void turnOn() {
        System.out.println("Turning on amplifier...");
    }

    public void turnOff() {
        System.out.println("Turning off amplifier...");
    }

    public void increaseVolume() {
        System.out.println("Increasing amplifier volume...");
    }
}

public class CDPlayer {
    public void turnOn() {
        System.out.println("Turning on CD player...");
    }

    public void turnOff() {
        System.out.println("Turning off CD player...");
    }

    public void insertCD() {
        System.out.println("Inserting CD into player...");
    }
}

public class Speakers {
    public void turnOn() {
        System.out.println("Turning on speakers...");
    }

    public void turnOff() {
        System.out.println("Turning off speakers...");
    }
}
```

The MusicFacade class acts as a facade that hides the complexity of the music system and offers simple methods for the most common operations, such as turning on the system, turning it off, or playing a CD. When the user calls one of these methods, the facade interacts with the complex classes of the system to perform the requested task

## Diagram

![Facade](https://user-images.githubusercontent.com/67757313/230486610-9d786b18-c90a-4b38-b34d-165d9a7628b1.jpg)

[Back to the list](./README.md)