# Prototype pattern
## Description
The Prototype pattern typically involves creating a prototype object that serves as a blueprint for other objects. This prototype object is used to create new objects by making a copy of it. To achieve this, we need to ensure that the objects are cloneable. This can be done by implementing the Cloneable interface and overriding the clone() method.

Using the Prototype pattern has several benefits. It can improve performance by avoiding the costly object creation process. It can also make the code more flexible and maintainable by isolating the object creation process and making it easier to create variations of objects.

## Problem
Suppose we are developing a role-playing game where there are several types of characters, each with different attributes and abilities. Instead of creating each character from scratch, we can use the Prototype pattern to clone a base character and adjust the specific properties of each character.

## Solution 

```java 
public abstract class Character implements Cloneable {
    private String name;
    private int level;
    private String weapon;

    abstract void attack();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public Object clone() {
        Object clone = null;

        try {
            clone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        return clone;
    }
}

// Concrete class that extends the prototype class
public class Warrior extends Character {
    public Warrior() {
        setName("Warrior");
        setLevel(1);
        setWeapon("Sword");
    }

    @Override
    public void attack() {
        System.out.println("The Warrior attacks with his " + getWeapon());
    }
}

// Class that uses the Prototype pattern
public class CharacterCache {
    private static Map<String, Character> characters = new HashMap<String, Character>();

    public static Character getCharacter(String type) {
        Character cachedCharacter = characters.get(type);
        return (Character) cachedCharacter.clone();
    }

    public static void loadCache() {
        Warrior warrior = new Warrior();
        characters.put("Warrior", warrior);

        Mage mage = new Mage();
        characters.put("Mage", mage);
    }
}

// Example of using the Prototype pattern
public class PrototypePatternDemo {
    public static void main(String[] args) {
        CharacterCache.loadCache();

        Character warrior1 = CharacterCache.getCharacter("Warrior");
        warrior1.setLevel(5);

        Character warrior2 = CharacterCache.getCharacter("Warrior");
        warrior2.setLevel(8);

        warrior1.attack();
        warrior2.attack();
    }
}
```

In this example, the Character class is the prototype class that contains the base structure of the characters. The Warrior class is a concrete class that extends the prototype class.

The CharacterCache class uses the Prototype pattern to create objects by cloning a prototype character instead of creating them from scratch. The class contains a map that keeps track of the prototype characters.

In the loadCache() method, two objects are created: a Warrior and a Mage.

In the main() method, the CharacterCache is loaded with the prototypes, then two instances of the Warrior class are retrieved. The first Warrior object is set to level 5, and the second Warrior object is set to level 8. Finally, both Warrior objects are commanded to attack.

