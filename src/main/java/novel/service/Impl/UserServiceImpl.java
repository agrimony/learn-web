package novel.service.Impl;

import novel.dao.UserMapper;
import novel.model.User;
import novel.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by hou on 10/21/16.
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    public User getUserById(int id) {
        return userMapper.selectByPrimaryKey(id);
    }

//    public List<User> getUsers() {
//        return userMapper.selectlist();
//    }

    public int insert(User userInfo) {
        return userMapper.insert(userInfo);
    }
}
