package app.todaymealvote_backend.controller;

import app.todaymealvote_backend.dto.UserDTO;
import app.todaymealvote_backend.service.LocationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.todaymealvote_backend.service.UserService;

@CrossOrigin("http://localhost:4200")
@RestController
public class MainController {
    @Autowired
    UserService uService;

    @Autowired
    LocationService locationService;

    //등록과정
    @PostMapping("/register")
    public Object register(@RequestBody String id) throws JsonProcessingException {
        return locationService.save(id);
    }

    //장소조회
    @GetMapping("/location")
    public Object locationFindAll(){
        return locationService.findAll();
    }

    @GetMapping("/user")
    public UserDTO userFindAll() {
        return uService.userFindAll();
    }

}
