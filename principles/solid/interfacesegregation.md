## Interface Segregation

The principle of interface segregation says that no client should be
forced to depend on methods you don't use. On an existing interface no
we should add new methods that force to implement functionality
additional. Instead of adding methods to an existing interface, it is better to create another one.
interface and that the class that needs it implements it.

### Bad example:
~~~JAVA:
public interface Reproductor {
    void reproducirMusica();
    void reproducirVideo();
    void mostrarImagen();
}

public class ReproductorMultimedia implements Reproductor {
    @Override
    public void reproducirMusica() {
        System.out.println("Reproduciendo música");
    }

    @Override
    public void reproducirVideo() {
        System.out.println("Reproduciendo video");
    }

    @Override
    public void mostrarImagen() {
        System.out.println("Mostrando imagen");
    }
}
~~~

### Good example:
~~~JAVA:
public interface ReproductorMusica {
    void reproducir();
    void pausar();
}

public interface ReproductorVideo {
    void reproducirVideo();
    void pausarVideo();
}

public class ReproductorMP3 implements ReproductorMusica {
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo música");
    }

    @Override
    public void pausar() {
        System.out.println("Música en pausa");
    }
}

public class ReproductorMP4 implements ReproductorVideo, ReproductorMusica {
    @Override
    public void reproducir() {
        System.out.println("Reproduciendo audio");
    }

    @Override
    public void pausar() {
        System.out.println("Audio en pausa");
    }

    @Override
    public void reproducirVideo() {
        System.out.println("Reproduciendo video");
    }

    @Override
    public void pausarVideo() {
        System.out.println("Video en pausa");
    }
}
~~~

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)