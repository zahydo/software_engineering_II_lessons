# Observer pattern

## Description
The Observer pattern is a behavioral design pattern that establishes a one-to-many relationship between objects, such that when one object changes its state, it automatically notifies all objects that depend on it. This pattern helps decouple objects and increase flexibility and maintainability in software systems. It allows for dynamic addition and removal of observers at runtime and can reduce code duplication and increase code cohesion. As a systems engineering student, understanding and applying the Observer pattern can be useful in designing complex software systems.

## Problem
You are tasked with building a system to monitor temperature readings from multiple sensors in a factory. Whenever a sensor reading exceeds a certain threshold, an alert should be triggered to notify the maintenance team to investigate the issue.
Implement the system using the Observer pattern.

## Solution
```java
interface TemperatureSensor {
    void subscribe(MaintenanceTeam maintenanceTeam);
    void unsubscribe(MaintenanceTeam maintenanceTeam);
    void notifyMaintenanceTeams();
}

class FactoryTemperatureSensor implements TemperatureSensor {
    private List<MaintenanceTeam> maintenanceTeams = new ArrayList<>();
    private int temperature;
    private int threshold = 100;

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        if (temperature > threshold) {
            notifyMaintenanceTeams();
        }
    }

    @Override
    public void subscribe(MaintenanceTeam maintenanceTeam) {
        maintenanceTeams.add(maintenanceTeam);
    }

    @Override
    public void unsubscribe(MaintenanceTeam maintenanceTeam) {
        maintenanceTeams.remove(maintenanceTeam);
    }

    @Override
    public void notifyMaintenanceTeams() {
        for (MaintenanceTeam maintenanceTeam : maintenanceTeams) {
            maintenanceTeam.notify(this);
        }
    }
}

interface MaintenanceTeam {
    void notify(TemperatureSensor temperatureSensor);
}

class ElectricalMaintenanceTeam implements MaintenanceTeam {
    @Override
    public void notify(TemperatureSensor temperatureSensor) {
        System.out.println("Electrical maintenance team notified about high temperature: " + temperatureSensor);
    }
}

class MechanicalMaintenanceTeam implements MaintenanceTeam {
    @Override
    public void notify(TemperatureSensor temperatureSensor) {
        System.out.println("Mechanical maintenance team notified about high temperature: " + temperatureSensor);
    }
}

public class Main {
    public static void main(String[] args) {
        TemperatureSensor sensor1 = new FactoryTemperatureSensor();
        MaintenanceTeam electricalTeam = new ElectricalMaintenanceTeam();
        MaintenanceTeam mechanicalTeam = new MechanicalMaintenanceTeam();

        sensor1.subscribe(electricalTeam);
        sensor1.subscribe(mechanicalTeam);

        sensor1.setTemperature(50);

        sensor1.unsubscribe(mechanicalTeam);

        sensor1.setTemperature(32);
    }
}

```
Observer pattern by allowing multiple maintenance teams to subscribe to a temperature sensor and receive notifications whenever the temperature exceeds a threshold.