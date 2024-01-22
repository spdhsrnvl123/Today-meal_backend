package app.todaymealvote_backend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Data
@Component
public class LocationDTO {
    private String id;
    private Date create_date;
    private Date update_date;
    private String state;
    private String title;
    private String img;
    private String addr;
    private String phonenum;
    private String category;
}
