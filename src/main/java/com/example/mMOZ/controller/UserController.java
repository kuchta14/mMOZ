package com.example.mMOZ.controller;

//import com.example.mMOZ.CurrentUser;
import com.example.mMOZ.Entity.User;
import com.example.mMOZ.interfejs.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(@Lazy UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public String createUser(Model model,User user) {
        if (user.getPassword().equals("") || user.getUsername().equals("")) {
            return "fail";
        }
        try {
            userService.saveUser(user);
            String success = "success";
            model.addAttribute("success", success);
        } catch (Exception e) {
            return "fail";
        }
        return "login";
    }

    @GetMapping("/login")
    public String createUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login";
    }

}
