# Mediator pattern

One of the advantages offered by Object-Oriented Programming (OOP) is the ability to reuse source code, but as we create objects that interrelate with each other, it becomes less likely for an object to function without the help of others.

To avoid this, we can use the Mediator pattern, which is a pattern that manages the way a set of classes communicate with each other. Mediator is especially useful when we have many classes communicating directly because through the implementation of this pattern, we can create a layer of bidirectional communication, in which classes can communicate with each other through a common object that acts as a mediator or intermediary.

In large projects, we may encounter a problem in which the number of classes increases and so do the relationships they have with the rest of the classes in the project. This can pose a serious problem of coupling with the rest of the classes in our project, especially because we create direct communication channels that are difficult to trace or debug.

## 🏗️ Estructure
<p align="center">
<img src="https://i.postimg.cc/fRRt8R3Z/Estructura-Mediator-drawio.png" alt="mypic" width="75%">
</p>

## 😟 Problem

Imagine that you are building an e-commerce application that has several components, such as the product page, the shopping cart, and the checkout process. Each component has its own logic and state and needs to communicate with other components to maintain the coherence of the user workflow.

The problem is that when a user adds a product to the shopping cart from the product page, the product page needs to update its state and notify the shopping cart that a product has been added. The shopping cart, in turn, needs to update its state and notify the checkout process that the cart has been updated. The checkout process, in turn, needs to wait for the shopping cart to be updated to continue with the payment process, and we can see a high coupling between the classes and all objects need to know about each other.

~~~java
// Product Page Component
class ProductPage {
    private ShoppingCart shoppingCart;
    private CheckoutProcess checkoutProcess;

    public ProductPage() {
        this.shoppingCart = new ShoppingCart();
        this.checkoutProcess = new CheckoutProcess();
    }

    public void addToCart(String product) {
        System.out.println("The product " + product + " has been added to the shopping cart.");
        shoppingCart.addProduct(product);
    }

    public void completeCheckout() {
        System.out.println("Checkout completed.");
        checkoutProcess.completeCheckout();
    }

    public void receiveStateUpdate(String state) {
        System.out.println("The product page has received a state update: " + state);
    }
}

// Shopping Cart Component
class ShoppingCart {
    public void addProduct(String product) {
        System.out.println("The product " + product + " has been added to the shopping cart.");
    }

    public void receiveStateUpdate(String state) {
        System.out.println("The shopping cart has received a state update: " + state);
    }
}

// Checkout Process Component
class CheckoutProcess {
    public void completeCheckout() {
        System.out.println("Checkout process completed.");
    }

    public void receiveStateUpdate(String state) {
        System.out.println("The checkout process has received a state update: " + state);
    }
}

// Example of Usage
public class EcommerceExample {
    public static void main(String[] args) {
        ProductPage productPage = new ProductPage();

        // Add product to the cart
        productPage.addToCart("Product 1");

        // Complete checkout
        productPage.completeCheckout();
    }
}
~~~
In this example, all components interact with each other directly

## 🙂 solution

Now we are going to apply the Mediator design pattern to our example. In this case, the "EcommerceMediator" acts as the mediator between the components "ProductPage", '
"ShoppingCart", and "PaymentProcess". The components communicate with the mediator through the "Mediator" interface, and the mediator coordinates the actions and updates between the components.
~~~java
// Mediator interface
interface Mediator {
    void notify(Component component, String event);
}

// Abstract component
abstract class Component {
    protected Mediator mediator;

    public Component(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void performAction(String event);
}

// Concrete component: Product Page
class ProductPage extends Component {
    public ProductPage(Mediator mediator) {
        super(mediator);
    }

    public void performAction(String event) {
        System.out.println("Product Page: " + event);
        mediator.notify(this, event);
    }
}

// Concrete component: Shopping Cart
class ShoppingCart extends Component {
    public ShoppingCart(Mediator mediator) {
        super(mediator);
    }

    public void performAction(String event) {
        System.out.println("Shopping Cart: " + event);
        mediator.notify(this, event);
    }
}

// Concrete component: Payment Process
class PaymentProcess extends Component {
    public PaymentProcess(Mediator mediator) {
        super(mediator);
    }

    public void performAction(String event) {
        System.out.println("Payment Process: " + event);
        mediator.notify(this, event);
    }
}

// Concrete implementation of the Mediator
class EcommerceMediator implements Mediator {
    private ProductPage productPage;
    private ShoppingCart shoppingCart;
    private PaymentProcess paymentProcess;

    public void setProductPage(ProductPage productPage) {
        this.productPage = productPage;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public void setPaymentProcess(PaymentProcess paymentProcess) {
        this.paymentProcess = paymentProcess;
    }

    public void notify(Component component, String event) {
        if (component instanceof ProductPage) {
            if (event.equals("ProductAdded")) {
                shoppingCart.performAction("UpdateCart");
            }
        } else if (component instanceof ShoppingCart) {
            if (event.equals("CartUpdated")) {
                paymentProcess.performAction("PaymentProcessStarted");
            }
        } else if (component instanceof PaymentProcess) {
            if (event.equals("PaymentCompleted")) {
                productPage.performAction("UpdateProducts");
                shoppingCart.performAction("EmptyCart");
            }
        }
    }
}

// Example usage of the Mediator pattern
public class EcommerceApplication {
    public static void main(String[] args) {
        // Create instances of the components
        EcommerceMediator mediator = new EcommerceMediator();
        ProductPage productPage = new ProductPage(mediator);
        ShoppingCart shoppingCart = new ShoppingCart(mediator);
        PaymentProcess paymentProcess = new PaymentProcess(mediator);

        // Set the mediator references in the components
        mediator.setProductPage(productPage);
        mediator.setShoppingCart(shoppingCart);
        mediator.setPaymentProcess(paymentProcess);

        // Simulate user actions
        productPage.performAction("ProductAdded");
        shoppingCart.performAction("CartUpdated");
        paymentProcess.performAction("PaymentCompleted");
    }
}
~~~