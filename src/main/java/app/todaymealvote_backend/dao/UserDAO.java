package app.todaymealvote_backend.dao;

import app.todaymealvote_backend.dto.UserDTO;
import app.todaymealvote_backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDAO {
    @Autowired UserMapper userMapper;
    public List<UserDTO> userFindAll(){
        return userMapper.userFindAll();
    }

    public int duplicationFindAll(String id){
        System.out.println(id);
        return userMapper.duplicationFindAll(id);
    }

    public int join(UserDTO userDTO){
        return userMapper.join(userDTO);
    }
}
