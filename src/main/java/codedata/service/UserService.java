package codedata.service;

import codedata.model.User;

import java.util.List;

/**
 * Created by hou on 10/21/16.
 */
public interface UserService {
    User getUserById(int id);

//    List<User> getUsers();

    int insert(User userInfo);
}
