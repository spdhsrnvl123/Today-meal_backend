package app.todaymealvote_backend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class UserDTO {
    private String id;
    private String name;
    private String password;
    private Date created_data;
}
