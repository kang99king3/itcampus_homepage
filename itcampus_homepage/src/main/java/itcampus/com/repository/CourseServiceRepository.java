package itcampus.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itcampus.com.vo.CourseVO;

@Repository
public interface CourseServiceRepository extends JpaRepository<CourseVO,Long>{

	List<CourseVO> findByCuse(String cuse);//과정목록조회  

	CourseVO findByCid(int cid);//과정 상세보기
}
