package app.todaymealvote_backend.dao;

import app.todaymealvote_backend.dto.LocationDTO;
import app.todaymealvote_backend.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LocationDAO {
    @Autowired
    LocationMapper locationMapper;
    public Object save(LocationDTO locationDTO){
        return locationMapper.save(locationDTO);
    }

    public List<LocationDTO> findAll(){
        return locationMapper.findAll();
    }

    //id값 조회
    public int idFindAll(String id){
        return locationMapper.idFindAll(id);
    }
}
