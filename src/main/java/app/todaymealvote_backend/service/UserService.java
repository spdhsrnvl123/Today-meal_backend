package app.todaymealvote_backend.service;

import app.todaymealvote_backend.dao.UserDAO;
import app.todaymealvote_backend.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserDAO userDao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public int duplicationFindAll(String id){
        return userDao.duplicationFindAll(id);
    }

    //가입
    public int joinProcess(UserDTO userDTO){
        String username = userDTO.getUser_id();
        String password = userDTO.getPassword();

//        Boolean isExist = userDao.userFindOne(username);
//        System.out.println(isExist);
        //회원아이디가 중복 될 경우 리턴
//        if(isExist){
//            return;
//        }

        //패스워드 암호화
//        userDTO.setPassword(bCryptPasswordEncoder.encode(password));
        userDTO.setRole("ROLE_USER");

        return userDao.join(userDTO);
    }

    public int userLeave(Object userInfo) {
        return userDao.userLeave(userInfo);
    }

    public int userChange(Object userInfo){
        return userDao.userChange(userInfo);
    }
}
