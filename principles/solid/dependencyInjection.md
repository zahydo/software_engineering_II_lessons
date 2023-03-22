# D
## Dependency Injection
Classes should not depend on others, but on abstractions that are implemented by other classes.
### Bad example:
We need to define a switch class, a lamp class, and in the future add a power source.
```JAVA:
    public class Lamp{
        public void turnOn(){
            System.out.println("Lamp turned on.");
        }

        public void turnOff(){
            System.out.println("Lamp turned off.");
        }
    }

    public interface ElectricDevice{
        void turnOn();
        void turnOff();
    }

    public class Switch{
        private ElectricDevice device;
        private boolean state;
        
        public Switch(ElectricDevice device){
            this.device = device;
        }

        public void press(){
            this.state = !this.state;
            if (this.state){
                device.turnOn();
            } else {
                device.turnOff();
            }
        }
    }

```
The Interruptor class is strongly dependent on the Lampara class, as the lamp instance is created in the constructor of the Interruptor. Therefore, Interruptor cannot be easily modified.
### Good example:

To do this, we do the following:
```JAVA:
    public interface ElectricalDevice{
        void turnOn();
        void turnOff();
    }
    public class Lamp implements ElectricalDevice{
        public void turnOn(){
            System.out.println("Lamp turned on.");
        }

        public void turnOff(){
            System.out.println("Lamp turned off.");
        }
    }

    public class Switch{
        private ElectricalDevice device;
        private boolean state;
        
        public Switch(ElectricalDevice device){
            this.device = device;
        }

        public void press(){
            this.state = !this.state;
            if (this.state){
                device.turnOn();
            } else {
                device.turnOff();
            }
        }
    }

```
The class Interruptor depends on the abstraction DispositivoElectrico instead of depending on a concrete implementation. This allows the Interruptor class to be flexible and reusable, as it can be used with any device that implements the DispositivoElectrico interface.


### Related patterns
- Separation of Concerns
- DRY (Don't Repeat Yourself)
- Code For The Maintainer
- Composition Over Inheritance