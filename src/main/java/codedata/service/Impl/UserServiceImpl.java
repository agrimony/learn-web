package codedata.service.Impl;

import codedata.dao.UserMapper;
import codedata.model.User;
import codedata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
