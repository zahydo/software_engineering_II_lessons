## Liskov Substitution

The Liskov substitution principle says that if class A is a subtype of class B, then we should be able to replace B with 
A without affecting the behavior of our program.

### Bad example:

Suppose we have a Bird class:

```JAVA:
public class Pajaro{ 

    public void volar(){} 

    public void comer(){} 

} 
```

Now we need to add a Duck and a Penguin to our application:

```JAVA:
public class Pato extends Parajo{} 

public class Pinguino extends Pajaro{} 

```

The problem we will find is that although the Penguin is a Bird, 
it does not have the ability to fly like the Duck. Therefore we will 
have a method in Penguin that we will not be able to implement.


### Good example:

```JAVA:

public class Pajaro{ 

    public void comer(){} 

} 

public class PajaroVolador extends Pajaro{ 

    public void volar(){} 

} 

public class Pato extends PajaroVolador{} 

public class Pinguino extends Pajaro{} 
```

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)