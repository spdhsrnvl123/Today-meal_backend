package app.todaymealvote_backend.dto;

import lombok.Data;
import org.springframework.stereotype.Component;


@Data
@Component
public class MenuDTO {
    private String id;
    private String menu;
    private String price;
    private String description;
    private String location_id;
}
