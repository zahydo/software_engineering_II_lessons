# S
## Single Responsibility
Each part of the code should only have one task or responsibility.
### Bad example:
Let's say we have to create a mail class and validate the email, and it has been decided to do everything in the same class.
```JAVA:
    public class Email {
        private String subject;
        private String content;
        private String sentBy;
        private String sentTo;
        
        public Email(String subject, String content, String sentBy, String sentTo) {
            this.subject = subject;
            this.content = content;
            this.sentBy = sentBy;
            this.sentTo = sentTo;
        }

        public int validateEmail() {
            if (this.subject != null && this.content != null && 
                this.sentBy != null && this.sentTo != null) {
                return 1;
            }
            return 0;
        }
    }

```
This violates the Single Responsibility Principle because it makes the Email class perform two different tasks (creating an email object and validating it).
### Good example:

So to fix it, you create another class called EmailValidator that is solely responsible for validating these emails.
```JAVA:
    public class Email {
        private String subject;
        private String content;
        private String sentBy;
        private String sentTo;
        
        public Email(String subject, String content, String sentBy, String sentTo) {
            this.subject = subject;
            this.content = content;
            this.sentBy = sentBy;
            this.sentTo = sentTo;
        }
    }

    public class EmailValidator {
        public int validateEmail(Email email) {
            if (email.subject != null && email.content != null && 
                email.sentBy != null && email.sentTo != null) {
                return 1;
            }
            return 0;
        }
    }
```
And thus, we adhere to the Single Responsibility Principle.

### Related patterns

- Separation of Concerns
- Code For The Maintainer