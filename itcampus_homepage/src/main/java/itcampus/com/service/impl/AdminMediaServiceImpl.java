package itcampus.com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import itcampus.com.dto.CourseDto;
import itcampus.com.dto.MediaDto;
import itcampus.com.repository.AdminCourseServiceRepository;
import itcampus.com.repository.AdminMediaServiceRepository;
import itcampus.com.service.AdminCourseService;
import itcampus.com.service.AdminMediaService;
import itcampus.com.vo.CourseVO;
import itcampus.com.vo.MediaVO;

@Service
public class AdminMediaServiceImpl implements AdminMediaService{

	@Autowired
	AdminMediaServiceRepository adminMediaServiceRepository;

	@Override
	public List<MediaVO> mediaList() {
		return adminMediaServiceRepository.findAllByOrderByMdregdateDesc();
	}

	@Override
	public void insertMedia(MediaDto mediaDto) {
		mediaDto.setMdregdate(adminMediaServiceRepository.findCurrentTime()); //현재날짜 넣어주기
		MediaVO mediaVo=new MediaVO();
		mediaVo.setMediaVO(mediaDto);
		adminMediaServiceRepository.save(mediaVo);
	}
	
}
