# Adapter pattern

The Adaptader pattern is a structural design pattern that is responsible for being a mediator between two classes that do not understand each other. 
A small example to understand a little more about this design pattern is that many times when data is requested to an external entity, the response of the data may have many parameters that maybe several of these are not going to be used. The most common use case is to create an adapter, which adapts the data to what is required in the views of the application.
We can make use of this pattern if an external entity cannot communicate with another class. The adapter serves as a kind of translator, the other class only understands with the adapter and whoever needs the content. 
		
The responsibility of this pattern is to adapt a class so that another one understands it. 

An example of the Adapter pattern using Java code could be:

Suppose we have an old storage device that only connects through an old USB port, and we want to connect it to our new computer, which only has USB-C ports. We could use the Adapter pattern to create an adapter that converts the USB-C port to an older USB port.

```Java
public interface DeviceUSB {
    public void connect();
}

public class DeviceOld implements DeviceUSB {
    public void connect() {
        System.out.println("Conectando dispositivo antiguo a través de USB");
    }
}

public interface DeviceUSB_C {
    public void connectByUSB_C();
}

public class AdapterUSB implements DeviceUSB_C {
    private DeviceOld device;

    public AdapterUSB_C(DeviceOld device) {
        this.device = device;
    }

    public void connectByUSB_C() {
        device.connect();
    }
}
```

In this example, the `DeviceUSB` interface represents the old USB port, and the `DeviceOld` class represents the storage device that connects through it. The `DeviceUSB_C` interface represents the USB-C port, and the `AdapterUSB_C` class acts as an adapter that converts the USB-C port to an old USB port using an instance of `DeviceOld`. In this way, we can connect our old device to our new computer without having to buy a new storage device.

```Java
DeviceOld device = new DeviceOld();
DeviceUSB_C adapter = new AdapterUSB_C(device);

adapter.connectByUSB_C();
```