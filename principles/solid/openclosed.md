## Open/Closed

Open for extension but closed for modification. Organize the code in a modular way, this means that "the entities: classes, modules, interfaces, etc. must be open for extension but closed for modification". (extend the functionality of the class but this must be closed for modification, this means that what we define in this part has to be sufficiently abstract or generic to be implemented and to be manipulated and to have a much higher polymorphism) this principle seeks to make the development as modular as possible. It also obeys the principle of composition, which defines that when you have a single class and you have different functionalities, that class can be composed of multiple functionalities. A great advantage is that you can assemble, disassemble functionalities and add behaviors without the need to use inheritance.

### Bad example:

In an application, an event handler class is designed to handle the response to a single event. If another event needs to be handled, the existing event handler class must be modified.

```Java
enum class Notification {
    push_notification,
    email,
    sms
}

class notificationService{
    fun sendNotification (notification: Notification){
        when (notification){
            Notification.push_notification ->{
                //enviar push notification
            }
            Notification.email -> {
                //enviar email notification
            }
            Notification.sms -> {
                //enviar sms notification
            }
        }
    }
}
```

### Good example:

You can create a generic event handler interface and have the event handler class implement the interface. Then, you can create new classes that implement the interface to handle different types of events.

```Java
interface Notification {
    fun sendNotification ()
}

class pushNotification: Notificacion {
    override fun sendNotification(){
        //enviar push notification
    }
}

class emailNotification: Notification {
    override fun sendNotification(){
        //enviar email notification
    }
}

class smsNotification: Notification {
    override fun sendNotification(){
        //enviar sms notification
    }
}
```

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)