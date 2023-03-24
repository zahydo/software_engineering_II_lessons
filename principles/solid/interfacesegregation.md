## Interface Segregation

Interface Segregation" is a software design principle that refers to the idea that a class or software module should not depend on interfaces it doesn't use.
n other words, instead of having a large and complex interface that contains many methods, the idea is to divide the interface into several smaller and more cohesive ones, each focusing on a specific set of related functionalities.

### Bad example:
´´´
public interface Car {
    void accelerate();
    void brake();
    void turn();
    void playMusic();
}

public class SportsCar implements Car {
    @Override
    public void accelerate() {
        // Implementación de acelerar para un automóvil deportivo
    }

    @Override
    public void brake() {
        // Implementación de frenar para un automóvil deportivo
    }

    @Override
    public void turn() {
        // Implementación de girar para un automóvil deportivo
    }

    @Override
    public void playMusic() {
        // Implementación de reproducir música para un automóvil deportivo
    }
}
´´´

This design may seem appropriate at first, but there may be problems if we later want to create a class that implements only the methods related to music playback. In this case, the MusicPlayer class should implement the Music interface instead of the Car interface, but there is no option to do so because Car defines the playMusic() method. This violates the interface segregation principle, as the Car interface has methods that not all implementers need or will use.

### Good example:

´´´
public interface Driving {
    void accelerate();
    void brake();
    void turn();
}

public interface MusicPlayer {
    void playMusic();
}

public class SportsCar implements Driving {
    @Override
    public void accelerate() {
        // Implementación de acelerar para un automóvil deportivo
    }

    @Override
    public void brake() {
        // Implementación de frenar para un automóvil deportivo
    }

    @Override
    public void turn() {
        // Implementación de girar para un automóvil deportivo
    }
}

public class MusicPlayerImpl implements MusicPlayer {
    @Override
    public void playMusic() {
        // Implementación de reproducir música
    }
}
´´´

In this way, we have separated the methods related to driving and music into two smaller and more cohesive interfaces, which makes our code more modular, easy to understand, and extend.


### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)