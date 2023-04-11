# Strategy pattern

## Description
The Strategy pattern is useful when you want to be able to swap out different algorithms or behaviors at runtime in a program, without having to change the code that's using them. Instead, you define a family of interchangeable algorithms as separate classes, each implementing a common interface or base class, and you pass instances of those classes to the client code at runtime as needed.

This pattern provides a way to create interchangeable algorithms with minimal impact on the rest of the code, making it easier to add new behaviors or modify existing ones without changing the underlying architecture of the program.

## Problem
Let's say we're designing a game that involves different types of characters. Each character has a unique attack style, and we want to be able to switch their attack strategy at runtime.

## Solution
```java
public interface AttackStrategy {
    void attack();
}
public class SwordAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("Attacking with sword!");
    }
}

public class BowAndArrowAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("Attacking with bow and arrow!");
    }
}

public class MagicAttack implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("Attacking with magic!");
    }
}

public class Character {
    private AttackStrategy attackStrategy;

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }

    public void attack() {
        attackStrategy.attack();
    }
}

Character warrior = new Character();
warrior.setAttackStrategy(new SwordAttack());
warrior.attack(); 

Character archer = new Character();
archer.setAttackStrategy(new BowAndArrowAttack());
archer.attack(); 

Character mage = new Character();
mage.setAttackStrategy(new MagicAttack());
mage.attack(); 
``` 
This way, we can easily switch a character's attack strategy by setting a different object that implements the AttackStrategy interface.