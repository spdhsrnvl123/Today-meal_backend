package app.todaymealvote_backend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class VoteDTO {
    private String id;
    private String user_id;
    private String location_id;
    private Date date;
}
