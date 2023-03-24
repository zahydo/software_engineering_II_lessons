## Single Responsibility

As its name suggests, it states that a class, component, or microservice should be responsible for only one thing. If, on the other hand, a class has several responsibilities, this implies that a change in one responsibility will cause a change in another responsibility.

### Bad example:

```JAVA:
    class Car {
        String mark;

        Car(String make){ this.make = make; }

        String getCarMake(){ return make; }

        void saveCarDB(Car car){ ... }
    }
```

As we can see, the Car class allows both access to the class properties and to perform operations on the DB, so the class already has more than one responsibility.

Suppose we have to make changes to the methods that perform operations on the database. In this case, in addition to these changes, we would probably have to touch the names or types of the properties, methods, etc., which does not seem very efficient because we are only modifying things that have to do with the DB.

### Good example:

To avoid this, we must separate the responsibilities of the class, so we can create another class that handles the operations to the DB.

```JAVA:
    class Car {
        String mark;

        Car(String make){ this.make = make; }

        String getCarMake(){ return make; }
    }

     class CarDB{
        void saveCarDB(Car car){ ... }
        void removeCarDB(Car car){ ... }
    }
```

Our program will be much more cohesive and encapsulated by applying this principle.

### Related principles

- Separation of Concerns.
- Code For The Maintainer. 

---
[Back to the list](./README.md)