package app.todaymealvote_backend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class UserDTO {
    private String user_id;
    private String name;
    private String password;
}
