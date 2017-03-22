package novel.controller;

import novel.model.User;
import novel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by hou on 10/25/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/showInfo/{userId}")
    public String showUserInfo(ModelMap modelMap, @PathVariable int userId){
        User userInfo = userService.getUserById(userId);
        modelMap.addAttribute("userInfo", userInfo);
        return "/user/showInfo";
    }
}
