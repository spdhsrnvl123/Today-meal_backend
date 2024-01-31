package app.todaymealvote_backend.controller;
import app.todaymealvote_backend.dto.UserDTO;
import app.todaymealvote_backend.service.LocationService;
import app.todaymealvote_backend.service.MenuService;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import app.todaymealvote_backend.service.UserService;

@CrossOrigin("origins = 'http://localhost:4200")
@RestController
public class MainController {
    @Autowired
    UserService userService;
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
//    @GetMapping("/location")
//    public Object locationFindAll(){
//        return locationService.findAll();
//    }
    @GetMapping("/location")
    public Object locationFindAll(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sessionId = session.getId();

        System.out.println("Session ID: " + sessionId);

        // 다른 작업 수행...

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
    @GetMapping("/duplication/{id}")
    public int duplicationFindAll(@PathVariable String id) {
        return userService.duplicationFindAll(id);
    }

    //회원가입 로직
    @PostMapping("/join")
    public int join(@RequestBody UserDTO userDTO){
        return userService.join(userDTO);
    }

}
