package app.todaymealvote_backend.controller;

import app.todaymealvote_backend.dto.MenuDTO;
import app.todaymealvote_backend.dto.UserDTO;
import app.todaymealvote_backend.service.LocationService;
import app.todaymealvote_backend.service.MenuService;
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
    @Autowired
    MenuService menuService;

    //장소등록
    @PostMapping("/register")
    public Object register(@RequestBody String id) throws JsonProcessingException {
        return locationService.save(id);
    }

    //장소조회 - 등록한 장소 조회
    @GetMapping("/location2")
    public Object locationFindAll(){
        return locationService.findAll();
    }

    //장소조회 - 삭제대기 장소 조회
    @GetMapping("/loading")
    public Object loadingLocation(){
        return locationService.loadingLocation();
    }

    //장소삭제
    @GetMapping("/location/delete/{id}")
    public Object del(@PathVariable String id){
        return locationService.del(id);
    }

    //장소삭제 취소
    @GetMapping("/loading/cancel/{id}")
    public Object loadingCancel(@PathVariable String id){
        return locationService.loadingCancel(id);
    }

    //메뉴조회
    @GetMapping("/menu/{id}")
    public Object menuFindAll(@PathVariable String id){ return menuService.menuFindAll(id); }

    //각 장소 조회
    @GetMapping("/location/{id}")
    public Object locationFindEach(@PathVariable String id){
        System.out.println(locationService.findOne(id));
        return locationService.findOne(id);
    }

    //유저 정보 조회
    @GetMapping("/user")
    public UserDTO userFindAll() {
        return uService.userFindAll();
    }

    //유저 정보 조회
    @GetMapping("/duplication/{id}")
    public int duplicationFindAll(@PathVariable String id) {
        return uService.duplicationFindAll(id);
    }

    //가입

}
