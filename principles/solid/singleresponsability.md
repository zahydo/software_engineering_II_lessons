# SINGLE RESPONSIBILITY

This principle states that each software class or component must have a single responsibility, meaning that a software class or module must have a single, well-defined task or responsibility, and there cannot be more than one reason for change. When a class has multiple responsibilities, it becomes difficult to maintain, extend and test it. In addition, any change in one of the responsibilities may affect other parts of the system that depend on that class, which may result in errors or unexpected behavior.

## Bad Example

```
class User:
    def __init__(self, name, email, password):
        self.name = name
        self.email = email
        self.password = password

    def send_email(self):
        # Sends a welcome email to the user

```
In this example, the "User" class has two responsibilities: to handle user information and to send a welcome email. This design violates the SRP principle because if in the future we want to change the way emails are sent, we will have to modify the User class.

## Good Example

```
class User:
    def __init__(self, name, email, password):
        self.name = name
        self.email = email
        self.password = password


class EmailService:
    def send_email(self, user):
        # Sends a welcome email to the user
```

In this design, the "User" class has a single responsibility for handling user information, and the "EmailService" class has a single responsibility for sending emails. In this way, we can modify the way emails are sent without having to change the User class.


## Related principles
- Separation of Concerns
- KISS
- Do the simplest thing that Could possible work
