package itcampus.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itcampus.com.vo.BannerVO;

@Repository
public interface AdminBannerServiceRepository extends JpaRepository<BannerVO,Long>{
	
//	List<CourseVO> findByCuseOrderByCsdateDesc(String cuse);//과정목록조회  
	//List<BannerVO> findAllByOrderByCsdateDesc();//과정목록조회 
	BannerVO findByBid(int bid);//배너 상세보기

	List<BannerVO> findByBuseOrderByBregdateDesc(String buse);
	
}
