package app.todaymealvote_backend.mapper;

import app.todaymealvote_backend.dto.LocationDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LocationMapper {
    //장소등록
    @Insert("insert into location(id,state,title,img,addr,phonenum,category) value (#{id},#{state},#{title},#{img},#{addr},#{phonenum},#{category})")
    public int save(LocationDTO locationDTO);

    //장소 전체 조회
    @Select("select * from location")
    public List<LocationDTO> findAll();

    //장소 id값 일치 컬럼 조회
    @Select("select * from location where id=#{id}")
    public List<LocationDTO> findOne(String id);

    //장소 id값 일치 컴럼 수 조회
    @Select("select COUNT(*) from location where id=#{id}")
    public int idFindAll(String id);

}