package app.todaymealvote_backend.mapper;

import app.todaymealvote_backend.dto.UserDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<UserDTO>userFindAll();

    @Select("select COUNT(*) from user where user_id=#{id}")
    public int duplicationFindAll(String id);

    @Insert("insert into user(user_id, name, password, role) values(#{user_id},#{name},#{password},#{role})")
    public int join(UserDTO userDTO);

    @Select("select * from user where user_id=#{id}")
    public UserDTO userFindOne(String id);
}
