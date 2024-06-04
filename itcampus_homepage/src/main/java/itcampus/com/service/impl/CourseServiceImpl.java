package itcampus.com.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import itcampus.com.dto.CourseDto;
import itcampus.com.repository.AdminCourseServiceRepository;
import itcampus.com.repository.CourseServiceRepository;
import itcampus.com.service.AdminCourseService;
import itcampus.com.service.CourseService;
import itcampus.com.vo.CourseVO;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseServiceRepository courseServiceRepository;
	
	@Override
	public List<CourseVO> courseList(int page, int size) {

		 Pageable pageable = PageRequest.of(page-1, size,Sort.by("csdate").descending());
		 Page<CourseVO> clist=courseServiceRepository.findByCuse("Y",pageable);

	     return  clist.getContent();
	}

	
	@Override
	public List<CourseVO> findTop4ByCuseOrderByCsdateDesc() {
//		List<CourseVO> list=courseServiceRepository.findTop4ByCuseOrderByCsdateDesc("Y");
//		for(CourseVO courseVO:list) {
//			String cthumb=courseVO.getCthumb();
//			String cthumbPath=cthumb.substring(cthumb.indexOf("/file"));
//			courseVO.setCthumb(cthumbPath);
//		}
		return courseServiceRepository.findTop4ByCuseOrderByCsdateDesc("Y");
	}
	
	@Override
	public CourseVO courseView(int cid) {
		return courseServiceRepository.findByCid(cid);
	}

}
