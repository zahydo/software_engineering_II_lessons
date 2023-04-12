# State

State is a behavioral design pattern that lets an object alter its behavior when its internal state changes. It appears as if the object changed its class.

The State pattern is closely related to the concept of a Finite-State Machine.
The main idea is that, at any given moment, there’s a finite number of states which a program can be in. Within any unique state, the program behaves differently, and the program can be switched from one state to another instantaneously. However, depending on a current state, the program may or may not switch to certain other states. These switching rules, called transitions, are also finite and predetermined.

The State pattern suggests that you create new classes for all possible states of an object and extract all state-specific behaviors into these classes.

Instead of implementing all behaviors on its own, the original object, called context, stores a reference to one of the state objects that represents its current state, and delegates all the state-related work to that object.

## Class Diagram of example:

![ClassDiagram](http://www.plantuml.com/plantuml/png/lPB1Yjim48RlVefXJywXsdlBGfBIynRIM-b1aSUnYYqPQUnkANttZZN8LLetK0Wh247CwDElRxoFf0DDGryzFiAd3k6zTuGl1ARNCG9rcc3GrX7_8cW8s690Pn38SnN1J87t1CmX17_-YeP0kmOQxF6Y2QEKtiGHZMsjWJDsUhO-B0HBgfARyhq_Ak0r1Zill5EY9i2xIYhJkMV8x6q34Iarr4NRBX5aKMUZac1F6GAyVlwDQlp1aFMkBixB4RMM5jmk4vYHZEMCh0X3gmsAimPRwp0cHGDIvvi8hGzf_myVgigCp9Gar_dM-SW_v_cTX6ic864wVIX7Q8Unnm4TyNuZyZAlCVZPDX9vpPGoYy53CQdobW9Tfju_pnW20qlLjvzIc3zzZuI3yXEfCN3EtjKFGkSB8oEiku2b23gXr4EQIrePfzQlm-6twz37UhSnn-kMEzixRjexlhQzunti7JRj3TgwqjaKiRGrQY8CJbNo5kcKsaSfVNZHx28BaBOaBxzykQ4-KU3mdx-03fTOllaF7V044ZpjQWvSTfRVRvI_jRzyw2qlSgu4vvOy8ZuERETved6Yjt3h-_q_nlOKxvH3nhf7rqn3_mi0)

## Example

The Context class that maintains a reference to the current state object and delegates state-specific behavior to it.

```Java
class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    // Method that delegates state-specific behavior to the current state object.
    public void doAction() {
        state.doAction(this);
    }
}
```

The State interface defines the method doAction(), which is implemented by the concrete state classes ConcreteStateA and ConcreteStateB.

```Java
interface State {
    void doAction(Context context);
}

```
The ConcreteStateA class that implements the State interface and provides the behavior for state A.
When doAction() is called on a concrete state object, it executes its specific behavior and changes the current state to the opposite state. For example, when ConcreteStateA's doAction() method is called, it outputs a message and changes the current state to ConcreteStateB.

```Java
class ConcreteStateA implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("State A is doing its action.");

        // Change the current state to ConcreteStateB.
        context.setState(new ConcreteStateB());
    }
}
```
The ConcreteStateB class that implements the State interface and provides the behavior for state B.

```Java
class ConcreteStateB implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("State B is doing its action.");

        // Change the current state to ConcreteStateA.
        context.setState(new ConcreteStateA());
    }
}
```
The main class that uses the State pattern.

Finally, in the main() method, we create a new Context object and set its initial state to ConcreteStateA. We then call doAction() three times to alternate between the two states and output the corresponding messages.

```Java
public class StatePatternExample {
    public static void main(String[] args) {
        // Create a new context object.
        Context context = new Context();

        // Set the initial state to ConcreteStateA.
        ConcreteStateA stateA = new ConcreteStateA();
        context.setState(stateA);

        // Call doAction three times to alternate between states A and B.
        context.doAction(); // Output: State A is doing its action.
        context.doAction(); // Output: State B is doing its action.
        context.doAction(); // Output: State A is doing its action.
    }
}
```
[Back](../behavioral/README.md)
