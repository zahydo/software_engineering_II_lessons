# Iterator pattern

## Description
Iterator is a behavioral design pattern that separates the algorithm for accessing and traversing the elements of a collection from the collection itself. It provides a way to access the elements of a collection without exposing its underlying representation. The pattern defines two main abstractions, the Iterator interface and the Aggregate interface, which allow multiple traversal algorithms to be defined and used with the same object. The Iterator pattern is particularly useful when the underlying representation of a collection is complex or when we want to hide the implementation details of the collection from the client code.

## Problem
Suppose you have a collection of items, and you want to provide a way for clients to access and iterate over the collection's elements. However, you don't want to expose the internal structure of the collection to clients or tie them to a particular iteration algorithm. Additionally, you want to allow clients to iterate over the collection in different ways, depending on their needs.

## Solution
```java
public interface Iterator<T> {
    boolean hasNext();
    T next();
}

public interface Aggregate<T> {
    Iterator<T> createIterator();
}

public class Song {
    private String title;
    private String artist;
    
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getArtist() {
        return artist;
    }
}

public class SongCollection implements Aggregate<Song> {
    private List<Song> songs;
    
    public SongCollection() {
        this.songs = new ArrayList<>();
    }
    
    public void addSong(Song song) {
        songs.add(song);
    }
    
    public Song getSong(int index) {
        return songs.get(index);
    }
    
    public int getSize() {
        return songs.size();
    }
    
    public Iterator<Song> createIterator() {
        return new SongIterator(this);
    }
}

public class SongIterator implements Iterator<Song> {
    private SongCollection collection;
    private int index;
    
    public SongIterator(SongCollection collection) {
        this.collection = collection;
        this.index = 0;
    }
    
    public boolean hasNext() {
        return index < collection.getSize();
    }
    
    public Song next() {
        Song song = collection.getSong(index);
        index++;
        return song;
    }
}

SongCollection collection = new SongCollection();
collection.addSong(new Song ("Bohemian Rhapsody", "Queen"));
collection.addSong(new Song("Stairway to Heaven", "Led Zeppelin"));
collection.addSong(new Song("Hotel California", "Eagles"));
collection.addSong(new Song("Hey Jude", "The Beatles"));
collection.addSong(new Song("Like a Rolling Stone", "Bob Dylan"));

Iterator<Song> iterator = collection.createIterator();

while(iterator.hasNext()) {
    Song song = iterator.next();
    System.out.println("Title: " + song.getTitle() + ", Artist: " + song.getArtist());
}
```


Song Collection that uses the Iterator pattern to allow the client to iterate over the collection of songs. The SongCollection class implements the Aggregate interface and provides methods to add songs to the collection and get the size of the collection. It also provides a method createIterator() which returns a new instance of the SongIterator class that implements the Iterator interface. The SongIterator class provides methods to check if there are more songs to iterate over and to get the next song in the collection. This pattern provides a way to iterate over a collection of objects without exposing the underlying structure of the collection to the client.
