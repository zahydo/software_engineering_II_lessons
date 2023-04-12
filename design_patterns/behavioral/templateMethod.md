# Template Method

 is a behavioral design pattern that defines the skeleton of an algorithm in the superclass but lets subclasses override specific steps of the algorithm without changing its structure.

## Problem

Imagine that you’re creating a data mining application that analyzes corporate documents. Users feed the app documents in various formats (PDF, DOC, CSV), and it tries to extract meaningful data from these docs in a uniform format.

The first version of the app could work only with DOC files. In the following version, it was able to support CSV files. A month later, you “taught” it to extract data from PDF files.

At some point, you noticed that all three classes have a lot of similar code. While the code for dealing with various data formats was entirely different in all classes, the code for data processing and analysis is almost identical. Wouldn’t it be great to get rid of the code duplication, leaving the algorithm structure intact?

There was another problem related to client code that used these classes. It had lots of conditionals that picked a proper course of action depending on the class of the processing object. If all three processing classes had a common interface or a base class, you’d be able to eliminate the conditionals in client code and use polymorphism when calling methods on a processing object.

## Solution

The Template Method pattern suggests that you break down an algorithm into a series of steps, turn these steps into methods, and put a series of calls to these methods inside a single template method. The steps may either be abstract, or have some default implementation. To use the algorithm, the client is supposed to provide its own subclass, implement all abstract steps, and override some of the optional ones if needed (but not the template method itself).

At first, we can declare all steps abstract, forcing the subclasses to provide their own implementations for these methods.

As you can see, we’ve got two types of steps:

--abstract steps must be implemented by every subclass
--optional steps already have some default implementation, but still can be overridden if needed

There’s another type of step, called hooks. A hook is an optional step with an empty body. A template method would work even if a hook isn’t overridden. Usually, hooks are placed before and after crucial steps of algorithms, providing subclasses with additional extension points for an algorithm.

## Diagram of example:
![ClassDiagram](http://www.plantuml.com/plantuml/png/bP31IiGm48RlUOeSAw4l8285KKz2GM_YOTeCTN2Ib6GgQksxMrC3bLqMzXJuVxvlCjCaWIYJOmLTaWYzw9uX9NqF3lMivX8l-ZsGrUH929Y-iBeuABEhPVWyqg6tVuqPjtTHQXjr4wb_GrcdcNzwi_UP8jY1To581ypdaq_eHWR11vJNO5iGmUXlFs1DyTVcW7m5SKYN-b4Y-U7v9TCdkVewNqtbqrrzrtNPR9UKBwi6lPqS_m00)

## Example

In this example, we have an abstract Game class that defines the template method play(), which defines the steps in the algorithm for playing a game. The initialize(), startPlay(), and endPlay() methods are abstract and must be implemented by subclasses.

```Java
// The abstract class that defines the template method and the steps in the algorithm.
abstract class Game {
    // The template method that defines the steps in the algorithm.
    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }

    // Abstract methods that subclasses must implement.
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
}
```
The Cricket and Football classes extend the Game class and provide implementations for the abstract methods.

```Java
// The concrete class that extends the abstract class and provides implementations for the abstract methods.
class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket game initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket game started! Enjoy the game.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket game finished!");
    }
}

// The concrete class that extends the abstract class and provides implementations for the abstract methods.
class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football game initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football game started! Enjoy the game.");
    }

    @Override
    void endPlay() {
        System.out.println("Football game finished!");
    }
}
```
In the main() method, we create instances of Cricket and Football and call the play() method on them. This demonstrates how the Template Method pattern allows us to define the overall structure of an algorithm in an abstract class, while allowing concrete subclasses to provide specific implementations for certain steps.

```Java

// The main class that uses the Template Method pattern.
public class TemplateMethodPatternExample {
    public static void main(String[] args) {
        // Create a cricket game and play it.
        Game cricket = new Cricket();
        cricket.play();

        System.out.println();

        // Create a football game and play it.
        Game football = new Football();
        football.play();
    }
}
```
When we run the code, we get the following output:

```sql
Cricket game initialized! Start playing.
Cricket game started! Enjoy the game.
Cricket game finished!

Football game initialized! Start playing.
Football game started! Enjoy the game.
Football game finished!
```

This demonstrates how the play() method in the Game class defines the overall structure for playing a game, while the concrete subclasses provide specific implementations for the initialize(), startPlay(), and endPlay() methods.

[Back](../behavioral/README.md)