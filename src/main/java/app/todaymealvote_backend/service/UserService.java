package app.todaymealvote_backend.service;

import app.todaymealvote_backend.dao.UserDAO;
import app.todaymealvote_backend.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired UserDAO userDao;
    public UserDTO userFindAll(){
//        System.out.println(uDao.userFindAll());
        return null;
    }

    public int duplicationFindAll(String id){
        return userDao.duplicationFindAll(id);
    }

    public int join(UserDTO userDTO){
        return userDao.join(userDTO);
    }


}
