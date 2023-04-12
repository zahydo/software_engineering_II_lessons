# Singleton pattern 
The Singleton pattern is a design pattern used to ensure that a class has only one instance and to provide a global access point to that instance. Its intention is to guarantee that a class has only one instance and to provide a global access point to it. The pattern is implemented by creating a method in our class that creates an instance of the object only if it does not already exist. To ensure that the class cannot be instantiated again, the constructor's scope is controlled (using access modifiers such as protected or private).

- Create a private constructor to prevent an instance of the class from being created from outside the class.
- Create a private and static variable of the same class that will be the only instance of the class.
- Create a public and static method that returns the only instance of the class created in step 2.

## 🏗️ Estructure
<p align="center">
<img src="https://res.cloudinary.com/dilrruxyx/image/upload/v1681007458/singleton_any5uv.png" alt="mypic" width="75%">
</p>

## 😟 Problem
Suppose you are developing a game that includes an object to control the game's music. In this case, you want there to be only one instance of the music control object throughout the game, to avoid multiple music tracks playing at the same time. Additionally, you want the instance to be globally accessible to change the music track at any time.

~~~java
public class MusicController {
    private String currentTrack;

    public MusicController(String track) {
        currentTrack = track;
    }

    public void play() {
        // reproducir la pista actual
    }

    public void stop() {
        // detener la reproducción de la pista actual
    }

    public void changeTrack(String newTrack) {
        currentTrack = newTrack;
    }
}
~~~

The problem with this code is that if multiple instances of the MusicController object are created in different parts of the game, multiple music tracks can be played at the same time, which can create an unwanted sound effect. Additionally, changing the music track in one instance will not affect the other instances, which can create inconsistencies in the game.

## 🙂 Solution
To solve this problem, the Singleton pattern can be used to ensure that there is only one instance of the MusicController object throughout the game. The following code shows how the Singleton pattern can be implemented in Java:

~~~java
public class MusicController {
    private static MusicController instance = null;
    private String currentTrack;

    private MusicController(String track) {
        currentTrack = track;
    }

    public static MusicController getInstance(String track) {
        if (instance == null) {
            instance = new MusicController(track);
        }
        return instance;
    }

    public void play() {
        // reproducir la pista actual
    }

    public void stop() {
        // detener la reproducción de la pista actual
    }

    public void changeTrack(String newTrack) {
        currentTrack = newTrack;
    }
}
~~~

In this code, the MusicController class now has a static field called instance that maintains the single instance of the class. The class constructor is now private to prevent instances of the class from being created outside of it. Instead, a static method getInstance has been added that returns the single instance of the class, creating it only if it does not already exist.

With this implementation, it is ensured that there is only one instance of the MusicController class throughout the game, which ensures that only one music track is played at a time."