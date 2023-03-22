# O
## Open/Closed
The code design should make it easy to add new features without having to change existing code.

### Bad example:
Let's say we have to send emails and encrypt them.
```JAVA:
    public class Email {
        private String subject;
        private String content;
        private String sentFrom;
        private String sentTo;
        
        public Email(String subject, String content, String sentFrom, String sentTo) {
            this.subject = subject;
            this.content = content;
            this.sentFrom = sentFrom;
            this.sentTo = sentTo;
        }

        public boolean send() {
            Email encryptedEmail = encrypt();
            // Suppose we have already called the responsible API.
            return true;
        }

        public Email encrypt() {
            Email encryptedEmail = new Email(this.subject, this.content, this.sentFrom, this.sentTo);
            // Suppose it is already encrypted.
            return encryptedEmail;
        }

    }

```
Unfortunately, we cannot add new code to that class because we would need to modify it, thereby violating the Open-Closed Principle.
### Good example:
```JAVA:
    public abstract class EmailBase {
        private String subject;
        private String content;
        private String sentBy;
        private String sendTo;
        
        public EmailBase(String subject, String content, String sentBy, String sendTo) {
            this.subject = subject;
            this.content = content;
            this.sentBy = sentBy;
            this.sendTo = sendTo;
        }

        public abstract boolean send();
    }

    public class EncryptedEmail extends EmailBase {
        public EncryptedEmail(String subject, String content, String sentBy, String sendTo) {
            super(subject, content, sentBy, sendTo);
        }

        @Override
        public boolean send() {
            EncryptedEmail encryptedEmail = encryptEmail();
            // Assume we've called the responsible API already.
            return true;
        }
        
        private EncryptedEmail encryptEmail() {
            EncryptedEmail encryptedEmail = new EncryptedEmail(this.subject, this.content, this.sentBy, this.sendTo);
            // Assume we've already encrypted it.
            return encryptedEmail;
        }
    }

```
By having EmailBase as an abstract class, we can create more types of emails without the need to modify the EmailBase class, such as adding emails with attachments, one-way emails, HTML emails, among others.

### Related patterns
- Separation of Concerns
- Code For The Maintainer