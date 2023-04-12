# Facade pattern

The Facade pattern is a structural design pattern that solves the integration of several complex systems in development projects by creating a class that encapsulates each of its systems and exposes it in a very simple way either in the same class with a method or simply with an instantiation.

The facade pattern is commonly used in very large applications, for example: Facebook, Youtube and Instagram, because they handle subsystems of logging, security, analytics, transfers, among others.

## Class Diagram of example:

![DiagramFacade](http://www.plantuml.com/plantuml/png/VLB1JiCm3BttAtpC13rnom4D4DoA9Y5nprg3CjncD4abGFmxJOrBCvNjCCL-zdj-JztwOFeGMofgCjv35RsjTsG-i8Ul0iPVUPogQdUbOVnZZ971KMpnpdMXTwJXULdo1Bv7G_OJUmttyYmcw6AXf3RSIahgnH9gU0gzxLut6WPd6qPzS4ULTKnpY3wmh28Sa3JOBgpCpE9gRmvkchg45XihRqF1PSlVXIJ2dYKFllB14fw_DEtiJVscJWdpc2JapihrnIy7XiVKKuAid3Qx4fRP79TYK6escMdSZXifazoye5KYK4opXjzGS6ejkkLdL9RNVo5gY1xzAPvdyi-Ck1MEBNPDREa7)

## Example
An example of the Facade pattern using Java code could be:

Suppose we are developing a music application and we need to use different subsystems to play music, such as MP3 player, volume control and sound equalizer. Instead of exposing these subsystems directly to our application, we can use the Facade pattern to create a MusicPlayer class that encapsulates all these functionalities and exposes them to our application in a simpler way.

```Java
public class MusicPlayer {
    private MP3Player playerMP3;
    private VolumeControl volumeControl;
    private Equalizer equalizer;
 
    public MusicPlayer() {
        this.playerMP3 = new MP3Player();
        this.volumeControl = new VolumeControl();
        this.equalizer = new Equalizer();
    }
 
    public void play(String file) {
        playerMP3.playFile(file);
    }
 
    public void stop() {
        playerMP3.stopPlayback();
    }
 
    public void adjustVolume(int level) {
        volumeControl.setNivel(level);
    }
 
    public void adjustEqualizer(int bajo, int medio, int alto) {
        equalizer.setBajo(bajo);
        equalizer.setMedio(medio);
        equalizer.setAlto(alto);
    }
}
```

In this example, the `MusicPlayer` class encapsulates the subsystems `MP3Player`, `VolumeControl` and `Equalizer`. The public methods of `MusicPlayer` are simpler and easier to use than the methods of the underlying subsystems. For example, instead of having to call the `playFile` method of `PlayerMP3`, we can simply call the play method of `MusicPlayer`.

```Java
MusicPlayer player = new MusicPlayer();
player.play("La quemona.mp3");
player.adjustVolume(50);
player.adjustEqualizer(10, 20, 30);
player.stop();
```

In this example, we use the instance of `MusicPlayer` to play a song, adjust the volume and equalizer, and finally stop playback.

[Back](../structural/README.md)