package itcampus.com.service;

import java.util.List;
import itcampus.com.dto.PostCourseDto;
import itcampus.com.vo.PostCourseVO;

public interface AdminPostCourseService {

	public List<PostCourseVO> postCourseList();//후기목록

	public void insertPostCourse(PostCourseDto postcourseDto);//후기등록

	public PostCourseVO postCourseUpdateForm(int pid);//후기수정폼

	public void updatePostCourse(PostCourseDto postcourseDto);//후기수정하기

	public void deletePostCourse(int pid);//후기삭제하기
}
