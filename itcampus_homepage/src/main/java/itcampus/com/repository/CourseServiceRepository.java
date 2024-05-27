package itcampus.com.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import itcampus.com.vo.CourseVO;

@Repository
public interface CourseServiceRepository extends JpaRepository<CourseVO,Long>{

//	List<CourseVO> findByCuseOrderByCsdateDesc(String cuse);//과정목록조회  
//	@Query("SELECT cid, cname,ccate,csdate,cedate,cnumber,cmoney,ccontent,cthumb,cuse FROM CourseVO c ORDER BY cid")
	Page<CourseVO> findByCuse(String cuse,Pageable pageable);
//    Page<CourseVO> findCourses(Pageable pageable);
	List<CourseVO> findTop4ByCuseOrderByCsdateDesc(String cuse);//과정목록조회(메인)

	CourseVO findByCid(int cid);//과정 상세보기
}
