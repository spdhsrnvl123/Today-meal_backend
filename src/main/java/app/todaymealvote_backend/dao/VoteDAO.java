package app.todaymealvote_backend.dao;

import app.todaymealvote_backend.dto.VoteDTO;
import app.todaymealvote_backend.mapper.VoteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VoteDAO {
    @Autowired
    VoteMapper voteMapper;

    public String vote(VoteDTO voteDTO){
        System.out.println(voteDTO);
        if(voteMapper.vote(voteDTO) == 1){
            return "투표가 완료되었습니다.";
        }else{
            return "투표 장소를 등록하면서 에러가 발생하였습니다.";
        }
    }

    //투표한 사용자인지 아닌지 확인
    public int userVoteFindAll(String user_id){
        return voteMapper.userVoteFindAll(user_id);
    }

    //투표한 사용자 투표장소 변경
    public String userVoteChange(String user_id, String location_id){
        System.out.println(voteMapper.userVoteChange(user_id, location_id));
        if(voteMapper.userVoteChange(user_id, location_id) == 1){
            return "투표한 장소가 변경되었습니다.";
        }else{
            return "투표 장소를 변경하면서 에러가 발생하였습니다.";
        }
    }

    //투표한 장소 삭제
    public String voteDel(String user_id){
        if(voteMapper.voteDel(user_id) == 1){
            return "투표한 장소가 삭제되었습니다.";
        }else{
            return "투표 장소를 삭제하면서 에러가 발생하였습니다.";
        }
    }

    public Object voteUser(String user_id) {
        return voteMapper.voteUser(user_id);
    }
}
