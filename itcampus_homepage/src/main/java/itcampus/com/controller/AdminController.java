package itcampus.com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import itcampus.com.service.AdminCourseService;
import itcampus.com.service.AdminMediaService;
import itcampus.com.service.AdminPostCourseService;
import itcampus.com.service.AdminService;
import itcampus.com.service.AdminStudentProjectService;
import itcampus.com.vo.MemberVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminService adminService;
	
	@Autowired
	AdminCourseService adminCourseService;
	
	@Autowired
	AdminPostCourseService adminPostCourseService;
	
	@Autowired
	AdminStudentProjectService adminStudentProjectService;
	
	@Autowired
	AdminMediaService adminMediaService;
	
	
	@GetMapping("/login")
	public String login(@ModelAttribute MemberVO memberVO, Model model) { 
		model.addAttribute("memberVO", memberVO);
		return "admin/login";
	}
	
	@PostMapping("/login") 
	public String main(@ModelAttribute MemberVO memberVO, Model model,HttpServletRequest request) {
		
		if (memberVO == null) { 
			return "redirect:admin/login";
		}
		
		System.out.println("------------------- 1");
		
	
		MemberVO loginmemberVO = adminService.login(memberVO);
		
		//logger.debug("id = " + loginmemberVO.getM_id() + "::" + "pwd = " + loginmemberVO.getM_pwd());
		System.out.println("------------------- 2");

		if (loginmemberVO != null) { 
			// session 생성 
			logger.info(loginmemberVO.getMname());
			
			// HttpSession을 생성합니다.
	        HttpSession session = request.getSession();
	        
	        // 세션의 유효 시간을 60분으로 설정
	        int seconds = 60 * 60;
	        session.setMaxInactiveInterval(seconds);
	        
	        // 세션에 데이터를 저장합니다.
	        session.setAttribute("loginUser", loginmemberVO);
			
		} else { 
			// 로그인 fail 
			logger.info("ID / PW 틀림 "  + memberVO.getMid() + ":" + memberVO.getMname());
			// alert 띄우고 // sendRedirect
			return "redirect:/admin/login";
		}
		
		return "redirect:/admin/main"; // Admin Main Page
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException { 
		
        HttpSession session = request.getSession(false); // false를 사용하여 새로운 세션을 생성하지 않도록 합니다.
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        if (session != null) {
            // 세션에서 특정 속성을 제거합니다.
            session.removeAttribute("loginUser");
            
            // 세션을 무효화합니다.
            session.invalidate();
            
            // 응답을 생성합니다.
            out.println("<html><body>");
            out.println("<scipt>alert('정상적으로 로그아웃 되었습니다 !!');</script>");
            out.println("</body></html>");
        } else {
            out.println("<html><body>");
            out.println("<scipt>alert('로그인 하세요!!');</script>");
            out.println("</body></html>");
        }
		
        logger.debug("로그아웃");
        
		return "redirect:/admin/login";
	}
	
	@GetMapping({"/main", "/"})
	public String main(Model model) { 
		System.out.println("메인화면");
		
		//상담신청현황 불러와야함.
		
		//List<QnaVO> list =  adminService.list();
		//System.out.println(list.toString());
		//model.addAttribute("list", list);
		
		long countTotalCourses = adminCourseService.countTotalCourses();
		long countTotalPostCourses = adminPostCourseService.countTotalPostCourses();
		long countTotalProject = adminStudentProjectService.countTotalProject();
		long countTotalMedia = adminMediaService.countTotalMedia();
		
		System.out.println("countTotalCourses = " + countTotalCourses);
		System.out.println("countTotalPostCourses = " + countTotalPostCourses);
		System.out.println("countTotalProject = " + countTotalProject);
		System.out.println("countTotalMedia = " + countTotalMedia);

		model.addAttribute("countTotalCourses", countTotalCourses);
		model.addAttribute("countTotalPostCourses", countTotalPostCourses);
		model.addAttribute("countTotalProject", countTotalProject);
		model.addAttribute("countTotalMedia", countTotalMedia);
		
		return "admin/main";
	}
}
