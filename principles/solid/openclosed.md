## Open/Closed

The Open/Closed Principle states that software entities (classes, modules, functions, etc.) should be open for extension but closed for modification. This means that the code should be designed in a way that allows for new functionality to be added without modifying existing code.


### Bad example:

```
public interface payMethod{
    public void cash();
    public void wiretransfer();
}

public class paid implementes payMethod(){

    @Override
    public void cash(){

    }

    @Override 
    public void wiretransfer(){

    }

}
```
This is a bad example because if we want to add a new payment method, such as PayPal, we would have to modify the payMethod interface, which violates the Open/Closed Principle.

### Good example:

```
public interface Payment {
    void processPayment();
}

public interface PayMethod extends Payment {
    // existing payment methods
    void cash();
    void wiretransfer();
}

public interface PaypalMethod extends Payment{
    void PayPal();
}

public class Paid implements PayMethod {
    @Override
    public void processPayment() {
        // implementation for processing payment
    }
    
    // implementations for the existing payment methods
    @Override
    public void cash() {
        // implementation for cash payment
    }
    
    @Override 
    public void wiretransfer() {
        // implementation for wire transfer payment
    }
}

public class PayPalPaid imlements PaypalMethod{

    @Override
    public void processPayment() {
        // implementation for processing payment
    }

    @Override
    public void PayPal() {
        // implementation for processing payment
    }

}
```
This is a good example because it separates the payment methods into different interfaces that extend a common Payment interface. This allows new payment methods to be added by simply creating a new interface and implementing it in a new class, without modifying any existing code. The Paid class implements the PayMethod interface, and the PayPalPaid class implements the PayPalMethod interface, both of which inherit the processPayment method from the Payment interface.

### Related principles


-[Separation of Concerns](../general/separationofconcerns.md)
- [Code For The Maintainer](../general/codeformantainer.md)
- [Boy-Scout Rule](../general/boyscoutrule.md)
-[Composition Over Inheritance](../general/compositionoverinheritance.md)

### Related patterns

- [Pattern names]


[Back to the list](./README.md)