# Mediator Patter

This is a behavioral design pattern that restricts communication between objects. For this, a mediator object is used that what it does is force the communications of the objects through this object, otherwise, the objects will not be able to communicate with each other.

## Problem

Let's say you have a chat application that allows users to send messages and files to each other. One of the requirements for the development of the chat is that users cannot communicate directly with each other, in order to regulate illicit or other illegal conversations, so someone must be aware of all the conversations that are taking place in the chat.

## Solution

In order that one or several people do not have to be reviewing each conversation, the mediator pattern can be implemented, with which we can regulate the communications between the different objects created by the users' communications.

We create the ``chatRoom`` class which will have the mediator role that will manage and coordinate the interactions between users.

```Java
public class ChatRoom {
    public void sendMessage(User user, String message) {
        // Send message to other users
    }
}
```

Now, we create the ``users`` class which is in charge of sending the messages with which the users communicate to the ``chatRoom`` mediator class in order to regulate the conversations.

```Java
public class User {
    private String name;
    private ChatRoom chatRoom;
    
    public User(String name, ChatRoom chatRoom) {
        this.name = name;
        this.chatRoom = chatRoom;
    }
    
    public void sendMessage(String message) {
        chatRoom.sendMessage(this, message);
    }
}
```

When a user sends a message, it calls the "sendMessage()" method of the "User" class, which in turn calls the "sendMessage()" method of the "ChatRoom" class. The "ChatRoom" object manages the sending of the message to the other users connected to the chat.

```Java
public class chat{
    public static void main(){
        ChatRoom chatRoom = new ChatRoom();
        User user1 = new User("John", chatRoom);
        User user2 = new User("Jane", chatRoom);
        user1.sendMessage("Hola Jane!");
        user2.sendMessage("Hola John!");
    }
}
```
## Class Diagram
![Mediator_Patter](//www.plantuml.com/plantuml/png/XP4nIySm4CNtV8hpFxNO3Zfca8AB22wA7-1eZpRG991BNSJlRiArCLZnlsIuztllxf618uQusLMfSKLcU5mmldfluLC10DmokUc5c76cPcCA6jxJsu6LcOQt68oRMmqVtapgwyZ9r9xHExG5bCcuRz5bdspBhgR6EpYZxVcoQzVaaAEHHUEQYYYD-mUvMaCgoYfxygpe6iP062j9y39Ejd3ton9eDXmfY7h_dofUmJJKzIvFVaLuHaStb_OdI3n_edvn6LL3alBlVWC0)

[Back](../behavioral/README.md)