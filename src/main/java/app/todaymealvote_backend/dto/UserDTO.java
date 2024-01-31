package app.todaymealvote_backend.dto;

import lombok.Data;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
public class UserDTO {
    private String user_id;
    private String name;
    private String password;
    private Date create_date;
    private String state;
    private String role;

    public void setPassword(String plainPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(plainPassword);
    }
}
