package app.todaymealvote_backend.mapper;

import app.todaymealvote_backend.dto.UserDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")
    public List<UserDTO>userFindAll();

    @Select("select COUNT(*) from user where user_id=#{id}")
    public int duplicationFindAll(String id);

    //회원가입
    @Insert("insert into user(user_id, name, password, role) values(#{user_id},#{name},#{password},#{role})")
    public int join(UserDTO userDTO);

    //회원아이디 중복검사
    @Select("select * from user where user_id=#{user_id}")
    public Boolean userFindOne(String user_id);

    // 로그인 아이디 정보에 따른 회원정보 뽑기
    @Select("select * from user where user_id=#{user_id}")
    public UserDTO infoId(String user_id);

    //회원탈퇴
    @Delete("delete from user where user_id = #{user_id} and password=#{password}")
    public int userLeave(Object userInfo);

    //비밀번호 변경
    @Update("""
        update user
        set password = #{newPassword} 
        where password = #{oldPassword} 
        and user_id = #{user_id}
    """)
    public int userChange(Object userInfo);
}
