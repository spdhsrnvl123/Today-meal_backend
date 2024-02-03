package app.todaymealvote_backend.controller;

import app.todaymealvote_backend.dto.UserDTO;
import app.todaymealvote_backend.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class JoinController {

    @Autowired
    UserService userService;
    @PostMapping("/join")
    public String joinProcess(UserDTO userDTO){
        userService.joinProcess(userDTO);
        return "ok";
    }
}
