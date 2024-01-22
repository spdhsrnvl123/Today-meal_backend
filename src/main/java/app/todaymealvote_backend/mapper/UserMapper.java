package app.todaymealvote_backend.mapper;

import app.todaymealvote_backend.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<UserDTO>userFindAll();
}
