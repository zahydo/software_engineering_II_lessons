# Strategy

Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

## Problem

One day you decided to create a navigation app for casual travelers. The app was centered around a beautiful map which helped users quickly orient themselves in any city.

One of the most requested features for the app was automatic route planning. A user should be able to enter an address and see the fastest route to that destination displayed on the map.

The first version of the app could only build the routes over roads. People who traveled by car were bursting with joy. But apparently, not everybody likes to drive on their vacation. So with the next update, you added an option to build walking routes. Right after that, you added another option to let people use public transport in their routes.

However, that was only the beginning. Later you planned to add route building for cyclists. And even later, another option for building routes through all of a city’s tourist attractions.

While from a business perspective the app was a success, the technical part caused you many headaches. Each time you added a new routing algorithm, the main class of the navigator doubled in size. At some point, the beast became too hard to maintain.

Any change to one of the algorithms, whether it was a simple bug fix or a slight adjustment of the street score, affected the whole class, increasing the chance of creating an error in already-working code.

In addition, teamwork became inefficient. Your teammates, who had been hired right after the successful release, complain that they spend too much time resolving merge conflicts. Implementing a new feature requires you to change the same huge class, conflicting with the code produced by other people.

## Solution

The Strategy pattern suggests that you take a class that does something specific in a lot of different ways and extract all of these algorithms into separate classes called strategies.

The original class, called context, must have a field for storing a reference to one of the strategies. The context delegates the work to a linked strategy object instead of executing it on its own.

The context isn’t responsible for selecting an appropriate algorithm for the job. Instead, the client passes the desired strategy to the context. In fact, the context doesn’t know much about strategies. It works with all strategies through the same generic interface, which only exposes a single method for triggering the algorithm encapsulated within the selected strategy.

This way the context becomes independent of concrete strategies, so you can add new algorithms or modify existing ones without changing the code of the context or other strategies.

In our navigation app, each routing algorithm can be extracted to its own class with a single buildRoute method. The method accepts an origin and destination and returns a collection of the route’s checkpoints.

Even though given the same arguments, each routing class might build a different route, the main navigator class doesn’t really care which algorithm is selected since its primary job is to render a set of checkpoints on the map. The class has a method for switching the active routing strategy, so its clients, such as the buttons in the user interface, can replace the currently selected routing behavior with another one.

## Example

In this example, we have two concrete strategies ConcreteStrategyAdd and ConcreteStrategySubtract that implement the Strategy interface, which defines the doOperation() method for performing the strategy.
```Java
//The Strategy interface that defines the method for the strategy.
interface Strategy {
    int doOperation(int num1, int num2);
}

// The ConcreteStrategyAdd class that implements the Strategy interface and provides the behavior for addition.
class ConcreteStrategyAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

// The ConcreteStrategySubtract class that implements the Strategy interface and provides the behavior for subtraction.
class ConcreteStrategySubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
```
The Context class uses the Strategy pattern to perform operations on two numbers. It maintains a reference to a Strategy object and delegates the operation to it via the executeStrategy() method.

```Java
class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    // Method that delegates the operation to the strategy object.
    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
```
In the main() method, we create two numbers num1 and num2 to perform operations on. We also create two strategy objects addStrategy and subtractStrategy for addition and subtraction, respectively.

We then create a Context object with the addition strategy and perform an addition operation using the executeStrategy() method. We output the result to the console.

Finally, we change the Context object's strategy to subtraction and perform another operation using the same executeStrategy() method. We output the result to the console again.

This example demonstrates how the Strategy pattern allows us to easily swap out strategies and perform different operations on the same data.

```Java

// The main class that uses the Strategy pattern.
public class StrategyPatternExample {
    public static void main(String[] args) {
        // Create two numbers to perform operations on.
        int num1 = 10;
        int num2 = 5;

        // Create two strategy objects: one for addition, one for subtraction.
        Strategy addStrategy = new ConcreteStrategyAdd();
        Strategy subtractStrategy = new ConcreteStrategySubtract();

        // Create a context object with the addition strategy and perform an operation.
        Context context = new Context(addStrategy);
        int result = context.executeStrategy(num1, num2);
        System.out.println(num1 + " + " + num2 + " = " + result);

        // Change the context's strategy to subtraction and perform another operation.
        context = new Context(subtractStrategy);
        result = context.executeStrategy(num1, num2);
        System.out.println(num1 + " - " + num2 + " = " + result);
    }
}

