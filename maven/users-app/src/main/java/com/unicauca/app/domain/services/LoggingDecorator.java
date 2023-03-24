package com.unicauca.app.domain.services;

import com.unicauca.app.domain.model.User;

public class LoggingDecorator extends UserServiceDecorator {

  public LoggingDecorator(IUserService userService) {
    super(userService);
  }

  @Override
  public void createUser(User user) {
    this.userService.createUser(user);
  }

  @Override
  public void deleteUser(String username) {
    this.userService.deleteUser(username);
  }

  @Override
  public String getJWT(String username, String password) {
    // Log the authentication attempt to a file
    logToFile("User " + username + " is attempting to authenticate.");

    // Call the wrapped object to authenticate the user
    String token = this.userService.getJWT(username, password);

    // Log the result of the authentication attempt to a file
    logToFile(
      "Authentication attempt for user " +
      username +
      " " +
      (token != null ? "succeeded." : "failed.")
    );

    // Return the JWT token
    return token;
  }

  private void logToFile(String message) {
    System.out.println("Logging message: " + message);
  }
}
