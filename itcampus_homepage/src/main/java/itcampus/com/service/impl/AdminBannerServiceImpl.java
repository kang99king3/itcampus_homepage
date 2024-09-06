package itcampus.com.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itcampus.com.dto.BannerDto;
import itcampus.com.repository.AdminBannerServiceRepository;
import itcampus.com.service.AdminBannerService;
import itcampus.com.vo.BannerVO;

@Service
public class AdminBannerServiceImpl implements AdminBannerService{

	@Autowired
	AdminBannerServiceRepository adminBannerServiceRepository;
	
	@Override
	public List<BannerVO> bannerList() {
		// List<BannerVO> list = adminBannerServiceRepository.findByBuseOrderByBsdateDesc("Y");
		List<BannerVO> list = adminBannerServiceRepository.findAll();
		return list;
	}

	@Override
	public List<BannerVO> bannerListFilter() {
		// List<BannerVO> list = adminBannerServiceRepository.findByBuseOrderByBsdateDesc("Y");
        // b_USE가 "Y"인 배너를 가져옵니다.
    List<BannerVO> list = adminBannerServiceRepository.findByBuseOrderByBregdateDesc("Y");


		System.out.println("list = " + list.toString());
    // b_URL이 비어있지 않은 배너만 필터링합니다.
    return list.stream()
								.filter(banner -> banner.getBurl() != null && !banner.getBurl().trim().isEmpty()) // b_URL이 비어있지 않은 배너
                .collect(Collectors.toList()); // 결과를 리스트로 수집		
								
		//return list;
	}

	@Override
	public void insertBanner(BannerDto bannerDto) {
		BannerVO bannerVO = new BannerVO();
		bannerVO.setBannerVO(bannerDto);
		adminBannerServiceRepository.save(bannerVO);
	}

	@Override
	public BannerVO bannerView(int bid) {
		return adminBannerServiceRepository.findByBid(bid);
	}

	@Override
	public void updateBanner(BannerDto bannerDto) {
		BannerVO bannerVO = new BannerVO();
		bannerVO.setBannerVO(bannerDto);
		adminBannerServiceRepository.save(bannerVO);
	}

	@Override
	public void deleteBanner(int bid) {
		BannerVO bannerVO = adminBannerServiceRepository.findByBid(bid);
		bannerVO.setBuse("N");
		adminBannerServiceRepository.save(bannerVO);
	}

	@Override
	public void copyBanner(int bid) {
		BannerVO bannerVO = adminBannerServiceRepository.findByBid(bid);
		bannerVO.setBid(0);
		adminBannerServiceRepository.save(bannerVO);
	}

	@Override
	public long countTotalBanners() {
		return adminBannerServiceRepository.count();
	}
}
