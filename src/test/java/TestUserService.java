import novel.model.User;
import novel.service.UserService;
import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hou on 10/21/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
        "classpath:spring-mybatis.xml" })
public class TestUserService {
    private static final Logger LOGGER = Logger
            .getLogger(TestUserService.class);

    @Autowired
    private UserService userService;


    @Test
    public void testQueryById1() {
        User userInfo = userService.getUserById(1);
        LOGGER.info(JSON.toJSON(userInfo));
    }

//    @Test
//    public void testQueryAll() {
//        List<User> userInfos = userService.getUsers();
//        LOGGER.info(JSON.toJSON(userInfos));
//    }
;
    @Test
    public void testInsert() {
        User userInfo = new User();
        userInfo.setName("xiaoming");
        userInfo.setAge(4);
        int result = userService.insert(userInfo);
        System.out.println(result);
    }
}
