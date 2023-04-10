# Mediator pattern

The Mediator pattern is a behavioral pattern that promotes loose coupling between a set of objects by creating a mediator object that encapsulates the communication between them. It allows objects to interact with each other without being tightly coupled to each other, which can make the system more flexible and easier to maintain. The Mediator pattern is often used in complex systems where many objects need to communicate with each other, but direct communication between them would be difficult to manage.

In the Mediator pattern, the mediator object acts as a centralized communication hub that coordinates the interactions between the objects. The objects themselves do not communicate directly with each other, but instead send messages to the mediator, which then forwards the messages to the appropriate recipients. This can reduce the complexity of the system by limiting the number of connections between objects and centralizing the communication logic in the mediator.

To implement the Mediator pattern, the mediator object typically defines a set of communication methods that the objects can use to interact with each other. The objects themselves may also implement a common interface that allows the mediator to send messages to them in a standardized way. By using a mediator object to handle communication, the objects can remain loosely coupled and changes to one object will not necessarily require changes to other objects in the system.

An example of the mediator pattern using Java code could be:

You need to implement a chat room application where users can send messages to each other. However, the users should not be tightly coupled to each other and adding new users should not require changes to the existing user classes. You can use the Mediator pattern to create a chat room mediator that encapsulates the communication between the users. Here's an example implementation:

```java
public interface ChatRoom {
    public void sendMessage(String message, User sender);
}

public class ChatRoomImpl implements ChatRoom {
    @Override
    public void sendMessage(String message, User sender) {
        // Forward message to all users in the chat room except the sender
        for (User user : users) {
            if (user != sender) {
                user.receiveMessage(message);
            }
        }
    }
    
    public void addUser(User user) {
        users.add(user);
    }
    
    public void removeUser(User user) {
        users.remove(user);
    }
    
    private List<User> users = new ArrayList<>();
}

public class User {
    private String name;
    private ChatRoom chatRoom;
    
    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }
    
    public void sendMessage(String message) {
        chatRoom.sendMessage(message, this);
    }
    
    public void receiveMessage(String message) {
        System.out.println(name + " received message: " + message);
    }
}

public class Main {
    public static void main(String[] args) {
        ChatRoom chatRoom = new ChatRoomImpl();
        
        User user1 = new User("Alice", chatRoom);
        User user2 = new User("Bob", chatRoom);
        
        chatRoom.addUser(user1);
        chatRoom.addUser(user2);
        
        user1.sendMessage("Hello, Bob!");
        user2.sendMessage("Hi, Alice!");
        
        chatRoom.removeUser(user2);
        
        user1.sendMessage("Bob has left the chat.");
    }
}
```

In this implementation, the ChatRoom interface defines a sendMessage method that allows users to send messages to each other, but without directly interacting with each other. The ChatRoomImpl class implements this interface and acts as the mediator between the users. It maintains a list of users in the chat room and forwards messages to all users except the sender.

The User class represents a user in the chat room and has a reference to the ChatRoom mediator. Users can send messages to each other by calling the sendMessage method on their own User object, which then forwards the message to the ChatRoom mediator.

Finally, in the Main class, we create a chat room and two users, and add them to the chat room. The users send messages to each other and we remove one user from the chat room. This demonstrates how the Mediator pattern allows users to communicate with each other without being tightly coupled, and how adding or removing users does not require changes to the existing user classes.
