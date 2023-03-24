## Dependency Injection

The Dependency Injection principle states that a class should depend on interfaces or abstract classes instead of high-level or concrete classes. This makes the class more flexible and easier to maintain.

To understand this principle better, here's an example:

### Bad example

```
public class buy{

    public buy(){
        
    }

    public void buy(){
        if(paid()){
            //product buyed
        }else{
            //error the was a problem with the paiment
        }

    }

    public void paid(){
        //retunr if was paid true else false
    }
}


public class product{

    private String name;
    private double price;
    private buy buyclass;

    public product(){

    }

    public void product(buy buyclass){
        buyclass.buy();
    }
}

```
This is a bad example because the Product class depends on the Buy class. If we want to implement a different Buy class that maybe has a different payment method or if we want to make the product free, we would have to change the Product or Buy class.

### Good example

```
public interface Ibuy{
   public void buy()
}

public class buy implements Ibuy{

    public void buy(){
        if(paid()){
            //product buyed
        }else{
            //error the was a problem with the paiment
        }

    }

    public void paid(){
        //retunr if was paid true else false
    }
}


public class product{

    private String name;
    private double price;
    private Ibuy buyclass;

    public product(){

    }

    public void product(Ibuy buyclass){
        buyclass.buy();
    }
}

```
This is a good example because the Product class now depends on an interface (IBuy) instead of a concrete class. This means that if we want to implement another Buy class with a different payment method, we can easily do so by creating a new class that implements the IBuy interface. We can then pass an instance of this new class to the product method of the Product class, without having to modify the Product class itself.

### Related principles

- [Separation of Concerns](../general/separationofconcerns.md)
- [Code For The Maintainer](../general/codeformantainer.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)

### Related patterns

- [Pattern names]


[Back to the list](./README.md)