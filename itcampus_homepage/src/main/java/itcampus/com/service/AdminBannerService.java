package itcampus.com.service;

import java.util.List;

import itcampus.com.dto.BannerDto;
import itcampus.com.vo.BannerVO;

public interface AdminBannerService {
    // 배너 목록 조회
    List<BannerVO> bannerList();

    // user가 Y이면서 Url이 비어 있지않은 것만 조회 

    List<BannerVO> bannerListFilter();

    // 배너 등록
    void insertBanner(BannerDto bannerDto);

    // 배너 상세 조회
    BannerVO bannerView(int bid);

    // 배너 수정
    void updateBanner(BannerDto bannerDto);

    // 배너 삭제 (단순히 사용 여부를 "N"으로 변경)
    void deleteBanner(int bid);

    // 배너 복사
    void copyBanner(int bid);

    // 전체 배너 수 카운트
    long countTotalBanners();
}
