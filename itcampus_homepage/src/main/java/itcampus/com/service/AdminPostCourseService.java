package itcampus.com.service;

import java.util.List;
import itcampus.com.dto.PostCourseDto;
import itcampus.com.vo.PostCourseVO;

public interface AdminPostCourseService {

	public List<PostCourseVO> postCourseList();//후기목록

	public void insertPostCourse(PostCourseDto postcourseDto);//후기등록

	public PostCourseVO postCourseView(int pid);//과정후기상세보기	

	public void updatePostCourse(PostCourseDto postcourseDto);//후기수정하기

	public void deletePostCourse(int pid);//후기삭제하기



}
