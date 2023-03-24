## Interface Segregation

The principle of interface segregation says that no client should be forced to depend on 
methods it doesn't use. In an existing interface we should not add new methods that force 
additional functionality to be implemented. Rather than add methods to an existing interface, 
it is better to create another interface and have the class that needs it implement it.


### Bad example:

interface for IProduct of which we will later create its implementations.
We then Implement a Shoes product from the interface. Iproduct.
Implementamos otro producto Games desde la interfaz IProduct.
We implement another Games product from the IProduct interface.

```JAVA:
package solid.i;

public interface IProduct {
    String getType();
}

class Shoes implements IProduct {
    @Override
    public String getType() {
        return "shoes";
    }
}

class Games implements IProduct {
    @Override
    public String getType() {
        return "game";
    }
}
```

Now we need our Games class to also implement a getAge() method to 
find out what age the games are for. The simple but wrong way to do this 
would be to add the method to the IProduct interface. But this will force us 
to implement the _getAge() method in all classes as well.

```JAVA:
package solid.i;
public interface IProduct {
    String getType();
    int getAge();
}

class Games implements IProduct {
    private int age;
    @Override
    public String getType() {
        return "game";
    }
    @Override
    public int getAge() {
        return age;
    }
    // get and set.. 
}

class Shoes implements IProduct {
    @Override
    public String getType() {
        return "shoes";
    }
    @Override
    public int getAge() {
        throw new UnsupportedOperationException();
    }
}
```

### Good example:

```JAVA:
package solid.i;

public interface IProduct {

    String getType();
}

public interface IRestrictedProduct {

    int getAge();

}

class Shoes implements IProduct {

    @Override
    public String getType() {
        return "shoes";
    }

}
```

The Games class now implements both interfaces. 
In this way we solve the principle of interface segregation.

```JAVA:
class Games implements IProduct, IRestrictedProduct {

    private int age;

    @Override
    public String getType() {
        return "game";
    }

    @Override
    public int getAge() {
        return age;
    }

    // get and set..

}
```

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)