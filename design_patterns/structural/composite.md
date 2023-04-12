## Composite pattern

## Description

The Composite pattern is a structural design pattern in object-oriented programming that allows you to compose 
objects into tree structures to represent whole-part hierarchies. The pattern lets clients treat individual objects 
and compositions of objects uniformly.

The Composite pattern consists of three main components: Component, Leaf, and Composite. The Component is the 
abstract class that defines the interface for both the Leaf and Composite classes. The Leaf class represents the 
"leaf" objects in the tree structure, which have no children. The Composite class represents the "composite" objects 
in the tree structure, which can have one or more children.

With the Composite pattern, you can create complex tree structures by combining simple objects into more complex 
ones. This allows you to treat individual objects and collections of objects in the same way, which simplifies the 
code and makes it more flexible. The Composite pattern is often used in user interface frameworks, where a composite 
object can contain other UI elements and be treated as a single object.

## Problem

You need to model a hierarchy of objects where each object can have sub-objects, and you want to be able to perform 
operations on both individual objects and groups of objects.

## Solution

Use the Composite pattern to create a tree-like structure of objects, where each object is either a leaf node or a 
composite node. The composite node can contain other objects, including other composite nodes, and can perform 
operations on its children.

Here's an example implementation of the Composite pattern in Java:

```Java: 

    // Component
    interface Component {
        public void operation();
    }

    // Leaf
    class Leaf implements Component {
        public void operation() {
            System.out.println("Leaf operation");
        }
    }

    // Composite
    class Composite implements Component {
        private List<Component> children = new ArrayList<Component>();

        public void add(Component component) {
            children.add(component);
        }

        public void remove(Component component) {
            children.remove(component);
        }

        public void operation() {
            for (Component component : children) {
                component.operation();
            }
        }
    }

    // Client code
    public class Client {
        public static void main(String[] args) {
            // Create leaf objects
            Leaf leaf1 = new Leaf();
            Leaf leaf2 = new Leaf();
            Leaf leaf3 = new Leaf();

            // Create composite object
            Composite composite = new Composite();

            // Add leaf objects to composite object
            composite.add(leaf1);
            composite.add(leaf2);

            // Add composite object to composite object
            composite.add(composite);

            // Call operation on composite object
            composite.operation();
        }
    }   

```

In this example, the Component interface defines the common interface for both the Leaf and Composite classes. The 
Leaf class represents a leaf node in the tree structure, which has no children. The Composite class represents a 
composite node in the tree structure, which can contain other objects, including other Composite objects.

The Composite class has a list of child Component objects, which can be either Leaf objects or Composite objects. 
The add and remove methods allow you to add or remove child objects from the composite.

The operation method of the Composite class calls the operation method on all of its child components, recursively 
traversing the tree structure. The Leaf class has its own implementation of the operation method.

In the client code, we create some Leaf objects and a Composite object, and add the Leaf objects and the Composite 
object to the Composite object. Then we call the operation method on the Composite object, which calls the operation 
method on all of its child components.