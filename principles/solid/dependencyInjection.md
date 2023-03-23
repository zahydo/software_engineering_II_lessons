# DEPENDENCY INJECTION

Refers to the idea that an object's dependencies should be provided by other objects, rather than being constructed directly by the object itself. This means that instead of an object creating its own dependencies, they are passed as arguments to the object's constructor or are established through specific methods.

## Bad Example
```
class Order:
    def __init__(self, amount):
        self.payment_processor = PaymentProcessor()
        self.amount = amount

    def process_payment(self):
        self.payment_processor.process_payment(self.amount)

```
In this example, the Order class directly creates an instance of PaymentProcessor in the constructor. This makes the Order class tightly coupled to the PaymentProcessor class, which makes it difficult to reuse the Order class in other contexts.

If we want to change the way payments are processed, we would have to modify the Order class, which can be costly and error-prone. In addition, we cannot test the Order class without creating an instance of PaymentProcessor, which makes unit testing difficult.

## Good Example
```
class Order:
    def __init__(self, payment_processor):
        self.payment_processor = payment_processor

    def process_payment(self, amount):
        self.payment_processor.process_payment(amount)
```
Applying the principle properly, the Order class will depend on the PaymentProcessor class to process payments, but instead of creating an instance of PaymentProcessor within the constructor of Order, it is passed as an argument to the constructor.

Now, to create an instance of Order you need to provide an instance of PaymentProcessor:
```
from payment_processor import PaymentProcessor

payment_processor = PaymentProcessor()
order = Order(payment_processor)
```

## Related principles
- Code for maintainer
- Boy-Scout Rule
- Separation of Concerns