package itcampus.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itcampus.com.dto.CourseDto;
import itcampus.com.vo.CourseVO;

@Repository
public interface AdminCourseServiceRepository extends JpaRepository<CourseVO,Long>{
	
	List<CourseVO> findAll();//과정목록조회
	
}
