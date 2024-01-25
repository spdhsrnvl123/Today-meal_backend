package app.todaymealvote_backend.dao;

import app.todaymealvote_backend.dto.LocationDTO;
import app.todaymealvote_backend.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
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

    // 한 장소 조회
    public List<LocationDTO> findOne(String id){
        return locationMapper.findOne(id);
    }

    //id값 조회
    public int idFindAll(String id){
        return locationMapper.idFindAll(id);
    }

    public int del(String id, LocalDate now, String loading) {
        return locationMapper.del(id,now,loading);
    }

    public int scheduleDel(){
        return locationMapper.scheduleDel();
    }
}
