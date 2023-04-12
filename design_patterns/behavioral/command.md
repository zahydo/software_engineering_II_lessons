# Command pattern

## Description
Command pattern is a behavioral design pattern that encapsulates a request as an object, thereby allowing for the parameterization of clients with different requests, queue or log requests, and support undoable operations.

The Command pattern involves four main components: the Command, Receiver, Invoker, and Client. The Command interface defines the contract for executing the command, the Receiver knows how to execute the command, the Invoker sends a command to the receiver to perform an action, and the Client creates the Command object and sets its receiver.

This pattern provides a way to decouple the object that invokes the operation from the one that knows how to perform it. It also provides a mechanism for undoing operations, by storing a history of commands.

## Problem
Let's say we're developing a remote control for a TV. We want to create a set of commands that can be executed by the remote control, such as turning the TV on/off, changing channels, and adjusting the volume. We also want to be able to undo the previous command.
## Solution

```java
public interface Command {
    void execute();
    void undo();
}

public class TurnOnCommand implements Command {
    private final TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOn();
    }

    @Override
    public void undo() {
        tv.turnOff();
    }
}

public class TurnOffCommand implements Command {
    private final TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    @Override
    public void execute() {
        tv.turnOff();
    }

    @Override
    public void undo() {
        tv.turnOn();
    }
}

public class TV {
    public void turnOn() {
        System.out.println("Turning on TV");
    }

    public void turnOff() {
        System.out.println("Turning off TV");
    }

}

public class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }

    public void pressUndo() {
        command.undo();
    }
}


TV tv = new TV();

TurnOnCommand turnOnCommand = new TurnOnCommand(tv);
TurnOffCommand turnOffCommand = new TurnOffCommand(tv);

RemoteControl remoteControl = new RemoteControl();
remoteControl.setCommand(turnOnCommand);
remoteControl.pressButton(); 
remoteControl.setCommand(turnOffCommand);
remoteControl.pressButton(); 
remoteControl.pressUndo();
```

This way, the RemoteControl object can execute different commands without knowing how they are executed, and the TV object knows how to execute the commands without knowing who is sending them. We can also undo the previous command by storing a history of commands.