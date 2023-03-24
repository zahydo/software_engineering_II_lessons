## Open/Closed

The open/closed principle says that every class, module, method, etc. 
it should be open to extend, but must be closed to be modified. What 
we want is to prevent our code from being modified unintentionally causing 
errors or unexpected functionality.

### Bad example:

Let's look at this Car class with the basic functionality for a vehicle.


```JAVA:
package solid;
class Car {

    void accelerate() {
        // accelerate car
    }

    void stop() {
        // stop car
    }
}
```

A RaceCar vehicle needs this extra functionality injectExtraGas.

```JAVA:
package solid;

class Car {

    void accelerate(boolean isCarRace) {
        if (isCarRace) {
            injectExtraGas();
        }
        // accelerate car
    }

    void stop() {
        // stop car
    }

    private void injectExtraGas() {
        // do.. 
    }

}
```

 The above is wrong since our code is modified and this can cause errors or unexpected functionality.


### Good example:

To comply with the principle, we can extend our class by creating another type of class derived from the main one.


```JAVA:
package solid;
public class RaceCar extends Car {

    @Override
    void accelerate() {
        injectExtraGas();
        super.accelerate();
    }

    private void injectExtraGas() {
        // do..
    }

}
```

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)