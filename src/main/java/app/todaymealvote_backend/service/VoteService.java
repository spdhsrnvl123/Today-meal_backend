package app.todaymealvote_backend.service;

import app.todaymealvote_backend.dao.VoteDAO;
import app.todaymealvote_backend.dto.VoteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public class VoteService {
    @Autowired
    VoteDAO voteDAO;

    //투표 등록 및 등록한 투표 변경
    public String vote(VoteDTO voteDTO){
        String user_id = voteDTO.getUser_id();
        String location_id = voteDTO.getLocation_id();

        // 투표한 유저 정보가 있는지 없는지에 따른 로직 분리
        if(voteDAO.userVoteFindAll(user_id) == 0){
            UUID id = UUID.randomUUID();
            voteDTO.setId(String.valueOf(id));
            return voteDAO.vote(voteDTO);
        }else{
            return voteDAO.userVoteChange(user_id,location_id);
        }
    }

    //등록한 투표 삭제
    public String voteDel(String user_id){
        return voteDAO.voteDel(user_id);
    }
}
