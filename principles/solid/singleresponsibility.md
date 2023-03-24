# Single Responsibility

Single Responsibility Principle (SRP). According to this principle, "a class should have one and only one reason to change." It is precisely this "reason to change" that Robert C. Martin identifies as "responsibility.

The Single Responsibility Principle is the most important and fundamental of SOLID, very easy to explain, but the most difficult to follow in practice.

Bob himself summarizes how to do it: "Gather together the things that change for the same reasons. Separate those things that change for different reasons," that is, "Gather together the things that change for the same reasons. Separate those things that change for different reasons."

### Bad example:

```
class Order {
  private items: Item[];
  private customer: string;
  private customerEmail: string;
  private customerAddress: string;
  private orderNumber: string;
  private date: Date;
  
  constructor(items: Item[], customer: string, customerEmail: string, customerAddress: string, orderNumber: string, date: Date) {
    this.items = items;
    this.customer = customer;
    this.customerEmail = customerEmail;
    this.customerAddress = customerAddress;
    this.orderNumber = orderNumber;
    this.date = date;
  }
  
  public getTotal(): number {
    let total = 0;
    for(let item of this.items) {
      total += item.price;
    }
    return total;
  }
  
  public getCustomer(): string {
    return this.customer;
  }
  
  public getCustomerEmail(): string {
    return this.customerEmail;
  }
  
  public getCustomerAddress(): string {
    return this.customerAddress;
  }
  
  public getOrderNumber(): string {
    return this.orderNumber;
  }
  
  public getDate(): Date {
    return this.date;
  }
  
  public sendConfirmationEmail(): void {
    //enviar un email de confirmación al cliente
  }
  
  public printOrder(): void {
    //imprimir el pedido
  }
}
class Item {
  private name: string;
  public price: number;
  
  constructor(name: string, price: number) {
    this.name = name;
    this.price = price;
  }
  public getName
```

### Good example:
```
class Order {
  private items: Item[];
  private customer: Customer;
  private orderNumber: string;
  private date: Date;
  
  constructor(items: Item[], customer: Customer, orderNumber: string, date: Date) {
    this.items = items;
    this.customer = customer;
    this.orderNumber = orderNumber;
    this.date = date;
  }
  
  public getTotal(): number {
    let total = 0;
    for(let item of this.items) {
      total += item.getPrice();
    }
    return total;
  }
  
  public getCustomer(): Customer {
    return this.customer;
  }
  
  public getOrderNumber(): string {
    return this.orderNumber;
  }
  
  public getDate(): Date {
    return this.date;
  }
}

class Customer {
  private name: string;
  private email: string;
  private address: string;
  
  constructor(name: string, email: string, address: string) {
    this.name = name;
    this.email = email;
    this.address = address;
  }
  
  public getName(): string {
    return this.name;
  }
  
  public getEmail(): string {
    return this.email;
  }
  
  public getAddress(): string {
    return this.address;
  }
}

class Item {
  private name: string;
  private price: number;
  
  constructor(name: string, price: number) {
    this.name = name;
    this.price = price;
  }
  
  public getName(): string {
    return this.name;
  }
  
  public getPrice(): number {
    return this.price;
  }
}
```
### Related principles

- Open/Closed 

### Related patterns

- KISS
- Separation of Concerns
- Boy-Scout Rule
- Do The Simplest Thing That Could Possibly Work

---
[Back to the list](./README.md)