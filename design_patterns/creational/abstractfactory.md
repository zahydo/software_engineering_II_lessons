# Abstract Factory 
## Description
The Abstract Factory design pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It is an extension of the Factory Method pattern, which creates objects through inheritance, whereas the Abstract Factory pattern creates families of related objects through composition.
## Problem:
In some scenarios, a system may need to create families of related or dependent objects, but the exact classes of those objects may not be known in advance.


## Solution:
The Abstract Factory pattern provides a solution to the above problem by defining an abstract factory interface that encapsulates the creation of families of related or dependent objects. Concrete factory classes implement this interface to create concrete products that belong to the same family. The client code uses the abstract factory interface to create the desired objects, without knowing the exact classes that are being instantiated.
## Example: 
Let's say we're building a game that can be played on multiple platforms, such as Windows and Mac OS, and we want to ensure that the game's graphics and audio are optimized for each platform. We can use the Abstract Factory pattern to create families of related graphics and audio objects for each platform.
### Structure

<p align="center">
    <img src="./diagrams/abstractfactory.svg"/>
</p>


### Implementation

First, we define abstract interfaces for our graphics and audio objects. For example, we might define an abstract `IButton` interface that includes methods for rendering the button and handling user input, and an abstract `ISound` interface that includes methods for playing and stopping the sound.

```Java
// Abstract interface for graphics objects
interface IButton {
    void render();
    void onClick();
}

// Abstract interface for audio objects
interface ISound {
    void play();
    void stop();
}


```


Next, we create concrete implementations of these interfaces for each platform we want to support. For example, we might create a `WindowsButton` class that implements the `IButton` interface and is optimized for Windows, and a `MacOSButton` class that implements the same interface but is optimized for Mac OS. We do the same for our `ISound` objects.



``` Java
// Concrete implementation of Button for Windows
class WindowsButton implements IButton {
    public void render() {
        // Windows-specific rendering logic
    }

    public void onClick() {
        // Windows-specific click handling logic
    }
}

// Concrete implementation of Button for Mac OS
class MacOSButton implements IButton {
    public void render() {
        // Mac OS-specific rendering logic
    }

    public void onClick() {
        // Mac OS-specific click handling logic
    }
}


// Concrete implementation of Sound for Windows
class WindowsSound implements ISound {
    public void play() {
        // Windows-specific play logic
    }

    public void stop() {
        // Windows-specific stop logic
    }
}

// Concrete implementation of Sound for Mac OS
class MacOSSound implements ISound {
    public void play() {
        // Mac OS-specific play logic
    }

    public void stop() {
        // Mac OS-specific stop logic
    }
}

```

We then create an abstract `IGameObjectFactory` interface that includes methods for creating all the graphics and audio objects we need in our game. 


``` Java

// Abstract factory interface
interface IGameObjectFactory {
    IButton createButton();
    ISound createSound();
}

```

We also create concrete implementations of `IGameObjectFactory` for each platform we want to support. For example, we might create a `WindowsGameObjectFactory` class that implements `IGameObjectFactory` and creates Windows-optimized graphics and audio objects, and a `MacOSGameObjectFactory` class that creates Mac OS-optimized graphics and audio objects.


``` Java
// Concrete factory implementation for Windows
class WindowsGameObjectFactory implements IGameObjectFactory {
    public IButton createButton() {
        return new WindowsButton();
    }

    public ISound createSound() {
        return new WindowsSound();
    }
}

// Concrete factory implementation for Mac OS
class MacOSGameObjectFactory implements IGameObjectFactory {
    public IButton createButton() {
        return new MacOSButton();
    }

    public ISound createSound() {
        return new MacOSSound();
    }
}
```

Finally, in our game code, we use a `IGameObjectFactory` object to create all of the graphics and audio objects we need. For example, we might create a `Game` class that takes a `IGameObjectFactory` object as a constructor parameter, and then uses that factory to create all of the `IButton` and `ISound` objects it needs.

``` Java
// Game class that uses the abstract factory to create graphics and audio objects
class Game {
    private IButton button;
    private ISound sound;

    public Game(IGameObjectFactory factory) {
        button = factory.createButton();
        sound = factory.createSound();
    }

    public void playSound() {
        sound.play();
    }

    public void stopSound() {
        sound.stop();
    }

    public void renderButton() {
        button.render();
    }

    public void handleClick() {
        button.onClick();
    }
}
```

This way, our game can support multiple platforms without having to hard-code platform-specific graphics and audio objects throughout the codebase. Instead, we use the Abstract Factory pattern to create families of related objects based on the current platform; the client code might look like this:

``` Java
// Client code that uses the game and abstract factory
public class Main {
    public static void main(String[] args) {
        // Determine the current platform
        String platform = System.getProperty("os.name").toLowerCase();
        IGameObjectFactory factory;

        // Create the appropriate factory based on the platform
        if (platform.contains("windows")) {
            factory = new WindowsGameObjectFactory();
        } else if (platform.contains("mac")) {
            factory = new MacOSGameObjectFactory();
        } else {
            throw new UnsupportedOperationException("Unsupported platform");
        }

        // Create the game using the appropriate factory
        Game game = new Game(factory);

        // Play the game
        game.playSound();
        game.renderButton();
        game.handleClick();
        game.stopSound();
    }
}
```