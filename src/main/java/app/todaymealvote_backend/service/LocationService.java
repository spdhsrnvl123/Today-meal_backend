package app.todaymealvote_backend.service;

import app.todaymealvote_backend.dao.LocationDAO;
import app.todaymealvote_backend.dao.MenuDAO;
import app.todaymealvote_backend.dto.LocationDTO;
import app.todaymealvote_backend.dto.MenuDTO;
import app.todaymealvote_backend.dto.RegisterDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


@Service
public class LocationService {

    @Autowired
    LocationDTO locationDTO;
    @Autowired
    LocationDAO locationDAO;
    @Autowired
    RegisterDTO registerDTO;
    @Autowired
    MenuDTO menuDTO;
    @Autowired
    MenuDAO menuDAO;

    //장소조회 - 등록한 장소 조회
    public Object findAll() {
        return locationDAO.findAll();
    }

    //장소조회 - 삭제대기 장소 조회
    public Object loadingLocation(){
        return locationDAO.loadingLocation();
    }

    //삭제대기 취소
    public Object loadingCancel(String id){
        return locationDAO.loadingCancel(id);
    }

    //후기 각 장소 조회
    public Object findOne(String id){
        return locationDAO.findOne(id);
    }

    //장소등록
    public Object save(String id) throws JsonProcessingException { //JsonProcessingException 기능 알아보기

        int idExist = locationDAO.idFindAll(id);

        if (idExist == 0) {
            // RestTemplate 생성
            RestTemplate restTemplate = new RestTemplate();

            // Request Header 및 매개변수 설정
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // GET Request 보내기
            ResponseEntity<String> response = restTemplate.getForEntity(
                    "https://place.map.kakao.com/main/v/" + id,
                    String.class // 실제 응답의 타입에 따라 설정
            );

            String jsonResponse = response.getBody();

            //자바오브젝트로 변환하기 위한 ObjectMapper선언
            ObjectMapper objectMapper = new ObjectMapper();
            // JSON데이터 -> 자바오브젝트로 변환
            JsonNode rootNode = objectMapper.readTree(jsonResponse);

            //1deps - basicInfo 접근
            JsonNode basicInfoNode = rootNode.path("basicInfo");

            // 1deps - 추출
            // cid 추출
            String cid = basicInfoNode.path("cid").asText();
            // placenamefull 추출
            String placenamefull = basicInfoNode.path("placenamefull").asText();
            // mainphotourl 추출
            String mainphotourl = basicInfoNode.path("mainphotourl").asText();
            // phonenum 추출
            String phonenum = basicInfoNode.path("phonenum").asText();

            //2deps - basicInfo 오브젝트 안에 address 값 접근
            JsonNode address = basicInfoNode.path("address");
            JsonNode category = basicInfoNode.path("category");

            //3deps - address 오브젝트 안 newaddr 값 접근
            JsonNode newaddr = address.path("newaddr");
            JsonNode region = address.path("region");

            // category에서 catename추출
            String catename = category.path("catename").asText();

            // newaddr값에서 newaddrfull, bsoznno 추출
            String newaddrfull = newaddr.path("newaddrfull").asText();
            String bsizonno = newaddr.path("bsizonno").asText();


            //region에서 newaddrfullname 추출 - newaddrfullname + newaddrfull + (우)bsizonno
            String newaddrfullname = region.path("newaddrfullname").asText();

//            System.out.println(newaddrfullname + " " + newaddrfull + " (우)" + bsizonno);
            //'', " "차이 알아보기

            String state = "등록완료";

            //get,setter 데이터 삽입
            locationDTO.setId(cid);
            locationDTO.setState(state);
            locationDTO.setTitle(placenamefull);
            locationDTO.setImg(mainphotourl);
            locationDTO.setAddr(newaddrfullname + " " + newaddrfull + " (우)" + bsizonno);
            locationDTO.setPhonenum(phonenum);
            locationDTO.setCategory(catename);

            locationDAO.save(locationDTO);

            // 메뉴 등록
            //1deps - MenuInfoNode 접근
            JsonNode MenuInfoNode = rootNode.path("menuInfo");
            JsonNode menuList = MenuInfoNode.path("menuList");
            String menucount = MenuInfoNode.path("menucount").asText();

            int count = Integer.parseInt(menucount);

            for(int i=0; i<count;i++){
                JsonNode menuListIndex = menuList.get(i);
                String menu = menuListIndex.path("menu").asText();
                String price = menuListIndex.path("price").asText();
                String desc = menuListIndex.path("desc").asText();

                menuDTO.setMenu(menu);
                menuDTO.setPrice(price);
                menuDTO.setDescription(desc);
                menuDTO.setLocation_id(id);
                menuDAO.save(menuDTO);
            }

            registerDTO.setStatus("등록이 완료되었습니다.");
            return registerDTO;
        }else {
            registerDTO.setStatus("중복된 장소입니다.");
            return registerDTO;
        }
    }

    //장소 삭제 요청값 DB삽입(날짜)
    public Object del(String id){
        LocalDate now = LocalDate.now();
        String loading = "삭제대기";
        return locationDAO.del(id,now,loading);
    }


    //장소 삭제 00:00 - 오늘 날짜가 아닌 update_date에선 state값 "등록취소"로 등록
    @Scheduled(cron = "0 0 0 * * *")
    public void scheduleDel(){
        System.out.println("삭제완료");
        locationDAO.scheduleDel();
    }

    public Object getLocationVoteCount() {
        return locationDAO.getLocationVoteCount();
    }
}
