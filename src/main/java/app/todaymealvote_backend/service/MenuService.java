package app.todaymealvote_backend.service;

import app.todaymealvote_backend.dao.MenuDAO;
import app.todaymealvote_backend.dto.MenuDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    @Autowired
    MenuDAO menuDAO;

    public Object menuFindAll(String id){
        System.out.println(menuDAO.menuFindAll(id));
        return menuDAO.menuFindAll(id);
    }
}
