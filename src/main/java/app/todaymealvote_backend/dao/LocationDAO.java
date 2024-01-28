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

    //장소 저장
    public Object save(LocationDTO locationDTO) {
        return locationMapper.save(locationDTO);
    }

    //등록 장소 조회
    public List<LocationDTO> findAll() {
        return locationMapper.findAll();
    }

    //장소조회 - 삭제대기 장소 조회
    public List<LocationDTO> loadingLocation(){
        return locationMapper.loadingLocation();
    }

    // 한 장소 조회
    public List<LocationDTO> findOne(String id) {
        return locationMapper.findOne(id);
    }

    //장소 id값 조회
    public int idFindAll(String id) {
        return locationMapper.idFindAll(id);
    }

    public int del(String id, LocalDate now, String loading) {
        return locationMapper.del(id, now, loading);
    }

    public int scheduleDel() {
        return locationMapper.scheduleDel();
    }

    //삭제대기 취소
    public int loadingCancel(String id){
        return locationMapper.loadingCancel(id);
    }
}
