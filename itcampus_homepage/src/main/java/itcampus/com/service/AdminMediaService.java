package itcampus.com.service;

import java.util.List;

import itcampus.com.dto.CourseDto;
import itcampus.com.dto.MediaDto;
import itcampus.com.vo.CourseVO;
import itcampus.com.vo.MediaVO;

public interface AdminMediaService {

	public List<MediaVO> mediaList();//미디어목록

	public void insertMedia(MediaDto mediaDto);//미디어등록

//	public void deleteMedia(int mdid);//미디어 삭제
//	public void updateMedia(MediaVO mediaVO);//미디어수정하기



}
