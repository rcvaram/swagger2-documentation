package com.cvaram.blog.services;

import com.cvaram.blog.beans.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private List<User> users;

  @PostConstruct
  void init() {
    this.users = new ArrayList<>();

    User siva = new User("Sivaram Rasathurai", "u0000");
    users.add(siva);

    User smith = new User("Joe Smith", "u0001");
    users.add(smith);

    User tack = new User("TackyOne", "u002");
    users.add(tack);
  }

  public List<User> getAllUsers() {
    return this.users;
  }

  public User getUserById(String id) {
    return this.users
        .stream()
        .filter(user -> user.getId().equals(id))
        .findFirst()
        .orElse(null);
  }

  public User createUser(User user) {
    users.add(user);
    return user;
  }

  public String deleteUser(String id) {
    String s = "Could not delete the user";
    for (User user : this.users) {
      if (user.getId().equals(id)) {
        this.users.remove(user);
        return "Successfully removed the user";
      }
    }
    return s;
  }
}
