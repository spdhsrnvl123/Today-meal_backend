package app.todaymealvote_backend.service;

import app.todaymealvote_backend.dao.UserDAO;
import app.todaymealvote_backend.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired UserDAO userDao;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    public UserDTO userFindAll(){
//        System.out.println(uDao.userFindAll());
        return null;
    }

    public int duplicationFindAll(String id){
        return userDao.duplicationFindAll(id);
    }

    //가입
    public int join(UserDTO userDTO){

        userDTO.setPassword(bCryptPasswordEncoder.encode(userDTO.getPassword()));
        userDTO.setRole("ROLE_ADMIN");

        return userDao.join(userDTO);
    }


}
