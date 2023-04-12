# Command Patter 

It is a behavior design pattern that allows requesting an operation to an object without actually knowing the content of this operation or the actual recipient of it. To do this, the request is encapsulated as an object, which also facilitates the parameterization of the methods.

Suppose we have a smart home with different rooms, and we want to implement a system so that users can control the lights in each room using a remote control. To do this, we can use the command pattern.

## Example

First, we create a command interface which will have a execute method.

```Java
public interface Command {
    void execute();
}
```
Now we create the receiver that is responsible for receiving the command that indicates whether the lights should be turned off or on

```Java
// Receptor del comando
public class Light {
    public void turnOn() {
        System.out.println("Light is on");
    }

    public void turnOff() {
        System.out.println("Light is off");
    }
}
``` 

Then, implementing the interface ``Command``, we create several concrete commands to control the lights of the different avitations. 

```Java
public class TurnOnLivingRoomLightsCommand implements Command {
    private final LivingRoomLights livingRoomLights;

    public TurnOnLivingRoomLightsCommand(LivingRoomLights livingRoomLights) {
        this.livingRoomLights = livingRoomLights;
    }

    @Override
    public void execute() {
        livingRoomLights.turnOn();
    }
}

public class TurnOffLivingRoomLightsCommand implements Command {
    private final LivingRoomLights livingRoomLights;

    public TurnOffLivingRoomLightsCommand(LivingRoomLights livingRoomLights) {
        this.livingRoomLights = livingRoomLights;
    }

    @Override
    public void execute() {
        livingRoomLights.turnOff();
    }
}

public class TurnOnBedroomLightsCommand implements Command {
    private final BedroomLights bedroomLights;

    public TurnOnBedroomLightsCommand(BedroomLights bedroomLights) {
        this.bedroomLights = bedroomLights;
    }

    @Override
    public void execute() {
        bedroomLights.turnOn();
    }
}

public class TurnOffBedroomLightsCommand implements Command {
    private final BedroomLights bedroomLights;

    public TurnOffBedroomLightsCommand(BedroomLights bedroomLights) {
        this.bedroomLights = bedroomLights;
    }

    @Override
    public void execute() {
        bedroomLights.turnOff();
    }
}
```

In these commands, we use different light objects to control the lights in each room. Each command has a ``execute`` method that calls the corresponding method on the lights object.

Finally, we create a class called ``remoteControl`` that will have the different buttons that will call the commands that will turn on the lights in the house and another method to assign a specific command to a specific button.

```Java
public class remoteControl {
    private final Command[] commands;

    public RemoteControl() {
        commands = new Command[4];
    }

    public void setCommand(int slot, Command command) {
        commands[slot] = command;
    }

    public void remoteControl.buttonWasPressed();(int slot) {
        commands[slot].execute();
    }
}
```
Now we can use these commands and the ``remoteControl`` class to control the lights in our house:

```Java
public class Main {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        LivingRoomLights livingRoomLights = new LivingRoomLights();
        BedroomLights bedroomLights = new BedroomLights();

        Command turnOnLivingRoomLightsCommand = new TurnOnLivingRoomLightsCommand(livingRoomLights);

        remoteControl.setCommand(0,livingRoomLights.turnOn);
        remoteControl.buttonWasPressed();
    }
}
```
