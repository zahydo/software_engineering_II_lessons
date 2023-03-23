# L
## Liskov Substitution
Child classes must be perfectly compatible with their parent class, and these child classes must not change their behavior or add new functionalities that break the code.

### Bad example:
Let's say we have to create two classes, one for ElectricBicycle and another for MountainBike.
We make MountainBike inherit from ElectricBicycle:
```JAVA:
    public class ElectricBicycle {
        private String motor;

        public void travel(String pointA, String pointB){
            System.out.println("Traveling from "+ pointA+ " to "+ pointB);
            System.out.println("The electric bicycle is using its motor to travel");
        }

        public String getMotor(){
            return this.motor;
        }
    }

    public class MountainBike extends ElectricBicycle {

        @Override
        public void travel(String pointA, String pointB, boolean isMountain, boolean isMountainDescent){

            if (isMountain == false){
                System.out.println("Traveling from "+ pointA+ " to "+ pointB);
            }else if(isMountainDescent){
                System.out.println("Descending the mountain from "+ pointA+ " to "+ pointB);
            } else{
                System.out.println("Climbing the mountain from "+ pointA+ " to "+ pointB);
            }
            
        }

    }
```
But, The principle is being violated because ElectricBicycle and MountainBike are not compatible.
### Good example:
Therefore it is decided to create another class called Bicycle that allows compatibility between ElectricBicycle and MountainBike
```JAVA:
    public class Bicycle{
        public void travel(String pointA, String pointB){
            System.out.println("Traveling from "+ pointA+ " to "+ pointB);
        }
    }

    public class ElectricBicycle extends Bicycle{
        private String motor;
        public String getMotor(){
            return this.motor;
        }

        @Override
        public void travel(String pointA, String pointB) {
            super.travel(pointA, pointB);
            System.out.println("The electric bicycle is using its motor to travel");
        }
    }
    
    public class MountainBike extends Bicycle {
        public void climbMountain(String pointA, String pointB) {
            System.out.println("Climbing the mountain from "+ pointA+ " to "+ pointB);
        }

        public void descendMountain(String pointA, String pointB) {
            System.out.println("Descending the mountain from "+ pointA+ " to "+ pointB);
        }
    }
```
The Bicycle class has been created so that the messages of ElectricBicycle and MountainBike are really coherent, making classes easier to understand.


### Related patterns
- Separation of Concerns
- Code For The Maintainer
- DRY (Don't Repeat Yourself)

---
[Back to the list](./README.md)