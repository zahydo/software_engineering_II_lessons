## Interface Segregation

This principle says: "Make fine grained interfaces that are client specific.", i.e. for a specific purpose.
The principle states that many client-specific interfaces are better than one general purpose interface. 
Clients should not be forced to implement a function that they do not need.

### Bad example:

Let's imagine that we want to define the classes needed to host some types of birds. For example, we would have parrots, toucans and hawks:

interface IAve {  
    void volar();
    void comer();
}

class Loro implements IAve{

    @Override
    public void volar() {
        //...
    }

    @Override
    public void comer() {
        //..
    }
}

class Tucan implements IAve{  
    @Override
    public void volar() {
        //...
    }

    @Override
    public void comer() {
        //..
    }
}

So far so good. But now let's imagine that we want to add penguins. These are birds, but they also have the ability to swim. We could do this:

interface IAve {  
    void volar();
    void comer();
    void nadar();
}

class Loro implements IAve{

    @Override
    public void volar() {
        //...
    }

    @Override
    public void comer() {
        //...
    }

    @Override
    public void nadar() {
        //...
    }
}

class Pinguino implements IAve{

    @Override
    public void volar() {
        //...
    }

    @Override
    public void comer() {
        //...
    }

    @Override
    public void nadar() {
        //...
    }
}

The problem is that the parrot does not swim, and the penguin does not fly, so we would have to add an exception or warning if we tried to call these methods. In addition, if we wanted to add another method to the IAve interface, we would have to go through each of the classes that implements it and add the implementation of that method in all of them. This violates the principle of interface segregation, since these classes (the clients) need not depend on methods that they do not use.
The most correct thing to do would be to further segregate the interfaces, as much as necessary. In this case we could do the following:

### Good example:

interface IAve {  
    void comer();
}
interface IAveVoladora {  
    void volar();
}

interface IAveNadadora {  
    void nadar();
}

class Loro implements IAve, IAveVoladora{

    @Override
    public void volar() {
        //...
    }

    @Override
    public void comer() {
        //...
    }
}

class Pinguino implements IAve, IAveNadadora{

    @Override
    public void nadar() {
        //...
    }

    @Override
    public void comer() {
        //...
    }
}

Thus, each class implements the interfaces of the one that really needs to implement its methods. When adding new functionality, this will save us a lot of time, and in addition, we comply with the first principle (Single Responsibility).

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)