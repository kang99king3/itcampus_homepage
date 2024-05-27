package itcampus.com.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import itcampus.com.vo.PostCourseVO;

public interface PostCourseRepository extends JpaRepository<PostCourseVO,Long>{
	
	//join한 테이블에서 10개의 행만 조회
//	@Query("SELECT p.pid,p.ptitle,c.cname, p.pcontent,p.pregdate,p.puse  FROM PostCourseVO p JOIN p.coursevo c "
//			+ "WHERE p.puse = :puse ORDER BY p.pregdate DESC")
	@Query("SELECT p  FROM PostCourseVO p LEFT JOIN p.coursevo c "
			+ "WHERE p.puse = :puse ORDER BY p.pregdate DESC")
	List<PostCourseVO> findTop20ByPuseOrderByPregdateDesc(@Param("puse") String puse);//후기목록조회
}
