package itcampus.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import itcampus.com.vo.PostCourseVO;

public interface PostCourseRepository extends JpaRepository<PostCourseVO,Long>{
//	@Query("SELECT  FROM postcourse p JOIN p.coursevo")
	List<PostCourseVO> findTop10ByPuseOrderByPregdateDesc(String puse);//후기목록조회
}
