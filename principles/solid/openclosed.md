## Open/Closed

[TODO]

### Bad example:
Suppose we have a class `ArithmeticOperations` that has a method to calculate the sum of two integers, `add(int a, int b)`. However, in a new update, it is required to multiply two integers instead of adding them. Instead of extending the functionality, we change the implementation of the `add()` method to perform multiplication of numbers.
~~~java:
public class OperacionesAritmeticas {
    public int sumar(int a, int b) {
        return a * b; // Cambiado para multiplicar en lugar de sumar
    }
}

public class Programa {
    public static void main(String[] args) {
        OperacionesAritmeticas operaciones = new OperacionesAritmeticas();
        int resultado = operaciones.sumar(2, 3);
        System.out.println("Resultado: " + resultado); // Debería ser 6, pero es 5
    }
}
~~~
In this example, `ArithmeticOperations` is not closed to modification, since we changed the `add()` method to perform a different operation. This can cause errors in the behavior of the program and makes moderation and maintenance difficult in the future.




### Good example:

Suppose we have an interface `IPago` with a `pay()` method. We create a concrete class `TarjetaCredito` that implements `IPago` and another class `PagoService` that has a method to process payments. Instead of changing the code in `PagoService` every time we need to add a new payment type, we can extend the functionality by adding new classes that implement `IPago`.
~~~java:
public interface IPago {
    void pagar(double cantidad);
}

public class TarjetaCredito implements IPago {
    public void pagar(double cantidad) {
        // código para procesar el pago con tarjeta de crédito
    }
}

public class Paypal implements IPago {
    public void pagar(double cantidad) {
        // código para procesar el pago con Paypal
    }
}

public class PagoService {
    public void procesarPago(IPago pago, double cantidad) {
        pago.pagar(cantidad);
    }
}

public class Programa {
    public static void main(String[] args) {
        IPago tarjetaCredito = new TarjetaCredito();
        IPago paypal = new Paypal();

        PagoService pagoService = new PagoService();
        pagoService.procesarPago(tarjetaCredito, 100.0);
        pagoService.procesarPago(paypal, 50.0);
    }
}
~~~
In this example, `PagoService` is closed to modification, since the code in `PagoService` does not need to be modified each time a new payment method is added. Instead, we extend the functionality by adding new classes that implement `IPago`.


### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)