package app.todaymealvote_backend.controller;

import app.todaymealvote_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/user")
    public String userP(){
        return "User Controller";
    }
}
