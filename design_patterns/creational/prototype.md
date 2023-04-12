# Prototype

## Description:

Prototype is a creational design pattern that lets you copy existing objects without making your code dependent on their classes.

## Problem:

Sometimes you have an object and you need to create an exact copy of it. The usual procedure is to create a new object of the same class and copy all the fields and values ​​from the original object to paste them into the new object, but there is a problem, not all objects can be copied this way, because some of the fields of the object can be private and invisible outside of the object itself.

Another problem is that you have to know the class of the object to be able to duplicate it, so the code becomes dependent on that class.

## Solution:

The Prototype pattern delegates the cloning process to the actual objects that are being cloned. The pattern declares a common interface for all objects that support cloning. This interface lets you clone an object without coupling your code to the class of that object. Usually, such an interface contains just a single clone method.

An object that supports cloning is called a prototype. When your objects have dozens of fields and hundreds of possible configurations, cloning them might serve as an alternative to subclassing.

## Example:

As an example we are simply going to create a "Person" object and we are going to clone it.

### Structure:

<p align="center">
    <img src="./diagrams/prototype.svg"/>
</p>

### Implementation:

The Prototype design pattern has the following structure:

1 - The Prototype interface declares the cloning methods. In most cases, it’s a single clone method.

```Java

interface IPerson{
    Iperson clone();
}

```

2 - The Concrete Prototype class implements the cloning method. In addition to copying the original object’s data to the clone, this method may also handle some edge cases of the cloning process related to cloning linked objects, untangling recursive dependencies, etc.

```Java

class Person implements IPerson{

    private String name;
    private int age;

    @Override
    public IPerson getName(){
        return name;
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public IPerson getAge(){
        return age;
    }

    @Override
    public void setAge(int age){
        this.age = age;
    } 

    @Override
    public Person(String name, int age){
        this.name = name;
        this.age = age;
    } 

    public IPerson Clone(){
        return new Person(name, age);
    }
}

```

3 - The Client can produce a copy of any object that follows the prototype interface.

```Java

class Application implements IHandler{

    Person personOriginal = new Person("Andres", 27);
    Person personClone = new (Person)personOriginal.Clone();
    
}
