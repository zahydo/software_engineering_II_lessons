# Strategy Pattern

The Strategy pattern is a behavioral design technique that defines how objects exchange messages with each other to solve a specific task. With this pattern, it is possible to maintain a set of algorithms in separate classes, allowing client objects to dynamically choose the algorithm that best suits their needs and change it at runtime.

The Strategy pattern is based on the principle of encapsulation, as each algorithm is encapsulated in a separate class, facilitating its reuse and maintenance. Additionally, this pattern promotes code flexibility and extensibility, as it is possible to add new algorithms without modifying the existing code.

A key advantage of the Strategy pattern is that it allows variability in the behavior of an object without having to modify its internal structure. This means that the behavior of an object can be changed simply by changing the strategy used, which is useful in situations where runtime adaptability is required, such as in systems that need to adjust their behavior based on the current situation.

## 🏗️ Estructure
<p align="center">
<img src="https://i.postimg.cc/tgxv5RrX/estrategy-Estructure-drawio.png" alt="mypic" width="75%">
</p>

## 😟 Problem

One day, you decided to create an application for food transportation from various locations. This application will feature different types of vehicles, such as vans, trucks, and tractor-trailers, each with different characteristics that will affect the delivery time and food carrying capacity.

One of the main functions of the application is to facilitate shipments, where food owners can request food pickups. For this, they will need to enter the approximate weight and type of food to be picked up. The application's algorithm should select the most appropriate type of vehicle to carry out this task.

However, the challenge lies in the fact that the application needs to calculate various factors, such as fuel consumption, estimated delivery time, and vehicle carrying capacity. Additionally, there is a possibility of adding other types of vehicles to the product transportation system, which will require adjustments in the algorithm and management of different factors to be taken into account. Having all of these functionalities in a single class may not be very useful in terms of readable code.
~~~java
// Abstract class representing a transportation vehicle
abstract class TransportVehicle {
    protected String type;
    protected double cargoCapacity;
    protected double fuelConsumption;

    public TransportVehicle(String type, double cargoCapacity, double fuelConsumption) {
        this.type = type;
        this.cargoCapacity = cargoCapacity;
        this.fuelConsumption = fuelConsumption;
    }

    public void calculateFactors(double weight, String foodType) {
        // Logic to calculate transportation factors
        double deliveryTime = calculateDeliveryTime(weight, foodType);
        double shippingCost = calculateShippingCost(weight);

        System.out.println("Vehicle type: " + type);
        System.out.println("Estimated delivery time: " + deliveryTime + " hours");
        System.out.println("Estimated shipping cost: $" + shippingCost);
    }

    protected abstract double calculateDeliveryTime(double weight, String foodType);

    protected abstract double calculateShippingCost(double weight);
}

// Different types of transport vehicles
class Van extends TransportVehicle {
    public Van() {
        super("Van", 500.0, 10.0);
    }

    @Override
    protected double calculateDeliveryTime(double weight, String foodType) {
        // Logic for specific calculations of the class

        return 2.5; // Example value for delivery time
    }

    @Override
    protected double calculateShippingCost(double weight) {
        // Logic for specific calculations of the class

        return 50.0; // Example value for shipping cost
    }
}

class Truck extends TransportVehicle {
    public Truck() {
        super("Truck", 2000.0, 20.0);
    }

    @Override
    protected double calculateDeliveryTime(double weight, String foodType) {
        // Logic for specific calculations of the class

        return 4.0; // Example value for delivery time
    }

    @Override
    protected double calculateShippingCost(double weight) {
        // Logic for specific calculations of the class

        return 100.0; // Example value for shipping cost
    }
}

class TractorTrailer extends TransportVehicle {
    public TractorTrailer() {
        super("Tractor-Trailer", 5000.0, 30.0);
    }

    @Override
    protected double calculateDeliveryTime(double weight, String foodType) {
        // Logic for specific calculations of the class

        return 6.0; // Example value for delivery time
    }

    @Override
    protected double calculateShippingCost(double weight) {
        // Logic for specific calculations of the class

        return 200.0; // Example value for shipping cost
    }
}
~~~

## 🙂 Solution

In our food transportation application, each type of food delivery vehicle can be extracted and placed in its own class with its method ("calculateFactors"). This method will accept parameters such as the weight of the product and the type.

Each delivery class with different types of trucks will be turned into a strategy that performs a specific action. From the "AplicacionTransporteAlimentos" class, the strategy that best fits the customer's needs will be chosen, and the customer will have the option to accept it or change it for another one through the interface. This modular approach allows flexibility in choosing the appropriate shipping method based on customer needs.

~~~java
// Interface to define the behavior of transport calculation
interface TransportStrategy {
    void calculateFactors(double weight, String foodType);
}

// Implementations of the strategies
class VanStrategy implements TransportStrategy {
    @Override
    public void calculateFactors(double weight, String foodType) {
        // Specific calculation logic for vans
        System.out.println("Calculating factors for van...");
        // Here, calculations for factors related to food transportation can be performed (e.g. fuel, time, etc.)
    }
}

class TruckStrategy implements TransportStrategy {
    @Override
    public void calculateFactors(double weight, String foodType) {
        // Specific calculation logic for trucks
        System.out.println("Calculating factors for truck...");
        // Here, calculations for factors related to food transportation can be performed (e.g. fuel, time, etc.)
    }
}

class TractorTrailerStrategy implements TransportStrategy {
    @Override
    public void calculateFactors(double weight, String foodType) {
        // Specific calculation logic for tractor trailers
        System.out.println("Calculating factors for tractor-trailer...");
        // Here, calculations for factors related to food transportation can be performed (e.g. fuel, time, etc.)
    }
}

// Context class that uses a transport strategy to calculate factors
class FoodTransportApplication {
    private TransportStrategy transportStrategy;

    public void setTransportStrategy(TransportStrategy transportStrategy) {
        this.transportStrategy = transportStrategy;
    }

    public void requestPickup(double weight, String foodType) {

        // Call the transport strategy to calculate factors
        if (transportStrategy != null) {
            transportStrategy.calculateFactors(weight, foodType);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // Declare an instance of the application
        FoodTransportApplication app = new FoodTransportApplication();

        // Assign a strategy and request pickup for food
        app.setTransportStrategy(new VanStrategy());
        app.requestPickup(100.0, "Fruits");

        // Change to another strategy
        app.setTransportStrategy(new TruckStrategy());
        app.requestPickup(500.0, "Meat");
    }
}
~~~