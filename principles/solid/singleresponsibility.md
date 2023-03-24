## Single Responsibility

This principle establishes that each class must have a unique 
responsibility within our software and this responsibility must be 
defined and concrete. All methods must be aligned with the purpose of the class..



### Bad example:

This UserLogin class has the sole responsibility of performing the login process,
but we also gave it the responsibility of sending messages to the user. The above does 
not comply with the description of the principle because the class is doing two things 
with different objectives.


```JAVA:
package solid;
class UserLogin {

    private final DataBase db;

    UserLogin(DataBase db) {
        this.db = db;
    }

    void login(String userName, String password) {
        User user = db.findUserByUserName(userName);
        if (user == null) {
            // do something
        }
        // login process..
    }

    void sendEmail(User user, String msg) {
        // sendEmail email to user
    }

}
```

### Good example:
To solve the problem we should separate the class in two. One for the specifics of the login and another for the functionality of sending messages.



```JAVA:
package solid;

class UserLogin {

    private final DataBase db;

    UserLogin(DataBase db) {
        this.db = db;
    }

    void login(String userName, String password) {
        User user = db.findUserByUserName(userName);
        if (user == null) {
            // do something
        }
        // login process..
    }
}

class EmailSender {

    void sendEmail(User user, String msg) {
        // send email to user
    }

}

```

### Related principles

- [Links to other principles] 

### Related patterns

- [Pattern names]

---
[Back to the list](./README.md)