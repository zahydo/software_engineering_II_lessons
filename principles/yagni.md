## YAGNI (You Ain't Gonna Need It)

The YAGNI principle suggests that you should only implement what is needed at the moment, rather than trying to anticipate future requirements. This is based on the idea that implementing unnecessary features or functionality can lead to additional complexity, which can in turn make the code harder to maintain and debug.

  
### Bad Example:

Suppose you are developing a registration system for a conference, and you have been asked to implement a feature that allows users to upload a profile picture. However, after considering the requirements, you realize that this feature is not necessary for the conference to function properly, and may add unnecessary complexity to the system. Despite this, you decide to implement the feature anyway, just in case it might be useful in the future:

```
public class User {
	private String name;
	private String email;
	private byte[] profilePicture;

	public User(String name, String email, byte[] profilePicture) 
		this.name = name;
		this.email = email;
		this.profilePicture = profilePicture;

	}
	// getters and setters
}
```

This code includes an additional field for the profile picture, even though it's not currently needed. This can lead to additional complexity and potentially slower performance, especially if the profile picture needs to be loaded or saved from a database.

### Good Example:

To apply the YAGNI principle, you would only include the necessary fields and methods to implement the current requirements, without adding any additional features that are not currently needed:

```
public class User {
	private String name;
	private String email;

	public User(String name, String email) {
		this.name = name;
		this.email = email;
	}

	// getters and setters
}
```

This code only includes the necessary fields and methods to register a user with their name and email, without including any additional features that are not currently needed. This results in a simpler and easier to maintain implementation.