package novel.service;

import novel.model.User;

/**
 * Created by hou on 10/21/16.
 */
public interface UserService {
    User getUserById(int id);

//    List<User> getUsers();

    int insert(User userInfo);
}
