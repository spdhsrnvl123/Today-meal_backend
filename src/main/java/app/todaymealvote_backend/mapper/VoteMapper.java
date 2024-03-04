package app.todaymealvote_backend.mapper;

import app.todaymealvote_backend.dto.LocationDTO;
import app.todaymealvote_backend.dto.VoteDTO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface VoteMapper {
    //투표를 했는지 안했는지 먼저 조회
//    @Select("select COUNT(*) from vote_list where user_id = #{user_id}")
//    public int userVoteFindAll(String user_id);

    @Select("SELECT COUNT(*) " +
            "FROM vote_list " +
            "WHERE user_id = #{user_id} AND DATE(date) = CURDATE()")
    public int userVoteFindAll(String user_id);
    //투표를 처음하는 유저 투표진행
    @Insert("insert into vote_list(id, user_id, location_id) values(#{id},#{user_id},#{location_id})")
    public int vote(VoteDTO voteDTO);

    //투표를 한 유저가 다를 장소로 투표를 하도록 진행(변경)
    @Update("""
        update vote_list 
        set location_id = #{location_id} 
        where user_id = #{user_id} 
        and date(date) = current_date()
    """)
    public int userVoteChange(String user_id, String location_id);

    //투표한 장소 삭제
    @Delete("""
        delete from vote_list 
        where user_id = #{user_id}
        and date(date) = current_date()
    """)
    public int voteDel(String user_id);

    @Select("""
        SELECT loc.*
        FROM vote_list vl
        INNER JOIN location loc ON vl.location_id = loc.id
        WHERE vl.user_id = #{user_id}
        AND date(vl.date) = current_date()
    """)
    public LocationDTO voteUser(String user_id);
}
