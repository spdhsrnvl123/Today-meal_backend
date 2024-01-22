package app.todaymealvote_backend.mapper;

import app.todaymealvote_backend.dto.LocationDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationMapper {
    @Insert("insert into location(id,state,title,img,addr,phonenum,category) value (#{id},#{state},#{title},#{img},#{addr},#{phonenum},#{category})")
    public int save(LocationDTO locationDTO);

    @Select("select * from location")
    public List<LocationDTO> findAll();

    @Select("select COUNT(*) from location where id=#{id}")
    public int idFindAll(String id);
}

//@Select("<script>" +
//        "select * from location" +
//        "<where>" +
//        "<if test='state != null'>" +
//        "and state = #{state}" +
//        "</if>" +
//        "<if test='category != null'>" +
//        "and category = #{category}" +
//        "</if>" +
//        "</where>" +
//        "</script>")
