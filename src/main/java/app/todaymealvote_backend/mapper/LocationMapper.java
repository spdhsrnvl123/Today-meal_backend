package app.todaymealvote_backend.mapper;

import app.todaymealvote_backend.dto.LocationDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface LocationMapper {
    //장소등록
    @Insert("insert into location(id,state,title,img,addr,phonenum,category) value (#{id},#{state},#{title},#{img},#{addr},#{phonenum},#{category})")
    public int save(LocationDTO locationDTO);

    //등록완료된 장소 조회
    @Select("""
        select * from location where state = '등록완료'
    """)
    public List<LocationDTO> findAll();

    //삭제대기 장소 조회
    @Select("""
        select * from location where state = '삭제대기'
    """)
    public List<LocationDTO> loadingLocation();

    //장소 id값 일치 컬럼 조회
    @Select("select * from location where id=#{id}")
    public List<LocationDTO> findOne(String id);


    //장소 id값 일치 컴럼 수 조회
    @Select("select COUNT(*) from location where id=#{id}")
    public int idFindAll(String id);

    //장소 삭제
    @Update("""
        update location set update_date = #{now},state=#{loading} where id = #{id}
    """)
    public int del(String id,LocalDate now,String loading);

    //장소 삭제 (update날짜 조회)
    @Update("""
        update location set state = '삭제완료' where state = '삭제대기'
    """)
    public int scheduleDel();

    //삭제대기 취소
    @Update("""
        update location set state = '등록완료' where id = #{id}
    """)
    public int loadingCancel(String id);

    //투표 목록 조회
    @Select("SELECT l.title, l.img, COUNT(v.location_id) as vote_count " +
            "FROM location l " +
            "INNER JOIN vote_list v ON l.id = v.location_id " +
            "INNER JOIN user u ON v.user_id = u.user_id " + // 사용자 정보 가져오기
            "WHERE DATE(v.date) = CURDATE() " + // 현재 날짜와 투표 날짜 비교
            "GROUP BY l.title, l.img " + // title 별로 그룹화하여 각 위치의 투표 수를 세어줍니다.
            "ORDER BY l.title")
    List<Map<String, String>> getLocationVoteCount();
}
