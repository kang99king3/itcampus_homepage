package itcampus.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import itcampus.com.vo.PostCourseVO;

@Repository
public interface AdminPostCourseServiceRepository extends JpaRepository<PostCourseVO,Long>{

	public List<PostCourseVO> findAll();//후기목록보기
}
