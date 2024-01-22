package app.todaymealvote_backend.service;

import app.todaymealvote_backend.dao.UserDAO;
import app.todaymealvote_backend.dto.UserDTO;
import app.todaymealvote_backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired UserDAO uDao;
    public UserDTO userFindAll(){
        System.out.println(uDao.userFindAll());
        return null;
    }
}
