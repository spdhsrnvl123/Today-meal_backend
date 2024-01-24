package app.todaymealvote_backend.mapper;

import app.todaymealvote_backend.dto.LocationDTO;
import app.todaymealvote_backend.dto.MenuDTO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface MenuMapper {
    //메뉴등록
    @Insert("""
            insert into menu(menu, price, description, location_id) 
            values (#{menu}, #{price}, #{description}, #{location_id})
            """)
    public int save(MenuDTO menuDTO);

    @Select("""
            select * from menu where location_id = #{id};
            """)
    public List<MenuDTO> menuFindAll(String id);
}
