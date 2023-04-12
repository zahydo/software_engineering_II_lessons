# Composite pattern

The Composite pattern is a powerful and versatile software design pattern that streamlines the creation, organization, and management of intricate, hierarchical object structures within an application.

This pattern is particularly useful in scenarios where an application needs to handle both individual objects and groups of objects in a uniform manner, as it allows objects to be composed of other objects, ultimately forming a tree-like structure.

<p align="center">
<img src="https://res.cloudinary.com/dzxhdnqm4/image/upload/v1681005367/UML_Composite_aqcqxr.png" alt="uml-composite" width="60%">
</p>

## 😟 Problem

Imagine you are creating an application to manage restaurant menus, which contain individual menu items and submenus.

Without an appropriate solution, you'll face:

1. A complicated data structure
2. Difficulties in adding or deleting items and submenus
3. Inconsistent handling of items and submenus

The code below demonstrates the problem:

```java
public class MenuItem {
    private String name;
    private double price;

    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void print() {
        System.out.println(getName() + " $" + getPrice());
    }
}
```

```java
public class Menu {
    private List<Object> menuComponents = new ArrayList<>();
    private String name;

    public Menu(String name) {
        this.name = name;
    }

    public void add(Object menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(Object menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public Object getChild(int index) {
        return menuComponents.get(index);
    }

    public String getName() {
        return name;
    }

    public void print() {
        System.out.println(getName());
        System.out.println("--------------------");

        for (Object menuComponent : menuComponents) {
            if (menuComponent instanceof MenuItem) {
                ((MenuItem) menuComponent).print();
            } else if (menuComponent instanceof Menu) {
                ((Menu) menuComponent).print();
            }
        }
    }
}
```

In this example, the `Menu` and `MenuItem` classes are separate and do not share a common interface. This makes it difficult to handle items and submenus consistently and creates a complex data structure that is hard to maintain.

## 🙂 Solution

The Composite pattern addresses these issues by providing a unified way to manage individual and composite items through a common interface and two concrete classes. This enables seamless addition, removal, and interaction of menu items.

Here is an implementation of the Composite pattern in Java:

```java
    public interface MenuComponent {
        public String getName();
        public double getPrice();
        public void print();
}
```

`IndividualMenuItem class`:

```java
public class MenuItem implements MenuComponent {
    // ...
}
```

`CompositeMenu class:`

```java

public class Menu implements MenuComponent {
    private List<Object> menuComponents = new ArrayList<>();

    // ...

    public void print() {
        System.out.println(getName());
        System.out.println("--------------------");

        for (MenuComponent menuComponent : menuComponents) {
            menuComponent.print();
        }
    }
}
```

In the `Menu` class, we create a list of `MenuComponen`t objects that can contain both `MenuItem` and `Menu` instances. This list can be easily managed, allowing for the retrieval of menu information and the printing of all menu items and their respective submenus, regardless of whether they are individual items or composite items.

The interface `MenuComponent` serves as a common contract for both individual and composite menu items, ensuring consistent handling of both types of elements.

```java
public class MenuDemo {
    public static void main(String[] args) {
        MenuComponent menu = new Menu("Menú Principal");
        MenuComponent menu1 = new Menu("Menú Desayuno");
        MenuComponent menu2 = new Menu("Menú Almuerzo");
        MenuComponent menu3 = new Menu("Menú Cena");

        menu1.add(new MenuItem("Café", 2.50));
        menu1.add(new MenuItem("Tostadas", 3.00));

        menu2.add(new MenuItem("Sopa del día", 4.50));
        menu2.add(new MenuItem("Plato principal", 12.50));

        menu3.add(new MenuItem("Ensalada", 8.50));
        menu3.add(new MenuItem("Postre", 5.50));
    }
}
```

With these classes, we can create a menu containing both individual items and composite items.

In summary, the Composite pattern uses aggregation to build hierarchical structures of composite objects, simplifying the handling of individual and composite items in a uniform manner. In this example, the `Menu` class uses aggregation to build a list of `MenuComponent` objects to handle both individual and composite menu items.
