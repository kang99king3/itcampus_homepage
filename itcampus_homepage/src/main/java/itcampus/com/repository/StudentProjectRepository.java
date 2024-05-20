package itcampus.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import itcampus.com.vo.CourseVO;
import itcampus.com.vo.StudentProjectVO;

@Repository
public interface StudentProjectRepository extends JpaRepository<StudentProjectVO,Long>{

//	List<StudentProjectVO> findBySuse(String suse);//프로젝트 목록조회  
	List<StudentProjectVO> findTop10BySuseOrderBySregdateDesc(String suse);
//	StudentProjectVO findBySid(int sid);//프로젝트 상세조회
}
