package edu.neu.cs4500.cs4500sp19s2acp9191.services;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import edu.neu.cs4500.cs4500sp19s2acp9191.models.User;

@RestController
public class UserService {
  static List<User> users = new ArrayList();

  static {
    users.add(new User(123, "alice", "alice", "Alice", "Wonderland"));
    users.add(new User(234, "bob", "bob", "Bob", "Marley"));
  }

  @GetMapping("/api/user")
  public List<User> findAllUsers() {
    return users;
  }

  @GetMapping("/api/user/{userId}")
  public User findUserById(
          @PathVariable("userId") Integer id) {
    for (User user : users) {
      if (user.getId() == id) {
        return user;
      }
    }
    return null;
  }
}
