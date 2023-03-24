## Single Responsibility
This principle states that a class, or component, should only be responsible for one thing. If this is not met, and a class has several responsibilities, it will involve changing several responsibilities for having made changes to a single responsibility. 

```Java
public class Computer {
    String mark;
    String model;
    int year;
    int price;
    String numSerial;

    public Computer(String brand, String model, int year, int price, String numSerial) {
        this.mark = mark;
        this.model = model;
        this.year = year;
        this.price = price;
        this.numSerial = numSerial;
    }
}
```
We have the exampleof a sale of computers. In the first class, we have the computer class, in which are all the basic attributes of the class.

### Bad example:

```Java
public class Invoice {

    private computer computer;
    private int quantity;
    private double discountRate;
    private double taxRate;
    private double total;

    public Invoice(Computer computer, int amount, double DiscountRate, double TaxRate) {
        this.Computer = computer;
        this.quantity = quantity;
        this.discountRate = discountRate;
        this.TaxRate = TaxRate;
        this.total = this.calculateTotal();
    }

    public double calculateTotal() {
            double price = ((Computer.price - Computer.price * discountRate) * this.quantity);

        double priceWithTax = price * (1 + taxRate);

        return priceWithTax;
    }

    public void printInvoice() {
            System.out.println(amount + "x " + Computer.name + " " + Computer.price + "$");
            System.out.println("DiscountRate: " + discountRate);
            System.out.println("Tax Rate: " + taxRate);
            System.out.println("Total: " + total);
    }

        public void saveFile(String fileName) {
    // Create a file with the given name and write the invoice.
    }
}
```
Here we have the invoice class, in which there are several methods implemented:
calculateTotal, PrintInvoice and saveFile.

Looking at these classes, we realize that  the first method  that violates the principle is  the printInvoice() method  which has the logic of printing the sales invoice of computers. The principle says that a class can only be created for a single purpose, so it will only have a single reason to change. That reason, for our class is the calculation of the bill. But in this case, if we want to change the printing format, we must change the class as well. 
There is a second violation in the beginning, and it is committed by the save file method. In this case, we are mixing persistence logic with business logic. 

### Good example:

The correct way to implement this example would be to create two classes, in order to separate the printing and persistence logics. 
So we have:

```Java
public class PrintInvoice {
    private Invoice invoice;

    public PrintInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public void print() {
        System.out.println(amount + "x " + Computer.name + " " + Computer.price + "$");
        System.out.println("DiscountRate: " + discountRate);
        System.out.println("Tax Rate: " + taxRate);
        System.out.println("Total: " + total);
    }
}
```
```Java
public class InvoicePersistence {
    invoice invoice;

    public InvoicePersistence(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveFile(String fileName) {
        // Create a file with the given name and write the invoice.
    }
}
```
With the creation of these two classes, we can already say that the program obeys the first SOLID principle. 
### Related principles

-[BOY-SCOUT RULE](../general/boyscoutrule.md)

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)