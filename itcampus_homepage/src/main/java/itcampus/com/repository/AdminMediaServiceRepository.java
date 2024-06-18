package itcampus.com.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import itcampus.com.vo.MediaVO;

@Repository
public interface AdminMediaServiceRepository extends JpaRepository<MediaVO,Long>{
	
	//미디어목록조회
	public List<MediaVO> findAllByOrderByMdregdateDesc();
	
	//미디어 등록일자
	@Query(value = "SELECT NOW()", nativeQuery = true)
	public Date findCurrentTime();
}
