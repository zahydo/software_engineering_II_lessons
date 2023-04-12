# Flyweight

The Flyweight design pattern is a structural pattern that allows efficient sharing of objects that have many similar properties, thus reducing memory usage and improving performance. It achieves this by separating the intrinsic state, which is shared among multiple objects, from the extrinsic state, which is specific to each object.

In this pattern, a Flyweight Factory creates and manages a pool of Flyweight objects, which can be shared by multiple clients. The Flyweight objects themselves are immutable, meaning that their state cannot be changed once they are created. Any changes to their state are handled through their context, which is passed in by the client at runtime.

The Flyweight pattern is particularly useful in situations where a large number of objects need to be created and memory usage is a concern. It can be used in a variety of contexts, such as graphics rendering, text processing, and game development, where objects with similar properties are frequently used.

## Diagram class of example
![ClassDiagram](http://www.plantuml.com/plantuml/png/ZP2zJiGm3CTtFuN7djhU0qJeT19IDoP6n12blXAH9YV71Sh7krDHJWxg3Kpvi7_EB_zZ5iioZG5y5EAJTOHTc5_93q-27r0ZK-o9Aw4tCNWlxEEmC_YIV0zV02xOdF4sHSSaL98jdb9Sa2v5MGxPlvD1_xDtAIGs2xKiK6_fIib6mUOFj_kVcdwciquIpwlPvJ8RlBFdcvLjjFa0DGuaQlHCipwXVKK4mLDS4nkjZvNb8L-8XyT2QvlLVZhlFm_5KDX8jsrHlrxUp0NuTL9OaQirE5Bifp5y0m00)
# Example
```java
import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

public class FlyweightFactory {
    private static Map<String, Flyweight> flyweights = new HashMap<>();

    public static Flyweight getFlyweight(String key) {
        Flyweight flyweight = flyweights.get(key);

        if (flyweight == null) {
            String[] properties = key.split("_");
            Font font = Font.getFont(properties[0]);
            int size = Integer.parseInt(properties[1]);
            Color color = Color.decode(properties[2]);
            flyweight = new ConcreteFlyweight(font, size, color);
            flyweights.put(key, flyweight);
        }

        return flyweight;
    }
}

public interface Flyweight {
    void render(String text);
}

public class ConcreteFlyweight implements Flyweight {
    private Font font;
    private int size;
    private Color color;

    public ConcreteFlyweight(Font font, int size, Color color) {
        this.font = font;
        this.size = size;
        this.color = color;
    }

    @Override
    public void render(String text) {
        // Render the text using the shared intrinsic state and the passed-in extrinsic state
        System.out.println("Rendering \"" + text + "\" in font \"" + font.getName() + "\", size " + size + ", and color " + color.toString());
    }
}

public class Client {
    public static void main(String[] args) {
        // Render three text strings with different intrinsic and extrinsic states
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight("Arial_12_#000000");
        flyweight1.render("Hello, world!");

        Flyweight flyweight2 = factory.getFlyweight("Times New Roman_18_#FF0000");
        flyweight2.render("The quick brown fox jumps over the lazy dog.");

        Flyweight flyweight3 = factory.getFlyweight("Arial_12_#000000");
        flyweight3.render("Flyweight pattern example.");
    }
}
```
In this example, FlyweightFactory is the flyweight factory that manages the creation and storage of flyweight objects. Flyweight is the interface that defines the render operation that is invoked when a new text is to be processed, and ConcreteFlyweight is the concrete implementation of the Flyweight interface that represents a specific flyweight.

The Client class represents the application that uses flyweights to process text. In the main method, three different flyweight objects are created using the factory, and the render method is called on each of them to process different texts with different intrinsic and extrinsic properties.

[Back](../structural/README.md)