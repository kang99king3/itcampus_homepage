package itcampus.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import itcampus.com.vo.PostCourseVO;

@Repository
public interface AdminPostCourseServiceRepository extends JpaRepository<PostCourseVO,Long>{

	public List<PostCourseVO> findByPuse(String puse);//후기리스트보기

	public PostCourseVO findByPid(int pid);//후기상세보기


}
