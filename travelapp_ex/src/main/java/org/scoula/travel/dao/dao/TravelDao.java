package org.scoula.travel.dao.dao;

import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.util.List;
import java.util.Optional;

public interface TravelDao {
    /**
     * 관광지정보를 추가한다
     * @param travel
     */
    void insert(TravelVO travel);

    /**
     * 관광지이미지 정보를 추가한다
     * @param image
     */
    void insertImage(TravelImageVO image);

    /**
     * 관광지정보의 총 건수를 반환한다
     * @return 총 여행건수
     */
    int getTotalCount();

    /**
     * 권역 목록 얻기
     * @return
     */
    List<String> getDistricts();

    /**
     * 전체 관광지정보를 모두 반환한다. 권역별, 제목순으로 정렬하여 반환한다
     * @return
     */
    List<TravelVO> getTravels();

    /**
     * 페이지에 해당하는 관광지정보들을 반환한다. 권역별, 제목순으로 정렬하여 반환한다
     * 한 페이지에서 보여줄 관광지정보는 최대 10개이다
     * @param page 페이지
     * @return
     */
    List<TravelVO> getTravels(int page);

    /**
     * 해당 권역의 관광지정보들을 반환한다
     * @param district 권역
     * @return
     */
    List<TravelVO> getTravels(String district);

    /**
     * 관광지 번호에 해당하는 여행상세정보를 반환한다
     * @param no 관광지번호
     * @return 관광지권역, 제목, 상세내용, 주소, 연락처, 관광지 이미지들을 포함한다
     */
    Optional<TravelVO> getTravel(Long no);


}
