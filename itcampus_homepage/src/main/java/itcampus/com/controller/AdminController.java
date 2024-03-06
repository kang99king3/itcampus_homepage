package itcampus.com.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import itcampus.com.service.AdminService;
import itcampus.com.vo.MemberVO;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	Logger logger=LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminService adminService;
	
	@GetMapping("/login")
	public String login(@ModelAttribute MemberVO memberVO, Model model) { 
		model.addAttribute("memberVO", memberVO);
		return "admin/login";
	}
	
	@PostMapping("/login") 
	public String main(@ModelAttribute MemberVO memberVO, Model model) {
		
		if (memberVO == null) { 
			return "redirect:admin/login";
		}
		
		System.out.println("------------------- 1");
		
		MemberVO loginmemberVO = adminService.login(memberVO);
		//logger.debug("id = " + loginmemberVO.getM_id() + "::" + "pwd = " + loginmemberVO.getM_pwd());
		System.out.println("------------------- 2");

		if (loginmemberVO != null) { 
			// session 생성 
			logger.debug(loginmemberVO.get(0).getM_id());
		} else { 
			// 로그인 fail 
			logger.debug("ID / PW 틀림 "  + memberVO.getM_id() + ":" + memberVO.getM_pwd());
		}
		
		return null;
	}
	
	@GetMapping("/aaa")
	@ResponseBody
	public String aaa() {
		return "afsfsdff";
	}

}
