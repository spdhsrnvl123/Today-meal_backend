package app.todaymealvote_backend.dao;

import app.todaymealvote_backend.dto.LocationDTO;
import app.todaymealvote_backend.dto.MenuDTO;
import app.todaymealvote_backend.mapper.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class MenuDAO {
    @Autowired MenuMapper menuMapper;
    public Object save(MenuDTO menuDTO){
        return menuMapper.save(menuDTO);
    }

    public List<MenuDTO> menuFindAll(String id){
        return menuMapper.menuFindAll(id);
    }
}
